package nibbles.analytica;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import nibbles.analytica.json.BankInfo;
import nibbles.analytica.json.Transaction;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Results extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.nibbles.analytica.USERNAME";
    public static final String EXTRA_PASSWORD = "com.nibbles.analytica.PASSWORD";

    public static final String EXTRA_CATEGORY1 = "com.nibbles.analytica.CATEGORY1";
    public static final String EXTRA_CATEGORY2 = "com.nibbles.analytica.CATEGORY2";
    public static final String EXTRA_CATEGORY3 = "com.nibbles.analytica.CATEGORY3";
    public static final String EXTRA_CATEGORY4 = "com.nibbles.analytica.CATEGORY4";
    public static final String EXTRA_CATEGORY5 = "com.nibbles.analytica.CATEGORY5";

    private String username;
    private String password;

    ArrayList<String> categories = new ArrayList<>();
    ArrayList<Float> categoryExpenditures = new ArrayList<>();

    private BankInfo bankInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        username = bundle.getString(EXTRA_USERNAME);
        password = bundle.getString(EXTRA_PASSWORD);

        if (!bundle.getString(EXTRA_CATEGORY1).isEmpty()) {
            categories.add(bundle.getString(EXTRA_CATEGORY1));
            categoryExpenditures.add(0f);
        }
        if (!bundle.getString(EXTRA_CATEGORY2).isEmpty()) {
            categories.add(bundle.getString(EXTRA_CATEGORY2));
            categoryExpenditures.add(0f);
        }
        if (!bundle.getString(EXTRA_CATEGORY3).isEmpty()) {
            categories.add(bundle.getString(EXTRA_CATEGORY3));
            categoryExpenditures.add(0f);
        }
        if (!bundle.getString(EXTRA_CATEGORY4).isEmpty()) {
            categories.add(bundle.getString(EXTRA_CATEGORY4));
            categoryExpenditures.add(0f);
        }
        if (!bundle.getString(EXTRA_CATEGORY5).isEmpty()) {
            categories.add(bundle.getString(EXTRA_CATEGORY5));
            categoryExpenditures.add(0f);
        }

        getTranscationData();
    }

    private void getTranscationData() {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().transactions(username, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    Gson gson = new Gson();
                    bankInfo = gson.fromJson(s, BankInfo.class);
                    categorize();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Results.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void categorize() {
        List<Transaction> transactions = bankInfo.getTransactions();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        for (int i = 0; i < transactions.size(); i++) {
            Date date = null;
            try {
                date = sdf.parse(transactions.get(i).getDate());
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

            int daysApart = (int)((today.getTime() - date.getTime()) / (1000*60*60*24l));

            if (daysApart <= 30 && transactions.get(i).getAmount() > 0) {
                List<String> groups = transactions.get(i).getCategory();
                for (int j = 0; j < categories.size(); j++) {
                    for (int k = 0; k < groups.size(); k++) {
                        String group = groups.get(k).toLowerCase();
                        if (group.contains(categories.get(j).toLowerCase())) {
                            categoryExpenditures.set(j, categoryExpenditures.get(j) + transactions.get(i).getAmount());
                            break;
                        }
                    }
                }
            }
        }

        BarChart barChart = (BarChart) findViewById(R.id.barChart);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(categories));
        xAxis.setGranularity(1f); // restrict interval to 1 (minimum)

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setValueFormatter(new MyYAxisValueFormatter());
        yAxisLeft.setGranularity(1f);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setValueFormatter(new MyYAxisValueFormatter());
        yAxisRight.setGranularity(1f);


        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        List<BarEntry> barEntries = new ArrayList<>();
        List<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {

            // turn your data into Entry objects
            barEntries.add(new BarEntry(i, categoryExpenditures.get(i)));
            pieEntries.add(new PieEntry(categoryExpenditures.get(i), categories.get(i)));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Categories"); // add entries to dataset
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Categories");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);
        barChart.invalidate(); // refresh

        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.BLACK);

        pieChart.setData(pieData);
        pieChart.invalidate(); // refresh
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(this, HomeScreen.class);
        Bundle extras = new Bundle();

        extras.putString(EXTRA_USERNAME, username);
        extras.putString(EXTRA_PASSWORD, password);
        myIntent.putExtras(extras);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter {

        private ArrayList<String> mValues;

        public MyXAxisValueFormatter(ArrayList<String> values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return mValues.get((int) value);
        }

        /** this is only needed if numbers are returned, else return 0 */
        public int getDecimalDigits() { return 0; }
    }

    public class MyYAxisValueFormatter implements IAxisValueFormatter {

        private DecimalFormat mFormat;

        public MyYAxisValueFormatter() {

            // format values to 2 decimal digit
            mFormat = new DecimalFormat("###,###,###.00");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            return "$" + mFormat.format(value);
        }

        /** this is only needed if numbers are returned, else return 0 */
        public int getDecimalDigits() { return 1; }
    }

}


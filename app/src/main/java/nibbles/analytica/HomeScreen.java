package nibbles.analytica;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import nibbles.analytica.json.BankInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.nibbles.analytica.USERNAME";
    public static final String EXTRA_PASSWORD = "com.nibbles.analytica.PASSWORD";

    public static final String EXTRA_CATEGORY1 = "com.nibbles.analytica.CATEGORY1";
    public static final String EXTRA_CATEGORY2 = "com.nibbles.analytica.CATEGORY2";
    public static final String EXTRA_CATEGORY3 = "com.nibbles.analytica.CATEGORY3";
    public static final String EXTRA_CATEGORY4 = "com.nibbles.analytica.CATEGORY4";
    public static final String EXTRA_CATEGORY5 = "com.nibbles.analytica.CATEGORY5";

    private String username;
    private String password;

    private BankInfo bankInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Bundle bundle = getIntent().getExtras();

        username = bundle.getString(EXTRA_USERNAME);
        password = bundle.getString(EXTRA_PASSWORD);

    }

    public void graph(View view) {
        Intent intent = new Intent(this, Results.class);
        Bundle extras = new Bundle();

        EditText category1EditText = (EditText) findViewById(R.id.category1);
        String category1 = category1EditText.getText().toString();

        EditText category2EditText = (EditText) findViewById(R.id.category2);
        String category2 = category2EditText.getText().toString();

        EditText category3EditText = (EditText) findViewById(R.id.category3);
        String category3 = category3EditText.getText().toString();

        EditText category4EditText = (EditText) findViewById(R.id.category4);
        String category4 = category4EditText.getText().toString();

        EditText category5EditText = (EditText) findViewById(R.id.category5);
        String category5 = category5EditText.getText().toString();


        extras.putString(EXTRA_USERNAME, username);
        extras.putString(EXTRA_PASSWORD, password);
        extras.putString(EXTRA_CATEGORY1, category1);
        extras.putString(EXTRA_CATEGORY2, category2);
        extras.putString(EXTRA_CATEGORY3, category3);
        extras.putString(EXTRA_CATEGORY4, category4);
        extras.putString(EXTRA_CATEGORY5, category5);

        intent.putExtras(extras);
        startActivity(intent);
    }

}

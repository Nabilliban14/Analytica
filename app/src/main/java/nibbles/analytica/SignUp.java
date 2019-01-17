package nibbles.analytica;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    public static final String EXTRA_USERNAME = "com.nibbles.analytica.USERNAME";
    public static final String EXTRA_PASSWORD = "com.nibbles.analytica.PASSWORD";
    public static final String EXTRA_CLASS = "com.nibbles.analytica.CLASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void register(View view) {
        final Context SignUpContext = this;

        EditText usernameEditText = (EditText) findViewById(R.id.register_username);
        final String username = usernameEditText.getText().toString();

        EditText passwordEditText = (EditText) findViewById(R.id.register_password);
        final String password = passwordEditText.getText().toString();

        EditText rePasswordEditText = (EditText) findViewById(R.id.register_rePassword);
        String rePassword = rePasswordEditText.getText().toString();

        if (!password.equals(rePassword)) {
            Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_LONG).show();
        }
        else {
            Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().username_exists(username);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String s = response.body().string();
                        //get rid of trailing whitespace
                        s = s.trim();
                        //if the username does not exist in the database
                        if (s.equals("false")) {
                            Intent intent = new Intent(SignUpContext, PlaidLink.class);
                            Bundle extras = new Bundle();
                            extras.putString(EXTRA_USERNAME, username);
                            extras.putString(EXTRA_PASSWORD, password);
                            extras.putString(EXTRA_CLASS, "SignUp");

                            intent.putExtras(extras);
                            startActivity(intent);
                        }
                        //username already exists, so show error message
                        else {
                            Toast.makeText(SignUp.this, "The username already exists", Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

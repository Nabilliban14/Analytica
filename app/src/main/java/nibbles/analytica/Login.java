package nibbles.analytica;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    public static final String EXTRA_USERNAME = "com.nibbles.analytica.USERNAME";
    public static final String EXTRA_PASSWORD = "com.nibbles.analytica.PASSWORD";
    public static final String EXTRA_CLASS = "com.nibbles.analytica.CLASS";
    public final Context LoginContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void login(View view) {
        EditText usernameEditText = (EditText) findViewById(R.id.usernameText);
        final String usernameMessage = usernameEditText.getText().toString();

        EditText passwordEditText = (EditText) findViewById(R.id.passwordText);
        final String passwordMessage = passwordEditText.getText().toString();

        checkPassword(usernameMessage, passwordMessage);
    }

    private void checkPassword(final String username, final String password) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().login_exists(username, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    //get rid of trailing whitespace
                    s = s.trim();
                    //if the username does not exist in the database
                    if (s.equals("true")) {
                        Intent intent = new Intent(LoginContext, HomeScreen.class);
                        Bundle extras = new Bundle();
                        extras.putString(EXTRA_USERNAME, username);
                        extras.putString(EXTRA_PASSWORD, password);
                        extras.putString(EXTRA_CLASS, "Login");

                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    //username already exists, so show error message
                    else {
                        Toast.makeText(Login.this, "Incorrect Password or Username", Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    //TODO: make hints for login screen


}

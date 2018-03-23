package com.oops.studentmanager.Activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oops.studentmanager.Constants.Constants;
import com.oops.studentmanager.Api.HttpHandler;
import com.oops.studentmanager.R;

import org.json.JSONObject;

import Security.Crypto;
import butterknife.ButterKnife;
import butterknife.Bind;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @Bind(R.id.input_email)
    EditText _emailText;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

          progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        new LoginAsync().execute(new String[]{Constants.LOGIN_URL, email, password});


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 2 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


    private class LoginAsync extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String response = null;
            String dencrypt = null;
            if (urls[0] != null && urls[1] != null && urls[2] != null) {
                try {
                    Log.d("username", urls[1]);

                    JSONObject json = new JSONObject();
                    json.put("username", urls[1]);
                    json.put("password", urls[2]);

                    response = new HttpHandler().GetText(urls[0],json.toString());
                     dencrypt=new Crypto() .decrypt(response.toString(), Constants.FIVE,Constants.SECRET_KEY);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


            return dencrypt;
        }


        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            String status= null;
            try
            {
                JSONObject jsonObject= new JSONObject(result.toString());
                status=jsonObject.getString("status");
                if (status.equalsIgnoreCase("success")) {
                    onLoginSuccess();

                } else {
                    onLoginFailed();
                }
            }catch(Exception e)
            {
             e.printStackTrace();
                onLoginFailed();
            }



        }
    }

}

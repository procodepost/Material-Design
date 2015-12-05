package com.floating.material.floatingtus;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LogInActivity extends AppCompatActivity {

     TextInputLayout userNameLayout,passwordLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userNameLayout= (TextInputLayout) findViewById(R.id.userNameLayout);
        passwordLayout= (TextInputLayout) findViewById(R.id.password_layout);

    }
    public void LogIn(View v){
        String userName=userNameLayout.getEditText().getText().toString();
        String password=passwordLayout.getEditText().getText().toString();

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$");
        if(!pattern.matcher(userName).matches())
            userNameLayout.setError("Please Enter Valid Email Address");
        else if(password.length()<6) {
            passwordLayout.setError("Password Length is too small");
        }
        else
        {
            userNameLayout.setErrorEnabled(false);
            passwordLayout.setErrorEnabled(false);
            Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_LONG).show();
        }
    }
}

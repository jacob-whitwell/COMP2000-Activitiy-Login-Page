package com.example.comp2000_activity_login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.comp2000_activity_login_page.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.comp2000_activity_login_page.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        EditText username = findViewById(R.id.username_signup);
        EditText password = findViewById(R.id.password_signup);


        // Check if username is empty
        if (TextUtils.isEmpty(username.toString()))
        {
            username.setError("Please enter a username.");
        }

        if (TextUtils.isEmpty(password.toString()))
        {
            password.setError("Please enter a password.");
        }
    }



    /** Called when the user taps the create account button */
    public void signUp(View view)
    {
        // Intent is what it sounds like, the 'intent' on making the app do something and is a constructor
        Intent signUpIntent = new Intent(this, MainActivity.class);

        // EditText is a field where you can input stuff (I think?)
        EditText usernameEditText = (EditText) findViewById(R.id.username_signup);
        EditText passwordEditText = (EditText) findViewById(R.id.password_signup);

        // This just sets the string to editText
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String[] userPass = new String[] { username, password };


        if (TextUtils.isEmpty(username))
        {
            usernameEditText.setError("Please enter a username.");
        }
        else if (TextUtils.isEmpty(password))
        {
            passwordEditText.setError("Please enter a password.");
        }
        else {
            // putExtra() adds the value of the parameters to the intent
            signUpIntent.putExtra(EXTRA_MESSAGE, userPass);
            startActivity(signUpIntent);
        }
    }
}
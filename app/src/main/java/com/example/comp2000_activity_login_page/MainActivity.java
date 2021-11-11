package com.example.comp2000_activity_login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.comp2000_activity_login_page.MESSAGE";
    /** Create the ArrayList to hold the user logins */
    public ArrayList<Account> loginList = new ArrayList<Account>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /** Called when the user taps the login button */
    public void login(View view)
    {
        // Intent is what it sounds like, the 'intent' on making the app do something and is a constructor
        Intent intent = new Intent(this, LoginActivity.class);

        Intent signUpIntent = getIntent();
        String[] usnm = signUpIntent.getStringArrayExtra(SignUpActivity.EXTRA_MESSAGE);

        loginList.add(new Account(usnm[0], usnm[1]));

        // EditText is a field where you can input stuff (I think?)
        EditText usernameEditText = (EditText) findViewById(R.id.username_input);
        EditText passwordEditText = (EditText) findViewById(R.id.password_input);

        // This just sets the string to editText
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
        {
            usernameEditText.setError("Invalid username/password");

        }
        else if (loginList.contains(new Account(username, password)))
        {
            usernameEditText.setError("Invalid username/password");
        }
        else if (TextUtils.isEmpty(username))
        {
            usernameEditText.setError("Please enter a username.");
        }
        else if (TextUtils.isEmpty(password))
        {
            passwordEditText.setError("Please enter a password.");
        }
        else {
            // putExtra() adds the value of the parameters to the intent
            intent.putExtra(EXTRA_MESSAGE, username);
            startActivity(intent);
        }
    }


    public void signUp(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);

        Toast toast = Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT);

        startActivity(intent);
    }
}
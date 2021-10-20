package com.example.comp2000_activity_login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.comp2000_activity_login_page.MESSAGE";

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

        // EditText is a field where you can input stuff (I think?)
        EditText usernameEditText = (EditText) findViewById(R.id.username_input);

        // This just sets the string to editText
        String username = usernameEditText.getText().toString();

        // putExtra() adds the value of the parameters to the intent
        intent.putExtra(EXTRA_MESSAGE, username);
        startActivity(intent);
    }

    public void signUp(View view)
    {
        Intent intent = new Intent(this, SignUpActivity.class);

        Toast toast = Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT);

        startActivity(intent);
    }
}
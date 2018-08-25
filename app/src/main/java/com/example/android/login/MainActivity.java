package com.example.android.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView attempt;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setview();
        attempt.setText("No of attempts : 3 ");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                validate (name, pass);
            }
        });
    }

    private void setview()
    {
        username = (EditText)findViewById(R.id.text_id);
        password = (EditText)findViewById(R.id.text_password);
        login = (Button)findViewById(R.id.button_login);
        attempt = (TextView)findViewById(R.id.text_attempt);
    }

    private void validate(String username, String password )
    {

        if (username.equals("Rahul") && (password.equals("9445649284")) )
        {
            Intent intent = new Intent ( MainActivity.this, Welcome.class);
            startActivity(intent);
        }
        else {
            count--;
            attempt.setText("No of attempts : " + count);
            if (count == 0) {
                login.setEnabled(false);
            }
        }
    }
}

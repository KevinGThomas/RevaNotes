package com.example.kev.revanotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UploadLogin extends AppCompatActivity {
    EditText username, password;
    Button buttonaccept;
    String uname;
    String pword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_login);
        Toolbar toolbar = findViewById(R.id.loginToolbar);
        toolbar.setTitle("");
        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        buttonaccept = findViewById(R.id.Login);
        buttonaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                pword = password.getText().toString();
                if (uname.equals(Credentials.username) && pword.equals(Credentials.password)) {
                    Intent intent = new Intent(UploadLogin.this, UploadActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}

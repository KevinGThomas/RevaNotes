package com.example.kev.revanotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);

        buttonaccept = findViewById(R.id.Login);
        buttonaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                pword = password.getText().toString();
                if (uname.equals("harsha_v_mnopq") && pword.equals("peacebro")) {
                    Intent intent = new Intent(UploadLogin.this, UploadActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}

package com.example.kev.revanotes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final EditText et = (EditText) findViewById(R.id.etSubmit);
        final EditText et1 = (EditText) findViewById(R.id.et1Submit);
        final EditText et2 = (EditText) findViewById(R.id.et2Submit);

        Button bt= (Button) findViewById(R.id.btSubmit);

        Toolbar toolbar = (Toolbar) findViewById(R.id.helpToolbarTab);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        RelativeLayout relativeLayout = findViewById(R.id.relativeHelpTab);
        ScrollView scrollView = findViewById(R.id.scrollHelp);

        scrollView.setBackgroundResource(R.drawable.background_primary);

        //relativeLayout.setBackgroundResource(R.drawable.background_primary);
        int dark = ColorUtil.darken(this.getResources().getColor(R.color.colorPrimary), 12);
        window.setStatusBarColor(dark);

        toolbar.setTitle("");
        //toolbar.setTitle(Selection.subject);
        setSupportActionBar(toolbar);

        et.setBackgroundResource(R.drawable.edittextline);
        et1.setBackgroundResource(R.drawable.edittextline);
        et2.setBackgroundResource(R.drawable.edittextline);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message="Feedback:\n"+et.getText().toString()+"\n"+et1.getText().toString()+"\n"+et2.getText().toString()
                        +"\n";
                String text="https://wa.me/918088542610?text="+message;
                Uri uri = Uri.parse(text)
                        .buildUpon()
                        .appendQueryParameter("key", "val")
                        .build();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });
    }
    @Override
    public void finish() {
        super.finish();
    }
}

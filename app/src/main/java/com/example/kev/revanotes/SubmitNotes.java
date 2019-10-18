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

public class SubmitNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_notes);


        Toolbar toolbar = (Toolbar) findViewById(R.id.submitToolbarTab);
        final EditText et = (EditText) findViewById(R.id.etSubmit);
        final EditText et1 = (EditText) findViewById(R.id.et1Submit);
        final EditText et2 = (EditText) findViewById(R.id.et2Submit);
        Button bt= (Button) findViewById(R.id.btSubmit);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        RelativeLayout relativeLayout = findViewById(R.id.relativeDisplayTab);
        ScrollView scrollView = findViewById(R.id.scrollSubmit);
        if (Selection.branch.equals(getString(R.string.CS))) {
            //relativeLayout.setBackgroundResource(R.drawable.background_cs);
            scrollView.setBackgroundResource(R.drawable.background_cs);
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.CS), 12);
            bt.setBackgroundColor(this.getResources().getColor(R.color.CS));
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Mech))) {
            //relativeLayout.setBackgroundResource(R.drawable.background_mech);
            scrollView.setBackgroundResource(R.drawable.background_mech);
            bt.setBackgroundColor(this.getResources().getColor(R.color.Mech));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Mech), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EE))) {
            //relativeLayout.setBackgroundResource(R.drawable.background_ee);
            scrollView.setBackgroundResource(R.drawable.background_ee);
            bt.setBackgroundColor(this.getResources().getColor(R.color.EE));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EE), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EC))) {
            //relativeLayout.setBackgroundResource(R.drawable.background_ec);
            scrollView.setBackgroundResource(R.drawable.background_ec);
            bt.setBackgroundColor(this.getResources().getColor(R.color.EC));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EC), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Civil))) {
            //relativeLayout.setBackgroundResource(R.drawable.background_civil);
            scrollView.setBackgroundResource(R.drawable.background_civil);
            bt.setBackgroundColor(this.getResources().getColor(R.color.Civil));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Civil), 12);
            window.setStatusBarColor(dark);
        }
        toolbar.setTitle("");
        //toolbar.setTitle(Selection.subject);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



        et.setText("Branch: "+Selection.branch+"\nSemester: "+Selection.semester+"\nSubject: "+Selection.subject);
        et.setBackgroundResource(R.drawable.edittextline);
        et1.setBackgroundResource(R.drawable.edittextline);
        et2.setBackgroundResource(R.drawable.edittextline);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message="NOTES FOR VALIDATION:\n"+et.getText().toString()+"\n"+et1.getText().toString()+"\n"+et2.getText().toString()
                        +"\n"+"Please find the Notes attached below.";
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
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}

package com.example.kev.revanotes;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SemesterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SemesterAdapter semAdapter;
    List<Semester> semList;
    String branch;
    TextView selectedBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        Toolbar toolbar = findViewById(R.id.semesterToolbar);
        selectedBranch=findViewById(R.id.selectSemester);
        Window window = this.getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        RelativeLayout relativeLayout = findViewById(R.id.relativeSemester);
        if (Selection.branch.equals(getString(R.string.CS))) {
            relativeLayout.setBackgroundResource(R.drawable.background_cs);
            selectedBranch.setText("COMPUTER SCIENCE");
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.CS), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Mech))) {
            relativeLayout.setBackgroundResource(R.drawable.background_mech);
            selectedBranch.setText("MECHANICAL");
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Mech), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EE))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ee);
            selectedBranch.setText("ELECTRICAL AND ELECTRONICS");
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EE), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EC))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ec);
            selectedBranch.setText("ELECTRICAL AND COMMUNICATION");
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EC), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Civil))) {
            relativeLayout.setBackgroundResource(R.drawable.background_civil);
            selectedBranch.setText("CIVIL");
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Civil), 12);
            window.setStatusBarColor(dark);
        }

        semList = new ArrayList<>();

        //recyclerView.setHasFixedSize(true);
        //toolbar.setTitle(Selection.branch);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        recyclerView = findViewById(R.id.semRecycler);
        recyclerView.setLayoutManager((new GridLayoutManager(this,2)));

        branch = Selection.branch;
        if (branch.equals("Computer Science Engineering") || branch.equals("Mechanical Engineering") || branch.equals("Electrical and Electronics Engineering") || branch.equals("Civil Engineering") || branch.equals("Electronics and Communication Engineering")) {
            semList.add(new Semester(1, "1st SEM"));
            semList.add(new Semester(2, "2nd SEM"));
            semList.add(new Semester(3, "3rd SEM"));
            semList.add(new Semester(4, "4th SEM"));
            semList.add(new Semester(5, "5th SEM"));
            semList.add(new Semester(6, "6th SEM"));
            semList.add(new Semester(7, "7th SEM"));
            semList.add(new Semester(8, "8th SEM"));
            /*semList.add(new Semester(1, "First Semester"));
            semList.add(new Semester(2, "Second Semester"));
            semList.add(new Semester(3, "Third Semester"));
            semList.add(new Semester(4, "Fourth Semester"));
            semList.add(new Semester(5, "Fifth Semester"));
            semList.add(new Semester(6, "Sixth Semester"));
            semList.add(new Semester(7, "Seventh Semester"));
            semList.add(new Semester(8, "Eighth Semester"));*/
        } else {
            semList.add(new Semester(8, "Eighth Semester"));
        }


        semAdapter = new SemesterAdapter(this, semList);
        recyclerView.setAdapter(semAdapter);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

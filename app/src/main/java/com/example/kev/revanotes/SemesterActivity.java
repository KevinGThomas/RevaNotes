package com.example.kev.revanotes;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class SemesterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SemesterAdapter semAdapter;
    List<Semester> semList;
    String branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        RelativeLayout relativeLayout = findViewById(R.id.relativeSemester);
        if (Selection.branch.equals("Computer Science Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.CS));
            window.setStatusBarColor(this.getResources().getColor(R.color.CS));
        } else if (Selection.branch.equals("Mechanical Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.Mech));
            window.setStatusBarColor(this.getResources().getColor(R.color.Mech));
        } else if (Selection.branch.equals("Electrical and Electronics Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.EE));
            window.setStatusBarColor(this.getResources().getColor(R.color.EE));
        } else if (Selection.branch.equals("Electronics and Communication Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.EC));
            window.setStatusBarColor(this.getResources().getColor(R.color.EC));
        } else if (Selection.branch.equals("Civil Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.Civil));
            window.setStatusBarColor(this.getResources().getColor(R.color.Civil));
        }

        semList = new ArrayList<>();
        recyclerView = findViewById(R.id.semRecycler);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.semesterToolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });

        branch = Selection.branch;
        if (branch.equals("Computer Science Engineering") || branch.equals("Mechanical Engineering") || branch.equals("Electrical and Electronics Engineering") || branch.equals("Civil Engineering") || branch.equals("Electronics and Communication Engineering")) {
            semList.add(new Semester(1, "First Semester"));
            semList.add(new Semester(2, "Second Semester"));
            semList.add(new Semester(3, "Third Semester"));
            semList.add(new Semester(4, "Fourth Semester"));
            semList.add(new Semester(5, "Fifth Semester"));
            semList.add(new Semester(6, "Sixth Semester"));
            semList.add(new Semester(7, "Seventh Semester"));
            semList.add(new Semester(8, "Eighth Semester"));
        } else {
            semList.add(new Semester(8, "Eighth Semester"));
        }

        semAdapter = new SemesterAdapter(this, semList);
        recyclerView.setAdapter(semAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*switch(item.getItemId()){
            case R.id.item1:
                Intent intent2=new Intent(Activity.this,UploadActivity.class);
                startActivity(intent2);
                break;

        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu, menu);
        return true;
    }
}

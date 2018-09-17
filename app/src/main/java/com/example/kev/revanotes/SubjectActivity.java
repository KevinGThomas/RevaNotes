package com.example.kev.revanotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SubjectAdapter subAdapter;
    List<Subject> subList;
    String branch, semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar=findViewById(R.id.subjectToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });

        subList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.subRecycler);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        branch = Selection.branch;
        semester = Selection.semester;
        if (branch.equals("Computer Science Engineering")) {
            if (semester.equals("First Semester")) {
                subList.add(new Subject(1, "Multivariable Calculus and Linear Algebra"));
                subList.add(new Subject(2, "Chemistry"));
                subList.add(new Subject(3, "Programming for Problem Solving"));
                subList.add(new Subject(4, "Basic Electrical and Electronics Engineering"));
                subList.add(new Subject(5, "Environmental Science"));
                subList.add(new Subject(6, "Technical English-1"));
            } else {
                subList.add(new Subject(1, "Mathematics"));
            }
        } else {
            subList.add(new Subject(1, "Mathematics"));
        }

        subAdapter = new SubjectAdapter(this, subList);
        recyclerView.setAdapter(subAdapter);
    }
}

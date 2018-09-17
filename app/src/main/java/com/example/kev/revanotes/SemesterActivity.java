package com.example.kev.revanotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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

        semList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.semRecycler);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar=findViewById(R.id.semesterToolbar);
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
        }
        semList.add(new Semester(8, "Eighth Semester"));

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
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.display_menu,menu);
        return true;
    }
}

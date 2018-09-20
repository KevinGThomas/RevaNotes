package com.example.kev.revanotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String selectedBranchName;
    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<Branch> branchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        branchList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerBranch);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        branchList.add(new Branch(1,"Computer Science Engineering"));
        branchList.add(new Branch(2,"Mechanical Engineering"));
        branchList.add(new Branch(3,"Electrical and Electronics Engineering"));
        branchList.add(new Branch(4,"Electronics and Communication Engineering"));
        branchList.add(new Branch(5,"Civil Engineering"));
        //branchList.add(new Branch(6,"Architecture"));
        //branchList.add(new Branch(7,"Business Administration"));
        //branchList.add(new Branch(8,"Commerce"));

        mainAdapter=new MainAdapter(this,branchList);
        recyclerView.setAdapter(mainAdapter);

    }
}

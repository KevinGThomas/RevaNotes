package com.example.kev.revanotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

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

        Toolbar toolbar = findViewById(R.id.mainToolbar);

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);

        branchList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerBranch);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        branchList.add(new Branch(1, getString(R.string.CS)));
        branchList.add(new Branch(2, getString(R.string.Mech)));
        branchList.add(new Branch(3, getString(R.string.EE)));
        branchList.add(new Branch(4, getString(R.string.EC)));
        branchList.add(new Branch(5, getString(R.string.Civil)));
        //branchList.add(new Branch(6,"Architecture"));
        //branchList.add(new Branch(7,"Business Administration"));
        //branchList.add(new Branch(8,"Commerce"));

        mainAdapter = new MainAdapter(this, branchList);
        recyclerView.setAdapter(mainAdapter);

    }
}

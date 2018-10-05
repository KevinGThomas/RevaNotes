package com.example.kev.revanotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_white));
        setSupportActionBar(toolbar);

        branchList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerBranch);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        branchList.add(new Branch(1, getString(R.string.CS),R.drawable.cs_card));
        branchList.add(new Branch(2, getString(R.string.Mech),R.drawable.mech_card));
        branchList.add(new Branch(3, getString(R.string.EE),R.drawable.ee_card));
        branchList.add(new Branch(4, getString(R.string.EC),R.drawable.ec_card));
        branchList.add(new Branch(5, getString(R.string.Civil),R.drawable.civil_card));
        //branchList.add(new Branch(6,"Architecture"));
        //branchList.add(new Branch(7,"Business Administration"));
        //branchList.add(new Branch(8,"Commerce"));

        mainAdapter = new MainAdapter(this, branchList);
        recyclerView.setAdapter(mainAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.item1:
                //Toast.makeText(getApplicationContext(),"This works",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent2);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}

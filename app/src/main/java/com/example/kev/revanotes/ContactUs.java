package com.example.kev.revanotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ContactUs extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    List<Contacts> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Toolbar toolbar = findViewById(R.id.contactToolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_white));
        toolbar.setTitle("Contact Us");

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        contactList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_contact);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactList.add(new Contacts(1, "Kevin George Thomas","Email: kevingt2007@gmail.com",R.drawable.kevin));
        contactList.add(new Contacts(2, "Harsha Vardhan MN","Email: harsa007123@gmail.com",R.drawable.harsha_pic));
        contactList.add(new Contacts(3, "Prof. Surekha Thota", "Email: surekha.thota@reva.edu.in",R.drawable.surekha_pic));
        contactList.add(new Contacts(4, "Prof. Rathan","Email: rathan.muralidhar@gmail.com",R.drawable.rathan_sir));

        contactAdapter = new ContactAdapter(this, contactList);
        recyclerView.setAdapter(contactAdapter);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

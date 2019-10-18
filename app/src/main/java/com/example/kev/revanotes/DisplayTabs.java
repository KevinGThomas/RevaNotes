package com.example.kev.revanotes;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayTabs extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    TextView selectedSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.displayToolbarTab);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        selectedSubject=findViewById(R.id.selectDisplayTab);

        RelativeLayout relativeLayout = findViewById(R.id.relativeDisplayTab);
        if (Selection.branch.equals(getString(R.string.CS))) {
            relativeLayout.setBackgroundResource(R.drawable.background_cs);
            selectedSubject.setText(Selection.subject.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.CS), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Mech))) {
            relativeLayout.setBackgroundResource(R.drawable.background_mech);
            selectedSubject.setText(Selection.subject.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Mech), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EE))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ee);
            selectedSubject.setText(Selection.subject.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EE), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EC))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ec);
            selectedSubject.setText(Selection.subject.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EC), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Civil))) {
            relativeLayout.setBackgroundResource(R.drawable.background_civil);
            selectedSubject.setText(Selection.subject.toUpperCase());
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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_tabs, menu);
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
                Intent intent2 = new Intent(DisplayTabs.this, UploadLogin.class);
                startActivity(intent2);
                break;
            case R.id.item2:
                //Toast.makeText(getApplicationContext(),"This works",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(DisplayTabs.this, HelpActivity.class);
                startActivity(intent3);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
           // Fragment fragment=null;
            switch(position)
            {
                case 0:
                    //Add Notes Fragment here
                    //fragment=new Notes();
                    return NotesFragment.newInstance();
                    //Notes notes=new Notes();
                    //BlankFragment notes=new BlankFragment();
                    //return notes;
                    //return BlankFragment.newInstance("k","kk");
                    //fragment=Notes.newInstance(null,null);
                case 1:
                    //fragment=new PYQ();
                    //fragment=PYQ.newInstance(null,null);
                    //PYQ pyq=new PYQ();
                    return PYQFragment.newInstance();
                    //BlankFragment pyq=new BlankFragment();
                    //return BlankFragment.newInstance("hi","hi2");
                    //return pyq;
            }
            return null;
            //return BlankFragment.newInstance("hi","hi2");
            //return Example.newInstance();
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position)
            {
                case 0:
                    return "Notes";
                case 1:
                    return "PYQ";
            }
            return null;
        }
    }
}

package com.example.kev.revanotes;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SubjectAdapter subAdapter;
    List<Subject> subList;
    String branch, semester;
    TextView selectedSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Toolbar toolbar = findViewById(R.id.subjectToolbar);
        selectedSemester = findViewById(R.id.selectSubject);
        toolbar.setTitle("");


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        RelativeLayout relativeLayout = findViewById(R.id.relativeSubject);
        if (Selection.branch.equals(getString(R.string.CS))) {
            relativeLayout.setBackgroundResource(R.drawable.background_cs);
            selectedSemester.setText(Selection.semester.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.CS), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Mech))) {
            relativeLayout.setBackgroundResource(R.drawable.background_mech);
            selectedSemester.setText(Selection.semester.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Mech), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EE))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ee);
            selectedSemester.setText(Selection.semester.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EE), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.EC))) {
            relativeLayout.setBackgroundResource(R.drawable.background_ec);
            selectedSemester.setText(Selection.semester.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EC), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals(getString(R.string.Civil))) {
            relativeLayout.setBackgroundResource(R.drawable.background_civil);
            selectedSemester.setText(Selection.semester.toUpperCase());
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Civil), 12);
            window.setStatusBarColor(dark);
        }
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //toolbar.setTitle(Selection.semester);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });


        subList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.subRecycler);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        branch = Selection.branch;
        semester = Selection.semester;
        if (branch.equals(getString(R.string.CS))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.CS_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.CS_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.CS_1_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.CS_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.CS_1_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.CS_1_Sub6), "TE-1"));
            } else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.CS_2_Sub1), "M-2"));
                subList.add(new Subject(2, getString(R.string.CS_2_Sub2), "PHY"));
                subList.add(new Subject(3, getString(R.string.CS_2_Sub3), "OOP"));
                subList.add(new Subject(4, getString(R.string.CS_2_Sub4), "TE-2"));
                subList.add(new Subject(5, getString(R.string.CS_2_Sub5), "ICP"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.CS_3_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_3_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_3_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_3_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_3_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.CS_3_Sub6), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.CS_4_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.CS_4_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.CS_4_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.CS_4_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.CS_4_Sub9), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.CS_5_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_5_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_5_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_5_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_5_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.CS_5_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.CS_5_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.CS_5_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.CS_5_Sub9), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.CS_6_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_6_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_6_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_6_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_6_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.CS_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.CS_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.CS_6_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.CS_6_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.CS_6_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.CS_6_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.CS_6_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.CS_6_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.CS_6_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.CS_6_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.CS_6_Sub16), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.CS_7_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_7_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_7_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_7_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_7_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.CS_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.CS_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.CS_7_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.CS_7_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.CS_7_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.CS_7_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.CS_7_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.CS_7_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.CS_7_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.CS_7_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.CS_7_Sub16), "SE"));
                subList.add(new Subject(17, getString(R.string.CS_7_Sub17), "SE"));
                subList.add(new Subject(18, getString(R.string.CS_7_Sub18), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.CS_8_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.CS_8_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.CS_8_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.CS_8_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.CS_8_Sub5), "DM"));
                //subList.add(new Subject(1, "Mathematics",""));
            }


        } else if (branch.equals(getString(R.string.Mech))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.Mech_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Mech_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Mech_1_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Mech_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Mech_1_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Mech_1_Sub6), "TE-1"));

            } else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.Mech_2_Sub1), "M-2"));
                subList.add(new Subject(2, getString(R.string.Mech_2_Sub2), "PHY"));
                subList.add(new Subject(3, getString(R.string.Mech_2_Sub3), "OOP"));
                subList.add(new Subject(4, getString(R.string.Mech_2_Sub4), "TE-2"));
                subList.add(new Subject(5, getString(R.string.Mech_2_Sub5), "ICP"));
                subList.add(new Subject(6, getString(R.string.Mech_2_Sub6), "ICP"));
                subList.add(new Subject(7, getString(R.string.Mech_2_Sub7), "ICP"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.Mech_3_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_3_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_3_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_3_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_3_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_3_Sub6), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.Mech_4_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_4_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.Mech_4_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.Mech_4_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.Mech_4_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.Mech_4_Sub10), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.Mech_5_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_5_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_5_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_5_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_5_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_5_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.Mech_5_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.Mech_5_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.Mech_5_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.Mech_5_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.Mech_5_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.Mech_5_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.Mech_5_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.Mech_5_Sub14), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.Mech_6_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_6_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_6_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_6_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_6_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.Mech_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.Mech_6_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.Mech_6_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.Mech_6_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.Mech_6_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.Mech_6_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.Mech_6_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.Mech_6_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.Mech_6_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.Mech_6_Sub16), "SE"));
                subList.add(new Subject(17, getString(R.string.Mech_6_Sub17), "SE"));
                subList.add(new Subject(18, getString(R.string.Mech_6_Sub18), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.Mech_7_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_7_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_7_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_7_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_7_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.Mech_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.Mech_7_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.Mech_7_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.Mech_7_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.Mech_7_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.Mech_7_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.Mech_7_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.Mech_7_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.Mech_7_Sub15), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.Mech_8_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_8_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_8_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_8_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_8_Sub5), "DM"));
                //subList.add(new Subject(1, "Mathematics",""));
            }
        } else if (branch.equals(getString(R.string.EE))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.EE_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.EE_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.EE_1_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.EE_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.EE_1_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.EE_1_Sub6), "TE-1"));
                subList.add(new Subject(7, getString(R.string.EE_1_Sub7), "TE-1"));

            } else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.EE_2_Sub1), "M-2"));
                subList.add(new Subject(2, getString(R.string.EE_2_Sub2), "PHY"));
                subList.add(new Subject(3, getString(R.string.EE_2_Sub3), "OOP"));
                subList.add(new Subject(4, getString(R.string.EE_2_Sub4), "TE-2"));
                subList.add(new Subject(5, getString(R.string.EE_2_Sub5), "ICP"));
                subList.add(new Subject(6, getString(R.string.EE_2_Sub6), "ICP"));
                subList.add(new Subject(7, getString(R.string.EE_2_Sub7), "ICP"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.EE_3_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_3_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_3_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_3_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EE_3_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EE_3_Sub6), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.EE_4_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EE_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EE_4_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EE_4_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EE_4_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EE_4_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EE_4_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EE_4_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EE_4_Sub12), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.EE_5_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_5_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_5_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_5_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EE_5_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EE_5_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EE_5_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EE_5_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EE_5_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EE_5_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EE_5_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EE_5_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.EE_5_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.EE_5_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.EE_5_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.EE_5_Sub16), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.EE_6_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_6_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_6_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_6_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EE_6_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EE_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EE_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EE_6_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EE_6_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EE_6_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EE_6_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EE_6_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.EE_6_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.EE_6_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.EE_6_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.EE_6_Sub16), "SE"));
                subList.add(new Subject(17, getString(R.string.EE_6_Sub17), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.EE_7_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_7_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_7_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_7_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EE_7_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EE_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EE_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EE_7_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EE_7_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EE_7_Sub10), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.EE_8_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EE_8_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EE_8_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EE_8_Sub4), "DS"));
                //subList.add(new Subject(1, "Mathematics",""));
            }
        } else if (branch.equals(getString(R.string.EC))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.EC_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.EC_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.EC_1_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.EC_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.EC_1_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.EC_1_Sub6), "TE-1"));
                subList.add(new Subject(7, getString(R.string.EC_1_Sub7), "TE-1"));

            } else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.EC_2_Sub1), "M-2"));
                subList.add(new Subject(2, getString(R.string.EC_2_Sub2), "PHY"));
                subList.add(new Subject(3, getString(R.string.EC_2_Sub3), "OOP"));
                subList.add(new Subject(4, getString(R.string.EC_2_Sub4), "TE-2"));
                subList.add(new Subject(5, getString(R.string.EC_2_Sub5), "ICP"));
                subList.add(new Subject(6, getString(R.string.EC_2_Sub6), "ICP"));
                subList.add(new Subject(7, getString(R.string.EC_2_Sub7), "ICP"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.EC_3_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_3_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_3_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_3_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_3_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_3_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EC_3_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EC_3_Sub8), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.EC_4_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_4_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EC_4_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EC_4_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EC_4_Sub9), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.EC_5_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_5_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_5_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_5_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_5_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_5_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EC_5_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EC_5_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EC_5_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EC_5_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EC_5_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EC_5_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.EC_5_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.EC_5_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.EC_5_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.EC_5_Sub16), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.EC_6_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_6_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_6_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_6_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_6_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EC_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EC_6_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EC_6_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EC_6_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EC_6_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EC_6_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.EC_6_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.EC_6_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.EC_6_Sub15), "SE"));
                subList.add(new Subject(16, getString(R.string.EC_6_Sub16), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.EC_7_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_7_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_7_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_7_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_7_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_6_Sub6), "SE"));
                subList.add(new Subject(7, getString(R.string.EC_6_Sub7), "SE"));
                subList.add(new Subject(8, getString(R.string.EC_7_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.EC_7_Sub9), "SE"));
                subList.add(new Subject(10, getString(R.string.EC_7_Sub10), "SE"));
                subList.add(new Subject(11, getString(R.string.EC_7_Sub11), "SE"));
                subList.add(new Subject(12, getString(R.string.EC_7_Sub12), "SE"));
                subList.add(new Subject(13, getString(R.string.EC_7_Sub13), "SE"));
                subList.add(new Subject(14, getString(R.string.EC_7_Sub14), "SE"));
                subList.add(new Subject(15, getString(R.string.EC_7_Sub15), "SE"));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.EC_8_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.EC_8_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_8_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_8_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_8_Sub5), "DS"));
                subList.add(new Subject(6, getString(R.string.EC_8_Sub6), "DS"));
                subList.add(new Subject(7, getString(R.string.EC_8_Sub7), "DS"));
                subList.add(new Subject(8, getString(R.string.EC_8_Sub8), "DS"));
            }
        } else if (branch.equals(getString(R.string.Civil))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.Civil_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_1_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_1_Sub5), "ES"));
            }
            else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.Civil_2_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_2_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_2_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_2_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_2_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_2_Sub6), "ES"));
            }
            else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.Civil_3_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_3_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_3_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_3_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_3_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_3_Sub6), "ES"));
            }
            else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.Civil_4_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_4_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_4_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_4_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_4_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_4_Sub6), "ES"));
                subList.add(new Subject(7, getString(R.string.Civil_4_Sub7), "ES"));
                subList.add(new Subject(8, getString(R.string.Civil_4_Sub8), "ES"));
                subList.add(new Subject(9, getString(R.string.Civil_4_Sub9), "ES"));
            }
            else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.Civil_5_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_5_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_5_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_5_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_5_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_5_Sub6), "ES"));
                subList.add(new Subject(7, getString(R.string.Civil_5_Sub7), "ES"));
                subList.add(new Subject(8, getString(R.string.Civil_5_Sub8), "ES"));
                subList.add(new Subject(9, getString(R.string.Civil_5_Sub9), "ES"));
                subList.add(new Subject(10, getString(R.string.Civil_5_Sub10), "ES"));
                subList.add(new Subject(11, getString(R.string.Civil_5_Sub11), "ES"));
                subList.add(new Subject(12, getString(R.string.Civil_5_Sub12), "ES"));
                subList.add(new Subject(13, getString(R.string.Civil_5_Sub13), "ES"));
                subList.add(new Subject(14, getString(R.string.Civil_5_Sub14), "ES"));
                subList.add(new Subject(15, getString(R.string.Civil_5_Sub15), "ES"));
            }
            else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.Civil_6_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_6_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_6_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_6_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_6_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_6_Sub6), "ES"));
                subList.add(new Subject(7, getString(R.string.Civil_6_Sub7), "ES"));
                subList.add(new Subject(8, getString(R.string.Civil_6_Sub8), "ES"));
                subList.add(new Subject(9, getString(R.string.Civil_6_Sub9), "ES"));
                subList.add(new Subject(10, getString(R.string.Civil_6_Sub10), "ES"));
                subList.add(new Subject(11, getString(R.string.Civil_6_Sub11), "ES"));
                subList.add(new Subject(12, getString(R.string.Civil_6_Sub12), "ES"));
            }
            else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.Civil_7_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Civil_7_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Civil_7_Sub3), "PPS"));
                subList.add(new Subject(4, getString(R.string.Civil_7_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.Civil_7_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Civil_7_Sub6), "ES"));
                subList.add(new Subject(7, getString(R.string.Civil_7_Sub7), "ES"));
                subList.add(new Subject(8, getString(R.string.Civil_7_Sub8), "ES"));
                subList.add(new Subject(9, getString(R.string.Civil_7_Sub9), "ES"));
                subList.add(new Subject(10, getString(R.string.Civil_7_Sub10), "ES"));
                subList.add(new Subject(11, getString(R.string.Civil_7_Sub11), "ES"));
                subList.add(new Subject(12, getString(R.string.Civil_7_Sub12), "ES"));
                subList.add(new Subject(13, getString(R.string.Civil_7_Sub13), "ES"));
                subList.add(new Subject(14, getString(R.string.Civil_7_Sub14), "ES"));
            }
            else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.Civil_8_Sub1), "M-1"));
            }

        }
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        //recyclerView.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.recycler_corner));
        //recyclerView.setBackground(ContextCompat.getDrawable(this,com.example.kev.revanotes.R.drawable.recycler_corner));

        subAdapter = new SubjectAdapter(this, subList);
        recyclerView.setAdapter(subAdapter);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

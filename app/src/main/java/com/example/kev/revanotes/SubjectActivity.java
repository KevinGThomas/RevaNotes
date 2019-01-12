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
                subList.add(new Subject(1, getString(R.string.CS_4_Sub1), "GTA"));
                subList.add(new Subject(2, getString(R.string.CS_4_Sub2), "M-4"));
                subList.add(new Subject(3, getString(R.string.CS_4_Sub3), "DAA"));
                subList.add(new Subject(4, getString(R.string.CS_4_Sub4), "mC"));
                subList.add(new Subject(5, getString(R.string.CS_4_Sub5), "FAFL"));
                subList.add(new Subject(6, getString(R.string.CS_4_Sub6), "SS"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.CS_5_Sub1), "FAFL"));
                subList.add(new Subject(2, getString(R.string.CS_5_Sub2), "PDA"));
                subList.add(new Subject(3, getString(R.string.CS_5_Sub3), "CN"));
                subList.add(new Subject(4, getString(R.string.CS_5_Sub4), "OS"));
                subList.add(new Subject(5, getString(R.string.CS_5_Sub5), "USP"));
                subList.add(new Subject(6, getString(R.string.CS_5_Sub6), "ADBMS"));
                subList.add(new Subject(7, getString(R.string.CS_5_Sub7), "IR"));
                subList.add(new Subject(8, getString(R.string.CS_5_Sub8), "HPC"));
                subList.add(new Subject(9, getString(R.string.CS_5_Sub9), "DDE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.CS_6_Sub1), "SET"));
                subList.add(new Subject(2, getString(R.string.CS_6_Sub2), "VCC"));
                subList.add(new Subject(3, getString(R.string.CS_6_Sub3), "CNS"));
                subList.add(new Subject(4, getString(R.string.CS_6_Sub4), "DMT"));
                subList.add(new Subject(5, getString(R.string.CS_6_Sub5), "ES&IOT"));
                subList.add(new Subject(6, getString(R.string.CS_6_Sub6), "DIP"));
                subList.add(new Subject(7, getString(R.string.CS_6_Sub7), "USP"));
                subList.add(new Subject(8, getString(R.string.CS_6_Sub8), "IA"));
                subList.add(new Subject(9, getString(R.string.CS_6_Sub9), "SC"));
                subList.add(new Subject(10, getString(R.string.CS_6_Sub10), "JAVA"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.CS_7_Sub1), "WAD"));
                subList.add(new Subject(2, getString(R.string.CS_7_Sub2), "CNS"));
                subList.add(new Subject(3, getString(R.string.CS_7_Sub3), "ASAN"));
                subList.add(new Subject(4, getString(R.string.CS_7_Sub4), "NP"));
                subList.add(new Subject(5, getString(R.string.CS_7_Sub5), "CAN"));
                subList.add(new Subject(6, getString(R.string.CS_6_Sub6), "ACI"));
                subList.add(new Subject(7, getString(R.string.CS_6_Sub7), "CDV"));
                subList.add(new Subject(8, getString(R.string.CS_7_Sub8), "DL"));
                subList.add(new Subject(9, getString(R.string.CS_7_Sub9), "MCN"));
                subList.add(new Subject(10, getString(R.string.CS_7_Sub10), "BIPM"));
                subList.add(new Subject(11, getString(R.string.CS_7_Sub11), "HCI"));
                subList.add(new Subject(12, getString(R.string.CS_7_Sub12), "CGA"));
                subList.add(new Subject(13, getString(R.string.CS_7_Sub13), "SDNNFV"));
                subList.add(new Subject(14, getString(R.string.CS_7_Sub14), "EC"));
                subList.add(new Subject(15, getString(R.string.CS_7_Sub15), "BDA"));
                subList.add(new Subject(16, getString(R.string.CS_7_Sub16), "BCT"));
                subList.add(new Subject(17, getString(R.string.CS_7_Sub17), "CS"));
                subList.add(new Subject(18, getString(R.string.CS_7_Sub18), "CD"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.CS_8_Sub1), "AWT"));
                subList.add(new Subject(2, getString(R.string.CS_8_Sub2), "EH&ITSE"));
                subList.add(new Subject(3, getString(R.string.CS_8_Sub3), "CSC"));
                subList.add(new Subject(4, getString(R.string.CS_8_Sub4), "NLP"));
                subList.add(new Subject(5, getString(R.string.CS_8_Sub5), "PA"));
                //subList.add(new Subject(1, "Mathematics",""));
            }


        } else if (branch.equals(getString(R.string.Mech))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.Mech_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Mech_1_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.Mech_1_Sub3), "BEE"));
                subList.add(new Subject(4, getString(R.string.Mech_1_Sub4), "CAED"));
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
                subList.add(new Subject(1, getString(R.string.Mech_3_Sub1), "NMP"));
                subList.add(new Subject(2, getString(R.string.Mech_3_Sub2), "MM"));
                subList.add(new Subject(3, getString(R.string.Mech_3_Sub3), "ET"));
                subList.add(new Subject(4, getString(R.string.Mech_3_Sub4), "FMFM"));
                subList.add(new Subject(5, getString(R.string.Mech_3_Sub5), "MMM"));
                subList.add(new Subject(6, getString(R.string.Mech_3_Sub6), "TMCMT"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.Mech_4_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_4_Sub6), "SE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.Mech_5_Sub1), "DME"));
                subList.add(new Subject(2, getString(R.string.Mech_5_Sub2), "TM"));
                subList.add(new Subject(3, getString(R.string.Mech_5_Sub3), "PPE"));
                subList.add(new Subject(4, getString(R.string.Mech_5_Sub4), "CM"));
                subList.add(new Subject(5, getString(R.string.Mech_5_Sub5), "HP"));
                subList.add(new Subject(6, getString(R.string.Mech_5_Sub6), "PM"));
                subList.add(new Subject(7, getString(R.string.Mech_5_Sub7), "DBMS"));
                subList.add(new Subject(8, getString(R.string.Mech_5_Sub8), "RER"));
                subList.add(new Subject(9, getString(R.string.Mech_5_Sub9), "TE"));
                subList.add(new Subject(10, getString(R.string.Mech_5_Sub10), "NTM"));
                subList.add(new Subject(11, getString(R.string.Mech_5_Sub11), "MM"));
                subList.add(new Subject(12, getString(R.string.Mech_5_Sub12), "JP"));
                subList.add(new Subject(13, getString(R.string.Mech_5_Sub13), "DM"));
                subList.add(new Subject(14, getString(R.string.Mech_5_Sub14), "MFP"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.Mech_6_Sub1), "FEM"));
                subList.add(new Subject(2, getString(R.string.Mech_6_Sub2), "H&MT"));
                subList.add(new Subject(3, getString(R.string.Mech_6_Sub3), "CAD"));
                subList.add(new Subject(4, getString(R.string.Mech_6_Sub4), "MD-2"));
                subList.add(new Subject(5, getString(R.string.Mech_6_Sub5), "MT-3"));
                subList.add(new Subject(6, getString(R.string.Mech_6_Sub6), "PP&C"));
                subList.add(new Subject(7, getString(R.string.Mech_6_Sub7), "TE"));
                subList.add(new Subject(8, getString(R.string.Mech_6_Sub8), "RER"));
                subList.add(new Subject(9, getString(R.string.Mech_6_Sub9), "M&mP"));
                subList.add(new Subject(10, getString(R.string.Mech_6_Sub10), "IE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.Mech_7_Sub1), "FEM"));
                subList.add(new Subject(2, getString(R.string.Mech_7_Sub2), "CE"));
                subList.add(new Subject(3, getString(R.string.Mech_7_Sub3), "EEFM"));
                subList.add(new Subject(4, getString(R.string.Mech_7_Sub4), "CE"));
                subList.add(new Subject(5, getString(R.string.Mech_7_Sub5), "TBD"));
                subList.add(new Subject(6, getString(R.string.Mech_6_Sub6), "MLP"));
                subList.add(new Subject(7, getString(R.string.Mech_6_Sub7), "RAC"));
                subList.add(new Subject(8, getString(R.string.Mech_7_Sub8), "SE"));
                subList.add(new Subject(9, getString(R.string.Mech_7_Sub9), "CFD"));
                subList.add(new Subject(10, getString(R.string.Mech_7_Sub10), "MV"));
                subList.add(new Subject(11, getString(R.string.Mech_7_Sub11), "OR"));
                subList.add(new Subject(12, getString(R.string.Mech_7_Sub12), "GTJP"));
                subList.add(new Subject(13, getString(R.string.Mech_7_Sub13), "DARP"));
                subList.add(new Subject(14, getString(R.string.Mech_7_Sub14), "PM"));
                subList.add(new Subject(15, getString(R.string.Mech_7_Sub15), "AE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.Mech_8_Sub1), "LD"));
                subList.add(new Subject(2, getString(R.string.Mech_8_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.Mech_8_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.Mech_8_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.Mech_8_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.Mech_8_Sub6), "DM"));
                subList.add(new Subject(7, getString(R.string.Mech_8_Sub7), "DM"));
                //subList.add(new Subject(1, "Mathematics",""));
            }
        } else if (branch.equals(getString(R.string.EE))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.EE_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.EE_1_Sub2), "P"));
                subList.add(new Subject(3, getString(R.string.EE_1_Sub3), "M"));
                subList.add(new Subject(4, getString(R.string.EE_1_Sub4), "EME"));
                subList.add(new Subject(5, getString(R.string.EE_1_Sub5), "BEE"));
                subList.add(new Subject(6, getString(R.string.EE_1_Sub6), "ICP"));
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
                subList.add(new Subject(1, getString(R.string.EE_3_Sub1), "M-3"));
                subList.add(new Subject(2, getString(R.string.EE_3_Sub2), "ECT"));
                subList.add(new Subject(3, getString(R.string.EE_3_Sub3), "EM-1"));
                subList.add(new Subject(4, getString(R.string.EE_3_Sub4), "AEDECD"));
                subList.add(new Subject(5, getString(R.string.EE_3_Sub5), "TALIC"));
                subList.add(new Subject(6, getString(R.string.EE_3_Sub6), "MA"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.EE_4_Sub1), "M-4"));
                subList.add(new Subject(2, getString(R.string.EE_4_Sub2), "ECT-2"));
                subList.add(new Subject(3, getString(R.string.EE_4_Sub3), "EM-1"));
                subList.add(new Subject(4, getString(R.string.EE_4_Sub4), "mC&A"));
                subList.add(new Subject(5, getString(R.string.EE_4_Sub5), "PE"));
                subList.add(new Subject(6, getString(R.string.EE_4_Sub6), "EMT"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.EE_5_Sub1), "PSA"));
                subList.add(new Subject(2, getString(R.string.EE_5_Sub2), "ET"));
                subList.add(new Subject(3, getString(R.string.EE_5_Sub3), "SGP"));
                subList.add(new Subject(4, getString(R.string.EE_5_Sub4), "HVE"));
                subList.add(new Subject(5, getString(R.string.EE_5_Sub5), "DEM"));
                subList.add(new Subject(6, getString(R.string.EE_5_Sub6), "APE"));
                subList.add(new Subject(7, getString(R.string.EE_5_Sub7), "VLSI"));
                subList.add(new Subject(8, getString(R.string.EE_5_Sub8), "P"));
                subList.add(new Subject(9, getString(R.string.EE_5_Sub9), "OR"));
                subList.add(new Subject(10, getString(R.string.EE_5_Sub10), "EHV"));
                subList.add(new Subject(11, getString(R.string.EE_5_Sub11), "DIP"));
                subList.add(new Subject(12, getString(R.string.EE_5_Sub12), "WP"));
                subList.add(new Subject(13, getString(R.string.EE_5_Sub13), "EPQ"));
                subList.add(new Subject(14, getString(R.string.EE_5_Sub14), "ESES"));
                subList.add(new Subject(15, getString(R.string.EE_5_Sub15), "ESI"));
                subList.add(new Subject(16, getString(R.string.EE_5_Sub16), "AI"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.EE_6_Sub1), "PSA"));
                subList.add(new Subject(2, getString(R.string.EE_6_Sub2), "HV"));
                subList.add(new Subject(3, getString(R.string.EE_6_Sub3), "LIC"));
                subList.add(new Subject(4, getString(R.string.EE_6_Sub4), "ACE"));
                subList.add(new Subject(5, getString(R.string.EE_6_Sub5), "DR"));
                subList.add(new Subject(6, getString(R.string.EE_6_Sub6), "ES&IOT"));
                subList.add(new Subject(7, getString(R.string.EE_6_Sub7), "DBMS"));
                subList.add(new Subject(8, getString(R.string.EE_6_Sub8), "PSPR"));
                subList.add(new Subject(9, getString(R.string.EE_6_Sub9), "OR"));
                subList.add(new Subject(10, getString(R.string.EE_6_Sub10), "WP"));
                subList.add(new Subject(11, getString(R.string.EE_6_Sub11), "SG"));
                subList.add(new Subject(12, getString(R.string.EE_6_Sub12), "DSP"));
                subList.add(new Subject(13, getString(R.string.EE_6_Sub13), "VLSI"));
                subList.add(new Subject(14, getString(R.string.EE_6_Sub14), "JAVA"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.EE_7_Sub1), "CAED"));
                subList.add(new Subject(2, getString(R.string.EE_7_Sub2), "ACE"));
                subList.add(new Subject(3, getString(R.string.EE_7_Sub3), "EEC"));
                subList.add(new Subject(4, getString(R.string.EE_7_Sub4), "CCED"));
                subList.add(new Subject(5, getString(R.string.EE_7_Sub5), "AM"));
                subList.add(new Subject(6, getString(R.string.EE_6_Sub6), "EEM"));
                subList.add(new Subject(7, getString(R.string.EE_6_Sub7), "MEMS"));
                subList.add(new Subject(8, getString(R.string.EE_7_Sub8), "OCPS"));
                subList.add(new Subject(9, getString(R.string.EE_7_Sub9), "OFC"));
                subList.add(new Subject(10, getString(R.string.EE_7_Sub10), "CNCP"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.EE_8_Sub1), "FACTS"));
                subList.add(new Subject(2, getString(R.string.EE_8_Sub2), "EDEI"));
                subList.add(new Subject(3, getString(R.string.EE_8_Sub3), "ANN"));
                subList.add(new Subject(4, getString(R.string.EE_8_Sub4), "ES"));
                subList.add(new Subject(5, getString(R.string.EE_8_Sub5), "M&E"));
                subList.add(new Subject(6, getString(R.string.EE_8_Sub6), "TSCEA"));
                //subList.add(new Subject(1, "Mathematics",""));
            }
        } else if (branch.equals(getString(R.string.EC))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.EC_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.EC_1_Sub2), "P"));
                subList.add(new Subject(3, getString(R.string.EC_1_Sub3), "EME"));
                subList.add(new Subject(4, getString(R.string.EC_1_Sub4), "BEE"));
                subList.add(new Subject(5, getString(R.string.EC_1_Sub5), "CCP"));
                subList.add(new Subject(6, getString(R.string.EC_1_Sub6), "ICP"));
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
                subList.add(new Subject(1, getString(R.string.EC_3_Sub1), "M-3"));
                subList.add(new Subject(2, getString(R.string.EC_3_Sub2), "LIC"));
                subList.add(new Subject(3, getString(R.string.EC_3_Sub3), "DEV"));
                subList.add(new Subject(4, getString(R.string.EC_3_Sub4), "SS"));
                subList.add(new Subject(5, getString(R.string.EC_3_Sub5), "NT"));
                subList.add(new Subject(6, getString(R.string.EC_3_Sub6), "IE"));
                subList.add(new Subject(7, getString(R.string.EC_3_Sub7), "CA"));
                subList.add(new Subject(8, getString(R.string.EC_3_Sub8), "OOPC"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.EC_4_Sub1), "M-4"));
                subList.add(new Subject(2, getString(R.string.EC_4_Sub2), "AEC"));
                subList.add(new Subject(3, getString(R.string.EC_4_Sub3), "PJ"));
                subList.add(new Subject(4, getString(R.string.EC_4_Sub4), "DS"));
                subList.add(new Subject(5, getString(R.string.EC_4_Sub5), "DM"));
                subList.add(new Subject(6, getString(R.string.EC_4_Sub6), "CO&OS"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.EC_5_Sub1), "DC"));
                subList.add(new Subject(2, getString(R.string.EC_5_Sub2), "RME"));
                subList.add(new Subject(3, getString(R.string.EC_5_Sub3), "DSP"));
                subList.add(new Subject(4, getString(R.string.EC_5_Sub4), "EIS"));
                subList.add(new Subject(5, getString(R.string.EC_5_Sub5), "ME"));
                subList.add(new Subject(6, getString(R.string.EC_5_Sub6), "UOS"));
                subList.add(new Subject(7, getString(R.string.EC_5_Sub7), "OFC"));
                subList.add(new Subject(8, getString(R.string.EC_5_Sub8), "RMI"));
                subList.add(new Subject(9, getString(R.string.EC_5_Sub9), "APA"));
                subList.add(new Subject(10, getString(R.string.EC_5_Sub10), "TA"));
                subList.add(new Subject(11, getString(R.string.EC_5_Sub11), "BSP"));
                subList.add(new Subject(12, getString(R.string.EC_5_Sub12), "AE"));
                subList.add(new Subject(13, getString(R.string.EC_5_Sub13), "SV"));
                subList.add(new Subject(14, getString(R.string.EC_5_Sub14), "DM"));
                subList.add(new Subject(15, getString(R.string.EC_5_Sub15), "DSPA"));
                subList.add(new Subject(16, getString(R.string.EC_5_Sub16), "M"));
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
                subList.add(new Subject(1, getString(R.string.EC_7_Sub1), "ICPS"));
                subList.add(new Subject(2, getString(R.string.EC_7_Sub2), "AMMV"));
                subList.add(new Subject(3, getString(R.string.EC_7_Sub3), "CC"));
                subList.add(new Subject(4, getString(R.string.EC_7_Sub4), "WC"));
                subList.add(new Subject(5, getString(R.string.EC_7_Sub5), "RA"));
                subList.add(new Subject(6, getString(R.string.EC_6_Sub6), "IP"));
                subList.add(new Subject(7, getString(R.string.EC_6_Sub7), "MLDL"));
                subList.add(new Subject(8, getString(R.string.EC_7_Sub8), "BDDS"));
                subList.add(new Subject(9, getString(R.string.EC_7_Sub9), "SC"));
                subList.add(new Subject(10, getString(R.string.EC_7_Sub10), "ME"));
                subList.add(new Subject(11, getString(R.string.EC_7_Sub11), "SOC"));
                subList.add(new Subject(12, getString(R.string.EC_7_Sub12), "GC"));
                subList.add(new Subject(13, getString(R.string.EC_7_Sub13), "MMC"));
                subList.add(new Subject(14, getString(R.string.EC_7_Sub14), "RE"));
                subList.add(new Subject(15, getString(R.string.EC_7_Sub15), "ES"));
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
                subList.add(new Subject(1, getString(R.string.Civil_1_Sub1), "DELA"));
                subList.add(new Subject(2, getString(R.string.Civil_1_Sub2), "P"));
                subList.add(new Subject(3, getString(R.string.Civil_1_Sub3), "C++"));
                subList.add(new Subject(4, getString(R.string.Civil_1_Sub4), "BM"));
                subList.add(new Subject(5, getString(R.string.Civil_1_Sub5), "T-1"));
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
                subList.add(new Subject(1, getString(R.string.Civil_3_Sub1), "LTFS"));
                subList.add(new Subject(2, getString(R.string.Civil_3_Sub2), "SM"));
                subList.add(new Subject(3, getString(R.string.Civil_3_Sub3), "AS"));
                subList.add(new Subject(4, getString(R.string.Civil_3_Sub4), "FM"));
                subList.add(new Subject(5, getString(R.string.Civil_3_Sub5), "CT"));
                subList.add(new Subject(6, getString(R.string.Civil_3_Sub6), "ICP"));
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
                subList.add(new Subject(1, getString(R.string.Civil_5_Sub1), "DRCS"));
                subList.add(new Subject(2, getString(R.string.Civil_5_Sub2), "BGE"));
                subList.add(new Subject(3, getString(R.string.Civil_5_Sub3), "RAWT"));
                subList.add(new Subject(4, getString(R.string.Civil_5_Sub4), "ASA"));
                subList.add(new Subject(5, getString(R.string.Civil_5_Sub5), "TAD"));
                subList.add(new Subject(6, getString(R.string.Civil_5_Sub6), "IWWT"));
                subList.add(new Subject(7, getString(R.string.Civil_5_Sub7), "FRSG"));
                subList.add(new Subject(8, getString(R.string.Civil_5_Sub8), "SDSA"));
                subList.add(new Subject(9, getString(R.string.Civil_5_Sub9), "RWSS"));
                subList.add(new Subject(10, getString(R.string.Civil_5_Sub10), "WRSM"));
                subList.add(new Subject(11, getString(R.string.Civil_5_Sub11), "CPE"));
                subList.add(new Subject(12, getString(R.string.Civil_5_Sub12), "HM"));
                subList.add(new Subject(13, getString(R.string.Civil_5_Sub13), "OSHH"));
                subList.add(new Subject(14, getString(R.string.Civil_5_Sub14), "RE"));
                subList.add(new Subject(15, getString(R.string.Civil_5_Sub15), "NDTM"));
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
                subList.add(new Subject(1, getString(R.string.Civil_7_Sub1), "FME"));
                subList.add(new Subject(2, getString(R.string.Civil_7_Sub2), "SWM"));
                subList.add(new Subject(3, getString(R.string.Civil_7_Sub3), "DPPS"));
                subList.add(new Subject(4, getString(R.string.Civil_7_Sub4), "BMC"));
                subList.add(new Subject(5, getString(R.string.Civil_7_Sub5), "RHGWR"));
                subList.add(new Subject(6, getString(R.string.Civil_7_Sub6), "WSS"));
                subList.add(new Subject(7, getString(R.string.Civil_7_Sub7), "ERDRCS"));
                subList.add(new Subject(8, getString(R.string.Civil_7_Sub8), "GBT"));
                subList.add(new Subject(9, getString(R.string.Civil_7_Sub9), "GDR"));
                subList.add(new Subject(10, getString(R.string.Civil_7_Sub10), "OCH"));
                subList.add(new Subject(11, getString(R.string.Civil_7_Sub11), "NMCE"));
                subList.add(new Subject(12, getString(R.string.Civil_7_Sub12), "EERS"));
                subList.add(new Subject(13, getString(R.string.Civil_7_Sub13), "UTSC"));
                subList.add(new Subject(14, getString(R.string.Civil_7_Sub14), "EAM"));
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

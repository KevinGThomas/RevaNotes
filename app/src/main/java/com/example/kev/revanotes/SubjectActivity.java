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
                subList.add(new Subject(1, getString(R.string.CS_5_Sub1), "OSUI"));
                subList.add(new Subject(2, getString(R.string.CS_5_Sub2), "OOPC"));
                subList.add(new Subject(3, getString(R.string.CS_5_Sub3), "DBMS"));
                subList.add(new Subject(4, getString(R.string.CS_5_Sub4), "SEPM"));
                subList.add(new Subject(5, getString(R.string.CS_5_Sub5), "CNCP"));
                subList.add(new Subject(6, getString(R.string.CS_5_Sub6), "PLC"));
                subList.add(new Subject(7, getString(R.string.CS_5_Sub7), "OOMD"));
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
                subList.add(new Subject(1, getString(R.string.CS_7_Sub1), "MLDA"));
                subList.add(new Subject(2, getString(R.string.CS_7_Sub2), "BDH"));
                subList.add(new Subject(3, getString(R.string.CS_7_Sub3), "PR"));
                subList.add(new Subject(4, getString(R.string.CS_7_Sub4), "WT"));
                subList.add(new Subject(5, getString(R.string.CS_7_Sub5), "PP"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.CS_8_Sub1), "SAN"));
                subList.add(new Subject(2, getString(R.string.CS_8_Sub2), "MCAD"));
                subList.add(new Subject(3, getString(R.string.CS_8_Sub3), "UIDD"));
                subList.add(new Subject(4, getString(R.string.CS_8_Sub4), "DAT"));
                subList.add(new Subject(5, getString(R.string.CS_8_Sub5), "SMS"));
                subList.add(new Subject(6, getString(R.string.CS_8_Sub6), "CN"));
                //subList.add(new Subject(1, "Mathematics",""));
            }


        } else if (branch.equals(getString(R.string.Mech))) {
            if (semester.equals(getString(R.string.First))) {
                subList.add(new Subject(1, getString(R.string.Mech_1_Sub1), "M-1"));
                subList.add(new Subject(2, getString(R.string.Mech_1_Sub2), "AC"));
                subList.add(new Subject(3, getString(R.string.Mech_1_Sub3), "BEE"));
                subList.add(new Subject(4, getString(R.string.Mech_1_Sub4), "CAED"));
                subList.add(new Subject(5, getString(R.string.Mech_1_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.Mech_1_Sub6), "TE-1"));

            } else if (semester.equals(getString(R.string.Second))) {
                subList.add(new Subject(1, getString(R.string.Mech_2_Sub1), "M-2"));
                subList.add(new Subject(2, getString(R.string.Mech_2_Sub2), "PHY"));
                subList.add(new Subject(3, getString(R.string.Mech_2_Sub3), "C"));
                subList.add(new Subject(4, getString(R.string.Mech_2_Sub4), "MT"));
                subList.add(new Subject(5, getString(R.string.Mech_2_Sub5), "EM"));
                subList.add(new Subject(6, getString(R.string.Mech_2_Sub6), "ICP"));
                subList.add(new Subject(7, getString(R.string.Mech_2_Sub7), "TE2"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.Mech_3_Sub1), "NMP"));
                subList.add(new Subject(2, getString(R.string.Mech_3_Sub2), "SOM"));
                subList.add(new Subject(3, getString(R.string.Mech_3_Sub3), "BTD"));
                subList.add(new Subject(4, getString(R.string.Mech_3_Sub4), "FM"));
                subList.add(new Subject(5, getString(R.string.Mech_3_Sub5), "MSM"));
                subList.add(new Subject(6, getString(R.string.Mech_3_Sub6), "CAMD"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.Mech_4_Sub1), "M-4"));
                subList.add(new Subject(2, getString(R.string.Mech_4_Sub2), "MMM"));
                subList.add(new Subject(3, getString(R.string.Mech_4_Sub3), "AT"));
                subList.add(new Subject(4, getString(R.string.Mech_4_Sub4), "TM"));
                subList.add(new Subject(5, getString(R.string.Mech_4_Sub5), "MT2"));
                subList.add(new Subject(6, getString(R.string.Mech_4_Sub6), "FM"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.Mech_5_Sub1), "FEM"));
                subList.add(new Subject(2, getString(R.string.Mech_5_Sub2), "HMT"));
                subList.add(new Subject(3, getString(R.string.Mech_5_Sub3), "MD1"));
                subList.add(new Subject(4, getString(R.string.Mech_5_Sub4), "HP"));
                subList.add(new Subject(5, getString(R.string.Mech_5_Sub5), "POM"));
                subList.add(new Subject(6, getString(R.string.Mech_5_Sub6), "ICE"));
                subList.add(new Subject(7, getString(R.string.Mech_5_Sub7), "PMM"));
                subList.add(new Subject(8, getString(R.string.Mech_5_Sub8), "SQC"));
                subList.add(new Subject(9, getString(R.string.Mech_5_Sub9), "PPE"));
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
                subList.add(new Subject(1, getString(R.string.Mech_7_Sub1), "CS"));
                subList.add(new Subject(2, getString(R.string.Mech_7_Sub2), "MV"));
                subList.add(new Subject(3, getString(R.string.Mech_7_Sub3), "OR"));
                subList.add(new Subject(4, getString(R.string.Mech_7_Sub4), "CRE"));
                subList.add(new Subject(5, getString(R.string.Mech_7_Sub5), "PDD"));
                subList.add(new Subject(6, getString(R.string.Mech_7_Sub6), "EEF"));
                subList.add(new Subject(7, getString(R.string.Mech_7_Sub7), "TOP"));
                subList.add(new Subject(8, getString(R.string.Mech_7_Sub8), "CFD"));
                subList.add(new Subject(9, getString(R.string.Mech_7_Sub9), "NTA"));
                subList.add(new Subject(10, getString(R.string.Mech_7_Sub10), "TBD"));
                subList.add(new Subject(11, getString(R.string.Mech_7_Sub11), "AM"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.Mech_8_Sub1), "SMME"));
                subList.add(new Subject(2, getString(R.string.Mech_8_Sub2), "AE"));
                subList.add(new Subject(3, getString(R.string.Mech_8_Sub3), "PM"));
                subList.add(new Subject(4, getString(R.string.Mech_8_Sub4), "MCM"));
                subList.add(new Subject(5, getString(R.string.Mech_8_Sub5), "BES"));
                subList.add(new Subject(6, getString(R.string.Mech_8_Sub6), "RP"));
                subList.add(new Subject(7, getString(R.string.Mech_8_Sub7), "NDTM"));
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
                subList.add(new Subject(2, getString(R.string.EE_2_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.EE_2_Sub3), "EPGT"));
                subList.add(new Subject(4, getString(R.string.EE_2_Sub4), "CCP"));
                subList.add(new Subject(5, getString(R.string.EE_2_Sub5), "EEIM"));
                subList.add(new Subject(6, getString(R.string.EE_2_Sub6), "ES"));
                subList.add(new Subject(7, getString(R.string.EE_2_Sub7), "TE2"));
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
                subList.add(new Subject(1, getString(R.string.EE_5_Sub1), "CE"));
                subList.add(new Subject(2, getString(R.string.EE_5_Sub2), "T&D"));
                subList.add(new Subject(3, getString(R.string.EE_5_Sub3), "S&S"));
                subList.add(new Subject(4, getString(R.string.EE_5_Sub4), "EM2"));
                subList.add(new Subject(5, getString(R.string.EE_5_Sub5), "EPU"));
                subList.add(new Subject(6, getString(R.string.EE_5_Sub6), "ED"));
                subList.add(new Subject(7, getString(R.string.EE_5_Sub7), "VHDL"));
                subList.add(new Subject(8, getString(R.string.EE_5_Sub8), "CNCP"));
                subList.add(new Subject(9, getString(R.string.EE_5_Sub9), "DEM"));
                subList.add(new Subject(10, getString(R.string.EE_5_Sub10), "APE"));
                subList.add(new Subject(11, getString(R.string.EE_5_Sub11), "PLC"));
                subList.add(new Subject(12, getString(R.string.EE_5_Sub12), "DSC"));
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
                subList.add(new Subject(1, getString(R.string.EE_7_Sub1), "CAPSAS"));
                subList.add(new Subject(2, getString(R.string.EE_7_Sub2), "CAED"));
                subList.add(new Subject(3, getString(R.string.EE_7_Sub3), "PSP"));
                subList.add(new Subject(4, getString(R.string.EE_7_Sub4), "OS"));
                subList.add(new Subject(5, getString(R.string.EE_7_Sub5), "TCEE"));
                subList.add(new Subject(6, getString(R.string.EE_7_Sub6), "NCES"));
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
                subList.add(new Subject(2, getString(R.string.EC_2_Sub2), "C"));
                subList.add(new Subject(3, getString(R.string.EC_2_Sub3), "AE"));
                subList.add(new Subject(4, getString(R.string.EC_2_Sub4), "PP"));
                subList.add(new Subject(5, getString(R.string.EC_2_Sub5), "ES"));
                subList.add(new Subject(6, getString(R.string.EC_2_Sub6), "TE2"));
                subList.add(new Subject(7, getString(R.string.EC_2_Sub7), "CAED"));
                //subList.add(new Subject(6, getString(R.string.CS_2_Sub6),"TE-1"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Third))) {
                subList.add(new Subject(1, getString(R.string.EC_3_Sub1), "M-3"));
                subList.add(new Subject(2, getString(R.string.EC_3_Sub2), "LIC"));
                subList.add(new Subject(3, getString(R.string.EC_3_Sub3), "DEV"));
                subList.add(new Subject(4, getString(R.string.EC_3_Sub4), "SS-1"));
                subList.add(new Subject(5, getString(R.string.EC_3_Sub5), "NA"));
                subList.add(new Subject(6, getString(R.string.EC_3_Sub6), "IE"));
                subList.add(new Subject(7, getString(R.string.EC_3_Sub7), "OOPC"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fourth))) {
                subList.add(new Subject(1, getString(R.string.EC_4_Sub1), "M-4"));
                subList.add(new Subject(2, getString(R.string.EC_4_Sub2), "DSD"));
                subList.add(new Subject(3, getString(R.string.EC_4_Sub3), "LIC"));
                subList.add(new Subject(4, getString(R.string.EC_4_Sub4), "MC"));
                subList.add(new Subject(5, getString(R.string.EC_4_Sub5), "SS"));
                subList.add(new Subject(6, getString(R.string.EC_4_Sub6), "CO&OS"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.EC_5_Sub1), "EMEP"));
                subList.add(new Subject(2, getString(R.string.EC_5_Sub2), "AC"));
                subList.add(new Subject(3, getString(R.string.EC_5_Sub3), "DSP"));
                subList.add(new Subject(4, getString(R.string.EC_5_Sub4), "RFME"));
                subList.add(new Subject(5, getString(R.string.EC_5_Sub5), "ICE"));
                subList.add(new Subject(6, getString(R.string.EC_5_Sub6), "TA&CBS"));
                subList.add(new Subject(7, getString(R.string.EC_5_Sub7), "CEE"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.EC_6_Sub1), "SSC"));
                subList.add(new Subject(2, getString(R.string.EC_6_Sub2), "DM"));
                subList.add(new Subject(3, getString(R.string.EC_6_Sub3), "JAVA"));
                subList.add(new Subject(4, getString(R.string.EC_6_Sub4), "OFC"));
                subList.add(new Subject(5, getString(R.string.EC_6_Sub5), "DBMS"));
                subList.add(new Subject(6, getString(R.string.EC_6_Sub6), "CMOS"));
                subList.add(new Subject(7, getString(R.string.EC_6_Sub7), "DC"));
                subList.add(new Subject(8, getString(R.string.EC_6_Sub8), "AWP"));
                //subList.add(new Subject(1, "Mathematics",""));
            } else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.EC_7_Sub1), "ITC"));
                subList.add(new Subject(2, getString(R.string.EC_7_Sub2), "CCN"));
                subList.add(new Subject(3, getString(R.string.EC_7_Sub3), "ES"));
                subList.add(new Subject(4, getString(R.string.EC_7_Sub4), "VCC"));
                subList.add(new Subject(5, getString(R.string.EC_7_Sub5), "SC"));
                subList.add(new Subject(6, getString(R.string.EC_7_Sub6), "WP"));
                subList.add(new Subject(7, getString(R.string.EC_7_Sub7), "SOC"));
                subList.add(new Subject(8, getString(R.string.EC_7_Sub8), "ASIC"));
                subList.add(new Subject(9, getString(R.string.EC_7_Sub9), "PP"));
                subList.add(new Subject(10, getString(R.string.EC_7_Sub10), "PUC"));
                subList.add(new Subject(11, getString(R.string.EC_7_Sub11), "DSC"));
            } else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.EC_8_Sub1), "AES"));
                subList.add(new Subject(2, getString(R.string.EC_8_Sub2), "BDA"));
                subList.add(new Subject(3, getString(R.string.EC_8_Sub3), "CNS"));
                subList.add(new Subject(4, getString(R.string.EC_8_Sub4), "GC"));
                subList.add(new Subject(5, getString(R.string.EC_8_Sub5), "MCN"));
                subList.add(new Subject(6, getString(R.string.EC_8_Sub6), "WCN"));
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
                subList.add(new Subject(1, getString(R.string.Civil_2_Sub1), "ATE"));
                subList.add(new Subject(2, getString(R.string.Civil_2_Sub2), "PAD"));
                subList.add(new Subject(3, getString(R.string.Civil_2_Sub3), "UTP"));
                subList.add(new Subject(4, getString(R.string.Civil_2_Sub4), "HEF"));
                subList.add(new Subject(5, getString(R.string.Civil_2_Sub5), "PEMS"));
                subList.add(new Subject(6, getString(R.string.Civil_2_Sub6), "HCM"));
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
                subList.add(new Subject(1, getString(R.string.Civil_4_Sub1), "M-4"));
                subList.add(new Subject(2, getString(R.string.Civil_4_Sub2), "WSSE"));
                subList.add(new Subject(3, getString(R.string.Civil_4_Sub3), "SA"));
                subList.add(new Subject(4, getString(R.string.Civil_4_Sub4), "RCCD"));
                subList.add(new Subject(5, getString(R.string.Civil_4_Sub5), "RAWT"));
                subList.add(new Subject(6, getString(R.string.Civil_4_Sub6), "HIE"));
            }
            else if (semester.equals(getString(R.string.Fifth))) {
                subList.add(new Subject(1, getString(R.string.Civil_5_Sub1), "HE"));
                subList.add(new Subject(2, getString(R.string.Civil_5_Sub2), "SMFE"));
                subList.add(new Subject(3, getString(R.string.Civil_5_Sub3), "ASA"));
                subList.add(new Subject(4, getString(R.string.Civil_5_Sub4), "IWWT"));
                subList.add(new Subject(5, getString(R.string.Civil_5_Sub5), "TCP"));
                subList.add(new Subject(6, getString(R.string.Civil_5_Sub6), "PPCM"));
                subList.add(new Subject(7, getString(R.string.Civil_5_Sub7), "DMS"));
                subList.add(new Subject(8, getString(R.string.Civil_5_Sub8), "ANP"));
                subList.add(new Subject(9, getString(R.string.Civil_5_Sub9), "RS&GIS"));
                subList.add(new Subject(10, getString(R.string.Civil_5_Sub10), "DERS"));
                subList.add(new Subject(11, getString(R.string.Civil_5_Sub11), "WRE"));
                subList.add(new Subject(12, getString(R.string.Civil_5_Sub12), "NDT"));
            }
            else if (semester.equals(getString(R.string.Sixth))) {
                subList.add(new Subject(1, getString(R.string.Civil_6_Sub1), "SS"));
                subList.add(new Subject(2, getString(R.string.Civil_6_Sub2), "PCPS"));
                subList.add(new Subject(3, getString(R.string.Civil_6_Sub3), "DTS"));
                subList.add(new Subject(4, getString(R.string.Civil_6_Sub4), "AGE"));
                subList.add(new Subject(5, getString(R.string.Civil_6_Sub5), "PM&A"));
                subList.add(new Subject(6, getString(R.string.Civil_6_Sub6), "AGPS"));
                subList.add(new Subject(7, getString(R.string.Civil_6_Sub7), "MMA"));
                subList.add(new Subject(8, getString(R.string.Civil_6_Sub8), "GIT"));
                subList.add(new Subject(9, getString(R.string.Civil_6_Sub9), "TE"));
                subList.add(new Subject(10, getString(R.string.Civil_6_Sub10), "OCH"));
                subList.add(new Subject(11, getString(R.string.Civil_6_Sub11), "TOE"));
                subList.add(new Subject(12, getString(R.string.Civil_6_Sub12), "HM"));
                subList.add(new Subject(13, getString(R.string.Civil_6_Sub13), "OHIS"));
                subList.add(new Subject(14, getString(R.string.Civil_6_Sub14), "BSD"));
            }
            else if (semester.equals(getString(R.string.Seventh))) {
                subList.add(new Subject(1, getString(R.string.Civil_7_Sub1), "SWM"));
                subList.add(new Subject(2, getString(R.string.Civil_7_Sub2), "DIS"));
                subList.add(new Subject(3, getString(R.string.Civil_7_Sub3), "PDC"));
                subList.add(new Subject(4, getString(R.string.Civil_7_Sub4), "OSCM"));
                subList.add(new Subject(5, getString(R.string.Civil_7_Sub5), "GWE"));
                subList.add(new Subject(6, getString(R.string.Civil_7_Sub6), "HGD"));
                subList.add(new Subject(7, getString(R.string.Civil_7_Sub7), "UTP"));
                subList.add(new Subject(8, getString(R.string.Civil_7_Sub8), "CE"));
            }
            else if (semester.equals(getString(R.string.Eighth))) {
                subList.add(new Subject(1, getString(R.string.Civil_8_Sub1), "PW"));
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

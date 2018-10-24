package com.example.kev.revanotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class PYQFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference mDatabaseReference;
    DatabaseReference dbUploads;
    List<Uploads> uploadsList = new ArrayList<>();
    TextView selectedSubject;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PYQFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PYQFragment newInstance() {
        PYQFragment fragment = new PYQFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // tv=getActivity().findViewById(R.id.test);
        //tv.setText("Java file is parsed");
        View rootView = inflater.inflate(R.layout.fragment_pyq, container, false);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);
        Query query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("sub").equalTo("Chemistry");

        for (Field field : R.string.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers()) && field.getType().equals(int.class)) {
                try {
                    if (Selection.branch.equals(getString(R.string.CS))) {
                        if (field.getName().startsWith("CS_")) {
                            int id = field.getInt(null);
                            //String s = getApplicationContext().getString(id);
                            String s = getActivity().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.CS) + "_" + s + "_" + "PYQ");
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.Mech))) {
                        if (field.getName().startsWith("Mech_")) {
                            int id = field.getInt(null);
                            String s = getActivity().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.Mech) + "_" + s + "_" + "PYQ");
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.EE))) {
                        if (field.getName().startsWith("EE_")) {
                            int id = field.getInt(null);
                            String s = getActivity().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.EE) + "_" + s + "_" + "PYQ");
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.EC))) {
                        if (field.getName().startsWith("EC_")) {
                            int id = field.getInt(null);
                            String s = getActivity().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.EC) + "_" + s + "_" + "PYQ");
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.Civil))) {
                        if (field.getName().startsWith("Civil_")) {
                            int id = field.getInt(null);
                            String s = getActivity().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.Civil) + "_" + s + "_" + "PYQ");
                            }
                        }
                    }
                } catch (IllegalArgumentException e) {
                    // ignore
                } catch (IllegalAccessException e) {
                    // ignore
                }
            }
        }

        //Select * from files where Subject='CS'
        //Query query=FirebaseDatabase.getInstance().getReference("uploads").orderByChild("sub").equalTo("Chemistry");
        //Query query=FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo("Computer Science Engineering_Chemistry");

        //Change it to query once complete
        //mDatabaseReference.addValueEventListener(new ValueEventListener() {
        final ProgressBar progressBar = rootView.findViewById(R.id.PYQProgress);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Uploads upload = postSnapshot.getValue(Uploads.class);
                    uploadsList.add(upload);
                }
                //String[] databasefilenames = new String[uploadsList.size()];
                String[] uploadsn = new String[uploadsList.size()];
                String[] uploadsd = new String[uploadsList.size()];
                String[] uploadsu = new String[uploadsList.size()];
                String[] uploadsbranch = new String[uploadsList.size()];
                String[] uploadssem = new String[uploadsList.size()];
                String[] uploadssub = new String[uploadsList.size()];
                //String[] uploads = new String[uploadsList.size()];

                for (int i = 0; i < uploadsn.length; i++) {
                    uploadsn[i] = uploadsList.get(i).getName();
                    uploadsd[i] = uploadsList.get(i).getDesc();
                    uploadsu[i] = uploadsList.get(i).getUrl();
                    uploadsbranch[i] = uploadsList.get(i).getBranch();
                    uploadssem[i] = uploadsList.get(i).getSem();
                    uploadssub[i] = uploadsList.get(i).getSub();

                    ((PYQAdapter) recyclerView.getAdapter()).update(uploadsu[i], uploadsn[i], uploadsd[i], uploadsbranch[i], uploadssem[i], uploadssub[i]);

                    //uploadsn[i] = uploadsList.get(i).getName();
                }
                progressBar.setVisibility(View.GONE);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView = rootView.findViewById(R.id.recycler_view_pyq);

        recyclerView.setLayoutManager(new LinearLayoutManager(PYQFragment.this.getActivity()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this.getActivity()));
        PYQAdapter pyqAdapter = new PYQAdapter(recyclerView, PYQFragment.this.getActivity(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        recyclerView.setAdapter(pyqAdapter);

        //TextView textView = (TextView) rootView.findViewById(R.id.test);
        //textView.setText("Java file is parsed");
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }
}

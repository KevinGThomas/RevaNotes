package com.example.kev.revanotes;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
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

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference mDatabaseReference;
    DatabaseReference dbUploads;
    List<Uploads> uploadsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        RelativeLayout relativeLayout = findViewById(R.id.relativeDisplay);
        if (Selection.branch.equals("Computer Science Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.CS));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.CS), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals("Mechanical Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.Mech));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Mech), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals("Electrical and Electronics Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.EE));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EE), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals("Electronics and Communication Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.EC));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.EC), 12);
            window.setStatusBarColor(dark);
        } else if (Selection.branch.equals("Civil Engineering")) {
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.Civil));
            int dark = ColorUtil.darken(this.getResources().getColor(R.color.Civil), 12);
            window.setStatusBarColor(dark);
        }

        Toolbar toolbar = findViewById(R.id.displayToolbar);
        toolbar.setTitle(Selection.subject);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        //Select * from files
        //dbUploads=FirebaseDatabase.getInstance().getReference("uploads");
        Query query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("sub").equalTo("Chemistry");

        for (Field field : R.string.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers()) && field.getType().equals(int.class)) {
                try {
                    if (Selection.branch.equals(getString(R.string.CS))) {
                        if (field.getName().startsWith("CS_")) {
                            int id = field.getInt(null);
                            String s = getApplicationContext().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.CS) + "_" + s);
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.Mech))) {
                        if (field.getName().startsWith("Mech_")) {
                            int id = field.getInt(null);
                            String s = getApplicationContext().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.Mech) + "_" + s);
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.EE))) {
                        if (field.getName().startsWith("EE_")) {
                            int id = field.getInt(null);
                            String s = getApplicationContext().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.EE) + "_" + s);
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.EC))) {
                        if (field.getName().startsWith("EC_")) {
                            int id = field.getInt(null);
                            String s = getApplicationContext().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.EC) + "_" + s);
                            }
                        }
                    } else if (Selection.branch.equals(getString(R.string.Civil))) {
                        if (field.getName().startsWith("Civil_")) {
                            int id = field.getInt(null);
                            String s = getApplicationContext().getString(id);
                            if (Selection.subject.equals(s)) {
                                query = FirebaseDatabase.getInstance().getReference("uploads").orderByChild("br_sub").equalTo(getString(R.string.Civil) + "_" + s);
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

                    ((DisplayAdapter) recyclerView.getAdapter()).update(uploadsu[i], uploadsn[i], uploadsd[i], uploadsbranch[i], uploadssem[i], uploadssub[i]);
                    //uploadsn[i] = uploadsList.get(i).getName();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));
        DisplayAdapter displayAdapter = new DisplayAdapter(recyclerView, DisplayActivity.this, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        recyclerView.setAdapter(displayAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                //Toast.makeText(getApplicationContext(),"This works",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(DisplayActivity.this, UploadLogin.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu, menu);
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}

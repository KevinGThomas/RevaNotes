package com.example.kev.revanotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.SemesterViewHolder> {

    private Context context;
    private List<Semester> semList;

    public SemesterAdapter(Context context, List<Semester> semList) {
        this.context = context;
        this.semList = semList;
    }


    @NonNull
    @Override
    public SemesterAdapter.SemesterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_semester_adapter, parent, false);
        return new SemesterAdapter.SemesterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterViewHolder holder, int position) {
        Semester semester = semList.get(position);
        holder.semNames.setText(semester.getSemName());

    }

    @Override
    public int getItemCount() {
        return semList.size();
    }

    class SemesterViewHolder extends RecyclerView.ViewHolder {
        TextView semNames;

        public SemesterViewHolder(View itemView) {
            super(itemView);
            semNames = itemView.findViewById(R.id.semesterName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int position = recyclerView.getChildLayoutPosition(v);
                    String semester = semNames.getText().toString();
                    if(semester.equals("1st SEM"))
                        Selection.semester="First Semester";
                    else if(semester.equals("2nd SEM"))
                        Selection.semester="Second Semester";
                    else if(semester.equals("3rd SEM"))
                        Selection.semester="Third Semester";
                    else if(semester.equals("4th SEM"))
                        Selection.semester="Fourth Semester";
                    else if(semester.equals("5th SEM"))
                        Selection.semester="Fifth Semester";
                    else if(semester.equals("6th SEM"))
                        Selection.semester="Sixth Semester";
                    else if(semester.equals("7th SEM"))
                        Selection.semester="Seventh Semester";
                    else if(semester.equals("8th SEM"))
                        Selection.semester="Eighth Semester";
                    //else if(semester.equals("9th SEM"))
                     //   Selection.semester="Ninth Semester";
                    //else if(semester.equals("10th SEM"))
                     //   Selection.semester="Tenth Semester";

                    //context.getApplicationContext();
                    //Selection.semester = semester;
                    //Toast.makeText(context,Selection.semester,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SubjectActivity.class);
                    //intent.putExtra("branch",branch);
                    Activity activity = (Activity) context;
                    context.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
        }
    }
}

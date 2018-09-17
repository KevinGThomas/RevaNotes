package com.example.kev.revanotes;

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

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private Context context;
    private List<Subject> subList;

    public SubjectAdapter(Context context, List<Subject> subList) {
        this.context = context;
        this.subList = subList;
    }

    @NonNull
    @Override
    public SubjectAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_subject_adapter,parent, false);
        return new SubjectAdapter.SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject=subList.get(position);
        holder.subNames.setText(subject.getSubName());

    }

    @Override
    public int getItemCount() {
        return subList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView subNames;
        public SubjectViewHolder(View itemView) {
            super(itemView);
            subNames=itemView.findViewById(R.id.subjectName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int position = recyclerView.getChildLayoutPosition(v);
                    String subject =subNames.getText().toString();
                    //context.getApplicationContext();
                    Selection.subject=subject;
                    Intent intent=new Intent(context,DisplayActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }


}

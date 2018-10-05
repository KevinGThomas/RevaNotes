package com.example.kev.revanotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.google.firebase.database.collection.LLRBNode;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    ColorGenerator generator = ColorGenerator.MATERIAL;

    private Context context;
    private List<Subject> subList;

    public SubjectAdapter(Context context, List<Subject> subList) {
        this.context = context;
        this.subList = subList;
    }

    @NonNull
    @Override
    public SubjectAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_subject_adapter, parent, false);
        return new SubjectAdapter.SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subList.get(position);
        int color1 = generator.getRandomColor();
        holder.subNames.setText(subject.getSubName());
        TextDrawable drawable2 = TextDrawable.builder().beginConfig().fontSize(50).endConfig().buildRound(subject.getImgLetter(), color1);
        //drawable2.
        holder.img.setImageDrawable(drawable2);

    }

    @Override
    public int getItemCount() {
        return subList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView subNames;
        ImageView img;


        public SubjectViewHolder(View itemView) {
            super(itemView);
            subNames = itemView.findViewById(R.id.subjectName);
            //TextDrawable drawable2 = TextDrawable.builder()
            //        .buildRound("A", Color.RED);
            img = itemView.findViewById(R.id.image_view);
            //image.setImageDrawable(drawable2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int position = recyclerView.getChildLayoutPosition(v);
                    String subject = subNames.getText().toString();
                    //context.getApplicationContext();
                    Selection.subject = subject;
                    //Intent intent = new Intent(context, DisplayActivity.class);
                    Intent intent = new Intent(context, DisplayTabs.class);
                    Activity activity = (Activity) context;
                    context.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
        }
    }


}

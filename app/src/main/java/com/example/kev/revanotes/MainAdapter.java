package com.example.kev.revanotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    private List<Branch> branchList;

    public MainAdapter(Context context, List<Branch> branchList) {
        this.context = context;
        this.branchList = branchList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main_adapter, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Branch branch = branchList.get(position);
        holder.branchNames.setText(branch.getBranchName());

    }

    @Override
    public int getItemCount() {
        return branchList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        TextView branchNames;

        public MainViewHolder(View itemView) {
            super(itemView);
            branchNames = itemView.findViewById(R.id.branchName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int position = recyclerView.getChildLayoutPosition(v);
                    String branch = branchNames.getText().toString();
                    //context.getApplicationContext();
                    //((Selection)context.getApplicationContext()).setBranch(branch);
                    Selection.branch = branch;
                    //Toast.makeText(context,Selection.branch,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SemesterActivity.class);
                    //intent.putExtra("branch",branch);
                    Activity activity = (Activity) context;
                    context.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                }
            });
        }
    }
}

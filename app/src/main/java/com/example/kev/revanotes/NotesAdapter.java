package com.example.kev.revanotes;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    //TextView nameOfFile=findViewById(R.id.CardText);

    RecyclerView recyclerView;
    Context context;
    //ArrayList<String> items = new ArrayList<>();
    ArrayList<String> urls = new ArrayList<>();
    ArrayList<String> filename = new ArrayList<>();
    ArrayList<String> filedesc = new ArrayList<>();
    ArrayList<String> filebranch = new ArrayList<>();
    ArrayList<String> filesem = new ArrayList<>();
    ArrayList<String> filesub = new ArrayList<>();

    public void update(String url, String fname, String fdesc, String fbranch, String fsem, String fsub) {
        //items.add(name);
        urls.add(url);
        filename.add(fname);
        filedesc.add(fdesc);
        filebranch.add(fbranch);
        filesem.add(fsem);
        filesub.add(fsub);
        notifyDataSetChanged();
    }

    public NotesAdapter(RecyclerView recyclerView, Context context, ArrayList<String> urls, ArrayList<String> filename, ArrayList<String> filedesc, ArrayList<String> filebranch, ArrayList<String> filesem, ArrayList<String> filesub) {
        this.recyclerView = recyclerView;
        this.context = context;
        //this.items = items;
        this.filename = filename;
        this.filedesc = filedesc;
        this.urls = urls;
        this.filebranch = filebranch;
        this.filesem = filesem;
        this.filesub = filesub;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_notes_adapter, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameOfFile.setText(filename.get(position));
        holder.descOfFile.setText(filedesc.get(position));

    }

    @Override
    public int getItemCount() {
        return filename.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameOfFile, descOfFile;

        public ViewHolder(View itemView) {
            super(itemView);
            nameOfFile = itemView.findViewById(R.id.NotesCardText);
            descOfFile = itemView.findViewById(R.id.NotesCardDesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = recyclerView.getChildLayoutPosition(v);
                    //DownloadManager downloadmanager = (DownloadManager) context.
                   //         getSystemService(Context.DOWNLOAD_SERVICE);
                   // Uri uri = Uri.parse(urls.get(position));
                    //DownloadManager.Request request = new DownloadManager.Request(uri);
                    //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    //request.setDestinationInExternalFilesDir(context, "test", filename.get(position) + ".pdf");
                    Intent intent = new Intent();
                    intent.setType(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urls.get(position)));
                    Activity activity = (Activity) context;
                    context.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            });
            /*public long downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {


                DownloadManager downloadmanager = (DownloadManager) context.
                        getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(url);
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

                return downloadmanager.enqueue(request);
            }*/
        }
    }
}

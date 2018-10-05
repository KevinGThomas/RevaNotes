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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    private List<Contacts> contactList;


    public ContactAdapter(Context context, List<Contacts> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_contact_adapter,parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts contact=contactList.get(position);
        holder.contactNames.setText(contact.getContactName());
        holder.contactDesc.setText(contact.getContactDesc());
        holder.contactImage.setImageResource(contact.getContactImage());
        //holder.relativeLayout.setBackgroundResource(contact.getContactImage());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView contactNames,contactDesc;
        //ImageView contactImage;
        CircleImageView contactImage;
        RelativeLayout relativeLayout;
        public ContactViewHolder(View itemView) {
            super(itemView);
            contactNames=itemView.findViewById(R.id.contactText);
            contactDesc=itemView.findViewById(R.id.contactDesc);
            contactImage=itemView.findViewById(R.id.contactImage);
            //relativeLayout=itemView.findViewById(R.id.cardRelative);
        }
    }
}

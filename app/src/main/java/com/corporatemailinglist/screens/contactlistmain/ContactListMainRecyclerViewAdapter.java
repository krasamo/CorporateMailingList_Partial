package com.corporatemailinglist.screens.contactlistmain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.corporatemailinglist.R;
import com.corporatemailinglist.repository.datamodels.Contact;

import java.util.List;

public class ContactListMainRecyclerViewAdapter extends RecyclerView.Adapter<ContactListMainRecyclerViewAdapter.ViewHolder> {

    private List contactList;

    private ContactListMainActivity.ContactListRecyclerViewOnItemClickListener contactListRecyclerViewOnItemClickListener;

    ContactListMainRecyclerViewAdapter(List contactList, ContactListMainActivity.ContactListRecyclerViewOnItemClickListener contactListRecyclerViewOnItemClickListener) {
        this.contactList = contactList;
        this.contactListRecyclerViewOnItemClickListener = contactListRecyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_cardview, parent, false);
        itemView.setOnClickListener(contactListRecyclerViewOnItemClickListener);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

//        Contact contact = (Contact) contactList.get(position);

        // Populate user interface
//        viewHolder.fullNameTextView.setText(contact.getFirstNameString() + " " + contact.getLastNameString());
//        viewHolder.emailTextView.setText(contact.getEmailString());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    /** ViewHolder pattern: Inner class needed to keep the references between widgets and data to improve the performance */
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullNameTextView;
        TextView emailTextView;

        ViewHolder(View itemView) {
            super(itemView);

            fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }
    }
}

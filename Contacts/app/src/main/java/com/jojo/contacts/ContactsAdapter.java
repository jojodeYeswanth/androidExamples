package com.jojo.contacts;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Contacts> contactsArrayList;

    public ContactsAdapter(Context context, int layout, ArrayList<Contacts> contacts) {
        this.context = context;
        this.layout = layout;
        this.contactsArrayList = contacts;
    }

    @Override
    public int getCount() {
        return contactsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View contactsView, ViewGroup parent) {
        if (contactsView == null) {
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            contactsView = inflater.inflate(R.layout.contactlist, null, true);
            TextView tvname = contactsView.findViewById(R.id.name);
            TextView tvnumber = contactsView.findViewById(R.id.number);
            TextView tvemail = contactsView.findViewById(R.id.email);
            TextView tvdob = contactsView.findViewById(R.id.dob);
            ImageView callBtn = contactsView.findViewById(R.id.users_profile_image);
            final Contacts contacts = contactsArrayList.get(position);

            tvname.setText(contacts.getName());
            tvemail.setText(" ( " + contacts.getEmail() + " ) ");
            tvnumber.setText(contacts.getNumber());
            tvdob.setText(contacts.getDob());
            callBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contacts.getNumber(), null));
                    context.startActivity(intent);
                }
            });
        }
        return contactsView;
    }
}
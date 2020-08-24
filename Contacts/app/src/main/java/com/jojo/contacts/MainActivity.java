package com.jojo.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    dbHandler database;
    private ListView listView;
    ArrayList<Contacts> list;
    ContactsAdapter adapter;
    LinearLayout layout;
    String name, phone, email, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        layout = findViewById(R.id.layout);
        list = new ArrayList<>();
        adapter = new ContactsAdapter(this, R.layout.contactlist, list);
        listView.setAdapter(adapter);
        database = new dbHandler(this);
        if (checkPermissions()) {
            requestPermissions();
        }
        readData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addContact:
                startActivity(new Intent(MainActivity.this, AddContact.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void readData(){
        Cursor cursor = database.getData("SELECT * FROM " + dbHandler.TABLE_NAME + " ORDER BY "+ dbHandler.COL_NAME +" ASC");
        list.clear();
        while (cursor.moveToNext()) {
            name = cursor.getString(0);
            phone = cursor.getString(1);
            email = cursor.getString(2);
            dob = cursor.getString(3);
            Log.d("Name", name);

            list.add(new Contacts(name, phone, email, dob));
        }
        adapter.notifyDataSetChanged();
    }
    private boolean checkPermissions(){
        int loc_res = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        return loc_res == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1: {
                if(grantResults.length >0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED )
                        Log.d("Permission", "permissionsAllowed");
                    else
                        Log.d("Permission", "permissionsDenied");
                }
            }
        }
    }

}
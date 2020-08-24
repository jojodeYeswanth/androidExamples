package com.jojo.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static imageDb database;
    GridView gridView;
    ArrayList<imageDetails> list;
    ImageAdapter adapter = null;
    Handler repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repeat = new Handler();

        database = new imageDb(this, "galleryDatabase.db", null, 1);
        database.queryData("CREATE TABLE IF NOT EXISTS GALLERY(Id INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB)");

        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, R.layout.imglist, list);
        gridView.setAdapter(adapter);
        updateList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,FullImage.class);
                Cursor c = database.getData("SELECT id FROM GALLERY");
                ArrayList<Integer> arrID = new ArrayList<Integer>();
                while (c.moveToNext()){
                    arrID.add(c.getInt(0));
                }
                intent.putExtra("imagePosition", arrID.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    private void updateList(){
        Cursor cursor = database.getData("SELECT * FROM GALLERY");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            byte[] image = cursor.getBlob(1);
            Log.d("IMAGE ",String.valueOf(image));

            list.add(new imageDetails(id, image));
        }
        adapter.notifyDataSetChanged();
    }
}

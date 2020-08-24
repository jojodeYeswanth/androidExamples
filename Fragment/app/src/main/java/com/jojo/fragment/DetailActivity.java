package com.jojo.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    SharedPreferences preferences;
    ImageView imageView;
    TextView header, body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.detailheadImg);
        header = findViewById(R.id.detailheadTitle);
        body = findViewById(R.id.detailheadDesc);

        preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
        String title = preferences.getString("title","");
        String desc = preferences.getString("desc","");
        String contrib = preferences.getString("contrib","");

        header.setText(title);
        body.setText(desc);

    }
}

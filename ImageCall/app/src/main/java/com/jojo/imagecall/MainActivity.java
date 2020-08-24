package com.jojo.imagecall;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.io.FileNotFoundException;
import java.io.InputStream;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    Button loadGallery, loadInternet;
    CircleImageView imageView;
    ImageView one, two, three;
    Button linkOne, linkTwo, linkThree;
    TextView showLink;
    LinearLayout layout;
    String uri1 = "https://firebasestorage.googleapis.com/v0/b/mapproject-beb46.appspot.com/o/Profile%20Images%2Fjf2AzQ4DWSNiwxlGlHDwh1xFGPV2.jpg?alt=media&token=66d5d76d-fe8a-4656-817b-148d87653134";
    String uri2 = "https://firebasestorage.googleapis.com/v0/b/mapproject-beb46.appspot.com/o/Profile%20Images%2FXVy8HtxY89PmElyMIcG9XXvsyYr2.jpg?alt=media&token=52f0cbae-ef58-4762-8785-a0a79ae2d9ca";
    String uri3 = "https://firebasestorage.googleapis.com/v0/b/mapproject-beb46.appspot.com/o/Profile%20Images%2FAKiL6INVtnSCSepe5WS3opPrhO72.jpg?alt=media&token=41ee0e81-62d1-4f84-b952-1f00441d38da";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadGallery = findViewById(R.id.loadGalleryBtn);
        loadInternet = findViewById(R.id.loadInternetBtn);
        layout = findViewById(R.id.linkLayout);
        imageView = findViewById(R.id.loadImg);
        one = findViewById(R.id.imgOne);
        two = findViewById(R.id.imgTwo);
        three = findViewById(R.id.imgThree);
        linkOne = findViewById(R.id.linkOne);
        linkTwo = findViewById(R.id.linkTwo);
        linkThree = findViewById(R.id.linkThree);
        showLink = findViewById(R.id.showLink);
        loadGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                showLink.setText("");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
        loadInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);

            }
        });
        linkOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(uri1).into(imageView);
                showLink.setText("Link: "+uri1);
            }
        });
        linkTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(uri2).into(imageView);
                showLink.setText("Link: "+uri2);
            }
        });
        linkThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(uri3).into(imageView);
                showLink.setText("Link: "+uri3);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.one);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.two);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.three);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    }
}
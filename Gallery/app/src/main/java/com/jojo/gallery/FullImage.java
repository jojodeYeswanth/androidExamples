package com.jojo.gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class FullImage extends AppCompatActivity {
    ImageView imageView;
    public static imageDb database;
    int id, pos;
    byte[] image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        database = new imageDb(this, "galleryDatabase.db", null, 1);
        database.queryData("CREATE TABLE IF NOT EXISTS GALLERY(Id INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB)");
        imageView = findViewById(R.id.full_image_view);
        Intent intent = getIntent();
        pos = intent.getIntExtra("imagePosition", 999);

        Cursor cursor = database.getData("SELECT * FROM GALLERY WHERE id = "+pos);
        while (cursor.moveToNext()) {
            id = cursor.getInt(0);
            image = cursor.getBlob(1);
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        imageView.setImageBitmap(bitmap);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.deleteImg) {
            AlertDialog.Builder builder = new AlertDialog.Builder(FullImage.this);
            builder.setTitle("Confirm delete ?")
                    .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            database.deleteData(pos);
                            Toast.makeText(getApplicationContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(FullImage.this, MainActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

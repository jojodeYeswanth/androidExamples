package com.jojo.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            case R.id.bluetooth:
                Intent bluetooth = new Intent();
                bluetooth.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(bluetooth);
                return true;
            case R.id.location:
                Intent location = new Intent();
                location.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(location);
                return true;
            case R.id.wifi:
                Intent wifi = new Intent();
                wifi.setAction(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);
                return true;
            case R.id.subitem1:
                Intent amode = new Intent();
                amode.setAction(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                startActivity(amode);
                return true;
            case R.id.subitem2:
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_SOUND_SETTINGS);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.jojo.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddContact extends AppCompatActivity {
    dbHandler database;
    int year, month, dayOfMonth;
    TextView name, number, email, dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name = findViewById(R.id.nameText);
        number = findViewById(R.id.phoneText);
        email = findViewById(R.id.emailText);
        dob = findViewById(R.id.dobText);
        database = new dbHandler(this);
        final Calendar calendar = Calendar.getInstance();
        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddContact.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dob.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.saveContact) {
            String nameStr = name.getText().toString().trim();
            String numberStr = number.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String dobStr = dob.getText().toString().trim();
            if (!nameStr.isEmpty() && !numberStr.isEmpty() && !emailStr.isEmpty() && !dobStr.isEmpty()) {
                long id = database.insertData(nameStr, numberStr, emailStr, dobStr);
                Toast.makeText(AddContact.this, "Contact saved.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(AddContact.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(AddContact.this, "Fill empty fields!", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

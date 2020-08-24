package com.jojo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText uname, upass;
    Button login;
    TextView attempt;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.username);
        upass = findViewById(R.id.password);
        login = findViewById(R.id.loginButt);
        attempt = findViewById(R.id.attempt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().isEmpty() && upass.getText().toString().isEmpty()){

                } else {
                    loginFun(uname.getText().toString(), upass.getText().toString());
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void loginFun(String name, String password) {
        if(count < 3){
            if(name.equals("admin") && password.equals("admin123")){
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish();
            }
            if(!name.equals("admin") && password.equals("admin123")){
                count++;
                int att = 3-count;
                attempt.setText( "\tWrong Password. " + att + " Attempts left");
            }
            if(name.equals("admin") && !password.equals("admin123")){
                count++;
                int att = 3-count;
                attempt.setText( "\tWrong Password. " + att + " Attempts left");
            }
            if (!name.equals("admin") && !password.equals("admin123")){
                count++;
                int att = 3-count;
                attempt.setText( "\tWrong Password. " + att + " Attempts left");
            }
            if(count == 3 ){
                login.setVisibility(View.GONE);
                attempt.setText("\tTry again later");
            }
        }
    }
}

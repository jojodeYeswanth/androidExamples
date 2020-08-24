package com.jojo.textviewruntime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText textInput;
    Button enterButton;
    LinearLayout removeViews;
    RelativeLayout hide;
    Button fontOne, fontTwo, fontThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput = findViewById(R.id.editText);
        enterButton = findViewById(R.id.buttonEnter);
        removeViews = findViewById(R.id.removeViews);
        hide = findViewById(R.id.hideLayout);
        fontOne = findViewById(R.id.fontOne);
        fontTwo = findViewById(R.id.fontTwo);
        fontThree = findViewById(R.id.fontThree);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textInput.getText().toString().isEmpty()){
                    String text = textInput.getText().toString();
                    TextView tv = new TextView(MainActivity.this);
                    tv.setPadding(10, 10, 10, 10);
                    tv.setText(text);
                    tv.setTextSize(20);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    removeViews.addView(tv);
                    hide.setVisibility(View.VISIBLE);
                } else {
                    Snackbar.make(v, "Enter Text to continue", Snackbar.LENGTH_LONG).show();
                    textInput.setFocusable(true);
                }
            }
        });

        fontOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/GellatioRegular.ttf");
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(20);
                tv.setTextColor(Color.BLUE);
                tv.setTypeface(custom_font);
                tv.setGravity(Gravity.END);
                removeViews.addView(tv);
                String styleText = "Font - GellatioRegular \n\n TextColor - Blue \n\n Gravity - End \n\n TextSize - 20";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(18);
                item.setTextColor(Color.BLUE);
                item.setTypeface(custom_font);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);
            }
        });
        fontTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/DeepShadow.ttf");
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(30);
                tv.setTextColor(Color.GREEN);
                tv.setTypeface(custom_font);
                tv.setGravity(Gravity.START);
                removeViews.addView(tv);
                String styleText = "Font - DeepShadow \n\n TextColor - Green \n\n Gravity - START \n\n TextSize - 30";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(18);
                item.setTextColor(Color.GREEN);
                item.setTypeface(custom_font);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);
            }
        });
        fontThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Photoshoot.ttf");
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(40);
                tv.setTextColor(Color.RED);
                tv.setTypeface(custom_font);
                tv.setGravity(Gravity.CENTER);
                removeViews.addView(tv);
                String styleText = "Font - Photoshop \n\n\n TextColor - RED \n\n\n Gravity - Center \n\n\n TextSize - 40";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(18);
                item.setTextColor(Color.RED);
                item.setTypeface(custom_font);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);

            }
        });
    }
}
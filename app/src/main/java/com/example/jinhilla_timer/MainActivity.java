package com.example.jinhilla_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //public static Context context_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context_main = this;
    }

    public void normal(View view) {
        Intent intent = new Intent(getApplicationContext(), normal.class);
        startActivity(intent);
    }

    public void hard(View view) {
        Intent intent = new Intent(getApplicationContext(), hard.class);
        startActivity(intent);
    }
}
package com.yehan.studentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }

    public void launchResultsSem1(View view){
        Intent intent = new Intent(this,ResultsSem1.class);
        startActivity(intent);
    }

    public void launchResultsSem2(View view){
        Intent intent = new Intent(this,ResultsSem2.class);
        startActivity(intent);
    }

    public void launchResultsSem3(View view){
        Intent intent = new Intent(this,ResultsSem3.class);
        startActivity(intent);
    }

    public void launchResultsSem4(View view){
        Intent intent = new Intent(this,ResultsSem5.class);
        startActivity(intent);
    }

    public void launchResultsSem5(View view){
        Intent intent = new Intent(this,ResultsSem5.class);
        startActivity(intent);
    }

    public void launchResultsSem6(View view){
        Intent intent = new Intent(this,ResultsSem6.class);
        startActivity(intent);
    }

    public void launchResultsSem7(View view){
        Intent intent = new Intent(this,ResultsSem7.class);
        startActivity(intent);
    }

    public void launchResultsSem8(View view){
        Intent intent = new Intent(this,ResultsSem8.class);
        startActivity(intent);
    }
}
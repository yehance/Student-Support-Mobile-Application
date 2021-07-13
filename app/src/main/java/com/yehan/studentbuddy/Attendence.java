package com.yehan.studentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Attendence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
    }

    public void launchAttendenceSem1(View view){
        Intent intent = new Intent(this,AttendenceSem1.class);
        startActivity(intent);
    }

    public void launchAttendenceSem2(View view){
        Intent intent = new Intent(this,AttendenceSem2.class);
        startActivity(intent);
    }

    public void launchAttendenceSem3(View view){
        Intent intent = new Intent(this,AttendenceSem3.class);
        startActivity(intent);
    }

    public void launchAttendenceSem4(View view){
        Intent intent = new Intent(this,AttendenceSem4.class);
        startActivity(intent);
    }

    public void launchAttendenceSem5(View view){
        Intent intent = new Intent(this,AttendenceSem5.class);
        startActivity(intent);
    }

    public void launchAttendenceSem6(View view){
        Intent intent = new Intent(this,AttendenceSem6.class);
        startActivity(intent);
    }

    public void launchAttendenceSem7(View view){
        Intent intent = new Intent(this,AttendenceSem7.class);
        startActivity(intent);
    }

    public void launchAttendenceSem8(View view){
        Intent intent = new Intent(this,AttendenceSem8.class);
        startActivity(intent);
    }
}
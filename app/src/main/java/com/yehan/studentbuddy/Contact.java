package com.yehan.studentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void callNumber1 (View view){
        Uri uri = Uri.parse("tel:0112758000");
        Intent intent= new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void callNumber2(View view){
        Uri uri = Uri.parse("tel:0112758525");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void callNumber3(View view){
        Uri uri = Uri.parse("tel:0112758330");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void callNumber4(View view){
        Uri uri = Uri.parse("tel:0112758602");
        Intent intent= new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void callNumber5(View view){
        Uri uri =Uri.parse("tel:0112802010");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    public void callNumber6(View view){
        Uri uri = Uri.parse("tel:0112803473");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}
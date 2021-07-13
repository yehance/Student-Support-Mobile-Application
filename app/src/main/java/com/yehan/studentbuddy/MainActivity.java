package com.yehan.studentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button result = findViewById(R.id.btnResults);
        Button attendence = findViewById(R.id.btnAttendence);
        Button contact = findViewById(R.id.btnContact);
        Button moreInfo = findViewById(R.id.btnMInfo);

        result.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Results.class);
                startActivity(intent);
            }
        });

        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Attendence.class);
                startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Contact.class);
                startActivity(intent);
            }
        });

    }

    public void launchWebSite(View view){
        Uri uri= Uri.parse("https://www.sjp.ac.lk/");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }


}
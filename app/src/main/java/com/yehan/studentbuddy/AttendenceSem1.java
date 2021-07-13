package com.yehan.studentbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AttendenceSem1 extends AppCompatActivity {

    EditText module,weeks,absent;
    Button insert,update,delete,view;

    //creating database variable
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_sem1);

        //initializing the variables
        module = findViewById(R.id.moduleNameTextAS1);
        weeks=findViewById(R.id.weeksTextS1);
        absent=findViewById(R.id.AbsentTextS1);

        insert=findViewById(R.id.btnInsertAS1);
        update=findViewById(R.id.btnUpdateAS1);
        delete=findViewById(R.id.btnDeleteAS1);
        view=findViewById(R.id.btnViewAS1);

        //Setting table name
        String tableName = "attendanceSem1";

        //creating new DBHelper object
        db= new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String moduleTXT= module.getText().toString();
                String weeksTXT=weeks.getText().toString();
                String absentTXT=absent.getText().toString();


                //inserting data using the created method in DBHelper
                Boolean checkInsertData = db.insertAttendanceData(moduleTXT,weeksTXT,absentTXT,tableName);
                if(checkInsertData==true){
                    Toast.makeText(AttendenceSem1.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AttendenceSem1.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String moduleTXT= module.getText().toString();
                String weeksTXT=weeks.getText().toString();
                String absentTXT=absent.getText().toString();

                //inserting data using the created method in DBHelper
                Boolean checkUpdateData = db.updateAttendanceData(moduleTXT,weeksTXT,absentTXT,tableName);
                if(checkUpdateData==true){
                    Toast.makeText(AttendenceSem1.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AttendenceSem1.this,"Entry not Updated",Toast.LENGTH_SHORT).show();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String moduleTXT= module.getText().toString();

                //inserting data using the created method in DBHelper
                Boolean checkDeleteData = db.deleteAttendanceData(moduleTXT,tableName);
                if(checkDeleteData==true){
                    Toast.makeText(AttendenceSem1.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AttendenceSem1.this,"Entry not Deleted",Toast.LENGTH_SHORT).show();
                }

            }
        });

        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //getting output of getData() of DBHelper
                Cursor result = db.getData(tableName);

                if(result.getCount()==0){
                    Toast.makeText(AttendenceSem1.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                //else we use string buffer
                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Module name :"+result.getString(0)+"\n");
                    buffer.append("Academic weeks :"+result.getString(1)+"\n");
                    buffer.append("Absent weeks :"+result.getString(2)+"\n");

                    //calculating attendance percentage and appending to buffer
                    float weeks = Float.parseFloat(result.getString(1));
                    float absent= Float.parseFloat(result.getString(2));
                    float percentage = ((weeks-absent)/weeks)*100;
                    float roundoff = Math.round(percentage*100)/100;

                    String percent = String.valueOf(roundoff);

                    buffer.append("Attendance :"+percent+"% \n\n");

                }

                //generates the output as an Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(AttendenceSem1.this);
                builder.setCancelable(true);
                builder.setTitle("Semester Attendance");
                builder.setMessage(buffer.toString());
                builder.show();
            }

        });

    }
}
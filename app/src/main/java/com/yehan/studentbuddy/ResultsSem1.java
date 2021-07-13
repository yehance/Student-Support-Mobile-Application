package com.yehan.studentbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ResultsSem1 extends AppCompatActivity {

    EditText module,credits,result;
    Button insert,update,delete,view;

    //creating database variable
    DBHelper db;

    //below variables are used for GPA calculation
    public static double value1 =0;
    public static double value2 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_sem1);

        //initializing the variables
        module = findViewById(R.id.moduleNameTextS1);
        credits=findViewById(R.id.creditTextS1);
        result=findViewById(R.id.ResultTextS1);

        insert=findViewById(R.id.btnInsertS1);
        update=findViewById(R.id.btnUpdateS1);
        delete=findViewById(R.id.btnDeleteS1);
        view=findViewById(R.id.btnViewS1);

        //Setting table name
        String tableName = "resultsSem1";

        //creating new DBHelper object
        db= new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String moduleTXT= module.getText().toString();
                String creditsTXT=credits.getText().toString();
                String resultTXT=result.getText().toString();


                //inserting data using the created method in DBHelper
                Boolean checkInsertData = db.insertResultData(moduleTXT,creditsTXT,resultTXT,tableName);
                if(checkInsertData==true){
                    Toast.makeText(ResultsSem1.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ResultsSem1.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String moduleTXT= module.getText().toString();
                String creditsTXT=credits.getText().toString();
                String resultTXT=result.getText().toString();

                //inserting data using the created method in DBHelper
                Boolean checkUpdateData = db.updateResultData(moduleTXT,creditsTXT,resultTXT,tableName);
                if(checkUpdateData==true){
                    Toast.makeText(ResultsSem1.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ResultsSem1.this,"Entry not Updated",Toast.LENGTH_SHORT).show();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //getting input data to String variables
                String nameTXT= module.getText().toString();

                //inserting data using the created method in DBHelper
                Boolean checkDeleteData = db.deleteResultData(nameTXT,tableName);
                if(checkDeleteData==true){
                    Toast.makeText(ResultsSem1.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ResultsSem1.this,"Entry not Deleted",Toast.LENGTH_SHORT).show();
                }

            }
        });

        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //getting output of getData() of DBHelper
                Cursor result = db.getData(tableName);

                if(result.getCount()==0){
                    Toast.makeText(ResultsSem1.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                //else we use string buffer
                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Module Name :"+result.getString(0)+"\n");
                    buffer.append("Credits :"+result.getString(1)+"\n");
                    buffer.append("Result :"+result.getString(2)+"\n\n");

                    double credits = Double.parseDouble(result.getString(1));
                    double grade=0;


                    switch(result.getString(2)){
                        case "A+":
                        case "A" :
                        case "a" :
                        case "a+":
                            grade= 4.00;
                            break;
                        case "A-":
                        case "a-":
                            grade= 3.70;
                            break;
                        case "B+":
                        case "b+":
                            grade= 3.30;
                            break;
                        case "B":
                        case "b":
                            grade= 3.00;
                            break;
                        case "B-":
                        case "b-":
                            grade= 2.70;
                            break;
                        case "C+":
                        case "c+":
                            grade= 2.30;
                            break;
                        default:
                            grade=0;
                    }

                    value1 = value1 + (credits*grade);
                    value2 = value2 + credits;

                }

                   Double GPA = value1/value2;
                   Double GPA_round= Math.round(GPA*1000.0)/1000.0;
                   String string_GPA = String.valueOf(GPA_round);
                   String string_value2=String.valueOf(value2);

                   //initializing static variables after while loop
                   value1=0;
                   value2=0;

                   buffer.append("Semester Credits :"+string_value2+"\n");
                   buffer.append("Semester GPA :"+string_GPA+"\n");

                //generates the output as an Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(ResultsSem1.this);
                builder.setCancelable(true);
                builder.setTitle("Semester Results");
                builder.setMessage(buffer.toString());
                builder.show();
            }

        });

    }
}
package com.yehan.studentbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //database constructor
    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1); //adds DB name,factory and version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //now execute an SQL query, giving table name and column name with parameters
        db.execSQL("create Table resultsSem1(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem2(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem3(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem4(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem5(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem6(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem7(Module TEXT primary key, Credits TEXT, Result TEXT) ");
        db.execSQL("create Table resultsSem8(Module TEXT primary key, Credits TEXT, Result TEXT) ");

        db.execSQL("create Table attendanceSem1(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem2(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem3(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem4(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem5(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem6(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem7(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");
        db.execSQL("create Table attendanceSem8(Module TEXT primary key, Weeks TEXT, Absent TEXT) ");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop the table if it already exists
        db.execSQL("drop Table if exists resultsSem1");
        db.execSQL("drop Table if exists resultsSem2");
        db.execSQL("drop Table if exists resultsSem3");
        db.execSQL("drop Table if exists resultsSem4");
        db.execSQL("drop Table if exists resultsSem5");
        db.execSQL("drop Table if exists resultsSem6");
        db.execSQL("drop Table if exists resultsSem7");
        db.execSQL("drop Table if exists resultsSem8");

        db.execSQL("drop Table if exists attendanceSem1");
        db.execSQL("drop Table if exists attendanceSem2");
        db.execSQL("drop Table if exists attendanceSem3");
        db.execSQL("drop Table if exists attendanceSem4");
        db.execSQL("drop Table if exists attendanceSem5");
        db.execSQL("drop Table if exists attendanceSem6");
        db.execSQL("drop Table if exists attendanceSem7");
        db.execSQL("drop Table if exists attendanceSem8");
    }

    //boolean method to insert user data to SQL database results tables
    public Boolean insertResultData(String Module, String Credits, String Result,String tableName){

        SQLiteDatabase db = this.getWritableDatabase();
        //below is used to put values inside the table
        ContentValues contentValues = new ContentValues();
        //setting column names
        contentValues.put("Module",Module);
        contentValues.put("Credits",Credits);
        contentValues.put("Result",Result);

        //then we use insert method which needs three parameters including table name
        long result= db.insert(tableName,null,contentValues);
        if(result==-1){ //-1 means insertion has failed
            return false;
        }else{
            return true;
        }
    }

    //boolean method to insert user data to SQL database attendance tables
    public Boolean insertAttendanceData(String Module, String Weeks, String Absent,String tableName){

        SQLiteDatabase db = this.getWritableDatabase();
        //below is used to put values inside the table
        ContentValues contentValues = new ContentValues();
        //setting column names
        contentValues.put("Module",Module);
        contentValues.put("Weeks",Weeks);
        contentValues.put("Absent",Absent);

        //then we use insert method which needs three parameters including table name
        long result= db.insert(tableName,null,contentValues);
        if(result==-1){ //-1 means insertion has failed
            return false;
        }else{
            return true;
        }
    }

    //boolean method to update user data to SQL database results tables
    public Boolean updateResultData(String Module, String Credits, String Result, String tableName){

        SQLiteDatabase db = this.getWritableDatabase();
        //below is used to put values inside the table
        ContentValues contentValues = new ContentValues();
        //name is not included below as we need to update only contact and dob
        contentValues.put("Credits",Credits);
        contentValues.put("Result",Result);

        //Cursor is used for selecting the row, whatever row selected get loaded into cursor object
        //this checks whether given name matches the what already exists
        Cursor cursor = db.rawQuery("Select* from "+tableName+" where Module=?",new String[]{Module});
        if(cursor.getCount()>0){
            //if cursor has some data then update should happen

            //then we use update method which needs three parameters including table name
            //here we update where name string matches to updating data
            long result= db.update(tableName, contentValues, "Module=?",new String[]{Module});
            if(result==-1){ //-1 means insertion has failed
                return false;
            }else{
                return true;
            }

        }

        else{
            return false;
        }
    }

    //boolean method to update user data to SQL database attendance tables
    public Boolean updateAttendanceData(String Module, String Weeks, String Absent, String tableName){

        SQLiteDatabase db = this.getWritableDatabase();
        //below is used to put values inside the table
        ContentValues contentValues = new ContentValues();
        //name is not included below as we need to update only contact and dob
        contentValues.put("Weeks",Weeks);
        contentValues.put("Absent",Absent);

        //Cursor is used for selecting the row, whatever row selected get loaded into cursor object
        //this checks whether given name matches the what already exists
        Cursor cursor = db.rawQuery("Select* from "+tableName+" where Module=?",new String[]{Module});
        if(cursor.getCount()>0){
            //if cursor has some data then update should happen

            //then we use update method which needs three parameters including table name
            //here we update where name string matches to updating data
            long result= db.update(tableName, contentValues, "Module=?",new String[]{Module});
            if(result==-1){ //-1 means insertion has failed
                return false;
            }else{
                return true;
            }

        }

        else{
            return false;
        }
    }

    //boolean method to delete user data from SQL database result tables
    public Boolean deleteResultData(String Module, String tableName){

        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor is used for selecting the row, whatever row selected get loaded into cursor object
        //this checks whether given name matches the what already exists
        Cursor cursor = db.rawQuery("Select* from "+tableName+" where Module=?",new String[]{Module});
        if(cursor.getCount()>0){
            //if cursor has some data then delete should happen

            //then we use update method which needs three parameters including table name
            //here we delete where name string matches to updating data
            long result= db.delete(tableName, "Module=?",new String[]{Module});
            if(result==-1){ //-1 means insertion has failed
                return false;
            }else{
                return true;
            }

        }
        else{
            return false;
        }
    }

    //boolean method to delete user data from SQL database attendance tables
    public Boolean deleteAttendanceData(String Module, String tableName){

        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor is used for selecting the row, whatever row selected get loaded into cursor object
        //this checks whether given name matches the what already exists
        Cursor cursor = db.rawQuery("Select* from "+tableName+" where Module=?",new String[]{Module});
        if(cursor.getCount()>0){
            //if cursor has some data then delete should happen

            //then we use update method which needs three parameters including table name
            //here we delete where name string matches to updating data
            long result= db.delete(tableName, "Module=?",new String[]{Module});
            if(result==-1){ //-1 means insertion has failed
                return false;
            }else{
                return true;
            }

        }
        else{
            return false;
        }
    }

    //Cursor method to view user data from SQL database result and attendance tables
    public Cursor getData(String tableName){

        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor is used for selecting the table data
        //in here where clause is not necessary as want to view all the data
        Cursor cursor = db.rawQuery("Select* from "+tableName+"",null);
        return cursor;
    }

}

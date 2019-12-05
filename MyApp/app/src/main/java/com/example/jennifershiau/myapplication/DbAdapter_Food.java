package com.example.jennifershiau.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter_Food {
    myDbHelper myhelper;
    public DbAdapter_Food(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String time, String food)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TIME, time);
        contentValues.put(myDbHelper.FOOD, food);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.TIME,myDbHelper.FOOD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String time =cursor.getString(cursor.getColumnIndex(myDbHelper.TIME));
            String food =cursor.getString(cursor.getColumnIndex(myDbHelper.FOOD));
            buffer.append(time + "\n" + food + "\n");
        }
        return buffer.toString();
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase2";    // Database Name
        private static final String TABLE_NAME = "myTable2";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";         // Column I (Primary Key)
        private static final String TIME = "Time";    //Column II
        private static final String FOOD = "Food";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TIME+" VARCHAR(255) ,"+ FOOD+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}

package com.google.android.gms.samples.vision.barcodereader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentsDataSource {
    private SQLiteDatabase mDatabase;
    private MySQLiteHelper dbHelper;
    private static final String TABLE_NAME = "in_out_table";
    public StudentsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        mDatabase = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void create_entry(String entry,String date,String time,String place) {
        ContentValues cv = new ContentValues();
        cv.put("entry_no", entry);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("place", place);

        mDatabase.insert("in_out_table", null, cv);
    }

    /*public void delete_entry(String time){
        mDatabase.delete(TABLE_NAME,,)
    }*/

    public Cursor view_entry() {

        String arr = null;
        String ss[] = null;
        Cursor c = mDatabase.rawQuery("select * from in_out_table ", null);
        int i = 0;

        return c;
    }

    //Kartik
    public void deleteTopEntry(){
        //currently deleting entire table....to be corrected
        mDatabase.delete(TABLE_NAME,
                null,
                null
                );
    }
}

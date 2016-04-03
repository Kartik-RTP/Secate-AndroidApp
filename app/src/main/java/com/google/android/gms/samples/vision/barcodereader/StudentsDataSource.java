package com.google.android.gms.samples.vision.barcodereader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentsDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private static final String TABLE_NAME = "in_out_table";
    public StudentsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
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

        database.insert("in_out_table", null, cv);
    }

    /*public void delete_entry(String time){
        database.delete(TABLE_NAME,,)
    }*/

    public Cursor view_entry() {

        String arr = null;
        String ss[] = null;
        Cursor c = database.rawQuery("select * from in_out_table ", null);
        int i = 0;
        // while (c.moveToNext()) {
        // arr = c.getString(c.getColumnIndex("entry_no"));
        // arr=Integer.toString(c.getCount());
        // ss[i]=c.getString(c.getColumnIndex("entry_no"));
        // }
        //String id[] = new String[c.getCount()];
        //i = 0;
        ///if (c != null && c.getCount() > 0) {
        //c.moveToFirst();
        //	do {
        //	id[i] = c.getString(c.getColumnIndex("entry_no"));
        //i++;
        //	} while (c.moveToNext());
        //c.close();


        //}
        return c;
    }
}

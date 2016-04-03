package com.google.android.gms.samples.vision.barcodereader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table if not exists in_out_table (entry_no text, date text, time text , place text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Log.w(MySQLiteHelper.class.getName(),
        //     "Upgrading database from version " + oldVersion + " to "
        //       + newVersion + ", which will destroy all old data");
        // db.execSQL("DROP TABLE IF EXISTS " + "in_out_table");
        onCreate(db);

    }


}

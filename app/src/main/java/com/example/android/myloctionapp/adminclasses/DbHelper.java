package com.example.android.myloctionapp.adminclasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eKasiLab Alex CDTB on 2018/02/09.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Meeting.db";
    private static final String TABLE_NAME = "meeting_table";
    private static final String COL_2 = "EVENT";
    private static final String COL_3 = "LOCATION";
    private static final String COL_4 = "DATETIME";
    private static final String COL_5 = "DESCRIPTION";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(EVENT TEXT PRIMARY KEY ,LOCATION TEXT,DATETIME INTEGER,DESCRIPTION STRING )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String event,String location,String datetime,String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,event);
        contentValues.put(COL_3,location);
        contentValues.put(COL_4,datetime);
        contentValues.put(COL_5,description);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        return result != -1;
    }

    public List<Info> getAllData(){
        List<Info> modelList = new ArrayList<Info>();
        String query = "select * from "+TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Info model = new Info();
                model.setEvent(cursor.getString(0));
                model.setLocation(cursor.getString(1));
                model.setDateTime(cursor.getString(2));
                model.setDescription(cursor.getString(3));


                modelList.add(model);
            }while (cursor.moveToNext());
        }


        Log.d("student data", modelList.toString());


        return modelList;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}

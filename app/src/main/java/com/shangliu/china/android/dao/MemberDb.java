package com.shangliu.china.android.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Administrator on 2016/4/12.
 */
public class MemberDb extends SQLiteOpenHelper {

    public static final String DBNAME = "memberdb";
    public static final String TABLEDBNAME = "membertable";
    private static MemberDb excutorDb = null;
    Context mContext;

    public String exsql = "CREATE TABLE IF NOT EXISTS " + TABLEDBNAME + " (personid integer primary key autoincrement, username varchar(20), moblie INTEGER)"; // 需要写；?

    public static MemberDb getInstance(Context context) {
        if (excutorDb == null) {
            excutorDb = new MemberDb(context);
        }
        return excutorDb;
    }


    public MemberDb(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(exsql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

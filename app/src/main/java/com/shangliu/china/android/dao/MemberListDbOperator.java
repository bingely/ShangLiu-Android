package com.shangliu.china.android.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shangliu.china.android.model.Customer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/4/12.
 */
public class MemberListDbOperator {
    private static MemberListDbOperator mMemberListDbOperator;

    public static MemberListDbOperator getInstance(Context context) {
        if (mMemberListDbOperator == null) {
            mMemberListDbOperator = new MemberListDbOperator();
        }
        return mMemberListDbOperator;
    }

    // 接下来就是写一些增删改查的操作

    // 存储
    public void saveMemberDatas(Context context,List<Customer> list) {
        SQLiteDatabase sqLiteDatabase = MemberDb.getInstance(context).getWritableDatabase();
        try {
            sqLiteDatabase.beginTransaction();
            int size = list.size();

            for (int i = 0; i < size; i++) {
                Customer item = list.get(i);

                ContentValues contentValues = new ContentValues();
                contentValues.put("username", item.username);
                contentValues.put("moblie", item.moblie);
                //contentValues.put("visit_time", item.visit_time);

                sqLiteDatabase.insert(MemberDb.TABLEDBNAME, null, contentValues);//存储

            }

            sqLiteDatabase.setTransactionSuccessful();
            System.out.println("通讯录数据存储成功 !!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("通讯录数据存储失败 !!!");
        }finally{

            sqLiteDatabase.endTransaction();
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

        }
    }

    // 从表中得到List<Customer>集合数据（查询）
    public List<Customer> getMemberList(Context context){

        List<Customer> executorList = new ArrayList<Customer>();
        SQLiteDatabase sqLiteDatabase = MemberDb.getInstance(context).getWritableDatabase();
        Cursor cursor = null;
        sqLiteDatabase.beginTransaction();//开启事务
        try {
            cursor = sqLiteDatabase.rawQuery("select * from "+ MemberDb.TABLEDBNAME, null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return executorList;
            }
            do {
                Customer customer = new Customer();
                customer.username =  cursor.getString(cursor.getColumnIndex("username"));
                customer.moblie =  cursor.getString(cursor.getColumnIndex("moblie"));
                customer.visit_time =  cursor.getString(cursor.getColumnIndex("type"));
                executorList.add(customer);
            } while (cursor.moveToNext());

            sqLiteDatabase.setTransactionSuccessful();
            System.out.println("db get data success !!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("db get data fail !!!");
        }finally{
            sqLiteDatabase.endTransaction();//结束事务
            if (cursor != null) {
                cursor.close();
            }
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
        }
        return executorList;
    }


}

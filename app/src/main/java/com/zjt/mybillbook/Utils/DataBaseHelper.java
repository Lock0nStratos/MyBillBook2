package com.zjt.mybillbook.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zjt.mybillbook.Bean.BillItemBean;

/**
 * Created by Y410P on 2018/3/15.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String BILL_TIME = "bill_time";
    public static final String BILL_TYPE = "bill_type";
    public static final String BILL_OUTIN = "bill_outin";
    public static final String BILL_MONEY = "bill_money";
    public static final String BILL_NAME = "bills";

    public DataBaseHelper(Context context){
        super(context,"bills",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exits bills("+
                "id integer primary key,"+
                "bill_time varchar,"+
                "bill_type varchar,"+
                "bill_outin integer"+
                "bill_money varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertBill(BillItemBean billItemBean){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(BILL_TIME,billItemBean.getTime());
        cv.put(BILL_TYPE,billItemBean.getType());
        cv.put(BILL_OUTIN,billItemBean.getOutIn());
        cv.put(BILL_MONEY,billItemBean.getMoney());
        database.insert(BILL_NAME,null,cv);
    }

    public Cursor getBillData(){
        SQLiteDatabase database=getWritableDatabase();
        return database.query(BILL_NAME,null,null,null,null,null,BILL_TIME+" ASC");
    }

    public void deleteAllData(){
        SQLiteDatabase database=getWritableDatabase();
        database.delete(BILL_NAME,null,null);
    }
}

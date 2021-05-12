package com.example.quanlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.quanlysinhvien.database.DatabaseHelper;
import com.example.quanlysinhvien.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NGUOI_DUNG ="CREATE TABLE NguoiDung (id text primary key, " +
            "hoten text lop text,noisinh text, phone text);";
    public static final String TAG = "NguoiDungDAO";

    public NguoiDungDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserNguoiDung(NguoiDung nd){
        ContentValues values = new ContentValues();
        values.put("hoten",nd.getHoten());
        values.put("lop",nd.getLop());
        values.put("noisinh",nd.getNoisinh());
        values.put("phone",nd.getPhone());
        try {
            if(db.insert(TABLE_NAME,null,values)== -1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }
        //getAll
    public List<NguoiDung> getAllNguoiDung(){
        List<NguoiDung> dsNguoiDung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            NguoiDung ee = new NguoiDung();
            ee.setHoten(c.getString(0));
            ee.setLop(c.getString(1));
            ee.setNoisinh(c.getString(2));
            ee.setPhone(c.getString(3));
            dsNguoiDung.add(ee);
            Log.d("//=====",ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;

    }
        //update
    public int updateNguoiDung(NguoiDung nd){
        ContentValues values = new ContentValues();
        values.put("hoten",nd.getHoten());
        values.put("lop",nd.getLop());
        values.put("noisinh",nd.getNoisinh());
        values.put("phone",nd.getPhone());
        int result = db.update(TABLE_NAME,values,"phone=?", new String[]{nd.getPhone()});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int updateInfoNguoiDung(String hoten, String lop, String noisinh, String phone){
        ContentValues values = new ContentValues();
        values.put("hoten",hoten);
        values.put("lop",lop);
        values.put("noisinh",noisinh);
        values.put("phone", phone);
        int result = db.update(TABLE_NAME,values,"hoten=?", new String[]{hoten});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteNguoiDungByID(String phone){
        int result = db.delete(TABLE_NAME,"phone=?",new String[]{phone});
        if (result == 0)
            return -1;
        return 1;
    }


}

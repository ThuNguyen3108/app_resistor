package com.example.introduce.HDSD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BangMauInsert {
    BangMauHandle helper;
    public BangMauInsert(Context context){
        helper = new BangMauHandle(context);
    }
    public ArrayList<BangMau> getAll() {
        ArrayList<BangMau> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM BangMau", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            //lay du lieu ra
            int id = cs.getInt(0);
            String vach1 = cs.getString(1);
            String vach2 = cs.getString(2);
            String vach3 = cs.getString(3);
            String vach4 = cs.getString(4);
            BangMau bm = new BangMau(id,vach1, vach2, vach3, vach4);
            ds.add(bm);
            cs.moveToNext();
        }
        cs.close();
        return ds;

    }
}

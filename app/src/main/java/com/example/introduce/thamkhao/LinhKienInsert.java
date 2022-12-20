package com.example.introduce.thamkhao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LinhKienInsert {
    LinhKienHandle helper;
    public LinhKienInsert(Context context){
        helper = new LinhKienHandle(context);
    }
    public ArrayList<LinhKien> getAll() {
        ArrayList<LinhKien> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM LinhKien", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            //lay du lieu ra
            int id = cs.getInt(0);
            String img = cs.getString(1);
            String ten = cs.getString(2);
            String giatri = cs.getString(3);
            String thieu = cs.getString(4);
            String chitiet = cs.getString(5);
            LinhKien bm = new LinhKien(id, img, ten, giatri, thieu, chitiet);
//            BangMau bm = new BangMau();
            ds.add(bm);
            cs.moveToNext();
        }
        cs.close();
        return ds;

    }
}

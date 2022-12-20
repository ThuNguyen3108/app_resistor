package com.example.introduce.thamkhao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MachDienInsert {
    MachDienHandle helper;
    public MachDienInsert(Context context){
        helper = new MachDienHandle(context);
    }
    public ArrayList<MachDien> getAll() {
        ArrayList<MachDien> ds = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM MachDien", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            //lay du lieu ra
            int id = cs.getInt(0);
            String img = cs.getString(1);
            String ten = cs.getString(2);
            String thieu = cs.getString(3);
            String chitiet = cs.getString(4);
            MachDien bm = new MachDien(id, img, ten, thieu, chitiet);
//            BangMau bm = new BangMau();
            ds.add(bm);
            cs.moveToNext();
        }
        cs.close();
        return ds;

    }
}

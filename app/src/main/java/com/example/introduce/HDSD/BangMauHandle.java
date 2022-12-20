package com.example.introduce.HDSD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BangMauHandle extends SQLiteOpenHelper {
    static String dbname = "BangMau.db";
    static String TABLE_NAME = "BangMau";
    static String COL_1 = "id";
    static  String COL_3 = "vach1";
    static  String COL_4 = "vach2";
    static  String COL_5 = "vach3";
    static  String COL_6 = "vach4";
    static int version=1;
    public BangMauHandle(Context context ) {

        super(context,dbname,  null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE BangMau(id integer primary key autoincrement, " +
                "vach1 text, vach2 text, vach3 text, vach4 text)";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('denv1','denv2','denv3','denv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('nauv1','nauv2','nauv3','nauv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('dov1','dov2','dov3','dov4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('camv1','camv2','camv3','camv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('vangv1','vangv2','vangv3','vangv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('lav1','lav2','lav3','lav4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('bluev1','bluev2','bluev3','bluev4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('timv1','timv2','timv3','timv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('xamv1','xamv2','xamv3','xamv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('trangv1','trangv2','trangv3','trangv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('dongv1','dongv2','dongv3','dongv4')";
        db.execSQL(sql);
        sql = "INSERT INTO BangMau(vach1, vach2, vach3, vach4) VALUES('bacv1','bacv2','bacv3','bacv4')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

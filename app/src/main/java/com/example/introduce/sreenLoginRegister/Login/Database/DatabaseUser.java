package com.example.introduce.sreenLoginRegister.Login.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.introduce.screenCamera.Constant;

public class DatabaseUser extends SQLiteOpenHelper {

    public DatabaseUser(@Nullable Context context) {
        super(context, "user.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_USER = "CREATE TABLE user ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "hoten TEXT,"
                + "email TEXT,"
                + "taikhoan TEXT,"
                + "matkhau TEXT,"
                + "sdt TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE);
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE_USERGG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE_USER = "DROP TABLE IF EXISTS user";
        sqLiteDatabase.execSQL(DROP_TABLE_USER);
        sqLiteDatabase.execSQL(Constant.DROP_TABLE);
        sqLiteDatabase.execSQL(Constant.DROP_TABLE_USERGG);
    }
}

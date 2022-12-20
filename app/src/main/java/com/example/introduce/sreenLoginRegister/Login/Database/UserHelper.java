package com.example.introduce.sreenLoginRegister.Login.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.introduce.screenCamera.Constant;
import com.example.introduce.sreenLoginRegister.Login.model.User;


public class UserHelper {
    DatabaseUser dbUser;
    SQLiteDatabase db;

    public UserHelper(Context context) {
        this.dbUser = new DatabaseUser(context) ;
        this.db = dbUser.getWritableDatabase();
    }
    public boolean InsertUser(User user){
        ContentValues values = new ContentValues();
        values.put("hoten", user.getHoten());
        values.put("email", user.getEmail());
        values.put("taikhoan", user.getTaikhoan());
        values.put("matkhau", user.getMatkhau());
        values.put("sdt",user.getSdt());
        long kq = db.insert("user",null,values);
        if(kq > 0){
            return true;
        }
        else{
            return false;
        }
    }
    //user gg
    public int InsertUserGG(String email){
        ContentValues values = new ContentValues();
        values.put("email", email);
        long kq = db.insert("user",null,values);
        if(kq > 0){
            return getUserGGByEmail(email);
        }
        else{
            return 0;
        }
    }
    public int getUserGGByEmail(String email){
        String sql = "SELECT id FROM user WHERE email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }else{
            InsertUserGG(email);
        }
        return 0;
    }
    public int getUserIdByUsername(String username){
        String sql = "SELECT id FROM user WHERE taikhoan = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{username});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }else{
            return 0;
        }
    }
    public User getUser(String username){
        User user = new User();
        String query = "SELECT matkhau FROM user WHERE taikhoan = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do{
                user.setMatkhau(cursor.getString(0));

            }while(cursor.moveToNext());

        }
        return user;
    }
    public User getUserByEmail(String email){
        User user = new User();
        String query = "SELECT matkhau FROM user WHERE email = '" + email + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do{
                user.setMatkhau(cursor.getString(0));

            }while(cursor.moveToNext());
        }
        return user;
    }


    public boolean checkUser(String username){
        String query = "SELECT * FROM user WHERE taikhoan = '" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUserByEmail(String email){
        String query = "SELECT * FROM user WHERE email = '" + email + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }





}

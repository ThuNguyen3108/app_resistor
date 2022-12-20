package com.example.introduce.screenCamera;

import static com.example.introduce.screenCamera.Constant.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.introduce.sreenLoginRegister.Login.Database.DatabaseUser;

import java.util.ArrayList;
import java.util.List;

public class databaseHelper {
    DatabaseUser dba;
    SQLiteDatabase db;
    public databaseHelper(Context context) {
        this.dba = new DatabaseUser(context);
        db = dba.getWritableDatabase();
    }
    //insert Resistor
    public boolean insertResistor(Resistor resistor){
        ContentValues values = new ContentValues();
        values.put(IMG, resistor.getImg());
        values.put(VACH1, resistor.getVach1());
        values.put(VACH2, resistor.getVach2());
        values.put(VACH3, resistor.getVach3());
        values.put(VACH4, resistor.getVach4());
        values.put(GIATRI, resistor.getGtri());
        values.put(id_user, resistor.getId_user());
        long kq = db.insert(TABLE_NAME, null, values);
        if(kq > 0){
            return true;
        }
        else{
            return false;
        }
    }
    //get all resistor by id_user
    public List<Resistor> getAllResistor(int id_user){
        Log.d("id_user!!", String.valueOf(id_user));
        List<Resistor> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id_user = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id_user)});
        Log.d("cursor", String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst()){
            do{
                Resistor resistor = new Resistor();
                resistor.setId(cursor.getInt(0));
                resistor.setImg(cursor.getBlob(1));
                resistor.setVach1(cursor.getString(2));
                resistor.setVach2(cursor.getString(3));
                resistor.setVach3(cursor.getString(4));
                resistor.setVach4(cursor.getString(5));
                resistor.setGtri(cursor.getString(6));
                resistor.setId_user(cursor.getInt(7));
                list.add(resistor);
            }while (cursor.moveToNext());

        }
        return list;
    }
    //delete
    public boolean deleteResistor(int id){
        long kq = db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(id)});
        if(kq > 0){
            return true;
        }
        else{
            return false;
        }
    }
}

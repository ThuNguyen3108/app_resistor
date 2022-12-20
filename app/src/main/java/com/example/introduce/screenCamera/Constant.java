package com.example.introduce.screenCamera;

public class Constant {
    public static final String DATABASE_NAME = "camera";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "camera";
    public static final String ID = "id";
    public static final String IMG = "img";
    public static final String VACH1 = "vach1";
    public static final String VACH2 = "vach2";
    public static final String VACH3 = "vach3";
    public static final String VACH4 = "vach4";
    public static final String GIATRI = "gtri";
    public static final String id_user = "id_user";
    public static final String TABLE_USERGG = "usergg";
    public static final String TABLE_USERFB = "userfb";
    public static final String EMAIL = "email";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + IMG + " BLOB,"
            + VACH1 + " TEXT,"
            + VACH2 + " TEXT,"
            + VACH3 + " TEXT,"
            + VACH4 + " TEXT,"
            + GIATRI + " TEXT,"
            + id_user + " INTEGER"
            + ")";
    public static final String CREATE_TABLE_USERGG = "CREATE TABLE " + TABLE_USERGG + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EMAIL + " TEXT"
            + ")";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String DROP_TABLE_USERGG = "DROP TABLE IF EXISTS " + TABLE_USERGG;
}

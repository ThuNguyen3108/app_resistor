package com.example.introduce.thamkhao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MachDienHandle extends SQLiteOpenHelper {
    static String dbname = "MachDien.db";
    static String TABLE_NAME = "MachDien";
    static String COL_1 = "id";
    static  String COL_2 = "img";
    static  String COL_3 = "ten";
    static  String COL_5 = "thieu";
    static  String COL_6 = "chitiet";
    static int version=1;
    public MachDienHandle(Context context ) {

        super(context,dbname,  null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE MachDien(id integer primary key autoincrement, " +
                "img text, ten text, thieu text, chitiet text)";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt1', 'Mạch Vi điều khiển PIC 16F887 thay thế PLC',  'STC (Said To Contain)'," +
                "'Mạch Vi điều khiển PIC 16F887 thay thế PLC \n ứng dụng giao tiếp ngõ vào-ngõ ra theo \n chuẩn 24V DC của PLC, bằng cách lập trình \n vi điều khiển PIC 16F887, với 35 I/O.\n" +
                "Ưu điểm của sản phẩm: Giá thành rẻ, người \n lập trình có thể nạp chương trình theo\n ý muốn, dễ sử dụng, cách ly điện áp \n an toàn, có led báo I/O, dễ lắp đặt\n, lập trình sẵn I/O mặc định.\n" +
                "' )";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt2', 'Main H61 intel','Intel'," +
                "'Thông số kỹ thuật-Intel Socket Intel Socket\n 1155 Form Factor ATX-Chipset Intel H61- CPU\n hỗ trợ các dòng 1155 - Memory Slot \n(Số khe  cắm ram): 2 - Memory Type \n (Loại Ram sử dụng) DDR3 Memory Bus 1066Mhz,\n 1333Mhz,  1600MHz, Internal I/O' )";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt3', 'Main Gigabyte H61M-DS2 ','Gigabyte'," +
                "'Được thiết kế dành cho các hệ thống máy tính\n phổ thông, ngoài các hỗ trợ cơ bản của nền \n tảng CoffeeLake, H310M-DS2 còn được trang bị \n các tính năng cũng như công nghệ đặc trưng \n từ nhà sản xuất GIGABYTE. Đầu tiên có thể \n  kể đến là công nghệ Ultra Durable với các\n tiêu chuẩn về thiết kế và linh kiện chất lượng cao\n mang đến sự bền bỉ và ổn định.' )";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt4', 'Bo mạch trên máy hàn most loại 12 sò ', 'No Brand'," +
                "'sản phẩm là 1 bo trên cho máy hàn mốt, \n bo công xuất cho máy hàn most, Hàn que , \n máy hàn tig , máy cut 40 ,50 điện 1 pha thì \nsử dụng sò 23N50 ;Điện 3 pha thì dùng K3878' )";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt5', ' ITX-P360 LGA1151 8th 9th Gen Mini ITX \nMotherboard','Intel'," +
                "'Cổng: wifi, SATA, VGA, PCI-Express X16,\n USB 2.0, PS2, Ethernet, USB 3.0, PCI-E 3.0 \n LAN:  2* RJ45 LAN Port \nKích thước:170mm x 170mm' )";
        db.execSQL(sql);
        sql = "INSERT INTO MachDien(img, ten, thieu, chitiet) " +
                "VALUES('mdt6', 'Bảng Mạch PCB Cao Cấp WMS 550 Life (LOL)','liejiang'," +
                "'Bảng mạch trong máy chơi game. \nGiao Diện cảm ứng: USB Và RS232 Nối\n Tiếp Cảm Ứng Tín hiệu Đầu Vào: VGA,HDMl \n ' )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE MachDien";
        db.execSQL(sql);
    }
}

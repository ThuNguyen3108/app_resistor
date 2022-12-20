package com.example.introduce.thamkhao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LinhKienHandle extends SQLiteOpenHelper {
    static String dbname = "LinhKien.db";
    static String TABLE_NAME = "LinhKien";
    static String COL_1 = "id";
    static  String COL_2 = "img";
    static  String COL_3 = "ten";
    static  String COL_4 = "giatri";
    static  String COL_5 = "thieu";
    static  String COL_6 = "chitiet";
    static int version=1;
    public LinhKienHandle(Context context ) {

        super(context,dbname,  null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE LinhKien(id integer primary key autoincrement, " +
                "img text, ten text, giatri text, thieu text, chitiet text)";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt1', 'ORANGE ORGANE BROWN GOLD','330Ω  ± 5% ','Công ty TNHH Tiến Đatk H&C'," +
                "'Điện trở 6,8R 1/4W ;  Loại:-điện trở 1/4w ;\nLoại 4 vòng màu; sai số 5% ;\n nhiệt độ hoạt động: -55 - >150.' )";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt2', 'Điện trở màu trắng xám 3W','10K, 10KΩ ± 5%','Panasonic'," +
                "'Dài 15mm * đường kính 5mm; Pin: 0,5 mm.\nĐiện trở 3W, trên thân có những vạch\n màu thể hiện giá trị của điện trở theo \n quy chuẩn thế giới để người dùng có thể \n dễ dàng lựa chọn điện trở phù hợp.' )";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt3', 'Điện trở màu xám ','39KΩ-J ± 5%','KOA'," +
                "'Điện trở thường dùng làm điện trở cặp \n với 33K trong mạch đảo pha của đèn \n EL34 đẩy kéo; Kích thước: 5x15 mm' )";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt4', 'Tụ hóa','4.7uF 450V JWCO 17x10mm','JWCO'," +
                "'Tụ hóa 4.7uF 450V là tụ phân cực, có \n dung môi là một lớp hóa chất. \n Tụ hóa 4.7uF 450V là tụ có hình trụ, \n trị số được ghi trực tiếp trên thân tụ. \n Sau trị số điện dung bao giờ cũng có \n giá trị điện áp, điện áp ghi trên \n tụ chính là điện áp cực đại mà tụ \n có thể chịu được, vượt qua giá trị \n này thì lớp cách điện sẽ bị đánh thủng ,\n trong thực tế ta phải lắp tụ có trị số \n điện áp cao gấp khoảng 1,5 lần \n điện áp của mạch điện.' )";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt5', 'Cầu chì nhiệt AUPO BF184','10A-250VAC 184 độ','OEM'," +
                "'Cầu chì nhiệt được dùng nhiều trong \n các thiết bị nhiệt dùng điện. Dùng thay thế \n cầu chì nồi Chiên/Nướng/Nồi cơm điện/Lẩu điện...\n Chất Lượng cao, bền và giúp an toàn khi dùng,\n  Chịu tải: 250V-10A. Nhiệt độ nhảy: 184 độ' )";
        db.execSQL(sql);
        sql = "INSERT INTO LinhKien(img, ten, giatri, thieu, chitiet) " +
                "VALUES('dt6', 'Điện trở sứ BPR56 KOA5N5','0.22R 0.33R 5W','KOA'," +
                "'Điện trở dùng cho các main mạch \n công suất bán dẫn. Điện trở sứ \n 0.22R 0.33R 5W có công suất lớn, \n hiệu suất ổn định, nhiệt độ hoạt động cao \n phù hợp với các mạch điện có dòng điện \n lớn, công suất tiêu thụ lớn.' )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE LinhKien";
        db.execSQL(sql);
    }
}

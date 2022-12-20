package com.example.introduce.HDSD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

import java.util.ArrayList;

public class BangMauActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<BangMau> ds;
    BangMauAdapter adapter;
    BangMauInsert dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bangmaulayout);

        dao = new BangMauInsert(BangMauActivity.this);
        ds = dao.getAll();
        lv = findViewById(R.id.lvMau);
        adapter = new BangMauAdapter(BangMauActivity.this, ds);

        lv.setAdapter(adapter);
    }
    public void ClickBack2(View view){

        Intent intent = new Intent(this, GioiThieuActivity.class);
        this.startActivity(intent);
    }
    public void ClickHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

}
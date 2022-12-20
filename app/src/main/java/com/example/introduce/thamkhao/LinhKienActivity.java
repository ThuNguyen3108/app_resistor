package com.example.introduce.thamkhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

import java.util.ArrayList;

public class LinhKienActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<LinhKien> ds;
    LinhKienAdapter adapter;
    LinhKienInsert dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linhkienlayout);

        dao = new LinhKienInsert(LinhKienActivity.this);
        ds = dao.getAll();
        lv = findViewById(R.id.lvLK);
        adapter = new LinhKienAdapter(LinhKienActivity.this, ds);

        lv.setAdapter(adapter);
    }
    public void ClickBack3(View view){

        Intent intent = new Intent(this, ChonActivity.class);
        this.startActivity(intent);
    }
    public void ClickHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
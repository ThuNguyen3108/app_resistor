package com.example.introduce.thamkhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

import java.util.ArrayList;

public class MachDienActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<MachDien> ds;
    MachDienAdapter adapter;
    MachDienInsert dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machdienlayout);

        dao = new MachDienInsert(MachDienActivity.this);
        ds = dao.getAll();
        lv = findViewById(R.id.lvMD);
        adapter = new MachDienAdapter(MachDienActivity.this, ds);

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
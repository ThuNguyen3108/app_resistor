package com.example.introduce.thamkhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

public class ChonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chonlayout);
    }
    public void linhkien(View view){

        Intent intent = new Intent(this, LinhKienActivity.class);
        this.startActivity(intent);
    }
    public void machdien(View view){

        Intent intent = new Intent(this, MachDienActivity.class);
        this.startActivity(intent);
    }
    public void ClickBack4(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
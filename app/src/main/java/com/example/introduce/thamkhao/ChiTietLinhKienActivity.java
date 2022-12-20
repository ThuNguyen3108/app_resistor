package com.example.introduce.thamkhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

public class ChiTietLinhKienActivity extends AppCompatActivity {

    ImageView img;
    TextView ten, gt, th, ct;
    String getimg, getten, getgt, getth, getct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet_linhkien_layout);

        img = findViewById(R.id.img);
        ten = findViewById(R.id.ten);
        gt = findViewById(R.id.giatri);
        th = findViewById(R.id.thieu);
        ct = findViewById(R.id.chitiet);

        Intent intent = getIntent();
        getimg = intent.getStringExtra("img");
        getten = intent.getStringExtra("ten");
        getgt = intent.getStringExtra("giatri");
        getth = intent.getStringExtra("thieu");
        getct = intent.getStringExtra("chitiet");

        ten.setText(getten);
        gt.setText(getgt);
        th.setText(getth);
        ct.setText(getct);
        int resId = getResources().getIdentifier(getimg, "drawable", getPackageName());
        img.setImageResource(resId);
    }
    public void ClickBack5(View view){

        Intent intent = new Intent(this, LinhKienActivity.class);
        this.startActivity(intent);
    }
    public void ClickHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
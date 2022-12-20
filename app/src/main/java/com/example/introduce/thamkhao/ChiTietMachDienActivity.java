package com.example.introduce.thamkhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

public class ChiTietMachDienActivity extends AppCompatActivity {
    ImageView img;
    TextView ten, th, ct;
    String getimg, getten, getth, getct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet_machdien_layout);

        img = findViewById(R.id.img);
        ten = findViewById(R.id.mdten);
        th = findViewById(R.id.mdthieu);
        ct = findViewById(R.id.mdchitiet);

        Intent intent = getIntent();
        getimg = intent.getStringExtra("img");
        getten = intent.getStringExtra("ten");
        getth = intent.getStringExtra("thieu");
        getct = intent.getStringExtra("chitiet");

        ten.setText(getten);
        th.setText(getth);
        ct.setText(getct);
        int resId = getResources().getIdentifier(getimg, "drawable", getPackageName());
        img.setImageResource(resId);
    }
    public void ClickBack5(View view){

        Intent intent = new Intent(this, MachDienActivity.class);
        this.startActivity(intent);
    }
    public void ClickHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
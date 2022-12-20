package com.example.introduce.HDSD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.introduce.MainActivity;
import com.example.introduce.R;

public class GioiThieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gioithieulayout);
    }
    public void ClickBack1(View view){

        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
    public void ClickContinue1(View view){

        Intent intent = new Intent(this, BangMauActivity.class);
        this.startActivity(intent);
    }
}
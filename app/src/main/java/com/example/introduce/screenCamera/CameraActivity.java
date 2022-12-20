package com.example.introduce.screenCamera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.introduce.R;
import com.example.introduce.databinding.ActivityCameraBinding;

import java.util.List;

public class CameraActivity extends AppCompatActivity {
    ActivityCameraBinding binding;
    private List<Resistor> resistors;
    private int id_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCameraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id_user = getIntent().getIntExtra("user_id",0);
        binding.floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddResistorActivity.class);
            intent.putExtra("user_id",id_user);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        resistors = new databaseHelper(this).getAllResistor(id_user);
        if(resistors.size() > 0){
            binding.tvNoData.setVisibility(View.GONE);
            binding.recyclerView.setVisibility(View.VISIBLE);
            AdapterRecyler adapterRecyler = new AdapterRecyler(this,resistors);
            binding.recyclerView.setAdapter(adapterRecyler);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            binding.tvNoData.setVisibility(View.VISIBLE);
            binding.recyclerView.setVisibility(View.GONE);
        }
    }
}
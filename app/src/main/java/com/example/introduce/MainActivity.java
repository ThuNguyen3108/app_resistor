package com.example.introduce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.introduce.HDSD.GioiThieuActivity;
import com.example.introduce.databinding.ActivityMainBinding;
import com.example.introduce.screenCamera.CameraActivity;
import com.example.introduce.screenDienTro.ResistorColor;
import com.example.introduce.HDSD.GioiThieuActivity;
import com.example.introduce.sreenLoginRegister.Login.Database.UserHelper;
import com.example.introduce.sreenLoginRegister.Login.login_screen;
import com.example.introduce.thamkhao.ChonActivity;
import com.example.introduce.thamkhao.LinhKienActivity;
import com.example.introduce.thamkhao.MachDienActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private String email,username;
    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this, gso);
        if(getIntent().getStringExtra("email") != null){
            email = getIntent().getStringExtra("email");
            binding.button.setVisibility(View.VISIBLE);
            binding.button.setOnClickListener(v -> {
                //logout gg account
                gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {//signout from google account
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {//when logout is complete
                        finish();
                        startActivity(new Intent(getApplicationContext(), login_screen.class));//go to main activity
                    }
                });
            });
        }else{
            username = getIntent().getStringExtra("username");
            binding.button.setVisibility(View.VISIBLE);
            binding.button.setOnClickListener(v -> {
                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username","");
                editor.putString("password","");
                editor.putBoolean("checked",false);
                editor.apply();
                startActivity(new Intent(MainActivity.this,login_screen.class));
            });
        }
        // bien v giong nhu moột hàm rút gọn
        binding.seehuongdan.setOnClickListener(v -> {
            Intent intent = new Intent(this, GioiThieuActivity.class);
            this.startActivity(intent);
        });

        binding.seeResistor.setOnClickListener(v -> {
            Intent intent = new Intent(this, ResistorColor.class);
            this.startActivity(intent);
        });

        binding.seeabout.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChonActivity.class);
            this.startActivity(intent);
        });

        binding.seeCapacitor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CameraActivity.class);
            int id;
            if(email != null){
                id = new UserHelper(this).getUserGGByEmail(email);
            }else{
                id = new UserHelper(this).getUserIdByUsername(username);
            }
            intent.putExtra("user_id",id);
            startActivity(intent);
        });
    }
}
package com.example.introduce.sreenLoginRegister.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.introduce.MainActivity;
import com.example.introduce.databinding.ActivityLoginScreenBinding;
import com.example.introduce.sreenLoginRegister.Login.Database.UserHelper;
import com.example.introduce.sreenLoginRegister.Login.model.User;
import com.example.introduce.sreenLoginRegister.Register.register_screen;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;


public class login_screen extends AppCompatActivity {
    ActivityLoginScreenBinding binding;
    private SharedPreferences sharedPreferences;
    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        binding.tvRegisterGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 1);
            }
        });
        binding.edtPassworldLogin.setTransformationMethod(new PasswordTransformationMethod());
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        binding.edtUsernameLogin.setText(sharedPreferences.getString("username",""));
        binding.edtPassworldLogin.setText(sharedPreferences.getString("password",""));
        binding.checkboxLogin.setChecked(sharedPreferences.getBoolean("checked",false));
        //login->Phone
        binding.tvLoginPhoneLogin.setOnClickListener(v->callLoginScreenPhone());
        //login->Home
        binding.btnLoginLogin.setOnClickListener(v->callLoginScreen());
        //login->Register
        binding.tvRegisterLogin.setOnClickListener(v->callRegisterScreen());
        //login->Forgot
        binding.tvForgotPassLogin.setOnClickListener(v->callForgotScreen());
    }

    private void callForgotScreen() {
        //animation
        binding.loginScreenLogin.animate().alpha(1).setDuration(1000);
        binding.loginScreenLogin.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },500);
    }

    private void callRegisterScreen() {
        //animation
        binding.loginScreenLogin.animate().alpha(1).setDuration(1000);
        binding.loginScreenLogin.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.tvRegisterLogin.setVisibility(View.GONE);
                startActivity(new Intent(login_screen.this, register_screen.class));
                finish();
            }
        },500);
    }

    private void callLoginScreen() {
        if(binding.edtUsernameLogin.getText() == null){
            binding.edtUsernameLogin.setError("User không được trống");
            return;
        }
        if(binding.edtPassworldLogin.getText() == null){
            binding.edtPassworldLogin.setError("Password không được trống");
            return;
        }
        UserHelper userHelper = new UserHelper(login_screen.this);
        User user = new User();
        if(!checkEmail(binding.edtUsernameLogin.getText().toString())){
             user = userHelper.getUser(binding.edtUsernameLogin.getText().toString());
        }
        else{
            user = userHelper.getUserByEmail(binding.edtUsernameLogin.getText().toString());
        }

        if(user.getMatkhau() == null){
            binding.edtUsernameLogin.setError("Tài khoản không tồn tại");
            return;
        }

        else if(!user.getMatkhau().equals(binding.edtPassworldLogin.getText().toString())){
            binding.edtPassworldLogin.setError("Mật khẩu không chính xác!!!");
            return;
        }
        else{
            Toast.makeText(login_screen.this,"Đăng nhập thành công!!!",Toast.LENGTH_SHORT).show();
            if(binding.checkboxLogin.isChecked()){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",binding.edtUsernameLogin.getText().toString());
                editor.putString("password",binding.edtPassworldLogin.getText().toString());
                editor.putBoolean("checked",true);
                editor.apply();
            }
            else{
                // khong lay dc va bi rong se tra ve false
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username","");
                editor.putString("password","");
                editor.putBoolean("checked",false);
                editor.apply();
            }
            Intent intent = new Intent(login_screen.this, MainActivity.class);
            intent.putExtra("username",binding.edtUsernameLogin.getText().toString());
            startActivity(intent);
            finish();
        }


    }

    private boolean checkEmail(String email){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return false;
        return true;
    }

    private void callLoginScreenPhone() {
        //chuyển màn animation
            binding.loginScreenLogin.animate().alpha(1).setDuration(2000);
            binding.loginScreenLogin.postDelayed(new Runnable() {
                @Override
                public void run() {

                    finish();
                }
            },500);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult();//get account info from google
                Intent intent = new Intent(login_screen.this, MainActivity.class);
                intent.putExtra("email", account.getEmail());
                startActivity(intent);
                Log.d("testAPI", "onActivityResult: " + account.getEmail());
            } catch (Exception e) {
                Log.w("testAPI", "Google sign in failed : "+ e.getMessage());
            }
        }
    }

}
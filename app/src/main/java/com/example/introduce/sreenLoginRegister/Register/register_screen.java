package com.example.introduce.sreenLoginRegister.Register;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.introduce.databinding.ActivityRegisterScreenBinding;
import com.example.introduce.sreenLoginRegister.Login.Database.DatabaseUser;
import com.example.introduce.sreenLoginRegister.Login.Database.UserHelper;
import com.example.introduce.sreenLoginRegister.Login.login_screen;
import com.example.introduce.sreenLoginRegister.Login.model.User;


public class register_screen extends AppCompatActivity {
    ActivityRegisterScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//

        //register -> login
        binding.tvRegisterRegister.setOnClickListener(v ->callLogin());

        binding.edtPassworldRegister.setTransformationMethod(new PasswordTransformationMethod());
        binding.edtPassworldConfirmRegister.setTransformationMethod(new PasswordTransformationMethod());
    }

    private void callOTP() {
//        binding.layoutRegister.animate().translationY(2000).setDuration(1000).setStartDelay(300);
//        binding.tvRegisterRegister.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                binding.layoutRegister.setVisibility(View.GONE);
//                startActivity(new Intent(register_screen.this, otp_screen.class));
//                finish();
//            }
//        },500);
        if(binding.edtUsernameRegister.getText() == null){
            binding.edtUsernameRegister.setError("Không được bỏ trống!!!");
            return;
        }
        if(!validateEmail(binding.edtEmailRegister.getText().toString())){
//            binding.edtEmailRegister.setError("Không được bỏ trống!!!");
            return;
        }
        if(binding.edtFullnameRegister.getText() == null){
            binding.edtFullnameRegister.setError("Không được bỏ trống!!!");
            return;
        }
        if(!validatePhone(binding.edtPhoneRegister.getText().toString())){
            return;
        }

        if(binding.edtPassworldRegister.getText() == null){
            binding.edtPassworldRegister.setError("Không được bỏ trống!!!");
            return;
        }
        if(binding.edtPassworldConfirmRegister.getText() == null){
            binding.edtPassworldConfirmRegister.setError("Không được bỏ trống!!!");
            return;
        }
        if(!checkPassword(binding.edtPassworldRegister.getText().toString(),binding.edtPassworldConfirmRegister.getText().toString() )){
            binding.edtPassworldConfirmRegister.setError("Mật khẩu không khớp !!!");
            return;
        }
        if(new UserHelper(this).checkUser(binding.edtUsernameRegister.getText().toString())){
            binding.edtUsernameRegister.setError("Tên đăng nhập đã tồn tại!!!");
            return;
        }
        if(new UserHelper(this).checkUserByEmail(binding.edtEmailRegister.getText().toString())){
            binding.edtEmailRegister.setError("Email đã tồn tại!!!");
            return;
        }
        User user = new User();
        user.setMatkhau(binding.edtPassworldRegister.getText().toString());
        user.setTaikhoan(binding.edtUsernameRegister.getText().toString());
        user.setEmail(binding.edtEmailRegister.getText().toString());
        user.setHoten(binding.edtFullnameRegister.getText().toString());
        user.setSdt(binding.countryCodePickerRegister.getSelectedCountryCodeWithPlus()+binding.edtPhoneRegister.getText().toString());
        UserHelper userHelper = new UserHelper(register_screen.this);
        if(userHelper.InsertUser(user)){
            Toast.makeText(register_screen.this,"Đăng ký thành công!!", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean checkPassword(String password, String confirmpassword){
        if(password.equals(confirmpassword)){
            return true;
        }
        return false;
    }
    private boolean validateEmail(String email){
        if(email.isEmpty()){
            binding.edtEmailRegister.setError("Field can't be empty");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.edtEmailRegister.setError("Please enter a valid email address");
            return false;
        }else{
            binding.edtEmailRegister.setError(null);
            return true;
        }

    }
    private boolean validatePhone(String phone){
        if(phone.isEmpty()){
            binding.edtPhoneRegister.setError("Field can't be empty");
            return false;
        }else if(!Patterns.PHONE.matcher(phone).matches()){
            binding.edtPhoneRegister.setError("Please enter a valid email address");
            return false;
        }else{
            binding.edtPhoneRegister.setError(null);
            return true;
        }
    }


    private void callLogin() {
        binding.layoutRegister.animate().translationY(2000).setDuration(1000).setStartDelay(300);
        binding.tvRegisterRegister.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.layoutRegister.setVisibility(View.GONE);
                startActivity(new Intent(register_screen.this, login_screen.class));
                finish();
            }
        },500);
    }
}
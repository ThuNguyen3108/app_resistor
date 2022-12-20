package com.example.introduce.screenCamera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.introduce.databinding.ActivityAddResistorBinding;

import java.io.ByteArrayOutputStream;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AddResistorActivity extends AppCompatActivity {
    ActivityAddResistorBinding binding;
    private String[] ds = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White"};
    private String[] ds2 = {"None","Gold", "Silver"};
    private double v1, v2, v3, total;
    private int v4,ps3,ps4;
    private String multi;
    private final static int REQUEST_CODE_CAMERA = 101;
    private boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddResistorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Adapter adapter = new Adapter(AddResistorActivity.this, ds);
        binding.spinner1.setAdapter(adapter);
        Adapter adapter2 = new Adapter(AddResistorActivity.this, ds);
        binding.spinner2.setAdapter(adapter2);
        Adapter adapter3 = new Adapter(AddResistorActivity.this, ds);
        binding.spinner3.setAdapter(adapter3);
        Adapter adapter4 = new Adapter(AddResistorActivity.this, ds2);
        binding.spinner4.setAdapter(adapter4);

        binding.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v1 = position;
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v2 = position;
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ps3 = position;
                switch (position) {
                    case 0:
                        multi = "";
                        v3 = 1;
                        break;
                    case 1:
                        v3 = 10;
                        multi = "";
                        break;
                    case 2:
                        v3 = 0.1;
                        multi = "K";
                        break;
                    case 3:

                        v3 = 1;
                        multi = "K";
                        break;
                    case 4:

                        v3 = 10;
                        multi = "K";
                        break;
                    case 5:
                        v3 = 0.1;
                        multi = "M";
                        break;
                    case 6:
                        v3 = 1;
                        multi = "M";
                        break;
                    case 7:

                        v3 = 10;
                        multi = "M";
                        break;
                    case 8:
                        v3 = 0.1;
                        multi = "G";
                        break;
                    case 9:
                        v3 = 1;
                        multi = "G";
                        break;
                }
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ps4 = position;
                switch (position) {
                    case 0:
                        v4 = 0;
                        break;
                    case 1:
                        v4 = 5;
                        break;
                    case 2:
                        v4 = 10;
                        break;
                }
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.imageViewCap.setOnClickListener(v -> {
            CameraIntent();
        });

        binding.btnSave.setOnClickListener(v -> {
            String vach1 = ds[(int) v1];
            String vach2 = ds[(int) v2];
            String vach3 = ds[ps3];
            String vach4 = ds2[ps4];
            String gtri =  binding.textTotal.getText().toString();
            if(!check){
                Toast.makeText(AddResistorActivity.this, "Please take a picture", Toast.LENGTH_SHORT).show();
                return;
            }
            byte[] image = converBitmaptoByte(binding.imageViewCap);
            int user_id = getIntent().getIntExtra("user_id",0);

            Resistor resistor = new Resistor(image,vach1, vach2, vach3, vach4,gtri, user_id);
            if(new databaseHelper(getApplicationContext()).insertResistor(resistor)){
                new SweetAlertDialog(AddResistorActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Success")
                        .setContentText("Add resistor successfully")
                        .setConfirmButton("OK", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                Intent intent = new Intent(AddResistorActivity.this, CameraActivity.class);
                                intent.putExtra("user_id",user_id);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .show();
            }
        });
    }

    public void calculator() {
        total = ((v1 * 10) + v2) * v3;
        binding.textTotal.setText(String.format("%.1f", total) + multi + " ohms   " + Integer.toString(v4) + " %");
    }


    private void askCameraPermission() {
        ActivityCompat.requestPermissions(AddResistorActivity.this, new String[]
                {Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
    }

    private void CameraIntent() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        } else {
            askCameraPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CameraIntent();
            } else {
                Toast.makeText(this, "Required Permission", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                check = true;
                binding.imageViewCap.setImageBitmap((Bitmap) data.getExtras().get("data"));
            }
        }
    }

    private byte[] converBitmaptoByte(ImageView bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap1 = ((BitmapDrawable) bitmap.getDrawable()).getBitmap();
        bitmap1.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
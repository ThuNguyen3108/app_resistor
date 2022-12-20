package com.example.introduce.screenCamera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.introduce.R;
import com.example.introduce.databinding.OneItemCameraBinding;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AdapterRecyler extends RecyclerView.Adapter<AdapterRecyler.ViewHolder> {
    private Context context;
    private List<Resistor> list;

    public AdapterRecyler(Context context, List<Resistor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_item_camera, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Resistor resistor = list.get(position);
        holder.binding.textgtri.setText(resistor.getGtri());
        updateColor(resistor.getVach1(), holder.binding.view1);
        updateColor(resistor.getVach2(), holder.binding.view2);
        updateColor(resistor.getVach3(), holder.binding.view3);
        updateColor(resistor.getVach4(), holder.binding.view4);
        holder.binding.imageviewCamera.setImageBitmap(convertBytetoBitmap(resistor.getImg()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                list.remove(position);
                                new databaseHelper(context).deleteResistor(resistor.getId());
                                notifyDataSetChanged();
                            }
                        })
                        .show();
                return false;
            }
        });
    }

    private Bitmap convertBytetoBitmap(byte[] img) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        return bitmap;
    }

    private void updateColor(String color,View v) {
        switch (color) {
            case "Black":
                v.setBackgroundColor(0xFF000000);
                break;
            case "Brown":
                v.setBackgroundColor(0xFFA52A2A);
                break;
            case "Red":
                v.setBackgroundColor(0xFFFF0000);
                break;
            case "Orange":
                v.setBackgroundColor(0xFFFFA500);
                break;
            case "Yellow":
                v.setBackgroundColor(0xFFFFFF00);
                break;
            case "Green":
                v.setBackgroundColor(0xFF008000);
                break;
            case "Blue":
                v.setBackgroundColor(0xFF0000FF);
                break;
            case "Violet":
                v.setBackgroundColor(0xFFEE82EE);
                break;
            case "Grey":
                v.setBackgroundColor(0xFF808080);
                break;
            case "White":
            case "None":
                v.setBackgroundColor(0xFFFFFFFF);
                break;
            case "Gold":
                v.setBackgroundColor(0xFFFFD700);
                break;
            case "Silver":
                v.setBackgroundColor(0xFFC0C0C0);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        OneItemCameraBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = OneItemCameraBinding.bind(itemView);
        }
    }
}

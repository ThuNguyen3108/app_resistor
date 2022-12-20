package com.example.introduce.screenCamera;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.introduce.R;

public class Adapter extends BaseAdapter {

    Context context;
    String[] ds;

    public Adapter(Context context, String[] ds){
        this.context = context;
        this.ds = ds;
    }

    @Override
    public int getCount() {
        return ds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int j, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item_resistorcolor, null);
        TextView tv = v.findViewById(R.id.textgtri);
            switch (ds[j]){
                case "Black":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFF000000);
                    break;
                case "Brown":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFA52A2A);
                    break;
                case "Red":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFFF0000);
                    break;
                case "Orange":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFFFA500);
                    break;
                case "Yellow":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFFFFF00);
                    break;
                case "Green":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFF008000);
                    break;
                case "Blue":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFF0000FF);
                    break;
                case "Violet":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFEE82EE);
                    break;
                case "Grey":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFF808080);
                    break;
                case "White":
                case "None":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFFFFFFF);
                    break;
                case "Gold":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFDAA520);
                    break;
                case "Silver":
                    tv.setText(ds[j]);
                    tv.setBackgroundColor(0xFFC0C0C0);
                    break;
            }
        return v;
    }
}

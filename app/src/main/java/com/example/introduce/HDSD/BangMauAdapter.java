package com.example.introduce.HDSD;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.introduce.R;

import java.util.ArrayList;

public class BangMauAdapter extends BaseAdapter {
    Context context;
    ArrayList<BangMau> ds;
    BangMau a;
    public BangMauAdapter(Context context, ArrayList<BangMau> ds){
        this.context = context;
        this.ds = ds;
    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return ds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.bangmau_list_item,null);
            holder.vach1 = view.findViewById(R.id.vach1);
            holder.vach2 = view.findViewById(R.id.vach2);
            holder.vach3 = view.findViewById(R.id.vach3);
            holder.vach4 = view.findViewById(R.id.vach4);
            view.setTag(holder);

        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        BangMau bm = ds.get(i);

        String vach1 = bm.getVach1();
        int resId1 = ((Activity)context).getResources().getIdentifier(
                vach1, "drawable", ((Activity)context).getPackageName());
        holder.vach1.setImageResource(resId1);

        String vach2 = bm.getVach2();
        int resId2 = ((Activity)context).getResources().getIdentifier(
                vach2, "drawable", ((Activity)context).getPackageName());
        holder.vach2.setImageResource(resId2);

        String vach3 = bm.getVach3();
        int resId3 = ((Activity)context).getResources().getIdentifier(
                vach3, "drawable", ((Activity)context).getPackageName());
        holder.vach3.setImageResource(resId3);

        String vach4 = bm.getVach4();
        int resId4 = ((Activity)context).getResources().getIdentifier(
                vach4, "drawable", ((Activity)context).getPackageName());
        holder.vach4.setImageResource(resId4);

        return view;
    }

    class  ViewHolder{
        ImageView vach1, vach2, vach3, vach4;


    }
}

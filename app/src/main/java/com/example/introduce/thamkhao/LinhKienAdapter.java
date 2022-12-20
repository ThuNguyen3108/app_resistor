package com.example.introduce.thamkhao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.introduce.R;

import java.util.ArrayList;

public class LinhKienAdapter extends BaseAdapter {
    Context context;
    ArrayList<LinhKien> ds;
    LinhKien a;
    public LinhKienAdapter(Context context, ArrayList<LinhKien> ds){
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
        //  ds = dao.getAll();
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.linhkien_list_item,null);
            holder.mau = view.findViewById(R.id.imageview);
            holder.ten = view.findViewById(R.id.textten);
            holder.giatri = view.findViewById(R.id.textgtri);
            view.setTag(holder);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                   Toast.makeText(context, a.getId(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ChiTietLinhKienActivity.class);
                    // intent.putExtra("img", "Truyen 1");
                    LinhKien lk = ds.get(i);
                    intent.putExtra("img",lk.getImg());
                    intent.putExtra("ten", lk.getTen());
                    intent.putExtra("giatri",lk.getGtri());
                    intent.putExtra("thieu", lk.getTh());
                    intent.putExtra("chitiet", lk.getCtiet());
                    context.startActivity(intent);
                }
            });
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        LinhKien lk = ds.get(i);
        holder.ten.setText(lk.getTen());
        holder.giatri.setText(lk.getGtri());
        String mau = lk.getImg();
        int resId = ((Activity)context).getResources().getIdentifier(
                mau, "drawable", ((Activity)context).getPackageName());
        holder.mau.setImageResource(resId);
        return view;
    }

    class  ViewHolder{
        ImageView mau;
        TextView ten, giatri;


    }
}

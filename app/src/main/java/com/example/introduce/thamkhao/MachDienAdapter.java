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

public class MachDienAdapter extends BaseAdapter{
    Context context;
    ArrayList<MachDien> ds;
    LinhKien a;

    public MachDienAdapter(Context context, ArrayList<MachDien> ds) {
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
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.machdien_list_item, null);
            holder.mau = view.findViewById(R.id.imageview);
            holder.ten = view.findViewById(R.id.txtten);

            view.setTag(holder);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                   Toast.makeText(context, a.getId(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ChiTietMachDienActivity.class);
                    // intent.putExtra("img", "Truyen 1");
                    MachDien md = ds.get(i);
                    intent.putExtra("img",md.getImg());
                    intent.putExtra("ten", md.getTen());
                    intent.putExtra("thieu", md.getTh());
                    intent.putExtra("chitiet", md.getCtiet());
                    context.startActivity(intent);
                }
            });
        } else {
            holder = (MachDienAdapter.ViewHolder) view.getTag();
        }
        MachDien md = ds.get(i);
        holder.ten.setText(md.getTen());
        String mau = md.getImg();
        int resId = ((Activity) context).getResources().getIdentifier(
                mau, "drawable", ((Activity) context).getPackageName());
        holder.mau.setImageResource(resId);
        return view;
    }

    class ViewHolder {
        ImageView mau;
        TextView ten;
    }
}

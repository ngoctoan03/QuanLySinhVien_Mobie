package com.example.quanlysinhvien.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.quanlysinhvien.ListNguoiDungActivity;
import com.example.quanlysinhvien.NguoiDungActivity;
import com.example.quanlysinhvien.NguoiDungDetailActivity;
import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.dao.NguoiDungDAO;
import com.example.quanlysinhvien.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> arrNguoiDung;
    public Activity context;
    public LayoutInflater inflater;
    NguoiDungDAO nguoiDungDAO;

    public NguoiDungAdapter(Activity context, List<NguoiDung> arrayNguoiDung) {
        super();
        this.context = context;
        this.arrNguoiDung = arrayNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoiDungDAO(context);
    }
    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {

        TextView txtName;
        TextView txtLop;
        TextView txtNoiSinh;
        TextView txtPhone;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            holder.txtLop = (TextView) convertView.findViewById(R.id.tvLop);
            holder.txtNoiSinh = (TextView) convertView.findViewById(R.id.tvNoiSinh);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);



            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nguoiDungDAO.deleteNguoiDungByID(arrNguoiDung.get(position).getPhone());
                    arrNguoiDung.remove(position);
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();

        NguoiDung _entry = (NguoiDung) arrNguoiDung.get(position);
        holder.txtName.setText(_entry.getHoten());
        holder.txtLop.setText(_entry.getLop());
        holder.txtNoiSinh.setText(_entry.getNoisinh());
        holder.txtPhone.setText(_entry.getPhone());


        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<NguoiDung> items){
        this.arrNguoiDung = items;
        notifyDataSetChanged();

    }

}


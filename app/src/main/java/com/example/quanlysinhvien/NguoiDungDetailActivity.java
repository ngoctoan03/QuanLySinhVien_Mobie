package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.dao.NguoiDungDAO;
import com.example.quanlysinhvien.model.NguoiDung;


public class NguoiDungDetailActivity extends AppCompatActivity {
    EditText edhoten, edlop, ednoisinh, edphone;
    NguoiDungDAO nguoiDungDAO;
    String  hoten, lop, noisinh, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CHI TIẾT SINH VIÊN");
        setContentView(R.layout.activity_nguoi_dung_detail);
        edhoten = (EditText) findViewById(R.id.edHoTen);
        edlop = (EditText) findViewById(R.id.edLop);
        ednoisinh = (EditText) findViewById(R.id.edNoiSinh);
        edphone = (EditText) findViewById(R.id.edPhone);

        nguoiDungDAO = new NguoiDungDAO(this);
        Intent in = getIntent();
        Bundle b = in.getExtras();

        hoten = b.getString("hoten");
        lop = b.getString("lop");
        noisinh = b.getString("noisinh");
        phone = b.getString("phone");

        edhoten.setText(hoten);
        edlop.setText(lop);
        ednoisinh.setText(noisinh);
        edphone.setText(phone);
    }
    public void updateUser(View view){
        if(nguoiDungDAO.updateInfoNguoiDung(edhoten.getText().toString(), edlop.getText().toString(),
                ednoisinh.getText().toString(), edphone.getText().toString()) > 0)
            {
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            }
                Intent intent = new Intent(NguoiDungDetailActivity.this,ListNguoiDungActivity.class);
                startActivity(intent);
    }


    public void Huy(View view){

        finish(

        );
    }
}

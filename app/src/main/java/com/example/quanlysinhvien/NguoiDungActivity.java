package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.dao.NguoiDungDAO;
import com.example.quanlysinhvien.model.NguoiDung;


public class NguoiDungActivity extends AppCompatActivity {
    Button btnThemNguoiDung, btnhuy;
    NguoiDungDAO nguoiDungDAO;
    EditText edhoten, edlop, ednoisinh, edphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("INSERT STUDENT");
        btnThemNguoiDung = (Button) findViewById(R.id.btnAddUser);
        edhoten = (EditText) findViewById(R.id.edhoten);
        edlop = (EditText) findViewById(R.id.edlop);
        ednoisinh = (EditText) findViewById(R.id.edNoiSinh);
        edphone = (EditText) findViewById(R.id.edPhone);
        btnhuy = (Button) findViewById(R.id.btnCancelUser);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NguoiDungActivity.this, ListNguoiDungActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showUsers(View view) {
        finish();
    }

    public void addUser(View view) {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung user = new NguoiDung(edhoten.getText().toString(), edlop.getText().toString(),
                ednoisinh.getText().toString(), edphone.getText().toString());
        try {
                if (nguoiDungDAO.inserNguoiDung(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NguoiDungActivity.this, ListNguoiDungActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

}

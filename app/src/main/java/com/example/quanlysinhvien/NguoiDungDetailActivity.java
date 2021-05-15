package com.example.quanlysinhvien;

import android.app.Dialog;
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


public class NguoiDungDetailActivity extends AppCompatActivity {
    EditText edhoten, edlop, ednoisinh, edphone;
    NguoiDungDAO nguoiDungDAO;
    String  hoten, lop, noisinh, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DETAILS STUDENT");
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
                ednoisinh.getText().toString(), edphone.getText().toString()) > 0){
//            Intent intent = new Intent(NguoiDungDetailActivity.this,ListNguoiDungActivity.class);
//            startActivity(intent);
//                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                DiaLog();
            }
    }

    public void Huy(View view){
        finish();
    }

    private void DiaLog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dia_log_detail);
        dialog.setCanceledOnTouchOutside(false);

        Button btnyess = (Button) dialog.findViewById(R.id.btnyes);
        Button btnnoo = (Button) dialog.findViewById(R.id.btnno);

        btnyess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NguoiDungDetailActivity.this,ListNguoiDungActivity.class);
                startActivity(intent);
                Toast.makeText(NguoiDungDetailActivity.this.getApplicationContext(), "successful fix", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        btnnoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    dialog.cancel();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}

package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.quanlysinhvien.adapter.NguoiDungAdapter;
import com.example.quanlysinhvien.dao.NguoiDungDAO;
import com.example.quanlysinhvien.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
    ListView lvNguoiDung;
    NguoiDungAdapter adapter = null;
    NguoiDungDAO nguoiDungDAO;
    Button btnthem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("LIST STUDENT ");
        setContentView(R.layout.activity_list_nguoi_dung);
        lvNguoiDung = (ListView) findViewById(R.id.lvNguoiDung);
        btnthem = (Button) findViewById(R.id.btnthem);

        nguoiDungDAO = new NguoiDungDAO(ListNguoiDungActivity.this);
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();

        adapter = new NguoiDungAdapter(this, dsNguoiDung);
        lvNguoiDung.setAdapter(adapter);

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListNguoiDungActivity.this,NguoiDungActivity.class);
                startActivity(intent);
            }
        });

        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListNguoiDungActivity.this,NguoiDungDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("hoten", dsNguoiDung.get(position).getHoten());
                b.putString("lop", dsNguoiDung.get(position).getLop());
                b.putString("noisinh", dsNguoiDung.get(position).getNoisinh());
                b.putString("phone", dsNguoiDung.get(position).getPhone());
                intent.putExtras(b);
                startActivity(intent);

            }
        });
        lvNguoiDung.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsNguoiDung.clear();
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter.changeDataset(nguoiDungDAO.getAllNguoiDung());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.add:
                intent = new Intent(ListNguoiDungActivity.this,NguoiDungActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

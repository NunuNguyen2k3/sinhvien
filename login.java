package com.example.nguyenducthang2_21103100783;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    private EditText etTenDn, etMatkhau;
    private Button btnDn, btnThoat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);


        etTenDn = findViewById(R.id.etTenDn);
        etMatkhau = findViewById(R.id.etMatkhau); // Sửa lại ID từ etMatkau thành etMatkhau
        btnDn = findViewById(R.id.btnDn);
        btnThoat = findViewById(R.id.btnThoat);

        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = etTenDn.getText().toString();
                String matkhau = etMatkhau.getText().toString();

                // Kiểm tra tên đăng nhập và mật khẩu
                if (ten.equals("cnttk15hn") && matkhau.equals("cnttk15")) {
                    // Đúng, chuyển sang màn hình chính
                    Intent intent = new Intent(login.this, thongtin.class); // Sửa tên lớp thành MainActivity
                    startActivity(intent);
                } else {
                    // Sai, hiển thị thông báo
                    Toast.makeText(login.this, "Tên đăng nhập hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
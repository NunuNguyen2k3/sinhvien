package com.example.nguyenducthang2_21103100783;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class thongtin extends AppCompatActivity {
    private EditText edten, edmsv, edtuoi;
    private RadioButton rbnam, rbnu;
    private CheckBox cbbongda, cbGame;
    private TextView tvResult;
    private Button btnLuu, btnThoat, btnTiep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtin);

        // Ánh xạ các view từ XML
        edten = findViewById(R.id.edten);
        edmsv = findViewById(R.id.edmsv);
        edtuoi = findViewById(R.id.edtuoi);
        rbnam = findViewById(R.id.rdbtn_nam);
        rbnu = findViewById(R.id.rdbtn_nu);
        cbbongda = findViewById(R.id.cbdabong);
        cbGame = findViewById(R.id.cbGame);
        tvResult = findViewById(R.id.tvResult);
        btnLuu = findViewById(R.id.btnLuu);
        btnThoat = findViewById(R.id.btnThoat);
        btnTiep = findViewById(R.id.btnTiep);

        // Đặt sự kiện cho các nút
        btnLuu.setOnClickListener(view -> saveData());

        btnThoat.setOnClickListener(view -> finish());

        btnTiep.setOnClickListener(view -> {
            Intent intent = new Intent(thongtin.this, listhienthi.class);
            startActivity(intent);
        });

        // Đặt padding cho view khi có các hệ thống thanh
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveData() {
        // Lấy giá trị từ các EditText
        String ten = edten.getText().toString();
        String msv = edmsv.getText().toString();
        String tuoi = edtuoi.getText().toString();
        // Lấy giá trị từ các RadioButton
        String gioitinh = rbnam.isChecked() ? "Nam" : "Nữ";
        StringBuilder hobbies = new StringBuilder();

        // Lấy giá trị từ các CheckBox
        if (cbbongda.isChecked()) {
            hobbies.append("Đá bóng ");
        }
        if (cbGame.isChecked()) {
            hobbies.append("Chơi game ");
        }

        // Kiểm tra nếu bất kỳ trường nào trống
        if (ten.isEmpty() || msv.isEmpty() || tuoi.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị kết quả trên TextView
        String result = "Tên: " + ten + "\nMSSV: " + msv + "\nTuổi: " + tuoi + "\nGiới tính: " + gioitinh + "\nSở thích: " + hobbies.toString();
        tvResult.setText(result);
    }
}

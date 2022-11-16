package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    public final static String EXTRA_NUMBER = "com.example.myapplication.NUMBER";
    public final static int TEXT_REQUEST = 3;
    TextView textView_response;
    Intent check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = new Intent(this, second.class);
        // pass data
        check.setData(Uri.parse("tao tên hoàng t đến từ màn 1 tao là data"));
        // pass extra theo cách bình thường
        check.putExtra(EXTRA_MESSAGE, "this is my message");
        // pass data sử dụng bundle (là map đc tối ưu cho android)
        Bundle extras = new Bundle();
        extras.putString(EXTRA_MESSAGE, " this is my message  2 ");
        extras.putInt(EXTRA_NUMBER, 100);
        check.putExtras(extras);    // khi put bằng bundle Extra thêm s thành Extras -> putExtras
        check.putExtras(extras);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(check, TEXT_REQUEST);  // khi muốn khởi chạy màn khác và nhận data từ màn đó gửi về
                // startActivity(check);                      // khi chỉ muốn khởi chạy màn 2
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView_response = (TextView) findViewById(R.id.textView3);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                String reply = data.getStringExtra(second.EXTRA_RETURN_MEESAGE);
                textView_response.setText(reply);
            }
        }
    }
}

/*
1. cách để khởi chạy 1 activity khác (màn 1 mở màn 2 )
    b1. tạo activity, khai báo trong manifest
    b2. trong màn 1 khởi tạo 1 Intent tên tùy ý ( ko được khởi tạo trong 1 phương thức )
        tạo const

* */
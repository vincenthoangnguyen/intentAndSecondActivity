package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class second extends AppCompatActivity {
    Intent intent;
    Intent returnIntent;
    TextView textView1;
    TextView textView2;

    public final static String EXTRA_RETURN_MEESAGE = "com.examole.myapplication.RETURNMESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        intent = getIntent();

        // get uri từ data
        Uri uri = intent.getData();

        // get string from way 1
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // get string from bundle

        Bundle extras2 = intent.getExtras();
        String message_bundle = (String) extras2.get(MainActivity.EXTRA_MESSAGE);
        Integer number =(Integer) extras2.get(MainActivity.EXTRA_NUMBER);
        String string_number = number.toString();

        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(uri.toString());
        textView2.setText(string_number);

    }
    public void onClick(View view) {
        // return intent
        returnIntent = new Intent();
        String mMessage = "massage return";
        returnIntent.putExtra(EXTRA_RETURN_MEESAGE, mMessage);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
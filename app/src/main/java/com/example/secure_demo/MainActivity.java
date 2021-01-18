package com.example.secure_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.secure_demo.security.DecryptUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {
    private Button btn_str;
    private Button btn_txt;
    private TextView contentTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"f91e188d656dcbaaeb6ba84f46b4f0e6");
        btn_str = (Button)findViewById(R.id.btn_str);
        btn_str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StrActivity.class);
                startActivity(intent);
            }
        });
        btn_txt = (Button)findViewById(R.id.btn_txt);
        btn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TxtActivity.class);
                startActivity(intent);
            }
        });
        //contentTv = (TextView)findViewById(R.id.bt1_text);
        //inputData();
    }
    /*
    private void inputData() {
        InputStream in = DecryptUtil.onObtainInputStream(this);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            contentTv.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

}
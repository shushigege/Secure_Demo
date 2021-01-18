package com.example.secure_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.secure_demo.bmob.AES;
import com.example.secure_demo.bmob.MD5;
import com.example.secure_demo.bmob.RSA;
import com.example.secure_demo.bmob.ThreeDE;
import com.example.secure_demo.util.AesUtil;
import com.example.secure_demo.util.Des3Util;
import com.example.secure_demo.util.MD5Util;
import com.example.secure_demo.util.RSAUtil;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class StrActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "StrActivity";
    private EditText et_raw;
    private TextView tv_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str);
        et_raw = (EditText) findViewById(R.id.et_raw);
        tv_des = (TextView) findViewById(R.id.tv_des);
        findViewById(R.id.btn_md5).setOnClickListener(this);
        findViewById(R.id.btn_rsa).setOnClickListener(this);
        findViewById(R.id.btn_aes).setOnClickListener(this);
        findViewById(R.id.btn_3des).setOnClickListener(this);
        Bmob.initialize(this,"f91e188d656dcbaaeb6ba84f46b4f0e6");
    }
    @Override
    public void onClick(View v) {
        String raw = et_raw.getText().toString();
        MD5 md5 = new MD5();
        RSA rsa = new RSA();
        AES aes = new AES();
        ThreeDE threeDE = new ThreeDE();
    //md5.getMd5before(raw);
        if (raw == null || raw.length() <= 0) {
            Toast.makeText(this, "请输入待加密字符串", Toast.LENGTH_LONG).show();
            return;
        }
/**
 * MD5按钮算法加密
 * */
        if (v.getId() == R.id.btn_md5) {
            String enStr = MD5Util.encrypBy(raw);
            tv_des.setText("MD5的加密结果是:" + enStr);
            md5.getMd5before(raw);
            md5.setMd5before(raw);
            md5.getMd5after(enStr);
            md5.setMd5after(enStr);
            md5.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                   if (e==null){
                      Toast.makeText(getApplication(),"添加数据成功"+s,Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(getApplication(),"创建数据失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                   }
                }
            });

            /**
             * RSA按钮加密解密
             *
             *
             *
            * */
        } else if (v.getId() == R.id.btn_rsa) {
            String enStr = RSAUtil.encodeRSA(null, raw);
            tv_des.setText("RSA加密结果是:" + enStr);
            rsa.getRsabefore(raw);
            rsa.setRsabefore(raw);
            rsa.getRsaafter(enStr);
            rsa.setRsaafter(enStr);
            rsa.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e==null){
                        Toast.makeText(getApplication(),"添加数据成功"+s,Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplication(),"创建数据失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
            /**
             *
             *AES按钮算法解密
             *
             * */
        } else if (v.getId() == R.id.btn_aes) {
            try {
                String seed = "a";
                String enStr = AesUtil.encrypt(seed, raw);
                String deStr = AesUtil.decrypt(seed, enStr);
                String desc = String.format("AES加密结果是:%s\nAES解密结果是:%s", enStr, deStr);
                tv_des.setText(desc);
                aes.getAesbefore(raw);
                aes.setAesbefore(raw);
                aes.getAesafter(enStr);
                aes.setAesafter(enStr);
                aes.getSolvedaes(deStr);
                aes.setSolvedaes(deStr);
                aes.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e==null){
                            Toast.makeText(getApplication(),"添加数据成功"+s,Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplication(),"创建数据失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                tv_des.setText("AES加密/解密失败");
                aes.getAesbefore(raw);
                aes.setAesbefore(raw);
                aes.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e==null){
                            Toast.makeText(getApplication(),"添加数据成功"+s,Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplication(),"创建数据失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //aes.setAesafter("");
            }
/**
 *
 * 3DE加密解密
 *
* */
        } else if (v.getId() == R.id.btn_3des) {
            String key = "a";
            String enStr = Des3Util.encrypt(key, raw);
            String deStr = Des3Util.decrypt(key, enStr);
            String desc = String.format("3DES加密结果是:%s\n3DES解密结果是:%s", enStr, new String(deStr));
            tv_des.setText(desc);
            threeDE.get3DEbefore(raw);
            threeDE.set3DEbefore(raw);
            threeDE.get3DEafter(desc);
            threeDE.set3DEafter(desc);
            threeDE.getSolvedString(deStr);
            threeDE.setSolvedString(deStr);
            threeDE.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e==null){
                        Toast.makeText(getApplication(),"添加数据成功"+s,Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplication(),"创建数据失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }



}
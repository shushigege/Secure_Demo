package com.example.secure_demo.bmob;

import cn.bmob.v3.BmobObject;

public class ThreeDE extends BmobObject {
    private String threeDEbefore;//要加密的字符串
    private String threeDEafter;//加密完的字符串
    private String solvedString;//解密后的字符串

    public String get3DEbefore(String threeDEbefore){
        return threeDEbefore;
    }

    public void  set3DEbefore(String threeDEbefore){
        this.threeDEbefore = threeDEbefore;
    }

    public String get3DEafter(String threeDEafter){
        return threeDEafter;
    }

    public void set3DEafter(String threeDEafter){
        this.threeDEafter = threeDEafter;
    }

    public String getSolvedString(String solvedString){
        return  solvedString;
    }

    public void setSolvedString(String solvedString){
        this.solvedString = solvedString;
    }
}

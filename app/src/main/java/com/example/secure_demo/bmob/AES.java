package com.example.secure_demo.bmob;

import cn.bmob.v3.BmobObject;

public class AES extends BmobObject {
    private String aesbefore;//要加密的字符串
    private String aesafter;//加密完的字符串
    private String solvedaes;

    public String getAesbefore(String aesbefore){
        return aesbefore;
    }

    public void  setAesbefore(String aesbefore){
        this.aesbefore = aesbefore;
    }

    public String getAesafter(String aesafter){
        return aesafter;
    }

    public void setAesafter(String aesafter){
        this.aesafter = aesafter;
    }

    public String getSolvedaes(String solvedaes){
        return solvedaes;
    }

    public void setSolvedaes(String solvedaes){
        this.solvedaes = solvedaes;
    }
}

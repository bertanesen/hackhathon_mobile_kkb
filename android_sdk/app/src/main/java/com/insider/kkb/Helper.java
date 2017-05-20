package com.insider.kkb;

import android.app.Activity;
import android.provider.Settings;

import java.util.ArrayList;

/**
 * Created by ip on 20-May-17.
 */

public class Helper {
    public  Activity currenActivity =null ;
    public static int NOW = 0;
    public static int ONE_DAY = 24;
    public static int HALF_DAY = 0;
    String productId =  null;
    String udid = null;
    int showTypeDefault = 0;

    public  void setUdid(String deviceId) {
        udid = deviceId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public  void setAndroidId(){
        String android_id = Settings.Secure.getString(currenActivity.getContentResolver(), Settings.Secure.ANDROID_ID);
        setUdid(android_id);
    }
}

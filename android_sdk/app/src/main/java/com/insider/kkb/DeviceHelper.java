package com.insider.kkb;

import android.provider.Settings.Secure;

public class DeviceHelper{
    Type type = new Type();

    public  void setAndroidId(){
        String android_id = Secure.getString(type.act.getContentResolver(), Secure.ANDROID_ID);
        type.setUdid(android_id);
    }




}

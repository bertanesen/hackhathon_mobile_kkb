package com.insider.kkb;

import android.provider.Settings.Secure;
import static java.security.AccessController.getContext;

/**
 * Created by ip on 20-May-17.
 */

public class DeviceHelper extends Insider{
    Type type = new Type();

    public  void setAndroidId(){
        String android_id = Secure.getString(act.getContentResolver(), Secure.ANDROID_ID);
        type.setUdid(android_id);

    }




}

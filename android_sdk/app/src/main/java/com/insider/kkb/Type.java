package com.insider.kkb;

import android.app.Activity;

/**
 * Created by ip on 20-May-17.
 */

public  class Type {
    public static  Activity act ;
    public static int NOW = 0;
    public static int ONE_DAY = 24;
    public static int HALF_DAY = 0;
    String product_id =  null;
    String  udid = null;

    public  void setUdid(String deviceId) {
        udid = deviceId;
    }
    public void setProductId(String productId) {
        this.product_id = productId;
    }


}

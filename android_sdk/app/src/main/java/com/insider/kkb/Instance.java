package com.insider.kkb;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ip on 20-May-17.
 */

public  class  Instance extends Insider {
    private Type type = new Type();
    private DeviceHelper dhelp = new DeviceHelper();

    public  void kkbInit(Activity activity ,String productId , int showType){
        type.act = activity;
        dhelp.setAndroidId();
        type.setProductId(productId);

        // {udid = type.getUdid , productId = type.getProductId }

    }

    public JSONObject makeJsonData(String udid, String productId) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("udid", udid);
        json.put("productId", productId);
        return json;
    }


}

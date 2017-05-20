package com.insider.kkb;

import android.app.Activity;
import android.widget.Toast;

import org.json.JSONException;



/**
 * Created by ip on 20-May-17.
 */

public class InsiderHack  extends Helper {
    Insider insider = new Insider();
    private long startTime;
    public void kkbInit(Activity activity , String productId , int showType) throws JSONException {
        try {
            currenActivity = activity;
            setAndroidId();
            setProductId(productId);
            showTypeDefault = showType;
            insider.sendPost(insider.makeJsonData(udid,productId,showTypeDefault,0),"/kkb/set_data");
            getData(showType);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private void  getData(int showType) throws JSONException {
       showData(insider.sendPost(insider.makeJsonData(udid,productId,showType,0),"/kkb/get_data"));
    }

    private void showData(String result){
        Toast.makeText(currenActivity,result,Toast.LENGTH_LONG).show();

    }
    public void kkbStop(){
        try {
            Long session_duration = System.currentTimeMillis() - startTime;
            insider.sendPost(insider.makeJsonData(udid,productId,showTypeDefault,session_duration),"/kkb/update_data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

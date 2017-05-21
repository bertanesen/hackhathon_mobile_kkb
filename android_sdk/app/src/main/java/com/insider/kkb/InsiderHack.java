package com.insider.kkb;

import android.app.Activity;
import android.widget.Toast;
import org.json.JSONException;
import java.io.UnsupportedEncodingException;


/**
 * Created by ip on 20-May-17.
 */

public class InsiderHack  extends Helper {

    public final static InsiderHack insdr = new InsiderHack();
    private InsiderHack() {
    }
    private long startTime;
    Insider insider = new Insider();

    public void kkbInit(Activity activity , String productId , int showType) throws JSONException {
        try {
            startTime = System.currentTimeMillis();
            currenActivity = activity;
            setAndroidId();
            setProductId(productId);
            showTypeDefault = showType;
            insider.BackgroundSender(insider.makeJsonData(udid,productId,showType,0),"/kkb/set_data");
            getData(showType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showData(String result){
        if(result != "0"){
            Toast.makeText(currenActivity,"Şu anda bu ürüne " + result + " kişi bakıyor.", Toast.LENGTH_LONG).show();
        }
    }
    private void  getData(int showType) throws JSONException, UnsupportedEncodingException {

        insider.BackgroundSender(insider.makeJsonData(udid,productId,showType,0),"/kkb/get_data");
    }

    public void kkbStop(){
        try {
            Long session_duration = (System.currentTimeMillis() - startTime)/1000;
            insider.BackgroundSender(insider.makeJsonData(udid,productId,showTypeDefault,session_duration),"/kkb/update_data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

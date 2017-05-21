package com.insider.kkb;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

import static com.insider.kkb.InsiderHack.insdr;


/**
 * Created by ip on 20-May-17.
 */

public class Insider extends Helper{

    public void BackgroundSender(JSONObject params, String linkParam) throws UnsupportedEncodingException {
        final JSONObject requestParams = params;
        String url = "http://c44e795d.ngrok.io" + linkParam;
        AsyncHttpClient client = new AsyncHttpClient();
        StringEntity entity = new StringEntity(requestParams.toString());
        System.out.println(params);
        client.post(currenActivity, url, entity, "application/json", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                if (statusCode ==200){
                    try {
                        System.out.println(requestParams);
                        System.out.println(responseString);
                        JSONObject response = new JSONObject(responseString);
                         String count = response.get("count").toString();
                        if (!count.equals("0")){
                           insdr.showData(count);
                       }
                    }catch (Exception e){e.printStackTrace();}
            }
        }});

    }

    public JSONObject makeJsonData(String udid,String production_id,int showType,long sessionDuration  ) {
        JSONObject json = new JSONObject();
        try {
            json.put("udid",udid);
            json.put("product_id",production_id);
            json.put("show_type",showType);
            json.put("session_duration",sessionDuration);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

}

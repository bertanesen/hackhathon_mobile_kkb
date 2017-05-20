package com.insider.kkb;

import android.util.Log;




import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by ip on 20-May-17.
 */

public class Insider extends Helper{

    public static String sendPost(JSONObject paramaters,String urlParamter){
        InputStream inputStream = null;
        String result = "";
        String url = "http://9ee6fdf5.ngrok.io" + urlParamter;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                String json = "";
                json = paramaters.toString();
                StringEntity se = new StringEntity(json);
                httpPost.setEntity(se);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");
                HttpResponse httpResponse = httpclient.execute(httpPost);
                inputStream = httpResponse.getEntity().getContent();
                if(inputStream != null)
                    result = convertInputStreamToString(inputStream);
                else
                    result = "Did not work!";

            } catch (Exception e) {
                e.printStackTrace();
            }
         return result;

    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }





    // Map<String, String> dictionary = new HashMap<String, String>();

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

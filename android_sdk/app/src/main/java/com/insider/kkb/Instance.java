package com.insider.kkb;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public  class  Instance extends Type {
    public long startTime, session_duration;
    private Type type = new Type();
    private DeviceHelper dhelp = new DeviceHelper();
    Insider insider = new Insider();
    public void kkbInit(Activity activity ,String productId , int showType){
        try {
            type.act = activity;
            dhelp.setAndroidId();
            type.setProductId(productId);
            startTime = System.currentTimeMillis();
            ArrayList requestList = new ArrayList();
            requestList.add(udid);
            requestList.add(product_id);
            JSONObject jsonToSend = makeJsonData(requestList);
            insider.sendPost(jsonToSend,"/kkb/set_data");
            getData();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void kkbStop(){
        try {
            Long session_duration = System.currentTimeMillis() - startTime;
            ArrayList requestList = new ArrayList();
            requestList.add(udid);
            requestList.add(product_id);
            requestList.add(session_duration);
            JSONObject jsonToSend = makeJsonData(requestList);
            insider.sendPost(jsonToSend,"/kkb/update_data");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void  getData() throws JSONException {
        ArrayList requestList = new ArrayList();
        requestList.add(product_id);
        JSONObject jsonToSend = makeJsonData(requestList);
        showData(insider.sendPost(jsonToSend,"/kkb/get_data"));

    }
    public JSONObject makeJsonData(ArrayList valueArray ) throws JSONException {
        JSONObject json = new JSONObject();
        int size = valueArray.size();
        switch (size){
            case 1:
                json.put("product_id",valueArray.get(0));
                break;
            case 2:
                json.put("udid",valueArray.get(0));
                json.put("product_id",valueArray.get(1));
                break;
            case 3:
                json.put("udid",valueArray.get(0));
                json.put("product_id",valueArray.get(1));
                json.put("session_duration",String.valueOf(valueArray.get(2)));
                break;
            default:
        }
        return json;
    }
    private void showData(String result){
        Toast.makeText(act,result,Toast.LENGTH_LONG).show();
    }

}

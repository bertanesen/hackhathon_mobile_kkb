package com.insider.kkb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import static com.insider.kkb.InsiderHack.insdr;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            insdr.kkbInit(this,"qsadqwdsa",InsiderHack.ONE_DAY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        insdr.kkbStop();

    }
}

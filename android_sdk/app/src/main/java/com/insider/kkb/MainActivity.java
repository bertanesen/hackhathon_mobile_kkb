package com.insider.kkb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Insider insider = new Insider();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        insider.kkbInit(this,"B342424",insider.NOW);
    }

    @Override
    protected void onStop() {
        super.onStop();
        insider.kkbStop();
    }
}

package com.hedo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    String tag = "TesteLifecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i(tag, "Main2Activity.onCreate");
    }
}

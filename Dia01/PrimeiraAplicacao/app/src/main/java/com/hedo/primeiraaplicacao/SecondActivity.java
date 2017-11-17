package com.hedo.primeiraaplicacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    String tag = "TesteLifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(tag, "SecondActivity.onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "SecondActivity.onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "SecondActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "SecondActivity.onDestroy");
    }
}

package com.hedo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String tag = "TesteLifecycle";

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                button.setText("Texto Diferente");
            }
        });
        Log.i(tag, "MainActivity.onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "MainActivity.onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "MainActivity.onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "MainActivity.onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "MainActivity.onRestart");
    }
}

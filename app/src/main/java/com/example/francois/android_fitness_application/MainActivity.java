package com.example.francois.android_fitness_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button3:
                Intent i = new Intent(this, OptionsActivity.class);
                startActivityForResult(i, 1);
                break;

    }
}
}

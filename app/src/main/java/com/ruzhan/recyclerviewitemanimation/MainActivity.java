package com.ruzhan.recyclerviewitemanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }


    public void slide01(View view) {
        Intent intent = new Intent(this, OneSlideActivity.class);
        startActivity(intent);
    }

    public void slide02(View view) {
        Intent intent = new Intent(this, TwoSlideActivity.class);
        startActivity(intent);
    }
}

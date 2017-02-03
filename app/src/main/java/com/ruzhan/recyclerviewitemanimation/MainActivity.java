package com.ruzhan.recyclerviewitemanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{

  @Override protected void onCreate(Bundle savedInstanceState) {
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

package com.ruzhan.recyclerviewitemanimation

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }


    fun slide01(view: View) {
        val intent = Intent(this, OneSlideActivity::class.java)
        startActivity(intent)
    }

    fun slide02(view: View) {
        val intent = Intent(this, TwoSlideActivity::class.java)
        startActivity(intent)
    }
}

package com.ruzhan.recyclerviewitemanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruzhan.recyclerviewitemanimation.adapter.OneSlideAdapter
import kotlinx.android.synthetic.main.one_slide_activity.*

class OneSlideActivity : AppCompatActivity() {

    companion object {
        private const val OPEN = "OPEN"
        private const val CLOSE = "CLOSE"
    }

    private var oneSlideAdapter = OneSlideAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_slide_activity)
        initData()
        initListener()
    }

    private fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = oneSlideAdapter
    }

    private fun initListener() {
        rightTv.setOnClickListener {
            editItems()
        }
    }

    private fun editItems() {
        if (CLOSE == rightTv.text.toString()) {
            rightTv.text = OPEN
            oneSlideAdapter.slideOpen()
        } else if (OPEN == rightTv.text.toString()) {
            rightTv.text = CLOSE
            oneSlideAdapter.slideClose()
        }
    }
}

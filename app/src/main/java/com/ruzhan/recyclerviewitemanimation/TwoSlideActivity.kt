package com.ruzhan.recyclerviewitemanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruzhan.recyclerviewitemanimation.adapter.TwoSlideAdapter
import kotlinx.android.synthetic.main.one_slide_activity.*


class TwoSlideActivity : AppCompatActivity() {

    companion object {
        private const val OPEN = "OPEN"
        private const val CLOSE = "CLOSE"
    }

    private val twoSlideAdapter = TwoSlideAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_slide_activity)
        initData()
        initListener()
    }

    private fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = twoSlideAdapter
    }

    private fun initListener() {
        rightTv.setOnClickListener {
            editItems()
        }
    }

    private fun editItems() {
        if (CLOSE == rightTv.text.toString()) {
            rightTv.text = OPEN
            twoSlideAdapter.slideOpen()
        } else if (OPEN == rightTv.text.toString()) {
            rightTv.text = CLOSE
            twoSlideAdapter.slideClose()
        }
    }
}

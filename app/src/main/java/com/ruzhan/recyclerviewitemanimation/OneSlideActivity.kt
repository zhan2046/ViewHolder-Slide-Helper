package com.ruzhan.recyclerviewitemanimation

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ruzhan.recyclerviewitemanimation.adapter.OneSlideAdapter

import java.util.ArrayList

class OneSlideActivity : AppCompatActivity(), View.OnClickListener {

    private var mRecyclerView: RecyclerView? = null
    private var mOneSlideAdapter: OneSlideAdapter? = null
    private var mRightTV: TextView? = null

    private var mData: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_slide_activity)

        addTestData()

        initView()
        initData()
        initListener()
    }

    private fun addTestData() {
        mData = ArrayList()
        for (x in 0..65) {
            mData!!.add("" + x)
        }
    }

    private fun initData() {
        mOneSlideAdapter = OneSlideAdapter()
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.adapter = mOneSlideAdapter
        mOneSlideAdapter!!.setData(mData!!)
    }

    private fun initListener() {
        mRightTV!!.setOnClickListener(this)
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.rcv_root)
        mRightTV = findViewById(R.id.right_tv)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.right_tv -> editItems()
        }
    }

    private fun editItems() {
        if ("CLOSE" == mRightTV!!.text.toString()) {
            mRightTV!!.text = "OPEN"
            mOneSlideAdapter!!.slideOpen()
        } else if ("OPEN" == mRightTV!!.text.toString()) {
            mRightTV!!.text = "CLOSE"
            mOneSlideAdapter!!.slideClose()
        }
    }
}

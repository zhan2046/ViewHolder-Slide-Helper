package com.ruzhan.recyclerviewitemanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ruzhan.recyclerviewitemanimation.adapter.TwoSlideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhan on 2017/2/3.
 */

public class TwoSlideActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private TwoSlideAdapter mTwoSlideAdapter;
    private TextView mRightTV;

    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_slide_activity);

        addTestData();

        initView();
        initData();
        initListener();
    }

    private void addTestData() {
        mData = new ArrayList<>();
        for (int x = 0; x < 66; x++) {
            mData.add("" + x);
        }
    }

    private void initData() {
        mTwoSlideAdapter = new TwoSlideAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTwoSlideAdapter);
        mTwoSlideAdapter.setData(mData);
    }

    private void initListener() {
        mRightTV.setOnClickListener(this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_root);
        mRightTV = (TextView) findViewById(R.id.right_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.right_tv:
                editItems();
                break;
        }
    }

    private void editItems() {
        if ("CLOSE".equals(mRightTV.getText().toString())) {
            mRightTV.setText("OPEN");
            mTwoSlideAdapter.slideOpen();
        } else if ("OPEN".equals(mRightTV.getText().toString())) {
            mRightTV.setText("CLOSE");
            mTwoSlideAdapter.slideClose();
        }
    }
}

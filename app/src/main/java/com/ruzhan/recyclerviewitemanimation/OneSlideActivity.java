package com.ruzhan.recyclerviewitemanimation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruzhan.recyclerviewitemanimation.adapter.OneSlideAdapter;

import java.util.ArrayList;
import java.util.List;

public class OneSlideActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private OneSlideAdapter mOneSlideAdapter;
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
        mOneSlideAdapter = new OneSlideAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mOneSlideAdapter);
        mOneSlideAdapter.setData(mData);
    }

    private void initListener() {
        mRightTV.setOnClickListener(this);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rcv_root);
        mRightTV = findViewById(R.id.right_tv);
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
            mOneSlideAdapter.slideOpen();
        } else if ("OPEN".equals(mRightTV.getText().toString())) {
            mRightTV.setText("CLOSE");
            mOneSlideAdapter.slideClose();
        }
    }
}

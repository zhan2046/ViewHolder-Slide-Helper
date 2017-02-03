package com.ruzhan.recyclerviewitemanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.ruzhan.recyclerviewitemanimation.adapter.OneSlideAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhan on 2017/2/3.
 */

public class OneSlideActivity extends AppCompatActivity implements View.OnClickListener {

  private RecyclerView mRecyclerView;
  private OneSlideAdapter mOneSlideAdapter;
  private TextView mRightTV;

  private List<String> mData;

  @Override protected void onCreate(Bundle savedInstanceState) {
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
    mRecyclerView = (RecyclerView) findViewById(R.id.rcv_root);
    mRightTV = (TextView) findViewById(R.id.right_tv);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.right_tv:
        editItems();
        break;
    }
  }

  private void editItems() {
    if ("关闭中".equals(mRightTV.getText().toString())) {
      mRightTV.setText("打开了");
      mOneSlideAdapter.openItemAnimation();
    } else if ("打开了".equals(mRightTV.getText().toString())) {
      mRightTV.setText("关闭中");
      mOneSlideAdapter.closeItemAnimation();
    }
  }

}

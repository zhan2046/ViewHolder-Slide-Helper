package com.pioneers.recyclerviewitemanimation.bean;

import java.io.Serializable;

/**
 * Created by Young Pioneers on 16/6/30.
 */
public class ItemBean implements Serializable {

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

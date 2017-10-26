package com.lostbug.demo;

import java.util.UUID;

/**
 * Created by rocka on 2017/10/26.
 */

public class DemoItem {
    private UUID mId;
    private int mNameId;
    private int mIconId;

    public DemoItem() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public int getNameId() {
        return mNameId;
    }

    public void setNameId(int nameId) {
        mNameId = nameId;
    }

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int iconId) {
        mIconId = iconId;
    }
}

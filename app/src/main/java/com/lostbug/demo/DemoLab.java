package com.lostbug.demo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rocka on 2017/10/26.
 */

public class DemoLab {
    private static DemoLab sDemoLab;
    private List<DemoItem> mDemoItems;

    public static DemoLab get(Context context) {
        if (sDemoLab == null) {
            sDemoLab = new DemoLab(context);
        }
        return sDemoLab;
    }

    private DemoLab(Context context) {
        mDemoItems = new ArrayList<>();
    }

    public void addDemoItem(DemoItem demoItem) {
        mDemoItems.add(demoItem);
    }

    public DemoItem getDemoItem(UUID id) {
        for (DemoItem demoItem : mDemoItems) {
            if (demoItem.getId() == id) {
                return demoItem;
            }
        }
        return null;
    }

    public List<DemoItem> getDemoItems() {
        return mDemoItems;
    }
}

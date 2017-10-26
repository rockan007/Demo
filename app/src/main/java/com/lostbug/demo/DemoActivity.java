package com.lostbug.demo;

import android.support.v4.app.Fragment;

import com.lostbug.demo.base.SingleFragmentActivity;

public class DemoActivity extends SingleFragmentActivity {
    @Override
    public Fragment getFragment() {
        return DemoFragment.newInstance();
    }
}

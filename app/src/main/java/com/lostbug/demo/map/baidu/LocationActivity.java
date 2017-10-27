package com.lostbug.demo.map.baidu;

import android.support.v4.app.Fragment;

import com.lostbug.demo.base.SingleFragmentActivity;

/**
 * Created by rocka on 2017/10/27.
 */

public class LocationActivity extends SingleFragmentActivity {
    @Override
    public Fragment getFragment() {
        return LocationFragment.newInstance();
    }
}

package com.lostbug.demo.map.baidu;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lostbug.demo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationFragment extends Fragment {
    private String permissionInfo;
    private static final int PERMISSIONREQUESTCODE = 100;
    private static final String TAG = "LocationFragment";

    public LocationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationFragment newInstance() {
        LocationFragment fragment = new LocationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPermissions();
    }

    private void getPermissions() {
        ArrayList<String> permissions = new ArrayList<>();
        if (!isPermitted(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (addPermission(permissions, Manifest.permission_group.STORAGE)) {
            permissionInfo += "Manifest.permission_group.STORAGE Deny \n";
        }
        if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
            permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
        }
        if (permissions.size() > 0) {
            ActivityCompat.requestPermissions(getActivity(), permissions.toArray(new String[permissions.size()]), PERMISSIONREQUESTCODE);
        }
    }

    private boolean isPermitted(String permission) {
        boolean isPermitted = ContextCompat.checkSelfPermission(getActivity(), permission) == PackageManager.PERMISSION_GRANTED;
        if (!isPermitted) {
            if (shouldShowRequestPermissionRationale(permission)) {
                Log.d(TAG, permission + ":true");
            } else {
                Log.d(TAG, permission + ":false");
            }
        }
        return isPermitted;
    }

    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (!isPermitted(permission)) {
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

}

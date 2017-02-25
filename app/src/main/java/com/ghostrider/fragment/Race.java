package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.R;


public class Race extends Fragment {

    private static Race instance;

    public Race() {
    }

    public static Race getInstance() {
        return instance == null ? instance = new Race() : instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_race, container, false);
    }
}

package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.R;


public class Stats extends Fragment {

    private static Stats instance;

    public Stats() {
    }

    public static Stats getInstance() {
        return instance == null ? instance = new Stats() : instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }
}

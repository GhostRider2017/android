package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.R;


public class Dash extends Fragment {

    private static Dash instance;
    private int i = 0;
    private View view;

    public Dash() {
    }

    public static Dash getInstance() {
        return instance == null ? instance = new Dash() : instance;
    }

    public int increment() {
        return ++i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_dash, container, false);
    }
}

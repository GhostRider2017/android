package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.R;


public class Run extends Fragment {

    private static Run instance;

    public Run() {
    }

    public static Run getInstance() {
        return instance == null ? instance = new Run() : instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_run, container, false);
    }
}

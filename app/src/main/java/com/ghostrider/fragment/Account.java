package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.R;


public class Account extends Fragment {

    private static Account instance;

    public Account() {
    }

    public static Account getInstance() {
        return instance == null ? instance = new Account() : instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }
}

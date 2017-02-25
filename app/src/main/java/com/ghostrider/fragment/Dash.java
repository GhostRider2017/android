package com.ghostrider.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghostrider.Firebase;
import com.ghostrider.R;
import com.ghostrider.User;


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
        Log.e("Hello", "hello");
        User user = User.register("Anuraag Yachamaneni", "hello@purdue.edu",
                "123456", this.getContext());

        if(user != null) {
            Log.e("User", user.toString());
        } else {
            Log.e("LOL", "now");
        }

        User user2 = User.login("ayachama@purdue.edu", "123456", this.getContext());
        if(user != null) {
            Log.e("User", user.toString());
        } else {
            Log.e("LOL", "never");
        }
        return view = inflater.inflate(R.layout.fragment_dash, container, false);

    }
}

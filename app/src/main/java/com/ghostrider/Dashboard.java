package com.ghostrider;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ghostrider.fragment.Account;
import com.ghostrider.fragment.Dash;
import com.ghostrider.fragment.Race;
import com.ghostrider.fragment.Run;
import com.ghostrider.fragment.Stats;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Dashboard extends AppCompatActivity {

    public static final String[] colors = {"#9C27B0", "#e91e63", "#2196f3"};
    public Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Create Navigation Tabs
        createNavigationTabs();

    }

    void createNavigationTabs() {

        BottomBar _dashBar = (BottomBar) findViewById(R.id.dashBar);
        _dashBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        changeColors(R.drawable.background_dash, colors[0]);
                        changeFragment(Dash.getInstance());
                        break;
                    case R.id.tab_run:
                        changeColors(R.drawable.background_run, colors[1]);
                        changeFragment(Run.getInstance());
                        break;
                    case R.id.tab_race:
                        changeColors(R.drawable.background_race, colors[2]);
                        changeFragment(Race.getInstance());
                        break;
                    case R.id.tab_stats:
                        changeFragment(Stats.getInstance());
                        break;
                    case R.id.tab_account:
                        changeFragment(Account.getInstance());
                        break;
                }
            }
        });
    }

    void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (currentFragment != null) {
            transaction.remove(currentFragment);
        }

        transaction.replace(R.id.dashContainer, currentFragment = fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    void changeColors(int rescID, String color) {
        View _backgroundView = findViewById(R.id.dashContainer).getRootView();
        _backgroundView.setBackgroundResource(rescID);

        BottomBar _bar = (BottomBar) findViewById(R.id.dashBar);
        _bar.setActiveTabColor(Color.parseColor(color));
    }
}

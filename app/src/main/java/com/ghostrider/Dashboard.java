package com.ghostrider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ghostrider.fragment.Account;
import com.ghostrider.fragment.Dash;
import com.ghostrider.fragment.Race;
import com.ghostrider.fragment.Run;
import com.ghostrider.fragment.Stats;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Dashboard extends AppCompatActivity {

    public static final String[] colors = {"#9C27B0", "#e91e63", "#2196f3", "#4caf50", "#ff9800"};
    public static final String[] colors900 = {"#6a1b9a", "#ad1457", "#0277bd", "#2e7d32", "#ef6c00"};
    public Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Set Custom ACtion Bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.ghost_bar);

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
                        changeFragment(Dash.getInstance());
                        changeTitle("Dashboard");
                        changeColors(R.drawable.background_dash, 0);
                        break;
                    case R.id.tab_run:
                        changeFragment(Run.getInstance());
                        changeTitle("Run");
                        changeColors(R.drawable.background_run, 1);
                        break;
                    case R.id.tab_race:
                        changeFragment(Race.getInstance());
                        changeTitle("Race");
                        changeColors(R.drawable.background_race, 2);
                        break;
                    case R.id.tab_stats:
                        changeFragment(Stats.getInstance());
                        changeTitle("Statistics");
                        changeColors(R.drawable.background_stats, 3);
                        break;
                    case R.id.tab_account:
                        changeFragment(Account.getInstance());
                        changeTitle("Account Info");
                        changeColors(R.drawable.background_account, 4);
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

    void changeColors(int rescID, int index) {
        View _backgroundView = findViewById(R.id.dashContainer).getRootView();
        _backgroundView.setBackgroundResource(rescID);

        BottomBar _bar = (BottomBar) findViewById(R.id.dashBar);
        _bar.setActiveTabColor(Color.WHITE);
        _bar.setInActiveTabColor(0xFFE3E3E3);

        ActionBar _actbar = getSupportActionBar();
        _actbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(colors[index])));

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(colors900[index]));
    }

    void changeTitle(String title) {
        ((TextView) findViewById(R.id.action_bar_title)).setText(title);
    }
}

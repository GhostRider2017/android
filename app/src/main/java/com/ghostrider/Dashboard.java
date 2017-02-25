package com.ghostrider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ghostrider.fragment.Account;
import com.ghostrider.fragment.Dash;
import com.ghostrider.fragment.Race;
import com.ghostrider.fragment.Run;
import com.ghostrider.fragment.Stats;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Dashboard extends AppCompatActivity {

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
                        changeFragment(Dash.getInstance());
                        break;
                    case R.id.tab_run:
                        changeFragment(Run.getInstance());
                        break;
                    case R.id.tab_race:
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
}

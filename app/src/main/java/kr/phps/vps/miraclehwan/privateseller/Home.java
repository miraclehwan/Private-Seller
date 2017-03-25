package kr.phps.vps.miraclehwan.privateseller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


/**
 * Created by Daehwan Kim on 2017-02-20.
 */

public class Home extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    menu_main m_main;
    menu_sell m_sell;
    menu_buy m_buy;
    menu_stats m_stats;
    menu_setting m_setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        m_main = menu_main.newInstance();
        m_sell = menu_sell.newInstance();
        m_buy = menu_buy.newInstance();
        m_stats = menu_stats.newInstance();
        m_setting = menu_setting.newInstance();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_main).commit();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_item_main:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_main).commit();
                        break;
                    case R.id.navigation_item_buy:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_buy).commit();
                        break;
                    case R.id.navigation_item_sell:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_sell).commit();
                        break;
                    case R.id.navigation_item_stats:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_stats).commit();
                        break;
                    case R.id.navigation_item_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, m_setting).commit();
                        break;
                }

                return true;
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

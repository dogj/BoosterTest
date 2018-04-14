package com.example.administrator.boostertest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private ContentFragment contentFragment;
    private Question1 question1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.main);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setDefaultFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.defensive) {
            startActivity(new Intent(this, Defensive.class));

        } else if (id == R.id.conservative) {
            startActivity(new Intent(this, Conservative.class));
        } else if (id == R.id.balanced) {
            startActivity(new Intent(this, Balanced.class));

        } else if (id == R.id.balanced_growth) {
            startActivity(new Intent(this, BalancedGrowth.class));

        } else if (id == R.id.growth) {
            startActivity(new Intent(this, Growth.class));
        } else if (id == R.id.aggressive_growth) {
            startActivity(new Intent(this, AggressiveGrowth.class));
        }else if (id == R.id.nav_share) {
            FragmentManager fm = getFragmentManager();
            // 开启Fragment事务
            FragmentTransaction transaction = fm.beginTransaction();
                question1 = new Question1();
            transaction.replace(R.id.content, question1);
            transaction.commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }//close the drawer if the drawer is opened
        }


        return true;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        contentFragment = new ContentFragment();
        transaction.replace(R.id.content, contentFragment);
        transaction.commit();
    }

}

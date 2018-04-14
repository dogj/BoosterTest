package com.example.administrator.boostertest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.example.administrator.boostertest.questions.Question1;
import com.example.administrator.boostertest.questionsFragment.AgressiveGrowthFragment;
import com.example.administrator.boostertest.questionsFragment.BalancedFragment;
import com.example.administrator.boostertest.questionsFragment.BalancedGrowthFragment;
import com.example.administrator.boostertest.questionsFragment.ConservativeFragment;
import com.example.administrator.boostertest.questionsFragment.DefensiveFragment;
import com.example.administrator.boostertest.questionsFragment.GrowthFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private ContentFragment contentFragment;
    private Question1 question1;
    private AgressiveGrowthFragment agressiveGrowthFragment;
    private BalancedFragment balancedFragment;
    private BalancedGrowthFragment balancedGrowthFragment;
    private DefensiveFragment defensiveFragment;
    private GrowthFragment growthFragment;
    private ConservativeFragment conservativeFragment;
    private MenuItem itemSubmit;





    private boolean quit = false;
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
                super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.defensive) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            defensiveFragment = new DefensiveFragment();
            transaction.replace(R.id.content, defensiveFragment);
            transaction.commit();
            drawerClose();


        } else if (id == R.id.conservative) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            conservativeFragment = new ConservativeFragment();
            transaction.replace(R.id.content, conservativeFragment);
            transaction.commit();
            drawerClose();

        } else if (id == R.id.balanced) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            balancedFragment = new BalancedFragment();
            transaction.replace(R.id.content, balancedFragment);
            transaction.commit();
            drawerClose();


        } else if (id == R.id.balanced_growth) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            balancedGrowthFragment = new BalancedGrowthFragment();
            transaction.replace(R.id.content, balancedGrowthFragment);
            transaction.commit();
            drawerClose();


        } else if (id == R.id.growth) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            growthFragment = new GrowthFragment();
            transaction.replace(R.id.content, growthFragment);
            transaction.commit();
            drawerClose();

        } else if (id == R.id.aggressive_growth) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            agressiveGrowthFragment = new AgressiveGrowthFragment();
            transaction.replace(R.id.content, agressiveGrowthFragment);
            transaction.commit();
            drawerClose();
        }else if (id == R.id.questionaire) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
                question1 = new Question1();
            transaction.replace(R.id.content, question1);
            transaction.commit();
            drawerClose();
        }else if (id == R.id.submit) {
            new Update().execute();
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

    public void drawerClose(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }//close the drawer if the drawer is opened

    }

    class Update extends AsyncTask<String,Void,Long> {


        @Override
        protected Long doInBackground(String... params) {


                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        if(Data.isFinished()){
                            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                            Menu menu = navigationView.getMenu();
                            itemSubmit = menu.findItem(R.id.submit);
                            itemSubmit.setTitle("Submitted");
                        }else{
                            Toast.makeText(getApplicationContext(),"you haven't finished the questionaire",Toast.LENGTH_SHORT);
                        }
                    }
                });


//                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();

            return null;
        }
    }

}

package com.example.marijus.enduiprototype;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String DEBUG_TAG = "Debug_end";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        displayDrawerLayout(toolbar, drawerLayout);
        setupDrawerLayoutNavigationView(drawerLayout);
    }

    private void displayDrawerLayout(Toolbar toolbar, DrawerLayout drawerLayout) {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }

            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setupDrawerLayoutNavigationView(final DrawerLayout drawerLayout) {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.brands:
                        Log.d(DEBUG_TAG, "Brands");
                        openTemporaryFragment();
                        displayShortToast("Brands clicked");
                        return true;
                    case R.id.clothing:
                        openTemporaryFragment();
                        displayShortToast("Clothing clicked");
                        return true;
                    case R.id.latest:
                        Log.d(DEBUG_TAG, "Latest");
                        openTemporaryFragment();
                        displayShortToast("Latest clicked");
                        return true;
                    case R.id.login:
                        Log.d(DEBUG_TAG, "Login");
                        openTemporaryFragment();
                        displayShortToast("Login clicked");
                        return true;
                    case R.id.logout:
                        Log.d(DEBUG_TAG, "Logout");
                        openTemporaryFragment();
                        displayShortToast("Logout clicked");
                        return true;
                    default:
                        return true;
                }
            }

                    private void displayShortToast(String text) {
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    }

                    private void openTemporaryFragment() {
                        ContentFragment fragment = new ContentFragment();
                        android.support.v4.app.FragmentTransaction transaction =
                                getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //    return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}

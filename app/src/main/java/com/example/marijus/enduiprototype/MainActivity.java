package com.example.marijus.enduiprototype;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.marijus.enduiprototype.adapters.DataAdapter;
import com.example.marijus.enduiprototype.products.GymTrainers;
import com.example.marijus.enduiprototype.products.PlaceholderProduct;
import com.example.marijus.enduiprototype.products.RetroJordans;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataAdapter adapter;
    
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

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<PlaceholderProduct> products = buildProductList();
        adapter = new DataAdapter(products);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private List<PlaceholderProduct> buildProductList() {
        ArrayList<PlaceholderProduct> products = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            products.add(new RetroJordans());
            products.add(new GymTrainers());
        }
        return products;
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

        drawerLayout.addDrawerListener(toggle);
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
                        openTemporaryFragment();
                        displayShortToast("Brands clicked");
                        return true;
                    case R.id.clothing:
                        openTemporaryFragment();
                        return true;
                    case R.id.latest:
                        openTemporaryFragment();
                        displayShortToast("Latest clicked");
                        return true;
                    case R.id.login:
                        openTemporaryFragment();
                        displayShortToast("Login clicked");
                        return true;
                    case R.id.logout:
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}

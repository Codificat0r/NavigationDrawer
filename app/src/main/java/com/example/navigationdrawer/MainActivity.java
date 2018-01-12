package com.example.navigationdrawer;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener, FragmentTwo.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private DrawerLayout drawer_Layout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = findViewById(R.id.toolbar);
        drawer_Layout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home_h);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupNavigationView();
    }

    //Método que inicia el Listener NavigationItemSelected, y en base a la opcion seleccionada se realiza una accion.
    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //TERMINAR ESTO
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion HOME");
                        cargarFragmentOne();
                        drawer_Layout.closeDrawers();
                        break;
                    case R.id.action_dependency:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion DEPENDENCY");
                        cargarFragmentTwo();
                        drawer_Layout.closeDrawers();
                        break;
                    case R.id.action_sector:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion SECTOR");
                        cargarFragmentOne();
                        drawer_Layout.closeDrawers();
                        break;
                    case R.id.action_other_options:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion OTHER OPTIONS");
                        Intent i = new Intent(MainActivity.this, PreferenceActivity.class);
                        startActivity(i);
                        drawer_Layout.closeDrawers();
                        break;
                    case R.id.action_help:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion HELP");
                        cargarFragmentOne();
                        drawer_Layout.closeDrawers();
                        break;
                }
                //Marcamos como seleccionado el item.
                item.setChecked(true);
                //Ponemos el titulo de lo que se esta visualizando actualmente
                getSupportActionBar().setTitle(item.getTitle());
                drawer_Layout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer_Layout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //Desde donde se abre
        if (drawer_Layout.isDrawerOpen(GravityCompat.START)) {
            drawer_Layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void cargarFragmentOne() {
        FragmentOne fragmentOne = new FragmentOne();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentOne, "F1");
        fragmentTransaction.commit();
    }

    private void cargarFragmentTwo() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentTwo, "F1");
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

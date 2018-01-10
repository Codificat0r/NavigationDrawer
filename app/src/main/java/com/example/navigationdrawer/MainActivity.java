package com.example.navigationdrawer;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

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
                FragmentOne fragmentOne;
                FragmentTwo fragmentTwo;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion HOME");
                        break;
                    case R.id.action_dependency:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion DEPENDENCY");
                        break;
                    case R.id.action_sector:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion SECTOR");
                        break;
                    case R.id.action_other_options:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion OTHER OPTIONS");
                        break;
                    case R.id.action_help:
                        Log.d("NavigationDrawer", " Se ha pulsado la opcion HELP");
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
}

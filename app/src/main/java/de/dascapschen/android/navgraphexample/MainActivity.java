package de.dascapschen.android.navgraphexample;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener
{

    DrawerLayout drawer;

    NavigationView navView;
    NavController navController;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);

        //create hamburger menu!
        ActionBarDrawerToggle hamburgerMenu = new ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0);

        //drawer layout should listen clicks to the hamburger menu icon
        drawer.addDrawerListener(hamburgerMenu);
        hamburgerMenu.syncState();

        //override the listener for when we click on an item
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        if( drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch( item.getItemId() )
        {
            case R.id.menu_item_settings:
                navController.navigate(R.id.action_toSettings);
                break;
            case R.id.menu_item_about:
                navController.navigate(R.id.action_toAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        //if we selected the page we are already on, skip this!
        if( ! item.isChecked() )
        {
            switch (item.getItemId())
            {
                case R.id.drawer_item_main:
                    //solange poppen, bis wir im mainFragment sind.
                    //dieses aber NICHT poppen!
                    navController.popBackStack(R.id.mainFragment, false);
                    break;
                case R.id.drawer_item_settings:
                    navController.navigate(R.id.action_toSettings);
                    break;
                case R.id.drawer_item_about:
                    navController.navigate(R.id.action_toAbout);
                    break;
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

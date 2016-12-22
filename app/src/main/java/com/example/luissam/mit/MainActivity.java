package com.example.luissam.mit;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luissam.mit.Fragments.FiveFrag;
import com.example.luissam.mit.Fragments.FourFrag;
import com.example.luissam.mit.Fragments.InicialFrag;
import com.example.luissam.mit.Fragments.OneFrag;
import com.example.luissam.mit.Fragments.SixFrag;
import com.example.luissam.mit.Fragments.ThreeFrag;
import com.example.luissam.mit.Fragments.TwoFrag;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OneFrag.OnFragmentInteractionListener,
        TwoFrag.OnFragmentInteractionListener,
        ThreeFrag.OnFragmentInteractionListener,
        FourFrag.OnFragmentInteractionListener,
        FiveFrag.OnFragmentInteractionListener,
        SixFrag.OnFragmentInteractionListener,
        InicialFrag.OnFragmentInteractionListener{


    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager.beginTransaction()
                .replace(R.id.contenedor,
                        new InicialFrag())
                .commit();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home)  {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new InicialFrag())
                    .commit();

        } else if (id == R.id.pem) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new OneFrag())
                    .commit();

        } else if (id == R.id.oem) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new TwoFrag())
                    .commit();

        } else if (id == R.id.location) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new ThreeFrag())
                    .commit();

        } else if (id == R.id.cons) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new SixFrag())
                    .commit();

        } else if (id == R.id.servicios) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new FourFrag())
                    .commit();

        } else if (id == R.id.cliente) {

            fragmentManager.beginTransaction()
                    .replace(R.id.contenedor,
                            new FiveFrag())
                    .commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

            LayoutInflater inflater = getLayoutInflater();
            View dialoglayout = inflater.inflate(R.layout.activity_contacto, null);

            final EditText etAsunto = (EditText) dialoglayout.findViewById(R.id.et_EmailAsunto);
            final EditText etMensaje = (EditText) dialoglayout.findViewById(R.id.et_EmailMensaje);

            Button btnEnviarMail = (Button) dialoglayout.findViewById(R.id.btnEnviarMail);
            btnEnviarMail.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {


                    String subject = etAsunto.getText().toString();
                    String message = etMensaje.getText().toString();

                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"LuisMartin.Samano@gstautoleather.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, "" + message);


                    // need this to prompts email client only
                    email.setType("message/rfc822");
                    startActivity(email);

                }
            });

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setView(dialoglayout);
            builder.setIcon(R.drawable.ic_menu_send);
            builder.show();


        } else {
            Toast.makeText(MainActivity.this, "Fail conetion", Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}




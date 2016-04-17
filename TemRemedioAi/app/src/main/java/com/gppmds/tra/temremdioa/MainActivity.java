package com.gppmds.tra.temremdioa;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Context ctx;
    TextView helloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ctx = this;
        helloWorld = (TextView) findViewById(R.id.hello);

        // Establish connection with parse server
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("TemRemedioAi")
                        .server("http://temremedioai.herokuapp.com/temremedioai/Class")
                        .clientKey("kijasijijasiasjsiajalllkaosiajhsis")

                        .build()
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));

        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Pesquisar...");

        return super.onCreateOptionsMenu(menu);
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

        if (id == R.id.search) {

        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    public boolean onQueryTextChange(String newText){
        helloWorld.setText(newText);
        return false;
    }
}

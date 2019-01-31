package com.example.mediaescolarscroll;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {


    private Button btnPrimeiroBimestre;
    private Button btnSegundoBimestre;
    private Button btnTreceiroBimestre;
    private Button btnQuartoBimestre;
    Intent intent;
    public static SharedPreferences sharedMediaPref;
    public static final String CHAVE_MEDIA_PREFERENCIA="mediaEscolarPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPrimeiroBimestre = findViewById(R.id.btnPrimieroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTreceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);




    btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(), PrimeiroBimestreActivity.class);
            startActivity(intent);
        }
    });
    btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(), SegundoBimestreActivity.class);
            startActivity(intent);
        }
    });
    btnTreceiroBimestre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(), TerceiroBimestreActivity.class);
            startActivity(intent);
        }
    });
    btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(), QuartoBimestreActivity.class);
            startActivity(intent);
        }
    });







        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}


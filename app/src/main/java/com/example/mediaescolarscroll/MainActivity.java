package com.example.mediaescolarscroll;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnPrimeiroBimestre;
    private Button btnSegundoBimestre;
    private Button btnTerceiroBimestre;
    private Button btnQuartoBimestre;
    Intent intent;
    private String nomeMateriaPrimeiroBimestre, nomeMateriaSegundoBimestre, nomeMateriaTerceiroBimestre, nomeMateriaQuartoBimestre;
    private String notaProvaPrimeiroBimestre, notaProvaSegundoBimestre, notaProvaTerceiroBimestre, notaProvaQuartoBimestre;
    private String notaTrabalhoPrimeiroBimestre, notaTrabalhoSegundoBimestre, notaTrabalhoTerceiroBimestre, notaTrabalhoQuartoBimestre;
    private String mediaPrimeroBimestre, mediaSegundoBimestre, mediaTerceiroBimestre, mediaQuartoBimestre;
    private String situacaoFinalPrimeiroBimestre, situacaoFinalSegundoBimestre, situacaoFinalTerceiroBimestre, situacaoFinalQuartoBimestre;
    private Boolean validacaoPrimeiroBimestre, validacaoSegundoBimestre, validacaoTerceiroBimestre, validacaoQuartoBimestre;


    public static SharedPreferences sharedMediaPref;
    public static final String CHAVE_MEDIA_PREFERENCIA = "mediaEscolarPref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lerSharedPreferences();





        btnPrimeiroBimestre = findViewById(R.id.btnPrimieroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);



        visualizarResultado();






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
        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
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

    private void lerSharedPreferences() {

        SharedPreferences sharedMediaPref = getSharedPreferences(CHAVE_MEDIA_PREFERENCIA, 0);
        this.nomeMateriaPrimeiroBimestre = sharedMediaPref.getString("nomeMateriaPrimeiroBimestre", "");
        this.notaProvaPrimeiroBimestre = sharedMediaPref.getString("notaProvaPrimeiroBimestre", "");
        this.notaTrabalhoPrimeiroBimestre = sharedMediaPref.getString("notaTrabalhoPrimeiroBimestre", "");
        this.mediaPrimeroBimestre = sharedMediaPref.getString("mediaPrimeroBimestre", "");
        this.situacaoFinalPrimeiroBimestre = sharedMediaPref.getString("situacaoFinalPrimeiroBimestre", "");
        this.validacaoPrimeiroBimestre = sharedMediaPref.getBoolean("validacaoPrimeiroBimestre", false);


        this.nomeMateriaSegundoBimestre = sharedMediaPref.getString("nomeMateriaSegundoBimestre", "");
        this.notaProvaSegundoBimestre = sharedMediaPref.getString("notaProvaSegundoBimestre", "");
        this.notaTrabalhoSegundoBimestre = sharedMediaPref.getString("notaTrabalhoSegundoBimestre", "");
        this.mediaSegundoBimestre = sharedMediaPref.getString("mediaSegundoBimestre", "");
        this.situacaoFinalSegundoBimestre = sharedMediaPref.getString("situacaoFinalSegundoBimestre", "");


        this.nomeMateriaTerceiroBimestre = sharedMediaPref.getString("nomeMateriaTerceiroBimestre", "");
        this.notaProvaTerceiroBimestre = sharedMediaPref.getString("notaProvaTerceiroBimestre", "");
        this.notaTrabalhoTerceiroBimestre = sharedMediaPref.getString("notaTrabalhoTerceiroBimestre", "");
        this.mediaTerceiroBimestre = sharedMediaPref.getString("mediaTerceiroBimestre", "");
        this.situacaoFinalTerceiroBimestre = sharedMediaPref.getString("situacaoFinalTerceiroBimestre", "");
        this.validacaoTerceiroBimestre = sharedMediaPref.getBoolean("validacaoTerceiroBimestre", false);

        this.nomeMateriaQuartoBimestre = sharedMediaPref.getString("nomeMateriaQuartoBimestre", "");
        this.notaProvaQuartoBimestre = sharedMediaPref.getString("notaProvaQuartoBimestre", "");
        this.notaTrabalhoQuartoBimestre = sharedMediaPref.getString("notaTrabalhoQuartoBimestre", "");
        this.mediaQuartoBimestre = sharedMediaPref.getString("mediaQuartoBimestre", "");
        this.situacaoFinalQuartoBimestre = sharedMediaPref.getString("situacaoFinalQuartoBimestre", "");


    }
    private void visualizarResultado(){

        if(validacaoPrimeiroBimestre){
            btnSegundoBimestre.setEnabled(true);
            btnPrimeiroBimestre.setText(this.nomeMateriaPrimeiroBimestre + " / Nota : "+ (this.mediaPrimeroBimestre));

        }
        else{
            btnSegundoBimestre.setEnabled(false);
        }







    }


}


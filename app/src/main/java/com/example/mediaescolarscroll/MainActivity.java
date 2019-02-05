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
import android.widget.Toast;

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
    private boolean validacaoPrimeiroBimestre, validacaoSegundoBimestre, validacaoTerceiroBimestre, validacaoQuartoBimestre;
    private Button btnresultado;
    private String resultadoFinal;
    private double mediaGlobal;

    public static SharedPreferences sharedMediaPref;
    public static final String CHAVE_MEDIA_PREFERENCIA = "mediaEscolarPref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        btnPrimeiroBimestre = findViewById(R.id.btnPrimieroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnresultado = findViewById(R.id.btnResult);


        lerSharedPreferences();


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
                Snackbar.make(view, "Apagando Arquivo sharedPreferences", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                limparDados();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    private void limparDados() {
        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.CHAVE_MEDIA_PREFERENCIA,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        limparMenu();







    }

    private void limparMenu() {

        btnPrimeiroBimestre.setText("1º Bimestre");
        btnPrimeiroBimestre.setText("2º Bimestre");
        btnPrimeiroBimestre.setText("3º Bimestre");
        btnPrimeiroBimestre.setText("4º Bimestre");
        btnresultado.setText("RESULT");
        btnSegundoBimestre.setEnabled(false);
        btnTerceiroBimestre.setEnabled(false);
        btnQuartoBimestre.setEnabled(false);






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
            try{
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
        this.validacaoSegundoBimestre = sharedMediaPref.getBoolean("validacaoSegundoBimestre", false);

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
        this.validacaoQuartoBimestre = sharedMediaPref.getBoolean("validacaoQuartoBimestre", false);

    }
    catch (Exception e){
                e.getCause();

    }
    }

    private void visualizarResultado() {


        if (validacaoPrimeiroBimestre) {
            btnSegundoBimestre.setEnabled(true);
            btnPrimeiroBimestre.setText(this.nomeMateriaPrimeiroBimestre + " / Nota : " + (this.mediaPrimeroBimestre));

        }

        if (validacaoSegundoBimestre) {
            btnTerceiroBimestre.setEnabled(true);
            btnSegundoBimestre.setText(this.nomeMateriaSegundoBimestre + " / Nota : " + (this.mediaSegundoBimestre));
        }

        if (validacaoTerceiroBimestre) {
            btnQuartoBimestre.setEnabled(true);
            btnTerceiroBimestre.setText(this.nomeMateriaTerceiroBimestre + " / Nota : " + (this.mediaTerceiroBimestre));
        }
        if (validacaoQuartoBimestre) {
            btnQuartoBimestre.setText(this.nomeMateriaQuartoBimestre + " / Nota : " + (this.mediaQuartoBimestre));
            testaResultado(notaProvaPrimeiroBimestre,notaProvaSegundoBimestre,notaProvaTerceiroBimestre,notaProvaQuartoBimestre);
            btnresultado.setText("Voce foi :" + this.resultadoFinal + ":" + this.mediaGlobal+" pts");

        }


    }

    public void testaResultado(String nota1, String nota2,
                                 String nota3, String nota4) {

        double n1 = Double.parseDouble(nota1);
        double n2 = Double.parseDouble(nota2);
        double n3 = Double.parseDouble(nota3);
        double n4 = Double.parseDouble(nota4);


        mediaGlobal = ((n1 + n2 + n3 + n4) / 4);
        if (mediaGlobal >= 7) {
            resultadoFinal = "Aprovado";

        } else {
            resultadoFinal = "Reprovado";

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        visualizarResultado();
        Toast.makeText(getApplicationContext(),"on resume",Toast.LENGTH_LONG).show();
    }
}






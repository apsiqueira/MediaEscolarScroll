package com.example.mediaescolarscroll;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrimeiroBimestreActivity extends AppCompatActivity {

    private EditText nomeMateria;
    private EditText notaProva;
    private EditText notaTrabalho;
    private EditText media;
    private EditText situcaoFinal;
    private Button btnCalcular;
    private Button btnVoltar;
    private Intent intent;
    private Boolean validacaoPrimieroBimestre = false;
    private double notaProvaDouble,
            notaTrabalhoDouble,
            mediaParcial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_bimestre);
        nomeMateria = findViewById(R.id.editTextMateria);
        notaProva = findViewById(R.id.editTextNotaProva);
        notaTrabalho = findViewById(R.id.editTextNotaTrabalho);
        media = findViewById(R.id.editTextMedia);
        situcaoFinal = findViewById(R.id.editTextSituacao);
        btnCalcular = findViewById(R.id.btnCalcular);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        btnVoltar = findViewById(R.id.btnVoltarPrimeiro);
        try {


            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }
            });


            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (nomeMateria.getText().toString().length() > 0 && nomeMateria.getText().toString().length() <= 10 && notaProva.getText().toString().length() > 0 &&
                            notaTrabalho.getText().toString().length() > 0) {
                        notaProvaDouble = Double.parseDouble(notaProva.getText().toString());
                        notaTrabalhoDouble = Double.parseDouble(notaTrabalho.getText().toString());

                        if (notaTrabalhoDouble <= 10 && notaProvaDouble <= 10) {
                            mediaParcial = (notaProvaDouble + notaTrabalhoDouble) / 2;


                            if (mediaParcial >= 6 ) {
                                media.setText(String.valueOf(mediaParcial));
                                situcaoFinal.setText("Aprovado");


                            }
                            else {
                                media.setText(String.valueOf(mediaParcial));
                                situcaoFinal.setText("Reprovado");

                            }
                            validacaoPrimieroBimestre = true;
                            salvarSharedPreferences();



                        } else if (notaProvaDouble > 10 && notaTrabalhoDouble > 10) {
                                Toast.makeText(PrimeiroBimestreActivity.this, "Notas nao podem ser maior que 10 pts", Toast.LENGTH_SHORT).show();

                        } else if (notaTrabalhoDouble > 10) {
                            notaTrabalho.requestFocus();
                            notaTrabalho.setError("nota max 10pts");
                        } else if (notaProvaDouble > 10) {
                                notaProva.requestFocus();
                                notaProva.setError("nota max 10pts");
                        }


                    }  else if (nomeMateria.getText().toString().length() == 0 || nomeMateria.getText().toString().length() > 10) {
                        nomeMateria.setError("Digite a materia com max 10 digitos");
                        nomeMateria.requestFocus();
                    } else if (notaProva.getText().toString().length() == 0) {
                        notaProva.setError("Digite a nota max 10pts");
                        notaProva.requestFocus();


                    } else if (notaTrabalho.getText().toString().length() == 0) {
                        notaTrabalho.setError("Digite a nota do trabalho");
                        notaTrabalho.requestFocus();
                    }


                }

            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();


        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App media Escolar teste", Snackbar.LENGTH_LONG)
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

    private void salvarSharedPreferences() {

        MainActivity.sharedMediaPref = getSharedPreferences(MainActivity.CHAVE_MEDIA_PREFERENCIA, 0);
        SharedPreferences.Editor editor = MainActivity.sharedMediaPref.edit();

        editor.putString("nomeMateriaPrimeiroBimestre", this.nomeMateria.getText().toString());
        editor.putString("notaProvaPrimeiroBimestre", Double.toString(this.notaProvaDouble));
        editor.putString("notaTrabalhoPrimeiroBimestre", Double.toString(this.notaTrabalhoDouble));
        editor.putString("mediaPrimeroBimestre", Double.toString(this.mediaParcial));
        editor.putString("situacaoFinalPrimeiroBimestre", this.situcaoFinal.getText().toString());
        editor.putBoolean("validacaoPrimeiroBimestre", this.validacaoPrimieroBimestre);

        editor.commit();


    }


}

package com.example.mediaescolarscroll;

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

public class PrimeiroBimestreActivity extends AppCompatActivity {

    private EditText nomeMateria;
    private EditText notaProva;
    private EditText notaTrabalho;
    private EditText media;
    private EditText situcaoFinal;
    private Button btnCalcular;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_bimestre);
        nomeMateria=findViewById(R.id.editTextMateria);
        notaProva=findViewById(R.id.editTextNotaProva);
        notaTrabalho=findViewById(R.id.editTextNotaTrabalho);
        media=findViewById(R.id.editTextMedia);
        situcaoFinal=findViewById(R.id.editTextSituacao);
        btnCalcular =findViewById(R.id.btnCalcular);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nomeMateria.getText().toString().length()>0 && notaProva.getText().toString().length()>0 && notaTrabalho.getText().toString().length()>0){
                    double notaProvaDouble=Double.parseDouble(notaProva.getText().toString());
                    double notaTrabalhoDouble=Double.parseDouble(notaTrabalho.getText().toString());
                    double mediaFinal=(notaProvaDouble+notaTrabalhoDouble)/2;
                    if(mediaFinal>=6){
                        media.setText(String.valueOf(mediaFinal));
                        situcaoFinal.setText("Aprovado");
                    }
                    else{
                        media.setText(String.valueOf(mediaFinal));
                        situcaoFinal.setText("Reprovado");
                    }


                }

                if(nomeMateria.getText().toString().length()==0 ){
                    nomeMateria.setError("Digite a materia");
                    nomeMateria.requestFocus();
                }
                if(notaProva.getText().toString().length()==0){
                    notaProva.setError("Digite a nota da Prova");
                    notaProva.requestFocus();

                }
                if(notaTrabalho.getText().toString().length()==0){
                    notaTrabalho.setError("Digite a nota do Trabalho");
                    notaTrabalho.requestFocus();
                }


            }
        });








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

}

package com.example.appaulamediaescolar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText edMateria;
    EditText edNotaProva;
    EditText edNotaTrabalho;
    TextView txtResultado;
    TextView txtAprovacao;

    double notaProva;
    double notaTrabalho;
    double media;
    String resultado;
    boolean validacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edMateria = findViewById(R.id.edMateria);
        edNotaProva = findViewById(R.id.edNotaProva);
        edNotaTrabalho = findViewById(R.id.edNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        txtAprovacao = findViewById(R.id.txtAprovacao);
        validacao = false;


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (edNotaProva.getText().toString().length()>0) {
                        notaProva = Double.parseDouble(edNotaProva.getText().toString());
                        validacao = true;
                    }else{
                        edNotaProva.setError("Informe a Nota da Prova");
                        edNotaProva.requestFocus();
                        validacao = false;
                        txtAprovacao.setText("");
                        txtResultado.setText("");
                    }

                    if (edNotaTrabalho.getText().toString().length()>0) {
                        notaTrabalho = Double.parseDouble(edNotaTrabalho.getText().toString());
                        validacao = true;
                    }else{
                        edNotaTrabalho.setError("Informe a Nota do Trabalho");
                        edNotaTrabalho.requestFocus();
                        validacao = false;
                        txtAprovacao.setText("");
                        txtResultado.setText("");
                    }

                    if (edMateria.getText().toString().length()==0) {
                        edMateria.setError("Informe a Matéria");
                        edMateria.requestFocus();
                        validacao = false;
                        txtAprovacao.setText("");
                        txtResultado.setText("");
                    }
                    if (validacao){
                        media = (notaProva + notaTrabalho) / 2;

                        txtResultado.setText(String.valueOf(media));

                        if (media >= 7) {
                            txtAprovacao.setText("Aprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#006400"));
                        } else {
                            txtAprovacao.setText("Reprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#FF0000"));
                        }
                    }

                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Dados Necessários não informados", Toast.LENGTH_LONG).show();
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App Média Escolar", Snackbar.LENGTH_LONG)
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

package com.example.appmediaescolar;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TerceiroBimestreActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_terceiro_bimestre);
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
                    //Valida Preenchimento da Matéria
                    if (edMateria.getText().toString().length()==0) {
                        edMateria.setError("Informe a Matéria");
                        edMateria.requestFocus();
                        validacao = false;
                        txtAprovacao.setText("");
                        txtResultado.setText("");
                    }else {
                        //Verifica preenchimento nota prova
                        if (edNotaProva.getText().toString().length() > 0) {
                            //Se Preenchida valida os dados
                            if ((Double.parseDouble(edNotaProva.getText().toString()) > 10) ||
                                    (Double.parseDouble(edNotaProva.getText().toString()) < 0)) {
                                edNotaProva.setError("Nota Inválida - Deve ser entre 0 e 10");
                                edNotaProva.requestFocus();
                                validacao = false;
                            } else {
                                notaProva = Double.parseDouble(edNotaProva.getText().toString());
                                validacao = true;

                                //Verifica preenchimento nota trabalho
                                if (edNotaTrabalho.getText().toString().length() > 0) {

                                    //Se Preenchida valida os dados
                                    if ((Double.parseDouble(edNotaTrabalho.getText().toString()) > 10) ||
                                            (Double.parseDouble(edNotaTrabalho.getText().toString()) < 0)) {
                                        edNotaTrabalho.setError("Nota Inválida - Deve ser entre 0 e 10");
                                        edNotaTrabalho.requestFocus();
                                        validacao = false;
                                    } else {
                                        notaTrabalho = Double.parseDouble(edNotaTrabalho.getText().toString());
                                        validacao = true;
                                    }
                                    //Retorno se errada nota trabalho
                                } else {
                                    edNotaTrabalho.setError("Informe a Nota do Trabalho");
                                    edNotaTrabalho.requestFocus();
                                    validacao = false;
                                    txtAprovacao.setText("");
                                    txtResultado.setText("");
                                }
                            }
                            //Retorno se errada nota prova
                        } else {
                            edNotaProva.setError("Informe a Nota da Prova");
                            edNotaProva.requestFocus();
                            validacao = false;
                            txtAprovacao.setText("");
                            txtResultado.setText("");
                        }
                    }

                    //Calcula a média e joga o resultado para a tela
                    if (validacao){
                        media = (notaProva + notaTrabalho) / 2;

                        txtResultado.setText(String.valueOf(media));

                        //Define qual texto irá aparecer na tela "APROVADO" ou "REPROVADO"
                        if (media >= 7) {
                            txtAprovacao.setText("Aprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#006400"));
                        } else {
                            txtAprovacao.setText("Reprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#FF0000"));
                        }

                        salvarSharedPreferences();
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

    private void salvarSharedPreferences() {

        //Cria um arquivo XML dentro da pasta "data" do app
        SharedPreferences mediaEscolarPref = getSharedPreferences(MainActivity.NOME_SHARED_PREFER, 0);

        //Cria um editor para o arquivo XML
        SharedPreferences.Editor mediaEscolar = mediaEscolarPref.edit();

        //Adiciona os dados no arquivo XML
        mediaEscolar.putString("materiaTerceiro", edMateria.getText().toString());
        mediaEscolar.putString("txtResultadoTerceiro", txtResultado.getText().toString());
        mediaEscolar.putString("txtAprovacaoTerceiro", txtAprovacao.getText().toString());
        mediaEscolar.putString("notaProvaTerceiro", String.valueOf(notaProva));
        mediaEscolar.putString("notaTrabalhoTerceiro", String.valueOf(notaTrabalho));
        mediaEscolar.putString("mediaTerceiro", String.valueOf(media));
        mediaEscolar.putBoolean("terceiroBimestre", true);

        //Salva os dados adicionados
        mediaEscolar.commit();

    }
}

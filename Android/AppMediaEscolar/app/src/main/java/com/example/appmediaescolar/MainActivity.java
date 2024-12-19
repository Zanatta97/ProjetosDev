package com.example.appmediaescolar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.ResultReceiver;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static final String NOME_SHARED_PREFER = "mediaEscolarPref";

    Button btnPrimeiro, btnSegundo, btnTerceiro, btnQuarto, btnResultado;
    Boolean primeiroBimestre, segundoBimestre, terceiroBimestre, quartoBimestre;
    String situacaoPrimeiro, materiaPrimeiro,
            situacaoSegundo, materiaSegundo,
            situacaoTerceiro, materiaTerceiro,
            situacaoQuarto, materiaQuarto;
    double notaProvaPrimeiro, notaTrabalhoPrimeiro, mediaPrimeiro,
            notaProvaSegundo, notaTrabalhoSegundo, mediaSegundo,
            notaProvaTerceiro, notaTrabalhoTerceiro, mediaTerceiro,
            notaProvaQuarto, notaTrabalhoQuarto, mediaQuarto,
            mediaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lerSharedPreferences();

        btnPrimeiro = findViewById(R.id.btnPrimeiro);
        btnSegundo = findViewById(R.id.btnSegundo);
        btnTerceiro = findViewById(R.id.btnTerceiro);
        btnQuarto = findViewById(R.id.btnQuarto);
        btnResultado = findViewById(R.id.btnResultado);

        String pasta = "fonts/";
        String ttfToonish = "TOONISH.ttf";

        Typeface Toonish = Typeface.createFromAsset(getAssets(), pasta + ttfToonish);

        btnPrimeiro.setTypeface(Toonish);
        btnSegundo.setTypeface(Toonish);
        btnTerceiro.setTypeface(Toonish);
        btnQuarto.setTypeface(Toonish);
        btnResultado.setTypeface(Toonish);

        btnPrimeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(MainActivity.this,
                        PrimeiroBimestreActivity.class);
                startActivity(proximaTela);
            }
        });

        btnSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(MainActivity.this,
                        SegundoBimestreActivity.class);
                startActivity(proximaTela);
            }
        });

        btnTerceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(MainActivity.this,
                        TerceiroBimestreActivity.class);
                startActivity(proximaTela);
            }
        });

        btnQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximaTela = new Intent(MainActivity.this,
                        QuartoBimestreActivity.class);
                startActivity(proximaTela);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Dados Apagados com sucesso!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                clearSharedPreferences();
            }
        });

        visualizarResultado();

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

    @Override
    public void onResume()
    {
        super.onResume();

        lerSharedPreferences();
        visualizarResultado();

    }

    private void lerSharedPreferences() {
        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);

        primeiroBimestre = mediaEscolarPref.getBoolean("primeiroBimestre", false);
        situacaoPrimeiro = mediaEscolarPref.getString("txtAprovacaoPrimeiro", "");
        materiaPrimeiro = mediaEscolarPref.getString("materiaPrimeiro", "");
        notaProvaPrimeiro = Double.parseDouble(mediaEscolarPref.getString("notaProvaPrimeiro", "0.0"));
        notaTrabalhoPrimeiro = Double.parseDouble(mediaEscolarPref.getString("notaTrabalhoPrimeiro", "0.0"));
        mediaPrimeiro = Double.parseDouble(mediaEscolarPref.getString("mediaPrimeiro", "0.0"));

        segundoBimestre = mediaEscolarPref.getBoolean("segundoBimestre", false);
        situacaoSegundo = mediaEscolarPref.getString("txtAprovacaoSegundo", "");
        materiaSegundo = mediaEscolarPref.getString("materiaSegundo", "");
        notaProvaSegundo = Double.parseDouble(mediaEscolarPref.getString("notaProvaSegundo", "0.0"));
        notaTrabalhoSegundo = Double.parseDouble(mediaEscolarPref.getString("notaTrabalhoSegundo", "0.0"));
        mediaSegundo = Double.parseDouble(mediaEscolarPref.getString("mediaSegundo", "0.0"));

        terceiroBimestre = mediaEscolarPref.getBoolean("terceiroBimestre", false);
        situacaoTerceiro = mediaEscolarPref.getString("txtAprovacaoTerceiro", "");
        materiaTerceiro = mediaEscolarPref.getString("materiaTerceiro", "");
        notaProvaTerceiro = Double.parseDouble(mediaEscolarPref.getString("notaProvaTerceiroo", "0.0"));
        notaTrabalhoTerceiro = Double.parseDouble(mediaEscolarPref.getString("notaTrabalhoTerceiro", "0.0"));
        mediaTerceiro = Double.parseDouble(mediaEscolarPref.getString("mediaTerceiro", "0.0"));

        quartoBimestre = mediaEscolarPref.getBoolean("quartoBimestre", false);
        situacaoQuarto = mediaEscolarPref.getString("txtAprovacaoQuarto", "");
        materiaQuarto = mediaEscolarPref.getString("materiaQuarto", "");
        notaProvaQuarto = Double.parseDouble(mediaEscolarPref.getString("notaProvaQuarto", "0.0"));
        notaTrabalhoQuarto = Double.parseDouble(mediaEscolarPref.getString("notaTrabalhoQuarto", "0.0"));
        mediaQuarto = Double.parseDouble(mediaEscolarPref.getString("mediaQuarto", "0.0"));

    }

    private void visualizarResultado(){
        if (primeiroBimestre){
            btnPrimeiro.setText(materiaPrimeiro + " - 1º Bimestre" + situacaoPrimeiro + " - Nota: " + formataValorDecimal(mediaPrimeiro));
            btnPrimeiro.setEnabled(false);
            btnSegundo.setEnabled(primeiroBimestre);
        }

        if (segundoBimestre){
            btnSegundo.setText(materiaSegundo + " - 2º Bimestre" + situacaoSegundo + " - Nota: " + formataValorDecimal(mediaSegundo));
            btnSegundo.setEnabled(false);
            btnTerceiro.setEnabled(segundoBimestre);
        }

        if (terceiroBimestre){
            btnTerceiro.setText(materiaTerceiro + " - 3º Bimestre" + situacaoTerceiro + " - Nota: " + formataValorDecimal(mediaTerceiro));
            btnTerceiro.setEnabled(false);
            btnQuarto.setEnabled(terceiroBimestre);
        }

        if (quartoBimestre){
            btnQuarto.setText(materiaQuarto + " - 4º Bimestre" + situacaoQuarto + " - Nota: " + formataValorDecimal(mediaQuarto));
            btnQuarto.setEnabled(false);
            btnResultado.setEnabled(quartoBimestre);

            mediaFinal = 0;
            mediaFinal += mediaPrimeiro;
            mediaFinal += mediaSegundo;
            mediaFinal += mediaTerceiro;
            mediaFinal += mediaQuarto;

            String mensagemFinal = "";

            mediaFinal = (mediaFinal/4);

            if ((mediaPrimeiro >= 7) && (mediaSegundo >= 7) &&
                    (mediaTerceiro >= 7) && (mediaQuarto >= 7)) {
                mensagemFinal = mediaFinal >= 7? "Aprovado com média final " + formataValorDecimal(mediaFinal) :
                        "Reprovado com média final " + formataValorDecimal(mediaFinal);
            } else {
                mensagemFinal = "Reprovado por matéria com média final " + formataValorDecimal(mediaFinal);
            }
            btnResultado.setText(mensagemFinal);
        }
    }

    private void clearSharedPreferences()
    {
        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);
        SharedPreferences.Editor editor = mediaEscolarPref.edit();
        editor.clear();
        editor.commit();

        clearMenu();

    }

    private void clearMenu()
    {

        btnResultado.setEnabled(false);
        btnQuarto.setEnabled(false);
        btnTerceiro.setEnabled(false);
        btnSegundo.setEnabled(false);
        btnPrimeiro.setEnabled(true);

        btnResultado.setText("Resultado Final");
        btnPrimeiro.setText("1º Bimestre");
        btnSegundo.setText("2º Bimestre");
        btnTerceiro.setText("3º Bimestre");
        btnQuarto.setText("4º Bimestre");
    }

    public static String formataValorDecimal(Double valor){
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }
}

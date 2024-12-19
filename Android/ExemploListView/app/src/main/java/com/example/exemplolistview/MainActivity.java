package com.example.exemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    //Preparar os itens da liste em um array

    static final String[] cidade = new String[]{
            "São Paulo - SP",
            "Rio de Janeiro - RJ",
            "Porto Alegre - RS",
            "Campo Grande - MS",
            "Brasilia - DF",
            "Cuiabá - MT",
            "Campinas - ST",
            "Goiania - GO",
            "Passo Fundo - RS",
            "Belo Horizonte - MG",
            "Manaus - AM",
            "Fortaleza - CE",
            "Natal - RN",
            "Vitória - ES",
            "Curitiba - PR"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remover o Layout Default pois foi criado um layout no ListAdapter
        //setContentView(R.layout.activity_main);

        //Primeiro Passo - Adapter
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, cidade));

        //Segundo Passo - Setar a lista ao layout
        ListView cidadeListView = getListView();

        //Pegar o Click
        cidadeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Cidade: " + cidade[position], Toast.LENGTH_LONG).show();

            }
        });
    }
}

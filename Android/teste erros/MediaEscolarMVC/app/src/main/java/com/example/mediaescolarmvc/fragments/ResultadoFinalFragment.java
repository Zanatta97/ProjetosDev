package com.example.mediaescolarmvc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.mediaescolarmvc.R;
import com.example.mediaescolarmvc.adapter.ResultadoFinalListAdapter;
import com.example.mediaescolarmvc.controller.MediaEscolarController;
import com.example.mediaescolarmvc.model.MediaEscolar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class ResultadoFinalFragment extends Fragment {

    //Adapter
    //dataSet com os dados

    ArrayList<MediaEscolar> dataSet;

    //ListView para apresentar os dados

    ListView listView;
    //Controller para buscar os dados no DB

    MediaEscolarController controller;
    //Novo método na Controller getResultadoFinal devolvendo um ArrayList
    //Efeito de Animação da Lista


    View view;

    //final ResultadoFinalListAdapter adapter = new ResultadoFinalListAdapter(dataSet, getContext());

    public ResultadoFinalFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_resultado_final, container, false);

        controller = new MediaEscolarController(getContext());

        listView = view.findViewById(R.id.listView);

        dataSet = controller.getAllResultadoFinal();

        final ResultadoFinalListAdapter adapter = new ResultadoFinalListAdapter(dataSet, getContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MediaEscolar mediaEscolar = dataSet.get(position);

                Snackbar.make(view, mediaEscolar.getMateria() + "\n" + mediaEscolar.getSituacao() +
                        " Média Final: " + mediaEscolar.getMediaFinal(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();

                //Atualiza a lista se clicar no item
                dataSet = controller.getAllResultadoFinal();
                adapter.atualizarLista(dataSet);
            }
        });

        return view;
    }

}

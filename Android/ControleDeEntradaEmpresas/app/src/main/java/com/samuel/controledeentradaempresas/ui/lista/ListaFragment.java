package com.samuel.controledeentradaempresas.ui.lista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.adapter.ReservasAdapter;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.model.Reserva;

import java.util.ArrayList;

public class ListaFragment extends Fragment {


    //Adapter
    //dataSet com os dados

    ArrayList<Reserva> dataSet;

    //ListView para apresentar os dados

    ListView listView;
    //Controller para buscar os dados no DB

    ReservaController controller;
    //Novo método na Controller getResultadoFinal devolvendo um ArrayList
    //Efeito de Animação da Lista


    View view;

    //private ListaViewModel listaViewModel;

    public ListaFragment(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_lista, container, false);

        controller = new ReservaController(getContext());

        listView = view.findViewById(R.id.listView);

        dataSet = controller.getAllReservas();

        final ReservasAdapter adapter = new ReservasAdapter(dataSet, getContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Reserva reserva = dataSet.get(position);

                Snackbar.make(view, reserva.getNomeClliente() + ", " + reserva.getQtdPessoas() + " pessoas" +
                        "\nStatus: " + reserva.getStatus(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();

                //Atualiza a lista se clicar no item
                dataSet = controller.getAllReservas();
                adapter.atualizarLista(dataSet);
            }
        });

        return view;
    }

    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listaViewModel =
                ViewModelProviders.of(this).get(ListaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lista, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        listaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }*/
}
package com.methasystems.pedidosandroidmethasystems.ui.clientes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.adapter.ClientesAdapter;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;

import java.util.List;

public class ClientesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ClientesAdapter adapter;
    private ProgressBar progressBar;
    private ClientesViewModel clientesViewModel;
    private EditText editPesquisa;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel =
                new ViewModelProvider(this).get(ClientesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clientes, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        progressBar = root.findViewById(R.id.progress_bar);

        initRecyclerView();

        /*adapter = new ClientesAdapter(this.getContext(), clientesViewModel.getCliente().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);*/

        //final TextView textView = root.findViewById(R.id.text_slideshow);
        clientesViewModel.getCliente().observe(getViewLifecycleOwner(), new Observer<List<Cliente>>() {
            @Override
            public void onChanged(@Nullable List<Cliente> clientes) {
                adapter.notifyDataSetChanged();
            }
        });

        clientesViewModel.getisUpdating().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    mostrarProgressBar();
                } else {
                    esconderProgressBar();
                }
            }
        });

        editPesquisa = root.findViewById(R.id.edit_pesquisar_cliente);
        editPesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //String filtro = editPesquisa.getText().toString().toLowerCase();
                adapter.getFilter().filter(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }

    private void initRecyclerView(){
        adapter = new ClientesAdapter(this.getContext(), clientesViewModel.getCliente().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void mostrarProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void esconderProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}
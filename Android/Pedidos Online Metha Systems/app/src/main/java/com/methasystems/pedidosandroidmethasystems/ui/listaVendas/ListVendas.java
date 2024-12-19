package com.methasystems.pedidosandroidmethasystems.ui.listaVendas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.adapter.ProdutosAdapter;
import com.methasystems.pedidosandroidmethasystems.adapter.VendasAdapter;
import com.methasystems.pedidosandroidmethasystems.model.Venda;

import java.util.List;

public class ListVendas extends Fragment {

    private ListVendasViewModel listVendasViewModel;
    private VendasAdapter adapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    public static ListVendas newInstance() {
        return new ListVendas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        listVendasViewModel = new ViewModelProvider(this).get(ListVendasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list_vendas, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_vendas);
        progressBar = root.findViewById(R.id.progress_bar_vendas);

        initRecyclerView();

        listVendasViewModel.getVendas().observe(getViewLifecycleOwner(), new Observer<List<Venda>>() {
            @Override
            public void onChanged(List<Venda> vendas) {
                adapter.notifyDataSetChanged();
            }
        });

        listVendasViewModel.getIsUpdating().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    mostrarProgressBar();
                } else {
                    esconderProgressBar();
                }
            }
        });

        return root;
    }

    private void initRecyclerView(){
        adapter = new VendasAdapter(this.getContext(), listVendasViewModel.getVendas().getValue(), getParentFragmentManager());
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
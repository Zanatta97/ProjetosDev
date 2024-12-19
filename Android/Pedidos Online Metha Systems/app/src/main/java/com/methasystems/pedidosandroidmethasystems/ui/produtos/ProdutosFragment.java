package com.methasystems.pedidosandroidmethasystems.ui.produtos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.adapter.ClientesAdapter;
import com.methasystems.pedidosandroidmethasystems.adapter.ProdutosAdapter;
import com.methasystems.pedidosandroidmethasystems.model.Produto;

import java.util.List;

public class ProdutosFragment extends Fragment {

    private ProdutosViewModel produtosViewModel;
    private ProdutosAdapter adapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private EditText editPesquisa;

    public static ProdutosFragment newInstance() {
        return new ProdutosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        produtosViewModel = new ViewModelProvider(this).get(ProdutosViewModel.class);
        View root = inflater.inflate(R.layout.produtos_fragment, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_produtos);
        progressBar = root.findViewById(R.id.progress_bar_produtos);

        initRecyclerView();

        produtosViewModel.getProduto().observe(getViewLifecycleOwner(), new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                adapter.notifyDataSetChanged();
            }
        });

        produtosViewModel.getIsUpdating().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    mostrarProgressBar();
                } else {
                    esconderProgressBar();
                }
            }
        });

        editPesquisa = root.findViewById(R.id.edit_pesquisar_produto);
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
        adapter = new ProdutosAdapter(this.getContext(), produtosViewModel.getProduto().getValue());
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
package com.methasystems.pedidosandroidmethasystems.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.methasystems.pedidosandroidmethasystems.MainActivity;
import com.methasystems.pedidosandroidmethasystems.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = getContext();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final Button btnEscuro = root.findViewById(R.id.btnEscuro);

        btnEscuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeViewModel.changeText("Testando alterações no MutableLiveData");
                homeViewModel.receberRemessa(context, root);

                //Snackbar.make(v, "Este botão não funciona por que o programador é burro e não sabe como fazer para trocar para um tema escuro", Snackbar.LENGTH_LONG)
                 //       .setAction("action", null).show();
            }
        });
        return root;
    }
}
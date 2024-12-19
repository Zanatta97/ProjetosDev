package com.samuel.controledeentradaempresas.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;
import com.samuel.controledeentradaempresas.MainActivity;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.controller.ClienteController;
import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.ui.adicionarAFila.AdicionarViewModel;
import com.samuel.controledeentradaempresas.ui.lista.ListaFragment;
import com.samuel.controledeentradaempresas.util.GetClienteAsyncTask;
import com.samuel.controledeentradaempresas.util.IncluirReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.MaskEditUtil;
import com.samuel.controledeentradaempresas.util.SincronizarReservasAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Empresa empresa;
    EmpresaController controller;
    private static TextView txtCountReservas, txtProximaReserva;
    private Button btnFila, btnNovaReserva;


    private Context context;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        txtCountReservas = view.findViewById(R.id.txtCountReservas);
        txtProximaReserva = view.findViewById(R.id.txtProximaReserva);
        btnFila = view.findViewById(R.id.btnFila);
        btnNovaReserva = view.findViewById(R.id.btnNovaReserva);

        controller = new EmpresaController(getContext());

        btnFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                empresa = controller.getEmpresa(UtilAplicativo.emailEmpresa);

                SincronizarReservasAsyncTask task = new SincronizarReservasAsyncTask(context, empresa);
                task.execute();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                        navController.navigate(R.id.nav_lista);
                    }
                }, 1000);

                /*NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_lista);*/
            }
        });

        btnNovaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_reserva);
                //UtilAplicativo.showMessageToast(context, "Teste botão 2");
            }
        });

        return view;
    }

/*    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }*/

    public static void updateTxtCountReservas(String string){
        txtCountReservas.setText(string);
    }

    public static void updateTxtProximaReserva(String nome, String qtd){
        String string = "Próximo da fila\nNome: " + nome + "\nPara " + qtd + " pessoas";
        txtProximaReserva.setText(string);
    }

}
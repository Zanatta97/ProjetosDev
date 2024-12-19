package com.samuel.controledeentradaempresas.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.util.AlterarReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.DeletarReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class ReservasAntigasAdapter extends ArrayAdapter<Reserva> implements View.OnClickListener {

    Context context;
    private int ultimaPosicao;

    //Cria um constutor global para os alerts
    AlertDialog.Builder builder;

    //Criar uma classe global para os alerts
    AlertDialog alert;

    ArrayList<Reserva> dados;
    Reserva reserva;
    ReservaController controller;
    ViewHolder linha;

    //Cria um ViewHolder para poder instanciar os componentes da view
    private static class ViewHolder {
        TextView txtNomeAntigas, txtPessoasAntigas, txtHoraAntigas, txtStatusAntigas;
        ImageView imgLogoAntigas;
        Button btnReativarAntigas;


    }

    //Cria a lista com os dados do Banco de dados
    public ReservasAntigasAdapter(ArrayList<Reserva> dataSet, Context context) {
        super(context, R.layout.listwiev_reservas_antigas, dataSet);

        this.dados = dataSet;

        this.context = context;
    }

    //Atualiza os dados da lista
    public void atualizarLista(ArrayList<Reserva> dadosNovos) {
        this.dados.clear();
        this.dados.addAll(dadosNovos);

        notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void onClick(View view) {
        int posicao = (Integer) view.getTag();

        Object object = getItem(posicao);

        reserva = (Reserva) object;

        controller = new ReservaController(getContext());

        switch (view.getId()) {
            case R.id.imgLogoAntigas:

                //Apresentar os dados detalhados
                String timestampReserva = new SimpleDateFormat("dd/MM/YY HH:mm").format(reserva.getHoraReserva());

                //Cria um AlertDialog para exibir os dados do item selecionado
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("CONSULTA");
                builder.setMessage("Nome Cliente: " + reserva.getNomeClliente() + "\nQuantidade Pessoas: " + reserva.getQtdPessoas() +
                        "\nTelefone Cliente: " + reserva.getTelefoneCliente() + "\n\nHora da Reserva: " + timestampReserva +
                        "\nStatus Reserva: " + reserva.getStatus());
                builder.setCancelable(true);
                builder.setIcon(R.drawable.ic_menu_reserva);

                builder.setPositiveButton("VOLTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();
                //dados = controller.getAllResultadoFinal();
                //atualizarLista(dados);

                break;

            //Define o que ocorre no clique no botão Consultar
            case R.id.btnReativarAntigas:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja realmente REATIVAR esta reserva?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {

                            reserva.setStatus(UtilAplicativo.statusReservaAguardando);

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
                            String format = simpleDateFormat.format(new Date());
                            reserva.setHoraReserva(Timestamp.valueOf(format));
                            //Faz o update no BD com o objeto
                            controller.alterar(reserva);

                            AlterarReservaAsyncTask task = new AlterarReservaAsyncTask(reserva, context);
                            task.execute();


                        } catch (Exception e){
                            Log.e("Adapter", "Erro: " + e.getMessage());
                        }
                        //Atualiza a lista exibida na tela
                        atualizarLista(controller.getAllReservas());
                    }
                });
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();

                break;

        }
    }


    //Cria o layout para cada item da lista
    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent) {

        reserva = getItem(position);

        controller = new ReservaController(getContext());

        //ViewHolder linha;

        if (dataSet == null) {
            linha = new ViewHolder();

            LayoutInflater layoutResultadoFinalList = LayoutInflater.from(getContext());

            dataSet = layoutResultadoFinalList.inflate(R.layout.listwiev_reservas_antigas, parent, false);

            linha.txtNomeAntigas = dataSet.findViewById(R.id.txtNomeAntigas);
            linha.txtPessoasAntigas = dataSet.findViewById(R.id.txtPessoasAntigas);
            linha.txtHoraAntigas = dataSet.findViewById(R.id.txtHoraAntigas);
            linha.txtStatusAntigas = dataSet.findViewById(R.id.txtStatusAntigas);
            linha.imgLogoAntigas = dataSet.findViewById(R.id.imgLogoAntigas);
            linha.btnReativarAntigas = dataSet.findViewById(R.id.btnReativarAntigas);


            dataSet.setTag(linha);

        } else {
            linha = (ViewHolder) dataSet.getTag();
        }

        String horaReserva = new SimpleDateFormat("HH:mm").format(reserva.getHoraReserva());

        if (UtilAplicativo.getScreenResolution(context) < 720){
            linha.txtNomeAntigas.setTextSize(16);
        } else {
            linha.txtNomeAntigas.setTextSize(20);
        }

        linha.txtNomeAntigas.setText(reserva.getNomeClliente());
        linha.txtPessoasAntigas.setText(reserva.getQtdPessoas() + " Pessoas");
        linha.txtHoraAntigas.setText(horaReserva);
        linha.txtStatusAntigas.setText(String.valueOf(reserva.getStatus()));

        //Define a cor do Label da média na view
        String cor = controller.corStatus(reserva.getStatus());
        linha.txtStatusAntigas.setTextColor(Color.parseColor(cor));

        linha.imgLogoAntigas.setOnClickListener(this);
        linha.imgLogoAntigas.setTag(position);

        if(linha.txtStatusAntigas.getText().toString().equals(UtilAplicativo.statusReservaEntrou)){
            linha.btnReativarAntigas.setEnabled(false);
            //linha.btnReativarAntigas.setVisibility(View.INVISIBLE);
        } else {
            linha.btnReativarAntigas.setEnabled(true);
            //linha.btnReativarAntigas.setVisibility(View.VISIBLE);
        }

        linha.btnReativarAntigas.setOnClickListener(this);
        linha.btnReativarAntigas.setTag(position);

        return dataSet;
    }
}

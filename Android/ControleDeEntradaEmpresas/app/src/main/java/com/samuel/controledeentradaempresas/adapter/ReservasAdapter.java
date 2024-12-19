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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.util.AlterarReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.DeletarReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.net.URLEncoder;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReservasAdapter extends ArrayAdapter<Reserva> implements View.OnClickListener {

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
        TextView txtNome, txtPessoas, txtHora, txtStatus;
        ImageView imgLogo;
        ImageView imgConsultar;
        ImageView imgDeletar;
        ImageView imgSalvar;
        ImageView imgEditar;
        ImageView imgCorreto;

    }

    //Cria a lista com os dados do Banco de dados
    public ReservasAdapter(ArrayList<Reserva> dataSet, Context context) {
        super(context, R.layout.listwiev_reservas, dataSet);

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
            case R.id.imgLogo:

                //Apresentar os dados detalhados

                Snackbar.make(view, "Nome Cliente: " + reserva.getNomeClliente() + "\nQuantidade Pessoas:" + reserva.getQtdPessoas(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();

                //dados = controller.getAllResultadoFinal();
                //atualizarLista(dados);

                break;

            //Define o que ocorre no clique no botão Consultar
            case R.id.imgConsultar:

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

                break;

            //Define o que ocorre no clique no botão Salvar
            case R.id.imgSalvar:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja realmente CHAMAR esta reserva?");
                builder.setCancelable(true);
                builder.setIcon(R.drawable.ic_menu_reserva);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        PackageManager packageManager = context.getPackageManager();
                        Intent i = new Intent(Intent.ACTION_VIEW);

                        String message = "Teste";
                        String phone = "55" + reserva.getTelefoneCliente().replaceAll("[()-]", "");

                        /*try {
                            String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                            i.setPackage("com.whatsapp");
                            i.setData(Uri.parse(url));
                        } catch (Exception e){
                            e.printStackTrace();
                        }*/

                        switch (reserva.getStatus()){
                            case UtilAplicativo.statusReservaAguardando:

                                message = "*ATENÇÃO "+ reserva.getNomeClliente() + "*\n\nSua mesa para " +
                                        reserva.getQtdPessoas() + " pessoas está pronta!\n\nFavor se direcionar à porta do estabalecimento\n\n" +
                                        "*Caso não atenda ao chamado sua posição na fila será CANCELADA*";

                                try {
                                    String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                                    i.setPackage("com.whatsapp");
                                    i.setData(Uri.parse(url));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                                if (i.resolveActivity(packageManager) != null) {
                                    reserva.setStatus(UtilAplicativo.statusReservaChamado1);

                                    AlterarReservaAsyncTask alterarTask1 = new AlterarReservaAsyncTask(reserva, context);
                                    alterarTask1.execute();

                                    controller.alterar(reserva);
                                    atualizarLista(controller.getAllReservas());


                                    context.startActivity(i);
                                }
                                else {
                                    UtilAplicativo.showMessageToast(context, "Whatsapp não instalado");
                                }
                                break;

                            case UtilAplicativo.statusReservaChamado1:

                                message = "*SEGUNDO CHAMADO*\n\n"+ reserva.getNomeClliente() + "\nSua mesa para " +
                                        reserva.getQtdPessoas() + " pessoas está pronta!\n\nFavor se direcionar à porta do estabalecimento\n\n" +
                                        "*Caso não atenda ao chamado sua posição na fila será CANCELADA*";

                                try {
                                    String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                                    i.setPackage("com.whatsapp");
                                    i.setData(Uri.parse(url));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                                if (i.resolveActivity(packageManager) != null) {
                                    reserva.setStatus(UtilAplicativo.statusReservaChamado2);

                                    AlterarReservaAsyncTask alterarTask2 = new AlterarReservaAsyncTask(reserva, context);
                                    alterarTask2.execute();

                                    controller.alterar(reserva);
                                    atualizarLista(controller.getAllReservas());

                                    context.startActivity(i);
                                }
                                else {
                                    UtilAplicativo.showMessageToast(context, "Whatsapp não instalado");
                                }
                                break;

                            case UtilAplicativo.statusReservaChamado2:

                                message = "*ÚLTIMO CHAMADO*\n\n"+ reserva.getNomeClliente() + "\nSua mesa para " +
                                        reserva.getQtdPessoas() + " pessoas está pronta!\n\nFavor se direcionar à porta do estabalecimento\n\n" +
                                        "*Caso não atenda ao chamado sua posição na fila será CANCELADA*";

                                try {
                                    String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                                    i.setPackage("com.whatsapp");
                                    i.setData(Uri.parse(url));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                                if (i.resolveActivity(packageManager) != null) {
                                    reserva.setStatus(UtilAplicativo.statusReservaChamado3);

                                    AlterarReservaAsyncTask alterarTask3 = new AlterarReservaAsyncTask(reserva, context);
                                    alterarTask3.execute();

                                    controller.alterar(reserva);
                                    atualizarLista(controller.getAllReservas());

                                    context.startActivity(i);
                                }
                                else {
                                    UtilAplicativo.showMessageToast(context, "Whatsapp não instalado");
                                }
                                break;

                            case UtilAplicativo.statusReservaChamado3:

                                message = reserva.getNomeClliente() + "\n\nDevido a falta de resposta sua reserva foi CANCELADA\n\n" +
                                        "Você poderá entrar na fila novamente através do aplicativo ou com o atendende na porta do estabelecimemto";

                                try {
                                    String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                                    i.setPackage("com.whatsapp");
                                    i.setData(Uri.parse(url));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                                reserva.setStatus(UtilAplicativo.statusReservaCancelada);

                                AlterarReservaAsyncTask alterarTaskCancelada = new AlterarReservaAsyncTask(reserva, context);
                                alterarTaskCancelada.execute();

                                controller.deletarReserva(reserva);
                                atualizarLista(controller.getAllReservas());

                                if (i.resolveActivity(packageManager) != null) {

                                    context.startActivity(i);
                                }
                                else {
                                    UtilAplicativo.showMessageToast(context, "Whatsapp não instalado");
                                }
                                break;
                        }
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

            //Define o que ocorre no clique no botão Deletar
            case R.id.imgDeletar:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja realmente DELETAR esta reserva?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {
                            //Deleta o dado no Banco de Dados
                            controller.deletarReserva(reserva);

                            DeletarReservaAsyncTask task = new DeletarReservaAsyncTask(reserva, context);
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

            //Define o que ocorre no clique no botão Editar
            case R.id.imgEditar:

                //Instancia uma view para o alertView
                View alertView = view.inflate(getContext(), R.layout.alert_dialog_editar_reserva, null);

                //Objeto para ser usado dentro do método
                final Reserva reserva1 = reserva;


                final EditText editPessoas = alertView.findViewById(R.id.editPessoas);

                //Define os valores iniciais dos editTexts para os valores do item selecionado
                editPessoas.setText(String.valueOf(reserva1.getQtdPessoas()));

                //Cria o Alert
                AlertDialog.Builder alertBox = new AlertDialog.Builder(alertView.getRootView().getContext());
                alertBox.setMessage(reserva1.getNomeClliente());
                alertBox.setTitle("EDITANDO");

                //Define a view para o Alert
                alertBox.setView(alertView);

                alertBox.setNeutralButton("SALVAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Passa os dados dos editTexts para o objeto
                        reserva1.setQtdPessoas(Integer.valueOf(editPessoas.getText().toString()));

                        try {
                            //Faz o update no BD com o objeto
                            controller.alterar(reserva1);

                            AlterarReservaAsyncTask task = new AlterarReservaAsyncTask(reserva1, context);
                            task.execute();

                        } catch (Exception e) {
                            Log.e("Adapter", "Erro: " + e.getMessage());
                        }

                        //Atualiza a lista na tela
                        atualizarLista(controller.getAllReservas());


                    }
                });

                alertBox.show();

                break;

            case R.id.imgCorreto:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Confirmar ENTRADA desta pessoa?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {
                            reserva.setStatus(UtilAplicativo.statusReservaEntrou);

                            AlterarReservaAsyncTask alterarTask3 = new AlterarReservaAsyncTask(reserva, context);
                            alterarTask3.execute();

                            controller.alterar(reserva);
                            //atualizarLista(controller.getAllReservas());

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

            dataSet = layoutResultadoFinalList.inflate(R.layout.listwiev_reservas, parent, false);

            linha.txtNome = dataSet.findViewById(R.id.txtNome);
            linha.txtPessoas = dataSet.findViewById(R.id.txtPessoas);
            linha.txtHora = dataSet.findViewById(R.id.txtHora);
            linha.txtStatus = dataSet.findViewById(R.id.txtStatus);
            linha.imgLogo = dataSet.findViewById(R.id.imgLogo);
            linha.imgConsultar = dataSet.findViewById(R.id.imgConsultar);
            linha.imgDeletar = dataSet.findViewById(R.id.imgDeletar);
            linha.imgSalvar = dataSet.findViewById(R.id.imgSalvar);
            linha.imgEditar = dataSet.findViewById(R.id.imgEditar);
            linha.imgCorreto = dataSet.findViewById(R.id.imgCorreto);

            dataSet.setTag(linha);

        } else {
            linha = (ViewHolder) dataSet.getTag();
        }

        if (UtilAplicativo.getScreenResolution(context) < 720){
            linha.txtNome.setTextSize(16);
        } else {
            linha.txtNome.setTextSize(20);
        }

        String horaReserva = new SimpleDateFormat("HH:mm").format(reserva.getHoraReserva());

        linha.txtNome.setText(reserva.getNomeClliente());
        linha.txtPessoas.setText(reserva.getQtdPessoas() + " Pessoas");
        linha.txtHora.setText(horaReserva);
        linha.txtStatus.setText(String.valueOf(reserva.getStatus()));

        //Define a cor do Label da média na view
        String cor = controller.corStatus(reserva.getStatus());
        linha.txtStatus.setTextColor(Color.parseColor(cor));

        linha.imgLogo.setOnClickListener(this);
        linha.imgLogo.setTag(position);

        linha.imgSalvar.setOnClickListener(this);
        linha.imgSalvar.setTag(position);

        linha.imgConsultar.setOnClickListener(this);
        linha.imgConsultar.setTag(position);

        linha.imgEditar.setOnClickListener(this);
        linha.imgEditar.setTag(position);

        linha.imgDeletar.setOnClickListener(this);
        linha.imgDeletar.setTag(position);

        linha.imgCorreto.setOnClickListener(this);
        linha.imgCorreto.setTag(position);

        return dataSet;
    }
}

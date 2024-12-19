package com.samuel.controledeentradaempresas.ui.adicionarAFila;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.samuel.controledeentradaempresas.LoginActivity;
import com.samuel.controledeentradaempresas.MainActivity;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.controller.ClienteController;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.util.AlterarReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.GetClienteAsyncTask;
import com.samuel.controledeentradaempresas.util.IncluirReservaAsyncTask;
import com.samuel.controledeentradaempresas.util.MaskEditUtil;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AdicionarFragment extends Fragment {

    private AdicionarViewModel adicionarViewModel;

    private ClienteController controller;
    private ReservaController reservaController;

    private Context context;

    private Cliente cliente;
    private Reserva reserva;
    private Empresa empresa;

    private View view;

    CheckBox checkBoxAdd;
    EditText editEmailAdd, editNomeAdd, editQtdAdd, editTelefoneAdd;
    Button btnSalvarAdd, btnProcurar;
    TextView txtEmailClienteAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        controller = new ClienteController(context);
        reservaController = new ReservaController(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_adicionar, container, false);

        checkBoxAdd = view.findViewById(R.id.checkBoxAdd);

        String emailEmpresa = UtilAplicativo.emailEmpresa;

        empresa = controller.getEmpresa(emailEmpresa);

        txtEmailClienteAdd = view.findViewById(R.id.txtEmailClienteAdd);

        editEmailAdd = view.findViewById(R.id.editEmailAdd);
        editNomeAdd = view.findViewById(R.id.editNomeAdd);
        editQtdAdd = view.findViewById(R.id.editQtdAdd);
        editTelefoneAdd = view.findViewById(R.id.editTelefoneAdd);

        //Adiciona máscara para os dados digitados
        editTelefoneAdd.addTextChangedListener(MaskEditUtil.mask(editTelefoneAdd, MaskEditUtil.FORMAT_FONE));

        btnSalvarAdd = view.findViewById(R.id.btnSalvarAdd);
        btnProcurar = view.findViewById(R.id.btnProcurar);

        checkBoxAdd.setChecked(false);
        btnProcurar.setVisibility(View.INVISIBLE);
        editEmailAdd.setVisibility(View.INVISIBLE);
        txtEmailClienteAdd.setVisibility(View.INVISIBLE);

        checkBoxAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = checkBoxAdd.isChecked();

                if (checked) {
                    //do things when checked
                    btnProcurar.setVisibility(View.VISIBLE);
                    editEmailAdd.setVisibility(View.VISIBLE);
                    txtEmailClienteAdd.setVisibility(View.VISIBLE);
                } else {
                    btnProcurar.setVisibility(View.INVISIBLE);
                    editEmailAdd.setVisibility(View.INVISIBLE);
                    txtEmailClienteAdd.setVisibility(View.INVISIBLE);
                    //do thins when not checked
                }
            }
        });

        btnProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alertView = view.inflate(getContext(), R.layout.alert_dialog_procurar_cliente, null);

                final EditText editEmailCliente = alertView.findViewById(R.id.editEmailCliente);
                final TextView txtAlertDialogCliente = alertView.findViewById(R.id.txtAlertDialogCliente);
                final Button btnCliente = alertView.findViewById(R.id.btnCliente);
                txtAlertDialogCliente.setText(" ");
                txtAlertDialogCliente.setVisibility(View.INVISIBLE);

                btnCliente.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = editEmailCliente.getText().toString();

                        if (editEmailCliente.getText().toString().length()==0) {
                            editEmailCliente.setError("");
                            editEmailCliente.requestFocus();
                            txtAlertDialogCliente.setText("Favor Informar o Email");
                            txtAlertDialogCliente.setVisibility(View.VISIBLE);
                            //Checa se a senha foi digitada
                        } else {
                            GetClienteAsyncTask task = new GetClienteAsyncTask(context, email);
                            task.execute();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //Checa se o Email está cadastrado
                                    if(controller.getCliente(editEmailCliente.getText().toString()) == null){
                                        editEmailCliente.setError("");
                                        editEmailCliente.requestFocus();
                                        txtAlertDialogCliente.setText("Email inválido ou não cadastrado");
                                        txtAlertDialogCliente.setVisibility(View.VISIBLE);
                                    } else {

                                        //Instancia a classe Cliente para guardar os dados
                                        cliente = controller.getCliente(editEmailCliente.getText().toString());
                                        txtAlertDialogCliente.setText("Cliente: " + cliente.getNome());
                                        txtAlertDialogCliente.setVisibility(View.VISIBLE);
                                    }
                                }
                            },1000);
                        }
                    }
                });

                //Cria o Alert
                final AlertDialog.Builder alertBox = new AlertDialog.Builder(alertView.getRootView().getContext());
                alertBox.setMessage("Pesquisar Cliente por Email");
                alertBox.setTitle("EDITANDO");

                //Define a view para o Alert
                alertBox.setView(alertView);



                alertBox.setNeutralButton("SELECIONAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(cliente != null){

                            editEmailAdd.setText(cliente.getEmail());
                            editNomeAdd.setText(cliente.getNome());
                            editTelefoneAdd.setText(cliente.getTelefone());
                            editQtdAdd.requestFocus();
                        } else {
                            UtilAplicativo.showMessageToast(context, "Cliente não selecionado");
                            btnProcurar.callOnClick();
                        }

                    }
                });

                alertBox.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UtilAplicativo.showMessageToast(context, "Cliente não selecionado");
                    }
                });

                alertBox.show();

            }
        });

        btnSalvarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBoxAdd.isChecked() && editEmailAdd.getText().toString().length()==0) {
                    editEmailAdd.setError("Informe o Email");
                    editEmailAdd.requestFocus();
                } else if (editNomeAdd.getText().toString().length()==0) {
                    editNomeAdd.setError("Informe o Nome");
                    editNomeAdd.requestFocus();
                }  else if (editQtdAdd.getText().toString().length()==0) {
                    editQtdAdd.setError("Informe a Quantidade de Pessoas");
                    editQtdAdd.requestFocus();
                }  else if (editTelefoneAdd.getText().toString().length()==0) {
                    editTelefoneAdd.setError("Informe o Telefone");
                    editTelefoneAdd.requestFocus();
                } else {
                    reserva = new Reserva();
                    if (checkBoxAdd.isChecked()){
                        reserva.setIdCliente(cliente.getIdPk());
                        reserva.setNomeClliente(editNomeAdd.getText().toString());
                        reserva.setIdEmpresa(empresa.getIdPk());
                        reserva.setQtdPessoas(Integer.valueOf(editQtdAdd.getText().toString()));

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
                        String format = simpleDateFormat.format(new Date());
                        reserva.setHoraReserva(Timestamp.valueOf(format));
                        reserva.setTelefoneCliente(editTelefoneAdd.getText().toString());
                        reserva.setStatus(UtilAplicativo.statusReservaAguardando);
                    } else {
                        reserva.setNomeClliente(editNomeAdd.getText().toString());
                        reserva.setIdEmpresa(empresa.getIdPk());
                        reserva.setQtdPessoas(Integer.valueOf(editQtdAdd.getText().toString()));

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
                        String format = simpleDateFormat.format(new Date());
                        reserva.setHoraReserva(Timestamp.valueOf(format));
                        reserva.setTelefoneCliente(editTelefoneAdd.getText().toString());
                        reserva.setStatus(UtilAplicativo.statusReservaAguardando);
                    }



                    if (reservaController.salvar(reserva)){
                        IncluirReservaAsyncTask task = new IncluirReservaAsyncTask(reserva, context);
                        task.execute();

                        editTelefoneAdd.setText("");
                        editQtdAdd.setText("");
                        editNomeAdd.setText("");
                        editEmailAdd.setText("");
                        checkBoxAdd.setChecked(false);
                        btnProcurar.setVisibility(View.INVISIBLE);
                        editEmailAdd.setVisibility(View.INVISIBLE);
                        txtEmailClienteAdd.setVisibility(View.INVISIBLE);
                        UtilAplicativo.showMessageToast(context, "Adicionado com sucesso");
                    } else{
                        UtilAplicativo.showMessageToast(context, "Erro ao adicionar");
                    }
                }

            }
        });

        return view;
    }

/*    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        adicionarViewModel =
                ViewModelProviders.of(this).get(AdicionarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_adicionar, container, false);
        adicionarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }*/
}
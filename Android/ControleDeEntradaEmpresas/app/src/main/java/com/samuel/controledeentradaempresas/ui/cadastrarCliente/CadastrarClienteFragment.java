package com.samuel.controledeentradaempresas.ui.cadastrarCliente;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.samuel.controledeentradaempresas.LoginActivity;
import com.samuel.controledeentradaempresas.MainActivity;
import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.SplashActivity;
import com.samuel.controledeentradaempresas.controller.ClienteController;
import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.ui.home.HomeViewModel;
import com.samuel.controledeentradaempresas.util.GetClienteAsyncTask;
import com.samuel.controledeentradaempresas.util.IncluirClienteAsyncTask;
import com.samuel.controledeentradaempresas.util.MaskEditUtil;
import com.samuel.controledeentradaempresas.util.SincronizarReservasAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

public class CadastrarClienteFragment extends Fragment {

    private Context context;
    private View view;
    private EditText editNomeCliente, editTelefoneCliente, editEmailCliente, editSenhaCliente, editConfirmaCliente;
    private ImageView imgVerSenhaCliente, imgVerConfirmaCliente;
    private Button btnSalvarCliente;
    private Integer senha, confirma;
    private ClienteController controller;
    private Cliente cliente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        controller = new ClienteController(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cadastrar, container, false);

        editNomeCliente = view.findViewById(R.id.editNomeCliente);
        editTelefoneCliente = view.findViewById(R.id.editTelefoneCliente);
        editEmailCliente = view.findViewById(R.id.editEmailCliente);
        editSenhaCliente = view.findViewById(R.id.editSenhaCliente);
        editConfirmaCliente = view.findViewById(R.id.editConfirmaCliente);
        imgVerConfirmaCliente = view.findViewById(R.id.imgVerConfirmaCliente);
        imgVerSenhaCliente = view.findViewById(R.id.imgVerSenhaCliente);
        btnSalvarCliente = view.findViewById(R.id.btnSalvarCliente);

        editTelefoneCliente.addTextChangedListener(MaskEditUtil.mask(editTelefoneCliente, MaskEditUtil.FORMAT_FONE));
        senha = 1;
        confirma = 1;

        editSenhaCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editConfirmaCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());

        imgVerSenhaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senha == 1){
                    editSenhaCliente.setTransformationMethod(null);
                    senha = 0;
                } else {
                    editSenhaCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    senha = 1;
                }
            }
        });

        imgVerConfirmaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (confirma == 1){
                    editConfirmaCliente.setTransformationMethod(null);
                    confirma = 0;
                } else {
                    editConfirmaCliente.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    confirma = 1;
                }
            }
        });

        btnSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editEmailCliente.getText().toString().length() != 0){
                    GetClienteAsyncTask getTask = new GetClienteAsyncTask(context, editEmailCliente.getText().toString());
                    getTask.execute();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (editNomeCliente.getText().toString().length() == 0) {
                            editNomeCliente.setError("Favor Informar o Nome do Cliente");
                            editNomeCliente.requestFocus();
                        } else if (editTelefoneCliente.getText().toString().length() == 0) {
                            editTelefoneCliente.setError("Favor Informar o Telefone do Cliente");
                            editTelefoneCliente.requestFocus();
                        } else if (editEmailCliente.getText().toString().length() == 0) {
                            editEmailCliente.setError("Favor Informar o Email do Cliente");
                            editEmailCliente.requestFocus();
                        } else if (editSenhaCliente.getText().toString().length() == 0) {
                            editSenhaCliente.setError("Favor Digitar uma Senha");
                            editSenhaCliente.requestFocus();
                        } else if (editConfirmaCliente.getText().toString().length() == 0) {
                            editConfirmaCliente.setError("Favor Confirmar a Senha");
                            editConfirmaCliente.requestFocus();
                        } else if (controller.getCliente(editEmailCliente.getText().toString()) != null){
                            editEmailCliente.setError("Email Já Cadastrado");
                            editEmailCliente.requestFocus();
                        } else if (editSenhaCliente.getText().toString().length() < 8){
                            editSenhaCliente.setError("A senha deve ter pelo menos 8 caracteres");
                            editSenhaCliente.requestFocus();
                            editSenhaCliente.setText("");
                        } else if (!editSenhaCliente.getText().toString().equals(editConfirmaCliente.getText().toString())){
                            editSenhaCliente.setError("As Senhas não Combinam");
                            editSenhaCliente.requestFocus();
                            editSenhaCliente.setText("");
                            editConfirmaCliente.setText("");
                        } else {
                            try {
                                cliente = new Cliente();
                                cliente.setNome(editNomeCliente.getText().toString());
                                cliente.setTelefone(editTelefoneCliente.getText().toString());
                                cliente.setEmail(editEmailCliente.getText().toString());
                                cliente.setSenha(editSenhaCliente.getText().toString());
                                cliente.setStatus("Ativo");
                                cliente.setTokenFirebase("abc");

                                controller.salvar(cliente);

                                editNomeCliente.setText("");
                                editTelefoneCliente.setText("");
                                editEmailCliente.setText("");
                                editSenhaCliente.setText("");
                                editConfirmaCliente.setText("");

                                IncluirClienteAsyncTask task = new IncluirClienteAsyncTask(cliente, context);
                                task.execute();

                                UtilAplicativo.showMessageToast(context, "Dados Salvos com Sucesso");
                            } catch (Exception e) {
                                UtilAplicativo.showMessageToast(context, "Erro ao salvar cliente");
                            }
                        }
                    }
                }, 500);

            }
        });

        return view;
    }


/*    private CadastrarClienteViewModel cadastrarClienteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cadastrarClienteViewModel =
                ViewModelProviders.of(this).get(CadastrarClienteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cadastrar, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        cadastrarClienteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }*/
}
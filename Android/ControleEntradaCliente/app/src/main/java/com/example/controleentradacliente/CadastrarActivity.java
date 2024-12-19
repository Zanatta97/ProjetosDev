package com.example.controleentradacliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.controleentradacliente.controller.ClienteController;
import com.example.controleentradacliente.model.Cliente;
import com.example.controleentradacliente.util.GetClienteAsyncTask;
import com.example.controleentradacliente.util.IncluirClienteAsyncTask;
import com.example.controleentradacliente.util.MaskEditUtil;
import com.example.controleentradacliente.util.UtilAplicativo;

public class CadastrarActivity extends AppCompatActivity {

    private Context context;
    private View view;
    private EditText editNomeCliente, editTelefoneCliente, editEmailCliente, editSenhaCliente, editConfirmaCliente;
    private ImageView imgVerSenhaCliente, imgVerConfirmaCliente;
    private Button btnSalvarCliente;
    private Integer senha, confirma;
    private ClienteController controller;
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        context = getBaseContext();
        controller = new ClienteController(context);

        editNomeCliente = findViewById(R.id.editNomeCliente);
        editTelefoneCliente = findViewById(R.id.editTelefoneCliente);
        editEmailCliente = findViewById(R.id.editEmailCliente);
        editSenhaCliente = findViewById(R.id.editSenhaCliente);
        editConfirmaCliente = findViewById(R.id.editConfirmaCliente);
        imgVerConfirmaCliente = findViewById(R.id.imgVerConfirmaCliente);
        imgVerSenhaCliente = findViewById(R.id.imgVerSenhaCliente);
        btnSalvarCliente = findViewById(R.id.btnSalvarCliente);

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

                                finish();
                            } catch (Exception e) {
                                UtilAplicativo.showMessageToast(context, "Erro ao salvar cliente");
                            }
                        }
                    }
                }, 500);

            }
        });
    }
}

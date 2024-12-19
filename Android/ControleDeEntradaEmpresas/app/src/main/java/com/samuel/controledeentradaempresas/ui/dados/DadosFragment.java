package com.samuel.controledeentradaempresas.ui.dados;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.samuel.controledeentradaempresas.R;
import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.util.AlterarEmpresaAsyncTask;
import com.samuel.controledeentradaempresas.util.MaskEditUtil;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.sql.Time;

public class DadosFragment extends Fragment {

    private EmpresaController controller;

    private Context context;

    private Empresa empresa;

    private View view;

    private EditText editNome, editCnpj, editEndereco, editNumero, editComplemento, editBairro, editCidade, editUf, editCep, editDescricao;
    private EditText editHoraAberturaSegunda, editHoraFechamentoSegunda;
    private EditText editHoraAberturaTerca, editHoraFechamentoTerca;
    private EditText editHoraAberturaQuarta, editHoraFechamentoQuarta;
    private EditText editHoraAberturaQuinta, editHoraFechamentoQuinta;
    private EditText editHoraAberturaSexta, editHoraFechamentoSexta;
    private EditText editHoraAberturaSabado, editHoraFechamentoSabado;
    private EditText editHoraAberturaDomingo, editHoraFechamentoDomingo;
    private EditText editEmail, editSenha;

    private Button btnSalvar, btnSenha;

    private Integer senha, senhaAtual, senhaNova, senhaConfirma;

    public DadosFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        controller = new EmpresaController(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dados, container, false);

        btnSalvar = view.findViewById(R.id.btnSalvar);
        btnSenha = view.findViewById(R.id.btnSenha);

        editNome = view.findViewById(R.id.editNomeDados);
        editCnpj = view.findViewById(R.id.editCnpjDados);
        editEndereco = view.findViewById(R.id.editEnderecoDados);
        editNumero = view.findViewById(R.id.editNumeroDados);
        editComplemento = view.findViewById(R.id.editComplementoDados);
        editBairro = view.findViewById(R.id.editBairroDados);
        editCidade = view.findViewById(R.id.editCidadeDados);
        editUf = view.findViewById(R.id.editUfDados);
        editCep = view.findViewById(R.id.editCepDados);
        editDescricao = view.findViewById(R.id.editDescricaoDados);
        editHoraAberturaSegunda = view.findViewById(R.id.editAberturaSegundaDados);
        editHoraFechamentoSegunda = view.findViewById(R.id.editFechamentoSegundaDados);
        editHoraAberturaTerca = view.findViewById(R.id.editAberturaTercaDados);
        editHoraFechamentoTerca = view.findViewById(R.id.editFechamentoTercaDados);
        editHoraAberturaQuarta = view.findViewById(R.id.editAberturaQuartaDados);
        editHoraFechamentoQuarta = view.findViewById(R.id.editFechamentoQuartaDados);
        editHoraAberturaQuinta = view.findViewById(R.id.editAberturaQuintaDados);
        editHoraFechamentoQuinta = view.findViewById(R.id.editFechamentoQuintaDados);
        editHoraAberturaSexta = view.findViewById(R.id.editAberturaSextaDados);
        editHoraFechamentoSexta = view.findViewById(R.id.editFechamentoSextaDados);
        editHoraAberturaSabado = view.findViewById(R.id.editAberturaSabadoDados);
        editHoraFechamentoSabado = view.findViewById(R.id.editFechamentoSabadoDados);
        editHoraAberturaDomingo = view.findViewById(R.id.editAberturaDomingoDados);
        editHoraFechamentoDomingo = view.findViewById(R.id.editFechamentoDomingoDados);
        editEmail = view.findViewById(R.id.editEmailDados);
        editSenha = view.findViewById(R.id.editSenhaDados);
        senha = 1;



        //Adiciona máscara para os dados digitados
        editCnpj.addTextChangedListener(MaskEditUtil.mask(editCnpj, MaskEditUtil.FORMAT_CNPJ));
        editCep.addTextChangedListener(MaskEditUtil.mask(editCep, MaskEditUtil.FORMAT_CEP));
        editHoraAberturaSegunda.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaSegunda, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoSegunda.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoSegunda, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaTerca.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaTerca, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoTerca.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoTerca, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaQuarta.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaQuarta, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoQuarta.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoQuarta, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaQuinta.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaQuinta, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoQuinta.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoQuinta, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaSexta.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaSexta, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoSexta.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoSexta, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaSabado.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaSabado, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoSabado.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoSabado, MaskEditUtil.FORMAT_HOUR));
        editHoraAberturaDomingo.addTextChangedListener(MaskEditUtil.mask(editHoraAberturaDomingo, MaskEditUtil.FORMAT_HOUR));
        editHoraFechamentoDomingo.addTextChangedListener(MaskEditUtil.mask(editHoraFechamentoDomingo, MaskEditUtil.FORMAT_HOUR));


        empresa = controller.getEmpresa(UtilAplicativo.emailEmpresa);

        editNome.setText(empresa.getNome());
        editCnpj.setText(empresa.getCnpj());
        editEndereco.setText(empresa.getEndereco());
        editNumero.setText(String.valueOf(empresa.getNumero()));
        editComplemento.setText(empresa.getComplemento());
        editBairro.setText(empresa.getBairro());
        editCidade.setText(empresa.getCidade());
        editUf.setText(empresa.getUf());
        editCep.setText(empresa.getCep());
        editDescricao.setText(empresa.getDescricao());
        editHoraAberturaSegunda.setText(empresa.getHoraAberturaSegunda().toString());
        editHoraFechamentoSegunda.setText(empresa.getHoraFechamentoSegunda().toString());
        editHoraAberturaTerca.setText(empresa.getHoraAberturaTerca().toString());
        editHoraFechamentoTerca.setText(empresa.getHoraFechamentoTerca().toString());
        editHoraAberturaQuarta.setText(empresa.getHoraAberturaQuarta().toString());
        editHoraFechamentoQuarta.setText(empresa.getHoraFechamentoQuarta().toString());
        editHoraAberturaQuinta.setText(empresa.getHoraAberturaQuinta().toString());
        editHoraFechamentoQuinta.setText(empresa.getHoraFechamentoQuinta().toString());
        editHoraAberturaSexta.setText(empresa.getHoraAberturaSexta().toString());
        editHoraFechamentoSexta.setText(empresa.getHoraFechamentoSexta().toString());
        editHoraAberturaSabado.setText(empresa.getHoraAberturaSabado().toString());
        editHoraFechamentoSabado.setText(empresa.getHoraFechamentoSabado().toString());
        editHoraAberturaDomingo.setText(empresa.getHoraAberturaDomingo().toString());
        editHoraFechamentoDomingo.setText(empresa.getHoraFechamentoDomingo().toString());
        editEmail.setText(empresa.getEmail());
        editSenha.setText(empresa.getSenha());
        editSenha.setEnabled(false);
        editNome.setEnabled(false);
        editCnpj.setEnabled(false);

        btnSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UtilAplicativo.showMessageToast(context, "Alterar Senha");
                View alertView = view.inflate(getContext(), R.layout.alert_dialog_alterar_senha, null);

                final EditText editSenhaAtual = alertView.findViewById(R.id.editSenhaAtual);
                final EditText editSenhaNova = alertView.findViewById(R.id.editSenhaNova);
                final EditText editSenhaConfirma = alertView.findViewById(R.id.editSenhaConfirma);
                final TextView txtAlertDialogSenha = alertView.findViewById(R.id.txtAlertDialogSenha);
                final ImageView imgVerSenhaAtual = alertView.findViewById(R.id.imgVerSenhaAtual);
                final ImageView imgVerSenhaNova = alertView.findViewById(R.id.imgVerSenhaNova);
                final ImageView imgVerSenhaConfirma = alertView.findViewById(R.id.imgVerSenhaConfirma);
                txtAlertDialogSenha.setText(" ");
                txtAlertDialogSenha.setVisibility(View.INVISIBLE);
                editSenhaAtual.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editSenhaNova.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editSenhaConfirma.setTransformationMethod(PasswordTransformationMethod.getInstance());
                senhaAtual = 1;
                senhaNova = 1;
                senhaConfirma = 1;

                imgVerSenhaAtual.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (senhaAtual == 1){
                            editSenhaAtual.setTransformationMethod(null);
                            senhaAtual = 0;
                        } else {
                            editSenhaAtual.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            senhaAtual = 1;
                        }
                    }
                });

                imgVerSenhaNova.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (senhaNova == 1){
                            editSenhaNova.setTransformationMethod(null);
                            senhaNova = 0;
                        } else {
                            editSenhaNova.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            senhaNova = 1;
                        }
                    }
                });

                imgVerSenhaConfirma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (senhaConfirma == 1){
                            editSenhaConfirma.setTransformationMethod(null);
                            senhaConfirma = 0;
                        } else {
                            editSenhaConfirma.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            senhaConfirma = 1;
                        }
                    }
                });

                //Cria o Alert
                final AlertDialog.Builder alertBox = new AlertDialog.Builder(alertView.getRootView().getContext());
                alertBox.setMessage("Alterar Senha");
                alertBox.setTitle("EDITANDO");

                //Define a view para o Alert
                alertBox.setView(alertView);


                alertBox.setNeutralButton("ALTERAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertBox.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UtilAplicativo.showMessageToast(context, "Senha não alterada");
                    }
                });

                final AlertDialog dialog = alertBox.create();
                dialog.show();
                //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editSenhaAtual.getText().toString().length() == 0) {
                            editSenhaAtual.setError("*");
                            editSenhaAtual.requestFocus();
                            txtAlertDialogSenha.setText("Favor Informar a Senha Atual");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                        } else if (editSenhaNova.getText().toString().length() == 0) {
                            editSenhaNova.setError("*");
                            editSenhaNova.requestFocus();
                            txtAlertDialogSenha.setText("Favor Informar a Senha Nova");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                        } else if (editSenhaConfirma.getText().toString().length() == 0) {
                            editSenhaConfirma.setError("*");
                            editSenhaConfirma.requestFocus();
                            txtAlertDialogSenha.setText("Favor Confirmar a Senha Nova");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                        } else if (!editSenhaAtual.getText().toString().equals(empresa.getSenha())){
                            editSenhaAtual.setError("*");
                            editSenhaAtual.requestFocus();
                            txtAlertDialogSenha.setText("Senha atual incorreta");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                            editSenhaAtual.setText("");
                        } else if (!editSenhaNova.getText().toString().equals(editSenhaConfirma.getText().toString())){
                            editSenhaNova.setText("");
                            editSenhaNova.setError("*");
                            editSenhaNova.requestFocus();
                            txtAlertDialogSenha.setText("As senhas não combinam");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                            editSenhaConfirma.setText("");
                        } else if (editSenhaNova.getText().toString().length() < 8){
                            txtAlertDialogSenha.setText("A senha deve conter pelo menos 8 caracteres");
                            txtAlertDialogSenha.setVisibility(View.VISIBLE);
                        } else {
                            empresa.setSenha(editSenhaNova.getText().toString());
                            editSenha.setText(empresa.getSenha());
                            UtilAplicativo.showMessageToast(context, "Senha alterada com sucesso");
                            dialog.dismiss();
                        }
                    }
                });
                //alertBox.show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                empresa.setEndereco(editEndereco.getText().toString());
                empresa.setNumero(Integer.parseInt(editNumero.getText().toString()));
                empresa.setComplemento(editComplemento.getText().toString());
                empresa.setBairro(editBairro.getText().toString());
                empresa.setCidade(editCidade.getText().toString());
                empresa.setUf(editUf.getText().toString());
                empresa.setCep(editCep.getText().toString());
                empresa.setDescricao(editDescricao.getText().toString());
                empresa.setSenha(editSenha.getText().toString());
                empresa.setEmail(editEmail.getText().toString());

                empresa.setHoraAberturaSegunda(Time.valueOf(editHoraAberturaSegunda.getText().toString()));
                empresa.setHoraFechamentoSegunda(Time.valueOf(editHoraFechamentoSegunda.getText().toString()));

                empresa.setHoraAberturaTerca(Time.valueOf(editHoraAberturaTerca.getText().toString()));
                empresa.setHoraFechamentoTerca(Time.valueOf(editHoraFechamentoTerca.getText().toString()));

                empresa.setHoraAberturaQuarta(Time.valueOf(editHoraAberturaQuarta.getText().toString()));
                empresa.setHoraFechamentoQuarta(Time.valueOf(editHoraFechamentoQuarta.getText().toString()));

                empresa.setHoraAberturaQuinta(Time.valueOf(editHoraAberturaQuinta.getText().toString()));
                empresa.setHoraFechamentoQuinta(Time.valueOf(editHoraFechamentoQuinta.getText().toString()));

                empresa.setHoraAberturaSexta(Time.valueOf(editHoraAberturaSexta.getText().toString()));
                empresa.setHoraFechamentoSexta(Time.valueOf(editHoraFechamentoSexta.getText().toString()));

                empresa.setHoraAberturaSabado(Time.valueOf(editHoraAberturaSabado.getText().toString()));
                empresa.setHoraFechamentoSabado(Time.valueOf(editHoraFechamentoSabado.getText().toString()));

                empresa.setHoraAberturaDomingo(Time.valueOf(editHoraAberturaDomingo.getText().toString()));
                empresa.setHoraFechamentoDomingo(Time.valueOf(editHoraFechamentoDomingo.getText().toString()));

                controller.alterar(empresa);
                try {
                    AlterarEmpresaAsyncTask task = new AlterarEmpresaAsyncTask(empresa, context);
                    task.execute();
                    UtilAplicativo.showMessageToast(context,"Dados Salvos com Sucesso");
                } catch (Exception e){
                    UtilAplicativo.showMessageToast(context, "Erro ao Salvar Dados");
                }
            }
        });


        return view;
    }

    /*private DadosViewModel mViewModel;

    public static DadosFragment newInstance() {
        return new DadosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dados, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DadosViewModel.class);
    }*/

}

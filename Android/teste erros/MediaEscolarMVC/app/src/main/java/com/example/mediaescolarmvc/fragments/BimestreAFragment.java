package com.example.mediaescolarmvc.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mediaescolarmvc.R;
import com.example.mediaescolarmvc.controller.MediaEscolarController;
import com.example.mediaescolarmvc.model.MediaEscolar;
import com.example.mediaescolarmvc.util.IncluirAsyncTask;
import com.example.mediaescolarmvc.util.UtilMediaEscolar;


public class BimestreAFragment extends Fragment {

    MediaEscolar mediaEscolar;
    MediaEscolarController controller;

    Button btnCalcular;
    EditText edMateria;
    EditText edNotaProva;
    EditText edNotaTrabalho;
    TextView txtResultado;
    TextView txtAprovacao;

    double notaProva;
    double notaTrabalho;
    double media;
    boolean validacao;

    Context context;

    View view;

    public BimestreAFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        controller = new MediaEscolarController(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bimestre_a, container, false);

        edMateria = view.findViewById(R.id.edMateria);
        edNotaProva = view.findViewById(R.id.edNotaProva);
        edNotaTrabalho = view.findViewById(R.id.edNotaTrabalho);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        txtResultado = view.findViewById(R.id.txtResultado);
        txtAprovacao = view.findViewById(R.id.txtAprovacao);
        validacao = false;

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Valida Preenchimento da Matéria
                    if (edMateria.getText().toString().length()==0) {
                        edMateria.setError("Informe a Matéria");
                        edMateria.requestFocus();
                        validacao = false;
                        txtAprovacao.setText("");
                        txtResultado.setText("");
                    }else {
                        //Verifica preenchimento nota prova
                        if (edNotaProva.getText().toString().length() > 0) {
                            //Se Preenchida valida os dados
                            if (controller.isNotaValida(Double.parseDouble(edNotaProva.getText().toString()))){
                                edNotaProva.setError("Nota Inválida - Deve ser entre 0 e 10");
                                edNotaProva.requestFocus();
                                validacao = false;
                            } else {
                                notaProva = Double.parseDouble(edNotaProva.getText().toString());
                                validacao = true;

                                //Verifica preenchimento nota trabalho
                                if (edNotaTrabalho.getText().toString().length() > 0) {

                                    //Se Preenchida valida os dados
                                    if (controller.isNotaValida(Double.parseDouble(edNotaTrabalho.getText().toString()))) {
                                        edNotaTrabalho.setError("Nota Inválida - Deve ser entre 0 e 10");
                                        edNotaTrabalho.requestFocus();
                                        validacao = false;
                                    } else {
                                        notaTrabalho = Double.parseDouble(edNotaTrabalho.getText().toString());
                                        validacao = true;
                                    }
                                    //Retorno se errada nota trabalho
                                } else {
                                    edNotaTrabalho.setError("Informe a Nota do Trabalho");
                                    edNotaTrabalho.requestFocus();
                                    validacao = false;
                                    txtAprovacao.setText("");
                                    txtResultado.setText("");
                                }
                            }
                            //Retorno se errada nota prova
                        } else {
                            edNotaProva.setError("Informe a Nota da Prova");
                            edNotaProva.requestFocus();
                            validacao = false;
                            txtAprovacao.setText("");
                            txtResultado.setText("");
                        }
                    }

                    //Calcula a média e joga o resultado para a tela
                    if (validacao){

                        mediaEscolar = new MediaEscolar();
                        controller = new MediaEscolarController(context);

                        mediaEscolar.setBimestre("1º Bimestre");
                        mediaEscolar.setMateria(edMateria.getText().toString());
                        mediaEscolar.setNotaProva(Double.parseDouble(edNotaProva.getText().toString()));
                        mediaEscolar.setNotaTrabalho(Double.parseDouble(edNotaTrabalho.getText().toString()));

                        media = controller.calcularMedia(mediaEscolar);  //(notaProva + notaTrabalho) / 2;

                        mediaEscolar.setMediaFinal(media);
                        mediaEscolar.setSituacao(controller.resultadoFinal(media));

                        txtResultado.setText(UtilMediaEscolar.formataValorDecimal(media));
                        txtAprovacao.setText(mediaEscolar.getSituacao());

                        //Muda a cor da Label de acordo com o Resultado
                        if (media >= 7) {
                            txtAprovacao.setTextColor(Color.parseColor("#006400"));
                        } else {
                            txtAprovacao.setTextColor(Color.parseColor("#FF0000"));
                        }

                        //Define qual texto irá aparecer na tela "APROVADO" ou "REPROVADO e muda a cor"
                        /*if (media >= 7) {
                            txtAprovacao.setText("Aprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#006400"));
                        } else {
                            txtAprovacao.setText("Reprovado");
                            txtAprovacao.setTextColor(Color.parseColor("#FF0000"));
                        }*/

                        edNotaProva.setText(UtilMediaEscolar.formataValorDecimal(notaProva));
                        edNotaTrabalho.setText(UtilMediaEscolar.formataValorDecimal(notaTrabalho));
                        //salvarSharedPreferences();

                        if (controller.salvar(mediaEscolar)){



                            IncluirAsyncTask task = new IncluirAsyncTask(mediaEscolar, context);
                            task.execute();

                            UtilMediaEscolar.showMessageToast(context, "Dados salvos com sucesso...");
                        }else {
                            UtilMediaEscolar.showMessageToast(context, "Falha ao salvar dados...");
                        }
                    }

                }catch (Exception e) {
                    UtilMediaEscolar.showMessageToast(context, "Dados Necessários não informados");
                }

            }
        });

        return view;
    }
}

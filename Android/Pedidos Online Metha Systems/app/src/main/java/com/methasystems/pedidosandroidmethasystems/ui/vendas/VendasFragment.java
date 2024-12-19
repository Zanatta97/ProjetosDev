package com.methasystems.pedidosandroidmethasystems.ui.vendas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.adapter.ProdutoVendaAdapter;
import com.methasystems.pedidosandroidmethasystems.adapter.VencimentosAdapter;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.ModalidadePagamento;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;
import com.methasystems.pedidosandroidmethasystems.model.Venda;
import com.methasystems.pedidosandroidmethasystems.util.MaskEditUtil;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;

import java.text.SimpleDateFormat;
import java.util.List;

public class VendasFragment extends Fragment {

    private VendasViewModel vendasViewModel;
    private AutoCompleteTextView actCliente, actModalidade;
    //private ClienteController clienteController;
    //private ModalidadePagamentoController modalidadePagamentoController;
    private int clienteId, modalidadeId;
    private String stringCliente, stringModalidade;
    private EditText editData, editNroPedido, editValorTotal, editParcelas;
    ;
    private ModalidadePagamento modalidadeSelecionada;
    private Cliente clienteSelecionado;
    private RecyclerView recyclerProdutos, recyclerVenciementos;
    private ProdutoVendaAdapter produtoVendaAdapter;
    private VencimentosAdapter vencimentosAdapter;
    private int codigoVenda;
    private Button btnAdcionaProduto, btnAdicionaVencimento, btnFinaliza;


    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vendasViewModel =
                new ViewModelProvider(this).get(VendasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vendas, container, false);

        /*final TextView txtNomeCliente = root.findViewById(R.id.txtNomeClienteVenda);
        vendasViewModel.getClienteNome().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtNomeCliente.setText(s);
            }
        });

        final TextView txtCpfCnpj = root.findViewById(R.id.txtCpfCnpjClienteVenda);
        vendasViewModel.getClienteCpfCnpj().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtCpfCnpj.setText(s);
            }
        });*/

        /*if (container != null) {
            container.removeAllViews();
            container.clearDisappearingChildren();
        }*/

        Intent intent = getActivity().getIntent();


        codigoVenda = getArguments().getInt("codVenda");


        vendasViewModel.getmModalidadeSelecionada().observe(getViewLifecycleOwner(), new Observer<ModalidadePagamento>() {
            @Override
            public void onChanged(ModalidadePagamento novaModalidadePagamento) {
                modalidadeSelecionada = novaModalidadePagamento;
                modalidadeId = modalidadeSelecionada.getCodigo();
                stringModalidade = modalidadeSelecionada.toString();
            }
        });

        vendasViewModel.getmClienteSelecionado().observe(getViewLifecycleOwner(), new Observer<Cliente>() {
            @Override
            public void onChanged(Cliente novoCliente) {
                clienteSelecionado = novoCliente;
                clienteId = clienteSelecionado.getCodigo();
                stringCliente = clienteSelecionado.toString();
            }
        });
        //clienteController = new ClienteController(getContext());
        //modalidadePagamentoController = new ModalidadePagamentoController(getContext());
        //List<Cliente> clientes = clienteController.getAllCliente();
        //List<ModalidadePagamento> modalidades = modalidadePagamentoController.getAllModalidadePagamento();

        actCliente = root.findViewById(R.id.act_clientes);
        actModalidade = root.findViewById(R.id.act_mod_pagamento);
        editNroPedido = root.findViewById(R.id.editNroPedido);
        editValorTotal = root.findViewById(R.id.editValorTotal);
        editParcelas = root.findViewById(R.id.editParcelas);
        editData = root.findViewById(R.id.editDataPedido);
        btnAdcionaProduto = root.findViewById(R.id.btn_add_produto);
        btnAdicionaVencimento = root.findViewById(R.id.btn_vencimentos);
        btnFinaliza = root.findViewById(R.id.btn_finalizar_venda);

        editData.addTextChangedListener(MaskEditUtil.mask(editData, MaskEditUtil.FORMAT_DATE));

        ArrayAdapter<Cliente> clientesAdapter = new ArrayAdapter<Cliente>(getContext(),
                android.R.layout.simple_list_item_1, vendasViewModel.getClientes().getValue());

        ArrayAdapter<ModalidadePagamento> modalidadesAdapter = new ArrayAdapter<ModalidadePagamento>(getContext(),
                android.R.layout.simple_list_item_1, vendasViewModel.getModalidades().getValue());

        actCliente.setAdapter(clientesAdapter);
        actCliente.setThreshold(1);

        ClienteSelecionado clienteSelecionado = new ClienteSelecionado();
        actCliente.setOnItemSelectedListener(clienteSelecionado);
        actCliente.setOnItemClickListener(clienteSelecionado);
        actCliente.setOnFocusChangeListener(clienteSelecionado);

        actModalidade.setAdapter(modalidadesAdapter);
        actModalidade.setThreshold(1);

        ModalidadeSelecionada modalidadeSelecionada = new ModalidadeSelecionada();
        actModalidade.setOnItemSelectedListener(modalidadeSelecionada);
        actModalidade.setOnItemClickListener(modalidadeSelecionada);
        actModalidade.setOnFocusChangeListener(modalidadeSelecionada);

        actModalidade.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                actModalidade.showDropDown();
                return false;
            }
        });

        recyclerProdutos = root.findViewById(R.id.recycler_view_prod_vendas);
        recyclerVenciementos = root.findViewById(R.id.recycler_view_vencimentos);


        if (codigoVenda != 0) {
            vendasViewModel.getVendaSelecionada(codigoVenda).observe(getViewLifecycleOwner(), new Observer<Venda>() {
                @Override
                public void onChanged(Venda venda) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = sdf.format(venda.getData());
                    editData.setText(formattedDate);
                    editParcelas.setText(String.valueOf(venda.getNumParcelas()));
                    editValorTotal.setText(String.valueOf(venda.getTotal()));
                    editNroPedido.setText(venda.getNumPedido());
                    vendasViewModel.setmClienteSelecionado(venda.getCliente());
                    vendasViewModel.setmModalidadeSelecionada(venda.getModalidadePagamento());
                    actModalidade.setText(vendasViewModel.setTextModalidadePagamento());
                    actCliente.setText(vendasViewModel.setTextCliente());

                    if (venda.isTransmitida()) {
                        editData.setEnabled(false);
                        editData.setFocusable(false);
                        editParcelas.setEnabled(false);
                        editParcelas.setFocusable(false);
                        editValorTotal.setEnabled(false);
                        editValorTotal.setFocusable(false);
                        editNroPedido.setEnabled(false);
                        editNroPedido.setFocusable(false);
                        btnAdcionaProduto.setActivated(false);
                        btnAdicionaVencimento.setActivated(false);
                        btnFinaliza.setActivated(false);
                    }
                }
            });
        }


        initRecyclerViewProdutos();
        initRecyclerViewVencimentos();

        vendasViewModel.getProdutoVenda(codigoVenda).observe(getViewLifecycleOwner(), new Observer<List<ProdutoVenda>>() {
            @Override
            public void onChanged(List<ProdutoVenda> produtoVendas) {
                produtoVendaAdapter.notifyDataSetChanged();
            }
        });

        vendasViewModel.getVencimentosVenda(codigoVenda).observe(getViewLifecycleOwner(), new Observer<List<Vencimento>>() {
            @Override
            public void onChanged(List<Vencimento> vencimentos) {
                vencimentosAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }

    class ClienteSelecionado implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnFocusChangeListener {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            String nomeClienteSelecionado = actCliente.getText().toString();
            if (!nomeClienteSelecionado.isEmpty() && !nomeClienteSelecionado.equals(stringCliente)) {
                // we are in a new, undefined plant.
                // navigate to a screen where the user can enter a new plant.
                UtilAplicativo.showMessageToast(getContext(), "Cliente não encontrado");
                clienteId = 0;
                vendasViewModel.mudarTxtCliente("");
                vendasViewModel.mudarTxtCpfCnpj("");
            }
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cliente cliente = (Cliente) actCliente.getAdapter().getItem(position);
            vendasViewModel.setmClienteSelecionado(cliente);
            clienteId = cliente.getCodigo();
            stringCliente = actCliente.getText().toString();
            vendasViewModel.mudarTxtCliente(cliente.getNome());

            if (cliente.getCpf() == null || cliente.getCpf().equals("NULL")) {
                vendasViewModel.mudarTxtCpfCnpj(MaskEditUtil.mascaraCNPJ(cliente.getCnpj()));
            } else {
                vendasViewModel.mudarTxtCpfCnpj(MaskEditUtil.mascaraCPF(cliente.getCpf()));
            }
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Cliente cliente = (Cliente) actCliente.getAdapter().getItem(position);
            vendasViewModel.setmClienteSelecionado(cliente);
            clienteId = cliente.getCodigo();
            stringCliente = actCliente.getText().toString();
            vendasViewModel.mudarTxtCliente(cliente.getNome());

            if (cliente.getCpf() == null || cliente.getCpf().equals("NULL")) {
                vendasViewModel.mudarTxtCpfCnpj(MaskEditUtil.mascaraCNPJ(cliente.getCnpj()));
            } else {
                vendasViewModel.mudarTxtCpfCnpj(MaskEditUtil.mascaraCPF(cliente.getCpf()));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    class ModalidadeSelecionada implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnFocusChangeListener {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {

            String nomeModSelecionada = actModalidade.getText().toString();
            if (!nomeModSelecionada.isEmpty() && !nomeModSelecionada.equals(stringModalidade)) {
                UtilAplicativo.showMessageToast(getContext(), "Cliente não encontrado");
                modalidadeId = 0;
                vendasViewModel.mudarTxtCliente("");
                vendasViewModel.mudarTxtCpfCnpj("");
            }
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ModalidadePagamento modalidadePagamento = (ModalidadePagamento) actModalidade.getAdapter().getItem(position);
            vendasViewModel.setmModalidadeSelecionada(modalidadePagamento);
            modalidadeId = modalidadePagamento.getCodigo();
            stringModalidade = actModalidade.getText().toString();
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ModalidadePagamento modalidadePagamento = (ModalidadePagamento) actModalidade.getAdapter().getItem(position);
            vendasViewModel.setmModalidadeSelecionada(modalidadePagamento);
            modalidadeId = modalidadePagamento.getCodigo();
            stringModalidade = actModalidade.getText().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private void initRecyclerViewProdutos() {
        produtoVendaAdapter = new ProdutoVendaAdapter(this.getContext(), vendasViewModel.getProdutoVenda(codigoVenda).getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerProdutos.setLayoutManager(linearLayoutManager);
        recyclerProdutos.setAdapter(produtoVendaAdapter);
    }

    private void initRecyclerViewVencimentos() {
        vencimentosAdapter = new VencimentosAdapter(this.getContext(), vendasViewModel.getVencimentosVenda(codigoVenda).getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerVenciementos.setLayoutManager(linearLayoutManager);
        recyclerVenciementos.setAdapter(vencimentosAdapter);
    }
}
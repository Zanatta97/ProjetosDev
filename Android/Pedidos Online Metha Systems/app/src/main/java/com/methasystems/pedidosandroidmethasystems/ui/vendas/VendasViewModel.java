package com.methasystems.pedidosandroidmethasystems.ui.vendas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.methasystems.pedidosandroidmethasystems.controller.ClienteController;
import com.methasystems.pedidosandroidmethasystems.controller.ModalidadePagamentoController;
import com.methasystems.pedidosandroidmethasystems.controller.ProdutoVendaController;
import com.methasystems.pedidosandroidmethasystems.controller.VencimentoController;
import com.methasystems.pedidosandroidmethasystems.controller.VendaController;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.ModalidadePagamento;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;
import com.methasystems.pedidosandroidmethasystems.model.Venda;
import com.methasystems.pedidosandroidmethasystems.util.App;

import java.util.List;

public class VendasViewModel extends ViewModel {

    private MutableLiveData<String> mClienteNome;
    private MutableLiveData<String> mCpfCnpj;
    private final ClienteController mClienteController;
    private final ModalidadePagamentoController mModalidadeController;
    private MutableLiveData<List<Cliente>> mClientes;
    private MutableLiveData<Cliente> mClienteSelecionado;
    private MutableLiveData<ModalidadePagamento> mModalidadeSelecionada;
    private MutableLiveData<List<ModalidadePagamento>> mModalidades;
    private MutableLiveData<List<ProdutoVenda>> mProdutosVenda;
    private MutableLiveData<List<Vencimento>> mVencimentos;
    private final ProdutoVendaController produtoVendaController;
    private final VencimentoController vencimentoController;
    private MutableLiveData<Venda> mVendaSelecionada;
    private VendaController vendaController;

    public VendasViewModel() {
        mClienteNome = new MutableLiveData<>();
        mClienteNome.setValue("");

        mCpfCnpj = new MutableLiveData<>();
        mCpfCnpj.setValue("");

        mClienteController = new ClienteController(App.getAppContext());
        mModalidadeController = new ModalidadePagamentoController(App.getAppContext());
        vencimentoController = new VencimentoController(App.getAppContext());
        produtoVendaController = new ProdutoVendaController(App.getAppContext());
        vendaController = new VendaController(App.getAppContext());

        mClientes = new MutableLiveData<>();
        mModalidades = new MutableLiveData<>();
        mProdutosVenda = new MutableLiveData<>();
        mVencimentos = new MutableLiveData<>();

        mClienteSelecionado = new MutableLiveData<>();
        mModalidadeSelecionada = new MutableLiveData<>();
        mVendaSelecionada = new MutableLiveData<>();

    }

    public void mudarTxtCliente(String nome){
        mClienteNome.setValue(nome);
    }

    public void mudarTxtCpfCnpj(String string){
        mCpfCnpj.setValue(string);
    }

    public LiveData<String> getClienteNome() {
        return mClienteNome;
    }

    public LiveData<String> getClienteCpfCnpj() {
        return mCpfCnpj;
    }

    public LiveData<List<Cliente>> getClientes(){
        mClientes.setValue(mClienteController.getAllCliente());
        return mClientes;
    }
    public LiveData<List<ModalidadePagamento>> getModalidades(){
        mModalidades.setValue(mModalidadeController.getAllModalidadePagamento());
        return mModalidades;
    }

    public MutableLiveData<Cliente> getmClienteSelecionado() {
        return mClienteSelecionado;
    }

    public void setmClienteSelecionado(Cliente clienteSelecionado) {
        mClienteSelecionado.setValue(clienteSelecionado);
    }

    public void setmClienteSelecionado(int codigo) {
        mClienteSelecionado.setValue(mClienteController.getCliente(codigo));
    }

    public MutableLiveData<ModalidadePagamento> getmModalidadeSelecionada() {
        return mModalidadeSelecionada;
    }

    public void setmModalidadeSelecionada(ModalidadePagamento modalidadeSelecionada) {
        this.mModalidadeSelecionada.setValue(modalidadeSelecionada);
    }

    public void setmModalidadeSelecionada(int codigo) {
        this.mModalidadeSelecionada.setValue(mModalidadeController.getModalidadePagamento(codigo));
    }

    public String setTextModalidadePagamento() {
        ModalidadePagamento modalidadePagamento = mModalidadeSelecionada.getValue();
        return modalidadePagamento.toString();
    }

    public String setTextCliente() {
        Cliente cliente = mClienteSelecionado.getValue();
        return cliente.toString();
    }

    public LiveData<List<ProdutoVenda>> getProdutoVenda(int codigoVenda) {

        mProdutosVenda.setValue(produtoVendaController.getAllProdutoVenda(codigoVenda));
        return mProdutosVenda;

    }

    public LiveData<List<Vencimento>> getVencimentosVenda(int codigoVenda) {
        mVencimentos.setValue(vencimentoController.getAllVencimento(codigoVenda));
        return mVencimentos;

    }

    public LiveData<Venda> getVendaSelecionada (int codigoVenda){
        mVendaSelecionada.setValue(vendaController.getVenda(codigoVenda));
        return mVendaSelecionada;
    }
}
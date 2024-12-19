package com.methasystems.pedidosandroidmethasystems.ui.produtos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.methasystems.pedidosandroidmethasystems.controller.ProdutoController;
import com.methasystems.pedidosandroidmethasystems.model.Produto;
import com.methasystems.pedidosandroidmethasystems.util.App;

import java.util.List;

public class ProdutosViewModel extends ViewModel {
    private MutableLiveData<List<Produto>> mProdutos;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();
    private ProdutoController mController;

    public ProdutosViewModel(){
        mProdutos = new MutableLiveData<>();
        mController = new ProdutoController(App.getAppContext());
    }

    public LiveData<List<Produto>> getProduto(){
        isUpdating.setValue(true);
        mProdutos.setValue(mController.getAllProduto());
        isUpdating.postValue(false);
        return mProdutos;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
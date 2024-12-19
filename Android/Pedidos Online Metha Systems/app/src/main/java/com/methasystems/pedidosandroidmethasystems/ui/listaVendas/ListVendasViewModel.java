package com.methasystems.pedidosandroidmethasystems.ui.listaVendas;

import android.inputmethodservice.AbstractInputMethodService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.methasystems.pedidosandroidmethasystems.controller.ProdutoController;
import com.methasystems.pedidosandroidmethasystems.controller.VendaController;
import com.methasystems.pedidosandroidmethasystems.model.Produto;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;
import com.methasystems.pedidosandroidmethasystems.model.Venda;
import com.methasystems.pedidosandroidmethasystems.util.App;

import java.util.List;

public class ListVendasViewModel extends ViewModel {

    private MutableLiveData<List<Venda>> mVendas;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();
    private VendaController mController;

    public ListVendasViewModel(){

        mVendas = new MutableLiveData<>();
        mController = new VendaController(App.getAppContext());
    }

    public LiveData<List<Venda>> getVendas(){
        isUpdating.setValue(true);
        mVendas.setValue(mController.getAllVenda());
        isUpdating.postValue(false);
        return mVendas;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}

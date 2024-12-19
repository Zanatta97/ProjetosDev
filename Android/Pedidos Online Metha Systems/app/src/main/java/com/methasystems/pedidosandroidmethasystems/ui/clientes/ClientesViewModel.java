package com.methasystems.pedidosandroidmethasystems.ui.clientes;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.methasystems.pedidosandroidmethasystems.controller.ClienteController;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.util.App;

import java.util.List;

public class ClientesViewModel extends ViewModel {

    private MutableLiveData<List<Cliente>> mClientes;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private ClienteController mController;


    public ClientesViewModel() {
        mClientes = new MutableLiveData<>();
        mController = new ClienteController(App.getAppContext());
    }

    public LiveData<List<Cliente>> getCliente() {
        mIsUpdating.setValue(true);
        mClientes.setValue(mController.getAllCliente());
        mIsUpdating.postValue(false);
        return mClientes;
    }

    public LiveData<Boolean> getisUpdating(){
        return mIsUpdating;
    }
}
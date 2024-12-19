package com.samuel.controledeentradaempresas.ui.cadastrarCliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrarClienteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CadastrarClienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
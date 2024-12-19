package com.samuel.controledeentradaempresas.ui.adicionarAFila;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdicionarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AdicionarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
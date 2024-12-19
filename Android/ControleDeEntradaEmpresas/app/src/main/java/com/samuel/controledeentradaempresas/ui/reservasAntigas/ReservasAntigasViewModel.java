package com.samuel.controledeentradaempresas.ui.reservasAntigas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReservasAntigasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReservasAntigasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
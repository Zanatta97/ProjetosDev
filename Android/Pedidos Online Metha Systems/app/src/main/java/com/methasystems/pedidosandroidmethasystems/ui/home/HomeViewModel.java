package com.methasystems.pedidosandroidmethasystems.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.model.Usuario;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;
import com.methasystems.pedidosandroidmethasystems.util.cliente.SincronizarCliente;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    //Cria um constutor global para os alerts
    AlertDialog.Builder builder;

    //Criar uma classe global para os alerts
    AlertDialog alert;
    Usuario usuarioLogado;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void changeText(String newText){
        mText.setValue(newText);
    }

    public void receberRemessa(Context context, View view){

        //Instancia uma view para o alertView
        View alertView = view.inflate(context, R.layout.alert_dialog_receber_remessa, null);

        final EditText editPessoas = alertView.findViewById(R.id.txtRemessa);

        //Cria o Alert
        AlertDialog.Builder alertBox = new AlertDialog.Builder(alertView.getRootView().getContext());
        alertBox.setMessage(R.string.informa_remessa);
        alertBox.setTitle(R.string.num_remessa);

        //Define a view para o Alert
        alertBox.setView(alertView);

        alertBox.setNeutralButton(R.string.confirmar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                UtilAplicativo.showMessageToast(context, "Testando");

                /*final SincronizarCliente task = new SincronizarCliente(context);
                task.execute();*/
            }
        });

        alertBox.show();

    }
}
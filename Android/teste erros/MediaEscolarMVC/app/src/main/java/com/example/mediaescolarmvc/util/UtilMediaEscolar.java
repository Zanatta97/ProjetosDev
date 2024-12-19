package com.example.mediaescolarmvc.util;

import android.content.Context;
import android.widget.Toast;

import java.text.DecimalFormat;

public class UtilMediaEscolar {

    public static final String URL_WEB_SERVICE = "http://methasystems.com.br/mediaEscolar/"; //Endereço servidor na internet
    //public static final String URL_WEB_SERVICE = "http://192.168.0.113:8012/mediaEscolar/"; //Endereço servidor web service
    public static final int CONNECTION_TIMEOUT = 10000; //10 segundos para considerar erro de conexão
    public static final int READ_TIMEOUT = 15000; //15 segundos para acessar e ter uma resposta do web service

    public static String formataValorDecimal(Double valor){
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }

    public static void showMessageToast(Context context, String menssagem){
        Toast.makeText(context, menssagem, Toast.LENGTH_LONG).show();
    }
}

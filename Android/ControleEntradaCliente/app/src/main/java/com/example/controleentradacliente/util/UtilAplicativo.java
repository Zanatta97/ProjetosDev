package com.example.controleentradacliente.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UtilAplicativo {

    public static final String URL_WEB_SERVICE = "http://methasystems.com.br/appEntradas/"; //Endereço servidor na internet
    //public static final String URL_WEB_SERVICE = "http://192.168.0.113:8012/appEntradas/"; //Endereço servidor web service
    public static final int CONNECTION_TIMEOUT = 10000; //10 segundos para considerar erro de conexão
    public static final int READ_TIMEOUT = 15000; //15 segundos para acessar e ter uma resposta do web service
    public static String emailCliente;
    public static final String statusReservaAguardando = "Aguardando Chamado";
    public static final String statusReservaChamado1 = "Chamado 1x";
    public static final String statusReservaChamado2 = "Chamado 2x";
    public static final String statusReservaChamado3 = "Chamado 3x";
    public static final String statusReservaCancelada = "Cancelada";
    public static final String statusReservaEntrou = "Entrou";
    public static Boolean jaLogado;

    public static String formataValorDecimal(Double valor){
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }

    public static void showMessageToast(Context context, String menssagem){
        Toast.makeText(context, menssagem, Toast.LENGTH_LONG).show();
    }



    public static int getScreenResolution(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        return width;
    }



    /*private boolean checarPermissoes() {

        if (Build.VERSION.SDK_INT < 23) {

            return true;

        } else if (checkAndRequestPermissions()) {

            return true;

        } else {

            return false;

        }
    }

    private boolean checkAndRequestPermissions() {

        boolean retorno = true;

        //Conterá a lista de permissões a serem solicitadas para o usuário
        List<String> permissoesNecessarias = new ArrayList<>();

        //Checa se as permissões estão liberadas ou negadas
        int permissaoInternet = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int permissaoNetwork = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
        int permissaoReadES = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissaoWriteES = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // -1 negado
        // 0 permitido

        if (permissaoInternet != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.INTERNET);
        }

        if (permissaoNetwork != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }

        if (permissaoReadES != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (permissaoWriteES != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }


        if(!permissoesNecessarias.isEmpty()){
            ActivityCompat.requestPermissions(this,
                    permissoesNecessarias.toArray(new String[permissoesNecessarias.size()]),
                    APP_PERMISSIONS_REQUEST_CAMERA);

            retorno = false;
        }

        return retorno;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {

        switch (requestCode){
            case APP_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED){
                    }

                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED){
                    }

                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    }

                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    }
                } else {

                    UtilAplicativo.showMessageToast(this, "Necessário conceder permissões para rodar o aplicativo");

                 *//*   new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 5000);*//*
                }
            }
            break;


        }

    }*/

}

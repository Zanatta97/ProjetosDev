package com.example.mediaescolarmvc.controller;

import android.app.Activity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class AplicativoController {

    public static boolean verificarGooglePlayServices(Activity activity) {

        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();

        int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);

        if (status != ConnectionResult.SUCCESS){
            if (googleApiAvailability.isUserResolvableError(status));
            googleApiAvailability.getErrorDialog(activity, status, 2404).show();
            return false;
        }

     return true;

    }

}

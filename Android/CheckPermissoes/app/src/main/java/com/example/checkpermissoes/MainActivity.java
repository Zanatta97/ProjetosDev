package com.example.checkpermissoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private int SEM_PERMISSAO = -1;

    CheckBox checkBoxCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        checkBoxCamera = findViewById(R.id.checkBoxCamera);

        checkBoxCamera.setChecked(testarPermissaoCamera());
    }

    public boolean testarPermissaoCamera(){

        int permissao;

        permissao = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        return permissao == SEM_PERMISSAO? false : true;
    }
}

package maddo.foo.appmultiplaspermissoes;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Recomendação
 *
 * Para o melhor entendimento desta aula, é importante você ter
 * entendido as aulas anteriores ou já tem um nível além do
 * iniciante.
 *
 * Este é um projeto que contém apenas o ESQUELETO que deverá
 * ser utilizado por você para acompanhar as próximas aulas
 * relacionadas com permissões múltiplas
 */
public class MainActivity extends AppCompatActivity {

    TextView txtPermissoes;

    public static final int APP_PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPermissoes = findViewById(R.id.txtPermissoes);

        checarPermissoes();

    }


    private void checarPermissoes() {

        if (Build.VERSION.SDK_INT < 23) {

            txtPermissoes.setText("Ok, todas as permissões ativas.");

            // Acessar as funcionalidades do aplicativo

        } else if (checkAndRequestPermissions()) {

            txtPermissoes.setText("Ok, todas as permissões ativas.");

            // Acessar as funcionalidades do aplicativo

        } else {

            txtPermissoes.setText("OPS! Sem permissões!.");

        }
    }

    private boolean checkAndRequestPermissions() {

        boolean retorno = true;

        //Conterá a lista de permissões a serem solicitadas para o usuário
        List<String> permissoesNecessarias = new ArrayList<>();

                            //Checa se as permissões estão liberadas ou negadas
        int permissaoCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int permissaoLigacao = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        // -1 negado
        // 0 permitido

        if (permissaoCamera != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.CAMERA);
        }

        if (permissaoLigacao != PackageManager.PERMISSION_GRANTED){
            permissoesNecessarias.add(Manifest.permission.CALL_PHONE);
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
                            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        txtPermissoes.setText("Teste permissão camera");
                    }

                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        txtPermissoes.setText("Teste permissão Ligação");
                    }
                } else {
                    txtPermissoes.setText("Nem todas as permissões garantidas");
                }
            }
            break;


        }

    }
}

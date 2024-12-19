package foo.maddo.appcidadesbr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import foo.maddo.appcidadesbr.model.Cidade;

/**
 * Classe principal do aplicativo
 */
public class MainActivity extends AppCompatActivity {

    TextView txtSelecionados;

    Spinner spRegiao, spEstado, spMunicipio;

    Cidade cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

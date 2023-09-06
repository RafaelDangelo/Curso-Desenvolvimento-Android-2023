package devandroid.dangelo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import devandroid.dangelo.applistacurso.R;
import devandroid.dangelo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    Button btnFinalizar;
    Button btnSalvar;
    Button btnLimpar;

    EditText editTextPrimeiroNome;
    EditText editTextNomeCurso;
    EditText editTextTelefone;
    EditText editTextSobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Rafael");
        pessoa.setSobreNome("Dangelo");
        pessoa.setTelefone("12 99234765");
        pessoa.setCursoDesejado("Desenvolvimento Android");

        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextNomeCurso = findViewById(R.id.editTextNomeCurso);
        editTextTelefone = findViewById(R.id.editTextTelefone);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNomeCurso.setText("");
                editTextSobrenome.setText("");
                editTextNomeCurso.setText("");
                editTextTelefone.setText("");
            }
        });

        Log.i("POO Android", pessoa.toString());

    }
}
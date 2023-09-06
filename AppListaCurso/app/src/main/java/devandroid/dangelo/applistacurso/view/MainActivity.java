package devandroid.dangelo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        /*pessoa.setPrimeiroNome("Rafael");
        pessoa.setSobreNome("Dangelo");
        pessoa.setTelefone("12 99234765");
        pessoa.setCursoDesejado("Desenvolvimento Android");*/

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
                editTextPrimeiroNome.setText("");
                editTextSobrenome.setText("");
                editTextNomeCurso.setText("");
                editTextTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Obrigado por usar nosso App!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editTextSobrenome.getText().toString());
                pessoa.setCursoDesejado(editTextNomeCurso.getText().toString());
                pessoa.setTelefone(editTextTelefone.getText().toString());

                Toast.makeText(MainActivity.this,"Salvo: " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Log.i("POO Android", pessoa.toString());

    }
}
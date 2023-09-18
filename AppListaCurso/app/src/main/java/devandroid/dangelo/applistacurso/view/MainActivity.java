package devandroid.dangelo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.dangelo.applistacurso.R;
import devandroid.dangelo.applistacurso.controller.PessoaController;
import devandroid.dangelo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController controller;

    SharedPreferences preferences; //Cria arquivo temporário localmente para salvar infos.
    public static final String NOME_PREFERENCES = "pref_listavip";//Nome do arquivo xml que salva na pasta Sharedpref.
    SharedPreferences.Editor listaVip;

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
        controller = new PessoaController();

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit(); //Criação do arquivo e abre para edição

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeDoCursoDesejado", ""));
        pessoa.setTelefone(preferences.getString("telefone", ""));

        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextNomeCurso = findViewById(R.id.editTextNomeCurso);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobrenome.setText(pessoa.getSobreNome());
        editTextNomeCurso.setText(pessoa.getCursoDesejado());
        editTextTelefone.setText(pessoa.getTelefone());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrimeiroNome.setText("");
                editTextSobrenome.setText("");
                editTextNomeCurso.setText("");
                editTextTelefone.setText("");

                listaVip.clear();
                listaVip.apply();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Obrigado por usar nosso App!", Toast.LENGTH_LONG).show();
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

                controller.salvar(pessoa);

                Toast.makeText(MainActivity.this, "Salvo: " + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome()); //Envia os dados para o Shared Pref. Popula o arquivo
                listaVip.putString("sobreNome", pessoa.getSobreNome());
                listaVip.putString("nomeDoCursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefone", pessoa.getTelefone());

                listaVip.apply();//Salva os dados no arquivo
            }
        });

        Log.i("POO Android", pessoa.toString());
    }
}
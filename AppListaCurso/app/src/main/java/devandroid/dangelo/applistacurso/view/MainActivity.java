package devandroid.dangelo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.dangelo.applistacurso.R;
import devandroid.dangelo.applistacurso.controller.CursoController;
import devandroid.dangelo.applistacurso.controller.PessoaController;
import devandroid.dangelo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController pessoaController;
    CursoController cursoController;
    List<String> nomeDosCursos;

    Button btnFinalizar;
    Button btnSalvar;
    Button btnLimpar;

    EditText editTextPrimeiroNome;
    EditText editTextNomeCurso;
    EditText editTextTelefone;
    EditText editTextSobrenome;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController(MainActivity.this);
        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpinner();

        pessoa = new Pessoa();
        pessoa = pessoaController.buscar(pessoa);

        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextNomeCurso = findViewById(R.id.editTextNomeCurso);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        spinner = findViewById(R.id.spinner);

        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobrenome.setText(pessoa.getSobreNome());
        editTextNomeCurso.setText(pessoa.getCursoDesejado());
        editTextTelefone.setText(pessoa.getTelefone());

        //Adapter, Layout e Injetar o adapter ao spinner.

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrimeiroNome.setText("");
                editTextSobrenome.setText("");
                editTextNomeCurso.setText("");
                editTextTelefone.setText("");

                pessoaController.limpar();
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

                pessoaController.salvar(pessoa);

                Toast.makeText(MainActivity.this, "Salvo: " + pessoa.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Log.i("POO Android", pessoa.toString());
    }
}
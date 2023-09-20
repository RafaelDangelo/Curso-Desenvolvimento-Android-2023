package devandroid.dangelo.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.dangelo.applistacurso.model.Pessoa;
import devandroid.dangelo.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {//Cria SharedPreferences no Construtor
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit(); //Criação do arquivo e abre para edição
    }

    public void salvar(Pessoa pessoa) {

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome()); //Envia os dados para o Shared Pref. Popula o arquivo
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeDoCursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefone", pessoa.getTelefone());

        listaVip.apply();//Salva os dados no arquivo
    }

    public Pessoa buscar(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeDoCursoDesejado", ""));
        pessoa.setTelefone(preferences.getString("telefone", ""));

        return pessoa;
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();
    }

}

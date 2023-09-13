package devandroid.dangelo.applistacurso.controller;

import android.util.Log;

import devandroid.dangelo.applistacurso.model.Pessoa;

public class PessoaController {

    public void salvar(Pessoa pessoa) {
        Log.i("MVC Controller", "Salvo através da controller..." + pessoa.toString());
    }
}

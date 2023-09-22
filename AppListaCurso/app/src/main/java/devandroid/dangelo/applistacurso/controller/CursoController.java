package devandroid.dangelo.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.dangelo.applistacurso.model.Curso;

public class CursoController {

    private List listaDeCursos;

    public List getListaDeCursos(){

        listaDeCursos = new ArrayList<Curso>();

        listaDeCursos.add(new Curso("Java")); //Java
        listaDeCursos.add(new Curso("HTML")); //HTML
        listaDeCursos.add(new Curso("C++")); //C++
        listaDeCursos.add(new Curso("PHP")); //PHP
        listaDeCursos.add(new Curso("React"));
        listaDeCursos.add(new Curso("Phyton"));

        return listaDeCursos;
    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size(); i++) {
            Curso curso = (Curso) getListaDeCursos().get(i);
            dados.add(curso.getNomeDoCursoDesejado());
        }

        return dados;
    }
}

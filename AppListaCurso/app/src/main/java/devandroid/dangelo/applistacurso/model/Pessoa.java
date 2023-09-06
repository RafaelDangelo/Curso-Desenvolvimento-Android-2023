package devandroid.dangelo.applistacurso.model;

public class Pessoa {

    private String primeiroNome;
    private String sobreNome;
    private String telefone;
    private String cursoDesejado;

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Primeiro Nome='" + primeiroNome + '\'' +
                ", SobreNome='" + sobreNome + '\'' +
                ", Telefone='" + telefone + '\'' +
                ", Curso desejado='" + cursoDesejado + '\'' +
                '}';
    }
}

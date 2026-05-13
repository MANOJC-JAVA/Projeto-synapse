package modelo;

public class Participante {

    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    // GETTER
    public String getNome() {
        return nome;
    }

    // SETTER (pra editar)
    public void setNome(String nome) {
        this.nome = nome;
    }

    // EXIBIÇÃO EM LISTAS
    @Override
    public String toString() {
        return nome;
    }
}
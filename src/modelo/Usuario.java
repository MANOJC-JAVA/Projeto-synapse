package modelo;

public class Usuario {

    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // GETTERS
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    // SETTERS (pra editar depois)
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }

    // MOSTRAR BONITO EM LISTAS
    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}
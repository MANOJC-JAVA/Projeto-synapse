package modelo;

public class Resultado {

    private String nomeParticipante;
    private long tempo;

    public Resultado(String nomeParticipante, long tempo) {
        this.nomeParticipante = nomeParticipante;
        this.tempo = tempo;
    }

    // GETTERS
    public String getNomeParticipante() { return nomeParticipante; }
    public long getTempo() { return tempo; }

    // SETTER (pra editar)
    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    // FORMATAÇÃO BONITA
    @Override
    public String toString() {
        return nomeParticipante + " - " + tempo + " ms";
    }
}
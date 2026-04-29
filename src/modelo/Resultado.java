package modelo;

public class Resultado {

    private String nomeParticipante;
    private long tempo;

    public Resultado(String nomeParticipante, long tempo) {
        this.nomeParticipante = nomeParticipante;
        this.tempo = tempo;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public long getTempo() {
        return tempo;
    }
}
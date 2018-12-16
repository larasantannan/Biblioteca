package iusistema;

import java.util.Date;

public class Exemplar {

    private String exemplarId;
    private Bool disponibilidade;
    private Date dataDevolucao;

    public Exemplar(String exemplarId, Bool disponibilidade) {

        this.exemplarId = exemplarId;
        this.disponibilidade = disponibilidade;
    }

    public String getExemplarId() {
        return this.exemplarId;
    }

    public void mudarDiponibilidade() {
        this.disponibilidade = !this.disponibilidade;
    }

    public Bool getDisponibilidade() {
        return this.disponibilidade;
    }

    public Date getDataDevolucao() {
        return this.dataDevolucao;
    }
}

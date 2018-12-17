package iusistema;

import java.util.Date;

public class Exemplar {

    private String exemplarId;
    private boolean disponibilidade;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Exemplar(String exemplarId, boolean disponibilidade) {

        this.exemplarId = exemplarId;
        this.disponibilidade = disponibilidade;
    };

    public String getExemplarId() {
        return this.exemplarId;
    };

    public void mudarDisponibilidade() {
        this.disponibilidade = !this.disponibilidade;
    };

    public boolean getDisponibilidade() {
        return this.disponibilidade;
    };

    public Date getDataDevolucao() {
        return this.dataDevolucao;
    };

    public void setDataDevolucao(Date data) {
        this.dataDevolucao = data;
    };

    public void setDataEmprestimo(Date data) {
        this.dataEmprestimo = data;
    };

    public Date getDataEmprestimo() {
        return this.dataEmprestimo;
    };
}

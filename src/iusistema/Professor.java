
package iusistema;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Usuario {
    private String id;
    private String nome;
    private int notificacao = 0;
    private int qtdReservas = 0;
    private List<Livro> listaReservas = new ArrayList();
    private final int limiteEmprestimo = Integer.MAX_VALUE;

    public Professor(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void update() {
        this.notificacao++;
    }

    @Override
    public int getQtdReservas() {
        return this.qtdReservas;
    }

    @Override
    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }

    @Override
    public void addLivroReserva(Livro livro) {
        this.listaReservas.add(livro);
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}

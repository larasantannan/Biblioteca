
package iusistema;

import java.util.ArrayList;
import java.util.List;

public class AlunoGraduacao implements Usuario{
    private String id;
    private String nome;
    private int qtdReservas = 0;
    private List<Livro> listaReservas = new ArrayList();
    private final int limiteEmprestimo = 3;

    public AlunoGraduacao(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void update() {}

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

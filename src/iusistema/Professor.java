
package iusistema;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class Professor extends Usuario {
    private String id;
    private String nome;

    private int notificacao;

    private int qtdReservas;
    private List<Livro> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior = new RegraProfessor();
    private final int limiteEmprestimo = Integer.MAX_VALUE;
    private int qtdEmprestimos;
    private List<Pair<Livro, Exemplar>> listaEmprestimos = new ArrayList();
    private int tempoEmprestimo = 3;

    public Professor(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.notificacao = 0;
        this.qtdReservas = 0;
        this.qtdEmprestimos = 0;
        emprestimoBehavior = new RegraProfessor();
    }

    @Override
    public void update() {
        this.notificacao++;
    }

    public int getNotificacoes() {
        return this.notificacao;
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
    public void addLivroEmprestimo(Livro livro, Exemplar exemplar) {
        Pair<Livro, Exemplar> pair = new Pair<Livro, Exemplar>(livro, exemplar);
        this.listaEmprestimos.add(pair);
        this.qtdEmprestimos += 1;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    }
    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };
    @Override
    public Bool devedor() {
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {
            if (!iterator.next().getValue().getDisponibilidade()) {
                Exemplar exemplar = (Exemplar) iterator.next().getValue();
                Calendar c = Calendar.getInstance();
                Date data = new Date();
                c.setTime(data);

                if (c.after(exemplar.getDataDevolucao())){
                    return true;
                }
            }
        }
        return false;
    }
}

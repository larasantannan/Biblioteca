
package iusistema;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;

public class Professor extends Usuario {

    private int notificacao;

    private String id;
    private String nome;

    private int qtdReservas;
    private List<Livro> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private int qtdEmprestimos;
    private List<Pair<Livro, Exemplar>> listaEmprestimos = new ArrayList();

    public Professor(String id, String nome) {
        this.notificacao = 0;

        this.id = id;
        this.nome = nome;

        this.qtdReservas = 0;

        this.emprestimoBehavior = new RegraProfessor();
        this.limiteEmprestimo = Integer.MAX_VALUE;
        this.tempoEmprestimo = 7;
        this.qtdEmprestimos = 0;
    };

    @Override
    public void update() {
        this.notificacao++;
    };

    @Override
    public int getNotificacoes() {
        return this.notificacao;
    };

    @Override
    public int getQtdReservas() {
        return this.qtdReservas;
    };

    @Override
    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    };

    @Override
    public void addLivroReserva(Livro livro) {
        this.listaReservas.add(livro);
    };

    @Override
    public void addLivroEmprestimo(Livro livro, Exemplar exemplar) {
        Pair<Livro, Exemplar> pair = new Pair<Livro, Exemplar>(livro, exemplar);
        this.listaEmprestimos.add(pair);
        this.qtdEmprestimos += 1;
    };

    @Override
    public String getNome() {
        return this.nome;
    };

    @Override
    public boolean devedor() {
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {

            Pair<Livro, Exemplar> pair = (Pair<Livro, Exemplar>) iterator.next();
            Exemplar exemplar = (Exemplar) pair.getValue();

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());

            if (c.after(exemplar.getDataDevolucao())){
                return true;
            }
        }
        return false;
    };

    @Override
    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    };

    @Override
    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };

    @Override
    public boolean buscarLivroReserva(String livroId) {
        boolean reservado = false;
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next();
            String id = aux.getId();
            if (livroId == id) reservado = true;
        }
        return reservado;
    };

    @Override
    public boolean buscarLivroEmprestimo(String livroId) {
        boolean emprestado = false;
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {

            Pair<Livro, Exemplar> pair = (Pair<Livro, Exemplar>) iterator.next();
            Livro aux = (Livro) pair.getKey();

            String id = aux.getId();
            if (livroId == id) emprestado = true;
        }
        return emprestado;
    };

    @Override
    public void removerReserva(Livro livro) {
        String livroId = livro.getId();
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next();
            String id = aux.getId();
            if (livroId == id) iterator.remove();
        }
        this.qtdReservas -= 1;
    };

    @Override
    public boolean verficarRegras(Livro livro) {
        return emprestimoBehavior.regraEmprestimo(this, livro);
    };

    @Override
    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

}

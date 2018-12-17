
package iusistema;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
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
        this.qtdEmprestimos = 0;
        this.emprestimoBehavior = new RegraProfessor();
        this.limiteEmprestimo = Integer.MAX_VALUE;
        this.tempoEmprestimo = 7;
        this.qtdEmprestimos = 0;
    };

    @Override
    public void update() {
        this.notificacao++;
    };

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
    public Bool devedor() {
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {

            Exemplar exemplar = (Exemplar) iterator.next().getValue();

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
    
    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };

}

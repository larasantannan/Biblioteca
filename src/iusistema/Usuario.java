
package iusistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;

public abstract class Usuario {

    private int notificacao;

    private String id;
    private String nome;

    private int qtdReservas;
    private List<Livro> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private int qtdEmprestimos;
    private List<Pair> listaEmprestimos = new ArrayList();

    public Usuario() {};

    public void update() {};

    public int getNotificacoes() {
        return this.notificacao;
    };

    public int getQtdReservas() {
        return this.qtdReservas;
    };

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    };

    public void addLivroReserva(Livro livro) {
        this.listaReservas.add(livro);
    };

    public void addLivroEmprestimo(Livro livro, Exemplar exemplar) {
        Pair pair = new Pair(livro, exemplar);
        this.listaEmprestimos.add(pair);
        this.qtdEmprestimos += 1;
    };

    public String getNome() {
        return this.nome;
    };

    public boolean devedor() {
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {

            Pair pair = (Pair) iterator.next();
            Exemplar exemplar = (Exemplar) pair.getValue();

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());

            if (c.after(exemplar.getDataDevolucao())){
                return true;
            }
        }
        return false;
    };

    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    };

    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };

    public boolean buscarLivroReserva(String livroId) {
        boolean reservado = false;
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next();
            String id = aux.getId();
            if (livroId == id) reservado = true;
        }
        return reservado;
    };

    public boolean buscarLivroEmprestimo(String livroId) {
        boolean emprestado = false;
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {

            Pair pair = (Pair) iterator.next();
            Livro aux = (Livro) pair.getKey();

            String id = aux.getId();
            if (livroId == id) emprestado = true;
        }
        return emprestado;
    };

    public void removerReserva(Livro livro) {
        String livroId = livro.getId();
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next();
            String id = aux.getId();
            if (livroId == id) iterator.remove();
        }
        this.qtdReservas -= 1;
    };

    public boolean verficarRegras(Livro livro) {
        return emprestimoBehavior.regraEmprestimo(this, livro);
    };

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

}

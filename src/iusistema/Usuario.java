
package iusistema;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public abstract class Usuario {

    private String id;
    private String nome;

    private int qtdReservas;
    private List<Livro> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private int qtdEmprestimos;
    private List<Pair<Livro, Exemplar>> listaEmprestimos = new ArrayList();

    public Usuario() {};

    public void update() {};

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
        Pair<Livro, Exemplar> pair = new Pair<Livro, Exemplar>(livro, exemplar);
        this.listaEmprestimos.add(pair);
        this.qtdEmprestimos += 1;
    };

    public String getNome() {
        return this.nome;
    };

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

    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    };

    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };

    public Bool buscarLivroReserva(String livroId) {
        Bool reservado = false;
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next();
            String id = aux.getId();
            if (livroId == id) reservado = true;
        }
        return reservado;
    };

    public Bool buscarLivroEmprestimo(String livroId) {
        Bool emprestado = false;
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {
            Livro aux = (Livro) iterator.next().getKey();
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

    // Não implementei nos outros Usuarios
    public Bool verficarRegras(Livro livro) {
        emprestimoBehavior.regraEmprestimo(this, livro);
    };


}


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
    private List<LivDat> listaReservas = new ArrayList();

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
        Date data = new Date();
        LivDat duo = new LivDat(livro, data);
        this.listaReservas.add(duo);
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
            LivDat duo = (LivDat) iterator.next();
            Livro aux = (Livro) duo.getKey();
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
            LivDat duo = (LivDat) iterator.next();
            Livro aux = (Livro) duo.getKey();
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

    public void removerEmprestimo(Livro livro) {

        // Buscar livro emprestado e exemplar
        Pair emprestado = null;
        String livroId = livro.getId();
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {
            Pair pair = (Pair) iterator.next();
            Livro aux = (Livro) pair.getKey();
            String id = aux.getId();
            if (livroId == id) {
                emprestado = pair;
                break;
            }
        }

        // Remover da lista de emprestimos
        Livro aux = null;
        for (Iterator iterator = this.listaEmprestimos.iterator(); iterator.hasNext();) {
            Pair pair = (Pair) iterator.next();
            aux = (Livro) pair.getKey();
            String id = aux.getId();
            if (livroId == id) {
                iterator.remove();
                break;
            }
        }
        this.qtdEmprestimos -= 1;

        // Mudar disponibilidade do exemplar do livro aux
        Exemplar exemplar = emprestado.getValue();
        aux.setDisponibilidadeExemplarLista(exemplar);
    };

    public void printReservas() {
        System.out.println("Lista das reservas:");
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            LivDat duo = (LivDat) iterator.next();

            Livro livro = (Livro) duo.getKey();
            String titulo = livro.getTitulo();

            Date data = (Date) duo.getValue();
            String dataString = data.toString();

            System.out.println("Titulo do livro: " + titulo + " data de realizacao da reserva: " + dataString + ".");
        }
        System.out.println();
    };
}

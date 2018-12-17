
package iusistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;

public class AlunoGraduacao extends Usuario{

    private String id;
    private String nome;

    private int qtdReservas;
    private List<LivDat> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private int qtdEmprestimos;
    private List<Pair> listaEmprestimos = new ArrayList();

    public AlunoGraduacao(String id, String nome) {
        this.id = id;
        this.nome = nome;

        this.qtdReservas = 0;

        this.emprestimoBehavior = new RegraAlunoGraduacao();
        this.limiteEmprestimo = 3;
        this.tempoEmprestimo = 3;
        this.qtdEmprestimos = 0;
    };

    @Override
    public void update() {};

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
        Date data = new Date();
        LivDat duo = new LivDat(livro, data);
        this.listaReservas.add(duo);
    };

    @Override
    public void addLivroEmprestimo(Livro livro, Exemplar exemplar) {
        Pair pair = new Pair(livro, exemplar);
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
            LivDat duo = (LivDat) iterator.next();
            Livro aux = (Livro) duo.getKey();
            String id = aux.getId();
            if (livroId == id) reservado = true;
        }
        return reservado;
    };

    @Override
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

    @Override
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

    @Override
    public boolean verficarRegras(Livro livro) {
        return emprestimoBehavior.regraEmprestimo(this, livro);
    };

    @Override
    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    };

    @Override
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

}

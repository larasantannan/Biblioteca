
package iusistema;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class AlunoGraduacao extends Usuario{

    private String id;
    private String nome;

    private int qtdReservas;
    private List<Livro> listaReservas = new ArrayList();

    private EmprestimoBehavior emprestimoBehavior;
    private int limiteEmprestimo;
    private int tempoEmprestimo;
    private int qtdEmprestimos;
    private List<Pair<Livro, Exemplar>> listaEmprestimos = new ArrayList();

    public AlunoGraduacao(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.qtdReservas = 0;
        this.qtdEmprestimos = 0;
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

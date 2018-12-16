
package iusistema;

public abstract class Usuario {

    private String nome;
    private EmprestimoBehavior emprestimoBehavior;
    private int qtdReservas;
    private int qtdEmprestimos;
    private int limiteEmprestimo;

    public Usuario() {};
    public void update() {};
    public int getQtdReservas() {
        return this.qtdReservas;
    };
    public void setQtdReservas(int qtdReservas) {};
    public void addLivroReserva(Livro livro) {};
    public void addLivroEmprestimo(Livro livro) {};
    public String getNome() {
        return this.nome;
    };
    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    };
    public int getLimiteEmprestimos() {
        return this.limiteEmprestimo;
    };
    public Bool devedor() {};
    public Bool verficarRegras(Usuario this, Livro livro) {
        emprestimoBehavior.regraEmprestimo(this, livro);
    };

}

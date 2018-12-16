
package iusistema;

public class RegraAlunoGraduacao implements EmprestimoBehavior {

    public Bool regraEmprestimo(Usuario usuario, Livro livro) {
        int qtdEmprestimos = usuario.getQtdEmprestimos();
        int limiteEmprestimo = usuario.getLimiteEmprestimos();

        if (qtdEmprestimos == limiteEmprestimo) {
            return false;
        }
        else {
            
        }
    };
}


package iusistema;

public class RegraAlunoPosGraduacao implements EmprestimoBehavior {

    public boolean regraEmprestimo(Usuario usuario, Livro livro) {

        String usuarioNome = usuario.getNome();
        String livroTitulo = livro.getTitulo();

        int qtdEmprestimos = usuario.getQtdEmprestimos();
        int limiteEmprestimo = usuario.getLimiteEmprestimos();

        if (qtdEmprestimos < limiteEmprestimo) {
            String livroId = livro.getId();
            boolean reservado = usuario.buscarLivroReserva(livroId);

            int qtdReservas = livro.getQtdReservas();
            int qtdExemplaresDisponiveis = livro.getQtdExemplaresDisponiveis();

            if (reservado || qtdReservas < qtdExemplaresDisponiveis) {

                if (qtdReservas >=  qtdExemplaresDisponiveis && reservado) {
                    boolean emprestado = usuario.buscarLivroEmprestimo(livroId);
                    if (emprestado) {
                        return true;
                    }
                    else {
                        System.out.println("Usuario " + usuarioNome + " ja possui emprestimo do livro " + livroTitulo + ".");
                        System.out.println("Nao eh possivel pegar exemplares diferentes de um livro ao mesmo tempo.");
                    }
                }
                else {
                    System.out.println("Usuario " + usuarioNome + " nao possui reserva do livro " + livroTitulo + ".");
                    System.out.println("E o numero de reservas ultrapassa o numero de exemplares disponiveis.");
                }
            }
            else {
                System.out.println("Usuario " + usuarioNome + " nao possui reserva do livro " + livroTitulo + ".");
                System.out.println("E nao ha exemplares disponiveis.");
            }
        }
        else {
            System.out.println("Usuario " + usuarioNome + " alcancou o limite maximo de emprestimos.");
            System.out.println("Nao foi possivel efetuar o emprestimo de " + livroTitulo + ".");
        }
        return false;
    };
}

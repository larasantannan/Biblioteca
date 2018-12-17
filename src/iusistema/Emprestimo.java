package iusistema;

import java.util.Date;
import java.util.Calendar;

public class Emprestimo {

    private static Emprestimo instancia;
	private Emprestimo() {};

	public static Emprestimo obterInstancia() {
		if (instancia == null) {
			instancia = new Emprestimo();
		}
		return instancia;
	};

    public void fazerEmprestimo(Usuario usuario, Livro livro) {
        String usuarioNome = usuario.getNome();
        String livroTitulo = livro.getTitulo();
        String livroId = livro.getId();

        if (livro.exemplarDisponivel()) {
            if (!usuario.devedor()) {
                if (usuario.verficarRegras(livro)) {
                    if (usuario.buscarLivroReserva(livroId)) {
                        usuario.removerReserva(livro);
                    }

                    // Efetuar emprestimo
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());

                    c.add(c.DAY_OF_MONTH, usuario.getTempoEmprestimo());
                    Date dataDevolucao = c.getTime();
                    Exemplar exemplar = livro.getExemplarDisponivel();

                    exemplar.setDataEmprestimo(new Date());
                    exemplar.setDataDevolucao(dataDevolucao);
                    usuario.addLivroEmprestimo(livro, exemplar);
                    System.out.println("Usuario " + usuarioNome + " efetuou o emprestimo do livro " + livroTitulo + " com sucesso.");

                }
                else {
                    return;
                }
            }
            else {
                System.out.println("Usuario " + usuarioNome + " nao pode efetuar emprestimo.");
                System.out.println("Antes, o usuario deve devolver o livro " + livroTitulo + ".");
            }
        }
        else {
            System.out.println("Nao ha exemplar do livro " + livroTitulo + " disponivel no momento.");
            System.out.println("O usuario " + usuarioNome + " nao pode efetuar o emprestimo.");
        }
    };

    public void devolver(Usuario usuario, Livro livro) {
        String usuarioNome = usuario.getNome();
        String livroTitulo = livro.getTitulo();
        String livroId = livro.getId();
        boolean emprestado = usuario.buscarLivroEmprestimo(livroId);

        if (emprestado) {
            usuario.removerEmprestimo(livro);
            System.out.println("Devolucao concluida:");
            System.out.println("O usuario " + usuarioNome + " devolveu o livro " + livroTitulo + ".");
        }
        else {
            System.out.println("Devolucao nao foi concluida:");
            System.out.println("O usuario " + usuarioNome + " nao possui um emprestimo ativo");
            System.out.println("do livro " + livroTitulo + ".");

        }
    };
}

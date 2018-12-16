package iusistema;

public class Emprestimo {

    private static Emprestimo instancia;
	private Emprestimo() {}


	public static Emprestimo obterInstancia() {
		if (instancia == null) {
			instancia = new Emprestimo();
		}
		return instancia;
	}

    public void fazerEmprestimo(Usuario usuario, Livro livro) {
        String usuarioNome = usuario.getNome();
        String livroTitulo = livro.getTitulo();

        if (livro.exemplarDisponivel()) {
            if (!usuario.devedor()) {
                if (usuario.verficarRegras(livro)) {

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
            System.out.println("Nao foi possivel efetuar o emprestimo do livro: " + livroTitulo + ".");
        }

    }
}


// (i) houver a disponibilidade de algum exemplar daquele livro na biblioteca;
// (ii) o usuário não estiver “devedor” de um livro em atraso;
// (iii) forem obedecidas as regras específicas daquele tipo de usuário
//       no que se refere à quantidade máxima de empréstimos, de acordo com a Tabela 2;
// (iv) a quantidade de reservas existentes do livro formenor do que a quantidade de exemplares disponíveis,
//      caso o usuário não tenha reserva para ele;
// (vi) a quantidade de reservas for maior ou igual a de exemplares, mas uma das reservas é do usuário;
// (vi) o usuário não tiver nenhum empréstimo em curso de um exemplar daquele mesmo livro.


// (i) houver a disponibilidade de algum exemplar daquele livro na biblioteca;
// (ii) o usuário não estiver “devedor” de um livro em atraso.
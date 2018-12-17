
package iusistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Biblioteca {

    private static Biblioteca instancia;
    private HashMap<String, Object> listaUsuarios = new HashMap<String, Object>();

    // Preenche a lista de usuarios no próprio construtor
    private Biblioteca() {
        this.listaUsuarios.put("123", new AlunoGraduacao("123", "João da Silva"));
        this.listaUsuarios.put("456", new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        this.listaUsuarios.put("789", new AlunoGraduacao("789", "Pedro Paulo"));
        this.listaUsuarios.put("100", new Professor("100", "Carlos Lucena"));
    };

	public static Biblioteca obterInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	};

    private Usuario obterUsuarioPorId(String usuarioId) {
        Usuario usuario = (Usuario) listaUsuarios.get(usuarioId);
        return usuario;
    };

    private Livro obterLivroPorId(String livroId) {
        Estante estante = Estante.obterInstancia();
        Livro livro = estante.getLivroPorId(livroId);
        return livro;
    };

	public void fazerEmprestimo(String usuarioId, String livroId) {
        Emprestimo emprestimo = Emprestimo.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        Livro livro = obterLivroPorId(livroId);
        emprestimo.fazerEmprestimo(usuario, livro);
    };

	public void devolver(String usuarioId, String livroId) {
        Emprestimo emprestimo = Emprestimo.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        Livro livro = obterLivroPorId(livroId);
        emprestimo.devolver(usuario, livro);
    };

    public void reservar(String usuarioId, String livroId) {
        Reserva reserva = Reserva.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        Livro livro = obterLivroPorId(livroId);
        reserva.reservar(usuario, livro);
    };

    public void observar(String usuarioId, String livroId) {
        Estante estante = Estante.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        estante.addObservador(usuario);
    };

	public void consultarLivro(String livroId) {
        Estante estante = Estante.obterInstancia();
        Livro livro = estante.getLivroPorId(livroId);

        String livroTitulo = livro.getTitulo();
        System.out.println("Titulo: " + livroTitulo);

        int qtdReservas = livro.getQtdReservas();
        System.out.println("Quantidade de reservas: " + qtdReservas);

        if (qtdReservas != 0) {
            livro.getReservasNomes();
        }

        livro.printListaExemplares();
    };

	public void consultarUsuario(String usuarioId) {

        Usuario usuario = this.obterUsuarioPorId(usuarioId);
        // Listar esmprestimos correntes
        // Listar emprestimos passados
        usuario.printReservas();

    };

    public void notificacaoProfessor(String usuarioId) {
        Usuario usuario = (Usuario) obterUsuarioPorId(usuarioId);
        int aux = usuario.getNotificacoes();

        String nome = usuario.getNome();

        System.out.println("O professor " + nome + " foi notificado " + aux + " vezes.");
    };

}

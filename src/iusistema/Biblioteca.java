
package iusistema;

public class Biblioteca {

    private static Biblioteca instancia;
    private HashMap<String, Object> listaUsuarios = new HashMap<String, Object>();

    // Preenche a lista de usuarios no próprio construtor
    private Biblioteca() {
        this.listaUsuarios.put("123", new AlunoGraduacao("123", "João da Silva"));
        this.listaUsuarios.put("456", new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        this.listaUsuarios.put("789", new AlunoGraduacao("789", "Pedro Paulo"));
        this.listaUsuarios.put("100", new Professor("100", "Carlos Lucena"));
    }

	public static Biblioteca obterInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

    private Usuario obterUsuarioPorId(String usuarioId) {
        Usuario usuario = listaUsuarios.get(usuarioId);
        return usuario;
    }

    private Livro obterLivroPorId(String livroId) {
        Estante estante = Estante.obterInstancia();
        Livro livro = estante.getLivroPorId(livroId);
        return livro;
    }

	public void fazerEmprestimo(String usuarioId, String livroId) {}
	public void devolver(String usuarioId, String livroId) {}

    public void reservar(String usuarioId, String livroId) {
        Reserva reserva = Reserva.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        Livro livro = obterLivroPorId(livroId);
        reserva.reservar(usuario, livro);
    }

    public void observar(String usuarioId, String livroId) {
        Estante estante = Estante.obterInstancia();
        Usuario usuario = obterUsuarioPorId(usuarioId);
        estante.addObservador(usuario);
    }

	public void consultarLivro(String livroId) {}
	public void consultarUsuario(String usuarioId) {}

}

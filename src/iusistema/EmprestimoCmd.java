
package iusistema;

public class EmprestimoCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {

		Biblioteca blib = Biblioteca.obterInstancia();
		blib.fazerEmprestimo(usuarioId, livroId);
	}
}

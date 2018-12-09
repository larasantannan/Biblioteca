
package iusistema;

public class DevolucaoCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {

		Biblioteca blib = Biblioteca.obterInstancia();
		blib.devolver(usuarioId, livroId);

	}

}

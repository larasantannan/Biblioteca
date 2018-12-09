
package iusistema;

public class ObservadorCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {

        Biblioteca blib = Biblioteca.obterInstancia();
		blib.observar(usuarioId, livroId);
	}
}

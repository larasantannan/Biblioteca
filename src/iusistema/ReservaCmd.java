
package iusistema;

public class ReservaCmd implements Cmd {
    @Override
	public void executar(String usuarioId, String livroId) {

		Biblioteca blib = Biblioteca.obterInstancia();
		blib.reservar(usuarioId, livroId);

	}
}

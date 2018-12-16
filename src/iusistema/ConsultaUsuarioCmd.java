
package iusistema;

public class ConsultaUsuarioCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {

		Biblioteca blib = Biblioteca.obterInstancia();
		blib.consultarUsuario(usuarioId);

	}

}

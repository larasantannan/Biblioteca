
package iusistema;

public class NotificacaoCmd implements Cmd{

    @Override
	public void executar(String usuarioId, String livroId) {

        Biblioteca blib = Biblioteca.obterInstancia();
        blib.notificacaoProfessor(usuarioId);

	}
}


package iusistema;

public class SairCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {
		sair();
	}

	private void sair() {
		System.exit(0);
	}
}

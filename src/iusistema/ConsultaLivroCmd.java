
package iusistema;

public class ConsultaLivroCmd implements Cmd {

    @Override
	public void executar(String usuarioId, String livroId) {
            livroId = usuarioId;

            Biblioteca blib = Biblioteca.obterInstancia();
            blib.consultarLivro(livroId);

	}
}

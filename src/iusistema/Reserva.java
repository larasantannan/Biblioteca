
package iusistema;

public class Reserva {

    private static Reserva instancia;
	private Reserva() {}


	public static Reserva obterInstancia() {
		if (instancia == null) {
			instancia = new Reserva();
		}
		return instancia;
	}

    public void reservar(Usuario usuario, Livro livro) {
        String usuarioNome = usuario.getNome();
        String livroTitulo = livro.getTitulo();

        if (usuario.getQntReserva() == 3) {
            System.out.println("Usuario " + usuarioNome + " ja possui 3 reservas.");
            System.out.println("Nao foi possivel reservar o livro: " + livroTitulo);
        } else {
            int aux = usuario.getQntReserva();
            aux += 1;
            usuario.setQntReservas(aux);

            aux = livro.getQntReserva();
            aux += 1;
            livro.setQntReservas(aux); // Como notificar aos observadores que o livro possui mais de 2 reservas?

            usuario.addLivroReserva(livro);
            
            System.out.println("Usuario " + usuarioNome + " efetuou a reserva do livro " + livroTitulo + " com sucesso.");
        }
    }
}

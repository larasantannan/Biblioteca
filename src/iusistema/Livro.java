
package iusistema;

public class Livro {

    private String id;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private String anoPublicacao;
    private int qtdReservas = 0;

	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao) {

		this.id = codigo;
		this.titulo = titulo;
		this.editora = editora;
        this.autores = autores;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	}

	public String getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

    public int getQtdReservas() {
        return this.qtdReservas;
    }

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }
}

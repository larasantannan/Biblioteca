
package iusistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Livro {

    private String id;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private String anoPublicacao;
    private int qtdReservas = 0;
    private List<Usuario> listaReservas = new ArrayList();
    private List<Exemplar> listaExemplares = new ArrayList();

	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao) {

		this.id = codigo;
		this.titulo = titulo;
		this.editora = editora;
        this.autores = autores;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	};

	public String getId() {
		return this.id;
	};

	public String getTitulo() {
		return this.titulo;
	};

    public int getQtdReservas() {
        return this.qtdReservas;
    };

    public List<String> getReservasNomes() {
        List<String> nomes = new ArrayList<>();
        for (Iterator iterator = listaReservas.iterator(); iterator.hasNext();) {
            Usuario usuario = (Usuario) iterator.next();
            nomes.add(usuario.getNome());
		}
        return nomes;
    };

    public void addExemplar(String exemplarId, Bool disponibilidade) {
        Exemplar exemplar = new Exemplar(exemplarId, disponibilidade);
        this.listaExemplares.add(exemplar);
    };

    public Exemplar getExemplarDisponivel() {
        Exemplar exemplar;
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            if (iterator.next().getDisponibilidade()) {
                iterator.next().mudarDisponibilidade();
                exemplar = (Exemplar) iterator.next();
                break;
            }
		}
        return exemplar;
    };

    public Bool exemplarDisponivel() {
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            if (iterator.next().getDisponibilidade()) {
                return true;
            }
		}
        return false;
    };

    public int getQtdExemplaresDisponiveis() {
        int qtd = 0;
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            if (iterator.next().getDisponibilidade()) {
                qtd += 1;
            }
		}
        return qtd;
    };

    public void addUsuarioReserva(Usuario usuario) {
        this.listaReservas.add(usuario);
    };

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    };
}


package iusistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;

public class Livro {

    private String id;
	private String titulo;
	private String editora;
	private String autores;
	private String edicao;
	private String anoPublicacao;
    private int qtdReservas;
    private List<Usuario> listaReservas = new ArrayList();
    private List<Exemplar> listaExemplares = new ArrayList();

	public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao) {

		this.id = codigo;
		this.titulo = titulo;
		this.editora = editora;
        this.autores = autores;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;

        this.qtdReservas = 0;
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

    public void getReservasNomes() {
        System.out.println("Lista de usuarios que reservaram o livro:");
        for (Iterator iterator = this.listaReservas.iterator(); iterator.hasNext();) {
            Usuario usuario = (Usuario) iterator.next();
            String nome = usuario.getNome();

            System.out.print(nome + " ");
		}
        System.out.println();
    };

    public void addExemplar(String exemplarId, boolean disponibilidade) {
        Exemplar exemplar = new Exemplar(exemplarId, disponibilidade);
        this.listaExemplares.add(exemplar);
    };

    public Exemplar getExemplarDisponivel() {
        Exemplar exemplar = null;
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            exemplar = (Exemplar) iterator.next();
            if (exemplar.getDisponibilidade()) {
                iterator.remove();

                exemplar.mudarDisponibilidade();

                String exemplarId = exemplar.getExemplarId();
                boolean exemplarDisponibilidade = exemplar.getDisponibilidade();
                this.addExemplar(exemplarId, exemplarDisponibilidade);
                break;
            }
		}
        return exemplar;
    };

    public boolean exemplarDisponivel() {
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            Exemplar exemplar = (Exemplar) iterator.next();
            if (exemplar.getDisponibilidade()) {
                return true;
            }
		}
        return false;
    };

    public int getQtdExemplaresDisponiveis() {
        int qtd = 0;
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            Exemplar exemplar = (Exemplar) iterator.next();
            if (exemplar.getDisponibilidade()) {
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

    public void setDisponibilidadeExemplarLista(Exemplar exemplar){
        String exemplarId = exemplar.getExemplarId();
        Exemplar aux = null;
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            aux = (Exemplar) iterator.next();
            String auxId = aux.getExemplarId();

            if (exemplarId == auxId) {
                iterator.remove();
                aux.mudarDisponibilidade();

                boolean exemplarDisponibilidade = aux.getDisponibilidade();
                this.addExemplar(auxId, exemplarDisponibilidade);
                break;
            }
        }
    };

    public void printListaExemplares() {
        System.out.println("Lista de exemplares:");
        for (Iterator iterator = this.listaExemplares.iterator(); iterator.hasNext();) {
            Exemplar exemplar = (Exemplar) iterator.next();
            String id = exemplar.getExemplarId();
            boolean status = exemplar.getDisponibilidade();

            if (status) {
                System.out.println("O exemplar " + id + " esta disponivel.");
            }
            else {
                Date dataEmprestimo = exemplar.getDataEmprestimo();
                Date dataPrevisao = exemplar.getDataDevolucao();
                //System.out.println("O exemplar " + id + " esta emprestado para o usuario " + usuarioNome + ".");
                System.out.println("Emprestimo efetuado em: " + dataEmprestimo
                                 + " com previsao de devolucao para ate: " + dataPrevisao + ".");
            }
		}

        System.out.println();
    };
}

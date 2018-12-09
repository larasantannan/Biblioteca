
package iusistema;

public class AlunoPosGraduacao implements Usuario {

    private String id;
    private String nome;
    private int qtdReservas = 0;
    private List<Livros> listaReservas = new ArrayList();
    private final int limiteEmprestimo = 4;

    @Override
    public void Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    @Override
    public void update() {}

    @Override
    public int getQntReservas() {
        return this.qtdReservas;
    }

    @Override
    public void setQntReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }

    @Override
    public void addLivroReserva(Livro livro) {
        this.listaReserva.add(livro);
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}

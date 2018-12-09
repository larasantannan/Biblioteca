
package iusistema;

public interface Usuario {
    public void update();
    public int getQtdReservas();
    public void setQtdReservas(int qtdReservas);
    public void addLivroReserva(Livro livro);
    public String getNome();
}

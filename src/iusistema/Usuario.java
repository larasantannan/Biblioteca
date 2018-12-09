
package iusistema;

public interface Usuario {
    public void update();
    public int getQntReservas();
    public void setQntReservas(int qtdReservas);
    public void addLivroReserva(Livro livro);
    public String getNome();

}

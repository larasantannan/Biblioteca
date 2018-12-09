
package iusistema;

public interface SujeitoObservavel {
    public void addObservador(Usuario usuario);
    public void removerObservador(Usuario usuario);
    public void notificarObservador(Livro livro);
}

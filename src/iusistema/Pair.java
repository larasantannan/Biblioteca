package iusistema;

public class Pair {

    private Livro livro;
    private Exemplar exemplar;

    public Pair(Livro livro, Exemplar exemplar) {
        this.livro = livro;
        this.exemplar = exemplar;
    };

    public Exemplar getValue() {
        return this.exemplar;
    };

    public Livro getKey() {
        return this.livro;
    };
}

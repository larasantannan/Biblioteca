package iusistema;

import java.util.Date;

public class LivDat {

    private Livro livro;
    private Date data;

    public LivDat(Livro livro, Date data) {
        this.livro = livro;
        this.data = data;
    };

    public Livro getKey() {
        return this.livro;
    };

    public Date getValue() {
        return this.data;
    };
}

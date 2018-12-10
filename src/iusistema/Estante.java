
package iusistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estante implements SujeitoObservavel {

    private static List<Usuario> observadores = new ArrayList<Usuario>();
    private HashMap<String, Object> listaLivros = new HashMap<String, Object>();
    private static Estante instancia;

    // Preenche a lista de livros no próprio construtor
    private Estante() {
        this.listaLivros.put("100", new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommerville", "6", "2000"));
        this.listaLivros.put("101", new Livro("101", "UML - Guia do Usuario", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7", "2000"));
        this.listaLivros.put("200", new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnel", "2", "2014"));
        this.listaLivros.put("201", new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", "Robert Martin", "1", "2002"));
        this.listaLivros.put("300", new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1", "1999"));
        this.listaLivros.put("301", new Livro("301", "Software Metrics: Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3", "2014"));
        this.listaLivros.put("400", new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma Richard Helm, Ralph Johnson, John Vlissides", "1", "1994"));
        this.listaLivros.put("401", new Livro("401", "UML Distilled: A Brief Guide to the Standart Object Modeling Language", "Addinson-Wesley Professional", "Martin Fowler", "3", "2003"));

        // Exemplares
        Livro livro;
        livro = this.listaLivros.get("100");
        livro.addExemplar("01", true);
        livro.addExemplar("02", true);

        livro = this.listaLivros.get("101");
        livro.addExemplar("03", true);

        livro = this.listaLivros.get("200");
        livro.addExemplar("04", true);

        livro = this.listaLivros.get("201");
        livro.addExemplar("05", true);

        livro = this.listaLivros.get("300");
        livro.addExemplar("06", true);
        livro.addExemplar("07", true);

        livro = this.listaLivros.get("400");
        livro.addExemplar("08", true);
        livro.addExemplar("09", true);
    }

    public static Estante obterInstancia() {
        if (instancia == null){
            instancia = new Estante();
        }
        return instancia;
    }

    public Livro getLivroPorId(String livroId) {
        Livro livro = (Livro) listaLivros.get(livroId);
        return livro;
    }

    @Override
    public void addObservador(Usuario usuario) {
        observadores.add(usuario);
    }

    @Override
    public void removerObservador(Usuario usuario) {
        int i = observadores.indexOf(usuario);
		if (i >= 0) {
			observadores.remove(i);
        }
    }

    @Override
    public void notificarObservador(Livro livro) {
        for (int i = 0; i < observadores.size(); i++) {
            Usuario usuario = (Usuario)observadores.get(i);
		    usuario.update();

            String livroTitulo = livro.getTitulo();
            String usuarioNome = usuario.getNome();
            System.out.println(usuarioNome + ", o livro : " + livroTitulo + " possui " + livro.getQtdReservas() + "reservas.");
	    }
    }
}

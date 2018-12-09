/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iusistema;

public class Biblioteca {
    
    private static Biblioteca instancia;
	private Biblioteca() {}
	
	
	public static Biblioteca obterInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}	
	
	public void fazerEmprestimo(String usuario, String livro) {}
	public void devolver(String usuario, String livro) {}
	public void reservar(String usuario, String livro) {}
	public void consultarLivro(String livro) {}
	public void consultarUsuario(String usuario) {}
    
}

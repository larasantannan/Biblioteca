/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iusistema;

/**
 *
 * @author Lara
 */
public class EmprestimoCmd implements Cmd{
    
    @Override
	public void executar(String usuario, String livro) {
		
		Biblioteca blib = Biblioteca.obterInstancia();
		blib.fazerEmprestimo(usuario, livro);
                
                //estante = Estante.obterInstancia();
                
                System.out.println("Oi");
		
	}
    
}

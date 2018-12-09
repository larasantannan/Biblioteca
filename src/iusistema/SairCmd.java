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
public class SairCmd implements Cmd{
    
    @Override
	public void executar(String usuario, String livro) {
		sair();
	}
	
	private void sair() {
		System.exit(0);
	}
    
}

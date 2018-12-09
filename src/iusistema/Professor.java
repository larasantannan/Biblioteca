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
public class Professor implements Usuario{
    private String id;
    private String nome;
    private int notificacao;

    @Override
    public void update() {
        this.notificacao++;
    }
}

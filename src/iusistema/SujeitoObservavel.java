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
public interface SujeitoObservavel {
    public void addObservador(Usuario usuario);
    public void removerObservador(Usuario usuario);
    public void notificarObservador();
}

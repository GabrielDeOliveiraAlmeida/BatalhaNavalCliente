/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import game.GameInterface;

/**
 *
 * @author gabriel
 */
public class ControladorUI {

    public static GameInterface iu = new GameInterface();

    public void prontoParaJogar() {
        iu.prontoPosicionar();
    }

    public void novoJogo(){
        iu.novoJogo();
    }
    public void abrirInterface() {
        iu.setLocationRelativeTo(null);
        iu.setVisible(true);
    }
    
    public void vitorioso(int i){
        iu.vitorioso(i);
    }
    
    public void acertouTiro(){
        iu.acertouTiro();
    }
    
    public void errouTiro(){
        iu.errouTiro();
    }
    
    public void coordInimigo(int x, int y){
        iu.coordInimigo(x,y);
    }
    
    public void passarVez(){
        iu.passarVez();
    }
    
    public void atingido(){
        iu.atingido();
    }
    
    public void setVez(){
        iu.setVez();
    }
}


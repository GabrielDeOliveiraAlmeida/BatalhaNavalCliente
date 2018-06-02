/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import cliente.TrataServidor;

/**
 *
 * @author gabriel
 */
public class Controlador {
    public static TrataServidor game = new TrataServidor();
    
    public void conectar(String ip, int porta, String user){
        game.conectar(ip, porta, user);
    }
    public void fila(){
        game.fila();
    }
    public void desconectar(){
        game.desconectar();
    }
    public void espera(){
        game.espera();
    }
   
    public void apontar(int x,int y, int tipo){
        game.apontar(x,y, tipo);
    }
    
    public void toPronto(){
        game.toPronto();
    }
    
    public void fogo(int x, int y){
        game.fogo(x,y);
    }
    
    public void verificarVez(){
        game.verificarVez();
    }
    
    public void sairFila(){
        game.sairFila();
    }
    
    public void abandonarPartida(){
        game.abandonarPartida();
    }
}

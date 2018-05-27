/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import cliente.Cliente;

/**
 *
 * @author gabriel
 */
public class Controlador {
    public static Cliente game = new Cliente();
    
    public Boolean conectar(String ip, int porta, String user){
        return game.conectar(ip, porta, user);
    }
    public Boolean fila(){
        return game.fila();
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
    
    public Boolean toPronto(){
        return game.toPronto();
    }
    
    public Integer fogo(int x, int y){
        return game.fogo(x,y);
    }
}

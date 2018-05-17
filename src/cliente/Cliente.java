/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import game.GameLogin;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import respostas.Mensagem;

/**
 *
 * @author gabriel
 */
public class Cliente
{
    private ObjectInputStream entrada;
    private ObjectOutputStream saida;
    private String user;
    private int porta;
    private String ip;
    
    private Socket socket;
    public Cliente(){
        
    }
    
    public static void main(String[] args) {
        
            // TODO code application logic here
        GameLogin log = new GameLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        
        //ClienteBN cliente = new ClienteBN("localhost", 55555);
        
        
    }
    
    public Boolean conectar(String ip, int porta,String user){
        try{
            this.socket = new Socket(ip, porta);
            this.ip = ip;
            this.porta = porta;
            this.user = user;
            
            entrada = new ObjectInputStream(socket.getInputStream());
            saida = new ObjectOutputStream(socket.getOutputStream());
            
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro de Exceção, entrada e saida (CLIENTE)");
            return false;
            
        }
        return true;
    }

 
    public Boolean fila(){
        int code;
        
        try {
            saida.writeInt(Mensagem.jogar);
            code = entrada.readInt();
            System.out.println(code);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public void espera(){
        int code;
        try {
            //Scanner scan = new Scanner(entrada);
            code = entrada.readInt();
            System.out.println(code);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
    public void desconectar(){
        int code;
        try{
           // saida.writeInt(Mensagem.desconectar);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

     public void preparar(int mat[][]){
         int code;
         try {
            saida.writeInt(Mensagem.prontoJogar);
            code = entrada.readInt();
            System.out.println(code);
            saida.writeObject(mat);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     }   
    
    
}

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
public class Cliente implements Runnable{

    private DataInputStream entrada;
    private DataOutputStream saida;
    private String jog;
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
        
        int code;
        //ClienteBN cliente = new ClienteBN("localhost", 55555);
        
        
    }

    public void run(){
        
    }
    
    public void cancelar(Boolean a){
        
    }
    public Boolean conectar(String ip, int porta,String user){
        try{
            this.socket = new Socket(ip, porta);
            this.ip = ip;
            this.porta = porta;
            this.jog = user;
            
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro de Exceção, entrada e saida (CLIENTE)");
            return false;
            
        }
        return true;
    }

 
    public Boolean fila(){
        int code1, code2;
        try {
            saida.writeInt(Mensagem.jogar);
            code1 = entrada.readInt();
            code1 = entrada.readInt();
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
    
    
    public void apontar(int x, int y, int tipo){
        try{
            saida.writeInt(Mensagem.posicionar);
            saida.writeInt(tipo);
            saida.writeInt(x);
            saida.writeInt(y);
            int ok = entrada.readInt();
            System.out.println(ok);
        }
        catch(IOException e){
            
        }
    }
    
    
    public Boolean toPronto(){
        try {
            saida.writeInt(Mensagem.prontoJogar);
            entrada.readInt();
            entrada.readInt();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Integer fogo(int x, int y){
        try{
            if(!verificarVez()){
                JOptionPane.showMessageDialog(null,"Não é Sua vez de Jogar!");
                return null;
            }
//            
            saida.writeInt(Mensagem.coordenadas);
            saida.writeInt(x);
            saida.writeInt(y);
            int aux = entrada.readInt();
            if(aux == Mensagem.coordendasVencedor){
                return 2;
            }
            else if(aux == Mensagem.coordenadasSucesso){
                return 1;
            }
            else{
                return 0;
            }
            
        }catch(Exception e){
            
        }
        return 0;
    }
    
    public Boolean verificarVez(){
        try {
            saida.writeInt(Mensagem.jogarAguardar);
            return entrada.readInt() == Mensagem.jogar;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

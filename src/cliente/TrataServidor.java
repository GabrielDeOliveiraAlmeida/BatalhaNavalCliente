/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import controlador.ControladorUI;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import respostas.Mensagem;

/**
 *
 * @author gabriel
 */
public class TrataServidor implements Runnable {

//    private DataInputStream entrada;
//    private DataOutputStream saida;
    private AlmiranteCliente cliente;
//    private String jog;
//    private int porta;
//    private String ip;
//    private Socket socket;

    Thread s;
    public TrataServidor(){
        
    }
//    public TrataServidor(AlmiranteCliente cliente){
//        this.cliente = cliente;
//        s = new Thread();
//        s.start();
//    }
    @Override
    public void run() {
        int code;

        while (true) {
            code = cliente.readInt();
            if (code == Mensagem.desconectar) {
                //       break;
            }
            interpretador(code);
        }
    }

    private void interpretador(int code) {
        switch (code) {
            case Mensagem.filaSucesso:
                //System.out.println("Mensagem para JOGAR (Oponente Encontrado) recebida de: " + this.socket.getInetAddress().getHostAddress());
                prontoParaJogar();
                break;
            case Mensagem.fila:
                
                break;
            case Mensagem.vencedor:
                vitorioso(1);
                break;
            case Mensagem.coordendasVencedor:
                vitorioso(2);
                break;
            case Mensagem.fracassado:
                fracassado();
                break;
            case Mensagem.prontoJogarSucesso:
                novoJogo();
                break;
            case Mensagem.coordenadasSucesso:
                acertouTiro();
                break;
            case Mensagem.coordenadasFalha:
                errouTiro();
                break;
            case Mensagem.coordenadasInimigo:
                coordInimigo();
                break;
            case Mensagem.jogarAguardar:
                aguarde();
                break;
            case Mensagem.jogar:
                atirar();
                break;
            case Mensagem.passarVez:
                passarVez();
            default:
                System.out.println(code);
        }
    }

    public void coordInimigo() {
        int x;
        int y;
        x = cliente.readInt();
        y = cliente.readInt();
        ControladorUI.iu.coordInimigo(x, y);

    }

    public void fracassado(){
        ControladorUI.iu.fracasso();
    }
    public void acertouTiro() {
        ControladorUI.iu.acertouTiro();
    }

    public void errouTiro() {
        ControladorUI.iu.errouTiro();

    }

    public void novoJogo() {
        verificarVez();
        ControladorUI.iu.novoJogo();
    }

    public void cancelar(Boolean a) {

    }

    public void prontoParaJogar() {
        ControladorUI.iu.prontoParaJogar();
    }

    public void vitorioso(int i) {
        ControladorUI.iu.vitorioso(i);
    }

    public void conectar(String ip, int porta, String user) {
        cliente = new AlmiranteCliente(ip, porta, user);  
        s = new Thread(this);
        s.start();
    }

    public void fila() {
        int code1, code2;
        cliente.writeInt(Mensagem.jogar);
    }

    public void sairFila() {
        cliente.writeInt(Mensagem.sair);

    }

    public void abandonarPartida() {
        cliente.writeInt(Mensagem.abandonar);

    }

    public void espera() {
        int code;
        //Scanner scan = new Scanner(entrada);
        code = cliente.readInt();

    }

    public void desconectar() {
        int code;
        cliente.writeInt(Mensagem.desconectar);
    }

    public void apontar(int x, int y, int tipo) {
        cliente.writeInt(Mensagem.posicionar);
        cliente.writeInt(tipo);
        cliente.writeInt(x);
        cliente.writeInt(y);
    }

    public void toPronto() {
        cliente.writeInt(Mensagem.prontoJogar);
    }

    public void fogo(int x, int y) {
        try {
            
            cliente.writeInt(Mensagem.coordenadas);
            cliente.writeInt(x);
            cliente.writeInt(y);

        } catch (Exception e) {
            System.out.println("Excessao FOGO");
        }
    }

    public void verificarVez() {
        cliente.writeInt(Mensagem.verificarTurno);
    }
    
    public void aguarde(){
        ControladorUI.iu.aguarde();
    }
    
    public void atirar(){
        ControladorUI.iu.atirar();
    }

    public void passarVez(){
        ControladorUI.iu.passarVez();
    }
}

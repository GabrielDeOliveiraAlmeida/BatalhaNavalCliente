/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import respostas.Status;

/**
 *
 * @author gabriel
 */
public class AlmiranteCliente {

    private Socket cliente;
    private int porta;
    private String nome;
    private Status status;
    private DataInputStream entrada;
    private DataOutputStream saida;

    public AlmiranteCliente(String ip, int porta, String nome) {
        try {
            cliente = new Socket(ip, porta);
            status = Status.CONECTADO;
            this.porta = porta;
            this.nome = nome;

            entrada = new DataInputStream(cliente.getInputStream());
            saida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Exceção, entrada e saida (CLIENTE)");
        }

    }

    public int readInt() {
        try {
            return entrada.readInt();
        } catch (IOException ex) {
            Logger.getLogger(AlmiranteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void writeInt(int m) {
        try {
            saida.writeInt(m);
        } catch (IOException ex) {
            Logger.getLogger(AlmiranteCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean desconectar() {

        try {
            entrada.close();
            saida.close();
            System.out.println("Cliente desconectado");
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public int hasObject(Scanner scan) {
        scan = new Scanner(entrada);
        if (scan.hasNext()) {
            if (scan.hasNextInt()) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

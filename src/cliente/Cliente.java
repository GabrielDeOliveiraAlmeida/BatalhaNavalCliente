/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import game.GameInterface;
import game.GameLogin;

/**
 *
 * @author gabriel
 */
public class Cliente {

    public static void main(String[] args) {

        // TODO code application logic here
        GameLogin log = new GameLogin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
    }

}

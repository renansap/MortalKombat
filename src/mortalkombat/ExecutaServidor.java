/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

/**
 *
 * @author Ksa
 */
public class ExecutaServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SeverKombat mucs = new SeverKombat();
        mucs.configurarServidor();
        mucs.aguardarClientes();
    }
    
}


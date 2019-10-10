/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.awt.event.KeyEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ksa
 */
public class SeverKombat extends javax.swing.JFrame implements Runnable {

    Player player;
    Boolean keyRight = false, keyLeft = false, keyUp = false, keyDown = false;
    Thread t;
    Integer speed = 4;

    public SeverKombat() {
        initComponents();
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = true;
                break;
            case KeyEvent.VK_LEFT:
                keyLeft = true;
                break;
            case KeyEvent.VK_UP:
                keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = true;
                break;
        }

    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here elias
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = false;
                break;
            case KeyEvent.VK_LEFT:
                keyLeft = false;
                break;
            case KeyEvent.VK_UP:
                keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = false;
                break;
        }
    }//GEN-LAST:event_formKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        player = new Player();
        player.setup();
        getContentPane().add(player);
        repaint();
        t = new Thread(this);
        t.start();
    }//GEN-LAST:event_formWindowOpened

    static List<Jogador> clientes = new ArrayList<>();
    ServerSocket ss;
    Socket socketNovoCliente;

    public void configurarServidor() {
        try {
            ss = new ServerSocket(8200);
            
            System.out.println("linha 84" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aguardarClientes() {
        try {
            while (true) {
                socketNovoCliente = ss.accept();
                Jogador novoCliente = new Jogador(socketNovoCliente);
                clientes.add(novoCliente);
                System.out.println("linha 96" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }

}

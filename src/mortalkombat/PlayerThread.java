/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;


/**
 *
 * @author Ksa
 */
public class PlayerThread implements Runnable {
    Boolean keyRight = false, keyLeft = false, keyUp = false, keyDown = false;

    public Socket socket;
    Player player;
    public static final int SPEED = 8;

    public PlayerThread(Player player, Socket socket) {
        this.player = player;
        this.socket = socket;

    }

    @Override
    public void run() {
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);

            String command = "";

            while (true) {
                System.out.println(command);
            }
        } catch (IOException ex) {
            Logger.getLogger(PlayerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

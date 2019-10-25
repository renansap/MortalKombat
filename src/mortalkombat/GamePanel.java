/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ksa
 */
public class GamePanel implements Runnable {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando");
        players = new Player[2];
        GamePanel kse = new GamePanel();
        Thread th = new Thread(kse);
        th.start();
        kse.waitForPlayer();
    }

    //Player player;
    public static Player[] players;
    public static final int SPEED = 8;
//    Boolean keyRight = false, keyLeft = false, keyUp = false, keyDown = false;
//    Thread t;
//    Integer speed = 4;

    public void waitForPlayer() {
        try {
            ServerSocket ss = new ServerSocket(8880);
            for (int i = 0; i < 2; i++) {
                Socket s = ss.accept();
                Player p1 = new Player(s);
                players[i] = p1;
                PlayerThread p2 = new PlayerThread(p1, s);
                Thread th = new Thread(p2);
                th.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    PrintWriter out;  

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SPEED);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < players.length; i++) {
                if (players[i] != null) {
                    String posicao = players[i].id + "_" + players[i].x + "_" + players[i].y + "_" + players[i].w + "_" + players[i].h + "_" + players[i].lado + "_" + players[i].pontos;
                    players[i].out.println(posicao);
                    System.out.println(posicao);

                    for (int h = 0; h < players.length; h++) {
                        if (h != i && players[h] != null) {
                            players[h].out.println(posicao);
                            System.out.println(posicao);
                            double x = 0, y = 0;

                            if (players[i].punch == 1) {
                                players[i].punch = 0;

                                if (players[i].x > players[h].x) {
                                    x = players[i].x - players[h].x;

                                } else {
                                    x = players[h].x - players[i].x;
                                }

                                if (players[i].y > players[h].y) {
                                    y = players[i].y - players[h].y;

                                } else {
                                    y = players[h].y - players[i].y;
                                }

                                if (x < 50 && y < 50) {
                                    players[i].pontos = players[i].pontos + 1;
                                }
                            }
                            if (players[h].punch == 1) {
                                players[h].punch = 0;

                                if (players[i].x > players[h].x) {
                                    x = players[i].x - players[h].x;

                                } else {
                                    x = players[h].x - players[i].x;
                                }

                                if (players[i].y > players[h].y) {
                                    y = players[i].y - players[h].y;

                                } else {
                                    y = players[h].y - players[i].y;
                                }

                                if (x < 50 && y < 50) {
                                    players[h].pontos = players[h].pontos + 1;

                                }
                            }

                        }

                    }

                }
            }

        }
    }

//
//    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        // TODO add your handling code here:
//        player = new Player();
//        player.setup();
//        getContentPane().add(player);
//        repaint();
//        t = new Thread(this);
//        t.start();
//    }//GEN-LAST:event_formWindowOpened
//
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    double width = screenSize.getWidth();
//    double height = screenSize.getHeight();
//
//    /**
//     * @param args the command line arguments
//     */
//    boolean lEsq = false;
//    boolean lDir = true;
//
//    public void updateGame() {
//
//        if (keyRight) {//move direita
//            player.setIconRight();
//            player.x += speed;
//            lDir = true;
//            lEsq = false;
//        }
//
//        if (keyLeft) {//move esquerda
//            player.setIconLeft();
//            player.x -= speed;
//            lEsq = true;
//            lDir = false;
//        }
//
//        if (keyUp) {
//            player.y -= speed;
//        }
//
//        if (keyDown) {
//            player.y += speed;
//        }
//
//        if (!(keyDown || keyUp || keyLeft || keyRight)) {
//            if (lDir) {
//                player.setIconStoppedD();
//            }
//            if (lEsq) {
//                player.setIconStoppedE();
//            }
//        }
//
//        player.move();
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                updateGame();
//                Thread.sleep(20);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

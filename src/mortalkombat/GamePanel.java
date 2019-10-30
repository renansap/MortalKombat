/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ksa
 */
public class GamePanel implements Runnable {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando");
//        players = new Player[2];
        System.out.println("Iniciando 2");
        GamePanel kse = new GamePanel();
        System.out.println("Iniciando 3");
        Thread th = new Thread(kse);
        System.out.println("Iniciando 4");
        th.start();
        System.out.println("Iniciando 5");
        kse.waitForPlayer();
        System.out.println("aguardando playes");
    }

    //Player player;
    public List<Player> players = new ArrayList<>(); // lista do tipo player

    //public static Player[] players;
    public static final int SPEED = 8; //velocidade do jogo
//    Boolean keyRight = false, keyLeft = false, keyUp = false, keyDown = false;
//    Thread t;
//    Integer speed = 4;

    public void waitForPlayer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8880);

            while (true) {
                Socket socket = serverSocket.accept();

                RecebeComandos comandos = new RecebeComandos(socket, adicionarNovoJogador());
                Thread threadNovoJogador = new Thread(comandos);
                threadNovoJogador.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(20);
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).btR) {//move direita
                        if (players.get(i).x < 714) {
                            System.out.println("move direita"); //limitando tamanho da tela dir
                            System.out.println("Posição: " + players.get(i).x);
                            players.get(i).x += SPEED;
                            players.get(i).btR = false;
                            players.get(i).dirR = true;
                        } else {
                            players.get(i).x = 714;
                        }
                        System.out.println("move direita");
                        //System.out.println("Posição: " + players.get(i).x);
                        players.get(i).x += SPEED;
                        players.get(i).btR = false;
                        players.get(i).dirR = true;
                    }
                    if (players.get(i).btL) {//move esquerda
                        if (players.get(i).x > -14) {//limitando tamanho da tela esq
                            System.out.println("move Esquerda");
                            // System.out.println("Posição: " + players.get(i).x);
                            players.get(i).x -= SPEED;
                            players.get(i).btL = false;
                            players.get(i).dirR = false;
                        } else {
                            players.get(i).x = -14;
                        }
                        System.out.println("move Esquerda");
                        players.get(i).x -= SPEED;
                        players.get(i).btL = false;
                        players.get(i).dirR = false;
                    }
                    if (players.get(i).btU) {// move pra cima
                        if (players.get(i).y > 5) {// limit p/cima
                            System.out.println("move Cima");
                            System.out.println("Posição Cima1: " + players.get(i).y);
                            players.get(i).y -= SPEED;
                            players.get(i).btU = false;
                        } else {
                            players.get(i).y = 5;
                        }
                        System.out.println("move Cima");
                        System.out.println("Posição Cima2: " + players.get(i).y);
                        players.get(i).y -= SPEED;
                        players.get(i).btU = false;
                    }
                    if (players.get(i).btD) {
                        if (players.get(i).y < 466) {// limit p/baixo
                            System.out.println("move Baixo");
                            System.out.println("Posição Baixo: " + players.get(i).y);
                            players.get(i).y += SPEED;
                            players.get(i).btD = false;
                        } else {
                            players.get(i).y = 466;
                        }
                        System.out.println("move Baixo");
                        System.out.println("Posição Baixo2: " + players.get(i).y);
                        players.get(i).y += SPEED;
                        players.get(i).btD = false;
                    }

                    String posicaoPlayer = players.get(i).getId() + "_" + players.get(i).x + "_" + players.get(i).y + "_" + players.get(i).dirR + "_"
                            + players.get(i).w + "" + players.get(i).h; // Gravo no array a posição do jogador
                    players.get(i).out.println(posicaoPlayer);

                    for (int j = 0; j < players.size(); j++) {
                        if (j != i) {
                            players.get(j).out.println(posicaoPlayer);
                        }
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Player adicionarNovoJogador() {
        Player novoJogador = new Player();
        novoJogador.setId(players.size() == 0 ? players.size() : players.size() + 1);
        players.add(novoJogador);
        return novoJogador;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalkombat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Ksa
 */
public class ClienteConectado implements Runnable {

    Socket s;
    Thread thRecebeMsg;
    BufferedReader entrada;
    PrintWriter saida;

    public ClienteConectado(Socket s) {
        configurarCliente(s);
    }

    public void configurarCliente(Socket s) {
        this.s = s;
        try {
            entrada = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            saida = new PrintWriter(s.getOutputStream());
            thRecebeMsg = new Thread(this);
            thRecebeMsg.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void receberMensagens() {
        try {
            String msg;
            while ((msg = entrada.readLine()) != null) {
                System.out.println(msg);
                for (ClienteConectado cliente : MortalKombat.clientes) {
                    cliente.enviarMensagem(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String msg) {
        saida.println(msg);
        saida.flush();
    }

    @Override
    public void run() {
        receberMensagens();
    }

}

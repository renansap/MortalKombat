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
public class MortalKombat {

    static List<ClienteConectado> clientes = new ArrayList<>();
    ServerSocket ss;
    Socket socketNovoCliente;

    public void configurarServidor() {
        try {
            ss = new ServerSocket(8200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aguardarClientes() {
        try {
            while (true) {
                socketNovoCliente = ss.accept();
                ClienteConectado novoCliente = new ClienteConectado(socketNovoCliente);
                clientes.add(novoCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

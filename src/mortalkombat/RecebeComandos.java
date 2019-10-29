package mortalkombat;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RecebeComandos implements Runnable {

    public Socket socket;
    public BufferedReader in;
    boolean btR = false,
            btL = false,
            btU = false,
            btD = false;
    public static final int SPEED = 8;
    private Player jogador;

    public RecebeComandos(Socket socket, Player jogador) throws IOException {
        this.socket = socket;
        this.jogador = jogador;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.jogador.out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String command = "";
            while (!(command = in.readLine()).equals("exit")) {
                if (command.equals("PR_R")) {
                    jogador.btR = true;
                }

                if (command.equals("RE_R")) {
                    jogador.btR = false;
                }

                if (command.equals("PR_L")) {
                    jogador.btL = true;
                }

                if (command.equals("RE_L")) {
                    jogador.btL = false;
                }

                if (command.equals("PR_U")) {
                    jogador.btU = true;
                }

                if (command.equals("RE_U")) {
                    jogador.btU = false;
                }

                if (command.equals("PR_D")) {
                    jogador.btD = true;
                }

                if (command.equals("RE_D")) {
                    jogador.btD = false;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}

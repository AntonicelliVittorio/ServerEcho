package tcpserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author antonicelli.vittorio
 */

public class TCPServer{
    public static void main(String[] args)throws IOException{
        int porta = 6000;
        ServerSocket ss = new ServerSocket(porta);
        while(true){
            new ServerThread(ss.accept()).start();
        }
    }
}
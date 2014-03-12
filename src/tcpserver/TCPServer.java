package tcpserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author antonicelli.vittorio
 */

public class TCPServer{
    public static void main(String[] args)throws IOException{
        ServerSocket ss = new ServerSocket(2000);
        while(true){
            new ServerThread(ss.accept()).start();
        }
    }
}
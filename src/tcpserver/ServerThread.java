package tcpserver;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author antonicelli.vittorio
 */

public class ServerThread extends Thread {
    private Socket s;
    private boolean maiusc = false;
    private BufferedReader in = null;
    private PrintWriter out = null;
    
    public ServerThread(Socket s){
        this.s = s;
    }
    public void run(){
        System.out.println ("Connesso a " + s.getInetAddress());
        try{
           in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
           while(true){
                String str = in.readLine();
                if(str.equals("fine")){
                   in.close();
                   out.close();
                   s.close();
                   System.out.println ("Disonnesso da " + s.getInetAddress());
                   break;
                }
                if(str.equals("maiuscole:on")){
                    maiusc = true;
                }
                if(str.equals("maiuscole:off")){
                    maiusc = false;
                }
                if(str.equals("maiuscole:on") == false && str.equals("maiuscole:off") == false){
                    if(maiusc){
                        out.println(str.toUpperCase());
                    }else{
                        out.println(str.toLowerCase());
                    }
                }
            }
        }catch(IOException ioexc){}
    }
}
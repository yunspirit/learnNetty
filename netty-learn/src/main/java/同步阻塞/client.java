package 同步阻塞;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description
 * @Author yunqian
 * @Date 2019-01-25 14:40
 **/
public class client {

    public static void main(String[] args) {

        BufferedReader in = null;
        PrintWriter prin = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            prin = new PrintWriter(socket.getOutputStream(),true);
            prin.println("QUERY TIME ORDER");
            System.out.println("start query");
            String res = in.readLine();
            System.out.println("Now is:"+res);
        }catch (Exception e){


        }finally {
            if (prin != null){
                try {
                    prin.close();
                }catch (Exception e){

                }
                prin = null;
            }

            if (in != null){
                try {
                    in.close();
                }catch (Exception e){

                }
                in = null;
            }


            if (socket != null){
                try {
                    socket.close();
                }catch (Exception e){

                }
                socket = null;
            }
        }

    }

}

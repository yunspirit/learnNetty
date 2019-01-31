package 伪异步;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author yunqian
 * @Date 2019-01-25 15:11
 **/
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
                    50, 10000);// 创建IO任务线程池
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}

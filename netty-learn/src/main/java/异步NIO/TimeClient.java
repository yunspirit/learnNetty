package 异步NIO;

/**
 * @Description
 * @Author yunqian
 * @Date 2019-01-30 19:56
 **/
public class TimeClient {

    /**
     * @param args
     * @throws IOException
     */
    /**
     * @param args
     */
    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}

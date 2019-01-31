package AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Description
 * @Author yunqian
 * @Date 2019-01-30 22:42
 **/
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel result,
                          AsyncTimeServerHandler attachment) {

        //当我们调用AsynchronousServerSocketChannel的accept方法后，如果有新的客户端连接接入，
        //系统将回调我们传入的CompletionHandler实例的completed方法，表示新的客户端已经接入成功，
        //因为一个AsynchronousServerSocketChannel可以接收成千上万个客户端，所以我们需要继续调用它的accept方法，
        //接收其它的客户端连接，最终形成一个循环。每当接收一个客户读连接成功之后，再异步接收新的客户端连接

        //----》》》递归调用  接收新的连接
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}

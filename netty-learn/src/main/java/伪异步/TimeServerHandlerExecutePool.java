package 伪异步;

import org.junit.internal.runners.statements.RunAfters;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author yunqian
 * @Date 2019-01-25 14:58
 **/
public class TimeServerHandlerExecutePool {

    private ExecutorService executorService = null;

    public TimeServerHandlerExecutePool(int maxPoolSize,int queueSize) {
        this.executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,
                120L,
                TimeUnit.SECONDS ,
                new ArrayBlockingQueue<Runnable>(queueSize));

    }

    public void execute(Runnable task){
        executorService.execute(task);
    }
}

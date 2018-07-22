package net.xdclass.demo2.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步业务
 */
@Component
@Async
public class AsyncTask {


    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread.sleep(1000);

        long end = System.currentTimeMillis();

        System.out.println("任务1耗时"+(end - begin));
    }
    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread.sleep(2000);

        long end = System.currentTimeMillis();
        System.out.println("任务2耗时"+(end - begin));
    }
//    @Async
    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread.sleep(3000);

        long end = System.currentTimeMillis();
        System.out.println("任务3耗时"+(end - begin));
    }

    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread.sleep(3000);

        long end = System.currentTimeMillis();
        System.out.println("任务4耗时"+(end - begin));

        return new AsyncResult<>("任务4耗时"+(end - begin));
    }

    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread.sleep(1000);

        long end = System.currentTimeMillis();
        System.out.println("任务5耗时"+(end - begin));

        return new AsyncResult<>("任务5耗时"+(end - begin));
    }
}

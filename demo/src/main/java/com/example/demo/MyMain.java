package com.example.demo;

/**
 * Created by XGH on 2019/4/10
 */
public class MyMain {
    public static void main(String[] args)  throws InterruptedException {

       /* final int THREAD_COUNT=10;
        final int RUN_TIME=100;

        ExecutorService  threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        //用CountDownLatch保证主线程等待所有任务完成
        CountDownLatch count=new CountDownLatch(RUN_TIME);
        for (int i = 0; i < RUN_TIME; i++) {
            threadPool.execute(new MyConnector(count));
        }
        threadPool.shutdown();
        count.await();
        //提示所有任务执行完
        System.out.println("finish");*/
//        System.out.println(System.getProperty("user.name"));
//      //  Integer.MAX_VALUE
//        House h = new House();
//        h.f();
        System.out.println( System.getProperty("sun.arch.data.model"));
    }
}

package cn.qqchao.other.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {

    // 公共变量
    int count = 0;

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();

        MyRunnable myRunnable = threadTest.new MyRunnable();
        MyRunnable myRunnable1 = threadTest.new MyRunnable();
        MyRunnable myRunnable2 = threadTest.new MyRunnable();
        MyRunnable myRunnable3 = threadTest.new MyRunnable();
        MyRunnable myRunnable4 = threadTest.new MyRunnable();

        new Thread(myRunnable).start();
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
        new Thread(myRunnable4).start();
    }

    /**
     * 创建一个实现Runnable的类
     */
    class MyRunnable implements Runnable{

        @Override
        public void run() {
            while (true){
                // 锁住整个类
                synchronized (MyRunnable.class){
                    if(count > 100){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count" + (++ count));
                    // 测试时线程容易切换
                    Thread.yield();
                }
            }
        }
    }


//    public static void main(String[] args) {
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 0, 0, null, null);
//
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
//        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
//        ExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
//
//    }
}

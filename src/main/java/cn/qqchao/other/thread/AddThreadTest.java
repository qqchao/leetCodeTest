package cn.qqchao.other.thread;


public class AddThreadTest {

    private int count = 0;

    private class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100000000; i++) {
                synchronized (AddThreadTest.class) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + " i = " + i + " count = " + count);
                }
            }
        }
}
    public static void main(String[] args) {
        new AddThreadTest().test();
    }

    public void test() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new AddThread());
            thread.start();
        }
    }
}

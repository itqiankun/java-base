package com.itqiankun.StartingThreads_1;

class RunnerRunnable implements Runnable {

    private volatile Integer num = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            num = num - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num);
        }
    }
}

public class ApplicationRunnable {

    public static void main(String[] args) {
        RunnerRunnable target = new RunnerRunnable();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        Thread thread3 = new Thread(target);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

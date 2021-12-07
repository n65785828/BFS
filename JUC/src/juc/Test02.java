package juc;

import java.util.concurrent.locks.LockSupport;

//LockSupport 暂停线程  interrupt打断暂停
public class Test02 {
    public static void main(String[] args) {
        Thread thread = new Thread(Test02::run);
        thread.start();
        thread.interrupt();
        System.out.println("eee");
    }

    private static void run() {
        System.out.println("ttttt");
        LockSupport.park();
        boolean interrupted = Thread.currentThread().isInterrupted();
        System.out.println(interrupted);
        System.out.println("ttttt");
    }
}

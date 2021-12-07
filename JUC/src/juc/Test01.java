package juc;

import java.util.concurrent.TimeUnit;

/**
 * interrupt 打断线程 进行关闭线程的操作
 */
public class Test01 {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.start();
        try {
            TimeUnit.SECONDS.sleep(5);
            monitor.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class Monitor{
        private Thread t ;
        public Monitor(){
            t = new Thread(()->{
                while (true){
                    Thread thread = Thread.currentThread();
                    if(thread.isInterrupted()){
                        System.out.println("优雅退出");
                        break;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("监控执行中。。。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(thread.isInterrupted());
                        thread.interrupt();
                    }
                }
            });
        }

        public void start(){
            t.start();
        }

        public void stop(){
            t.interrupt();
        }
    }
}

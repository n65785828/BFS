package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

//FutureTask的使用
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 20;
        });
        new Thread(futureTask).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("test");
        }
        Integer integer = futureTask.get();//FutureTask get方法阻塞等待 线程结果
        System.out.println(integer);
    }
}

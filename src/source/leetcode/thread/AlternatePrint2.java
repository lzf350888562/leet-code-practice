package source.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用信号量
 * 顺序交替输出ABC  注意需要有一个信号量初始值为1
 */
public class AlternatePrint2 {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.println(Thread.currentThread().getName()+"  --- > A");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.println(Thread.currentThread().getName()+"  --- > B");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println(Thread.currentThread().getName()+"  --- > C");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }
}

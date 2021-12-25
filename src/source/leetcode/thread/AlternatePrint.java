package source.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock conditon
 * 顺序交替输出ABC 注意解决倒数第二个线程未结束问题
 */
public class AlternatePrint {
    private static volatile int I = 0;  // 不需要保证原子性，因为run有if判断  保证线程可见即可
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Runnable r1 = () -> {
            lock.lock();
            while (I <= 100) {
                if (I % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "   A--->" + I);
                    I++;
                    condition1.signal();
                    if(100-I <2){
                        break;
                    }
                } else {
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {

                    }
                }
            }
            lock.unlock();
        };
        Runnable r2 = () -> {
            lock.lock();
            while (I <= 100) {
                if (I % 3 == 1) {
                    System.out.println(Thread.currentThread().getName() + "   B--->" + I);
                    I++;
                    condition2.signal();
                    if(100-I < 2){
                        break;
                    }
                } else {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {

                    }
                }
            }
            lock.unlock();
        };
        Runnable r3 = () -> {
            lock.lock();
            while (I <= 100) {
                if (I % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + "   C--->" + I);
                    I++;
                    condition3.signal();
                    if(100-I <2){
                        break;
                    }
                } else {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {

                    }
                }
            }
            lock.unlock();
        };
        new Thread(r1,"t1").start();
        new Thread(r2,"t2").start();
        new Thread(r3,"t3").start();
    }

}

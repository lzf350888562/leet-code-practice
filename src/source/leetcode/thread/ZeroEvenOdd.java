package source.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * 输入：n = 2
 * 输出："0102"
 * 解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 */
public class ZeroEvenOdd {
    private int n;
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);
    private Semaphore all = new Semaphore(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int i = 0;
        while (i < n) {
            all.acquire();
            printNumber.accept(0);
            if( i % 2 ==0){
                odd.release();
            }else {
                even.release();
            }
            i++;
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int i = 2;
        while (i <= n){
            even.acquire();
            printNumber.accept(i);
            all.release();
            i+=2;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int i = 1;
        while (i <= n) {
            odd.acquire();
            printNumber.accept(i);
            all.release();
            i+=2;
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() ->{
            try {
                zeroEvenOdd.zero((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.even((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.odd((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

package source.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * no.1195 交替打印字符串
 */
public class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            if (i% 5 != 0 && i% 3 == 0) {
                printFizz.run();
                i++;
            }else{
                Thread.yield();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            if (i% 5 == 0 && i % 3 != 0) {
//                System.out.println("Buzz");
                printBuzz.run();
                i++;
            }else{
                Thread.yield();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i<= n) {
            if (i % 5 == 0 && i % 3 == 0) {
//                System.out.println("fizzbuzz");
                printFizzBuzz.run();
                i++;
            }else{
                Thread.yield();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            if (i % 5 != 0 && i % 3 != 0) {
                //                System.out.println(i);
                printNumber.accept(i);
                i++;
            }else{
                Thread.yield();
            }
        }
    }
}
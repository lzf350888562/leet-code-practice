package source.leetcode.thread;

/**
 *
 * no.1114 3个交替打印  自旋 信号量 锁 等方式
 */
public class AlternatePrint1114 {
    private volatile int state = 1;

    public AlternatePrint1114(){
    }


    public void first(Runnable printFirst) throws InterruptedException {
        for (;; ) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(state % 3 == 1){
                printFirst.run();
                state=2;
                break;
            }
            //    else {
            //        Thread.yield();
            //    }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (;; ) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(state % 3 == 2){
                printSecond.run();
                state=3;
                break;
            }
            //    else {
            //        Thread.yield();
            //    }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (;; ) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(state % 3 == 0){
                printThird.run();
                break;
            }
            //    else {
            //        Thread.yield();
            //    }
        }
    }
    public static void main(String[] args) {
        AlternatePrint1114 alternatePrint1114 = new AlternatePrint1114();
        new Thread(()->{
            try {
                alternatePrint1114.first(() ->{
                    System.out.println(Thread.currentThread().getName()+ " ---> first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                alternatePrint1114.second(() ->{
                    System.out.println(Thread.currentThread().getName()+ " ---> second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                alternatePrint1114.third(() ->{
                    System.out.println(Thread.currentThread().getName()+ " ---> third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

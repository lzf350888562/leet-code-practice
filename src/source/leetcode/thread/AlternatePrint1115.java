package source.leetcode.thread;

/**
 * no.1115 交替打印  Leetcode中需要加yield才行 自旋 信号量 锁 等方式
 */
public class AlternatePrint1115 {
    private int n;
    private volatile boolean state = true;

    public AlternatePrint1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            if(state){
                printFoo.run();
                state=!state;
                i++;
            }
//            else {
//                Thread.yield();
//            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(!state){
                printBar.run();
                state=!state;
                i++;
            }
//            else {
//                Thread.yield();
//            }
        }
    }

    public static void main(String[] args) {
        AlternatePrint1115 alternatePrint1115 = new AlternatePrint1115(20);
        new Thread(()->{
            try {
                alternatePrint1115.foo(() ->{
                    System.out.println(Thread.currentThread().getName()+ " ---> foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                alternatePrint1115.bar(() ->{
                    System.out.println(Thread.currentThread().getName()+ " ---> bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

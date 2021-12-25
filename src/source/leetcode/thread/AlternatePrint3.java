package source.leetcode.thread;

/**
 * 使用 自旋
 * 顺序交替输出ABC  注意需要有一个信号量初始值为1
 */
public class AlternatePrint3 {
    public static class ThreadComm extends Thread {
        //volatile修饰，保证线程可见性，这里不需要保证原子性，因为run有if判断 只需要保证内存可见
        private volatile static int state = 0;
        private static String name = "ABC";
        private int type;

        ThreadComm(int type,String name) {
            super(name);
            this.type = type;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
//                System.out.println("----------线程"+Thread.currentThread().getName()+" 空转一次");
                if (state % 3 == type) {
                    System.out.println(name.charAt(type));
                    state++;
                    i++;
                }
//                else{
//                    Thread.yield();
//                }
            }
        }

    }
    public static void main(String[] args) {
        new ThreadComm(0,"1").start();
        new ThreadComm(1,"2").start();
        new ThreadComm(2,"3").start();
    }
}

package single_multithread_comparison;

public class MultiThreadReplacingSingleThread extends Thread {

    public static void main(String[] args) {
        Thread thread = new MultiThreadReplacingSingleThread();
        thread.start();// new thread created along with existing default thread (i.e existence of multiple threads)
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
        System.out.println("main method computation is over");
    }


    @Override
    public  void run() {
        for (int j = 101; j <= 200; j++) {
            System.out.println(j);
        }
        System.out.println("run method computation over");
    }


   // With multihtreading , priority algo kicks in, with computation switching between threads helping better CPU utilization.
}

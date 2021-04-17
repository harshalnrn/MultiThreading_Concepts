package thread_methods_lifecycle;

import java.util.Scanner;

public class Thread_Priority_Demo extends  Thread {

    public static void main(String[] args) throws InterruptedException {

System.out.println("Main thread priority"+Thread.currentThread().getPriority());
Thread.currentThread().setPriority(MIN_PRIORITY);
        System.out.println("Main thread priority"+Thread.currentThread().getPriority());
        Thread thread = new Thread_Priority_Demo();//Thread-0
        Thread thread1 = new Thread_Priority_Demo();//Thread-1
        Thread thread2 = new Thread_Priority_Demo ();//Thread-2
        thread.setPriority(MAX_PRIORITY);
        thread1.setPriority(2);
        thread2.setPriority(3);

        thread.start();
        thread1.start();
        thread2.start();

        //thread, main, thread3, thread2 should be the order as per set priority
System.out.println("Thread name: " + Thread.currentThread().getName());

    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());

    }
}

package thread_methods_lifecycle;
//Divide and conquer using threads.

import java.util.Scanner;

//note: The caller thread will still keep waiting, if the referenced thread is blocked or is taking too long to process. This can become an issue as the calling thread will become non-responsive. To handle these situations, we use overloaded versions of the join() method that allow us to specify a timeout period.
//https://www.baeldung.com/java-thread-join
public class Thread_Join_Demo extends Thread {

    static int n, sum = 0;


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an integer");
        Thread_Join_Demo.n = scanner.nextInt();

        Thread_Join_Demo thread = new Thread_Join_Demo();
        thread.start();
        thread.join();
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName());
        }


    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("printing joined thread name" + Thread.currentThread().getName());
        }

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Thread name: " + Thread.currentThread().getName() + " Sum " + sum);
        try {
            Thread.sleep(1000); //
        } catch (InterruptedException e) {

        }

    }
}


class ChildThreadClass extends  Thread {

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("child thread class"+i);
            Thread.yield(); //yielding current thread and taking it back to runnable state, to allow JVM to run-complete other threads (here main thread) and post which the current resumes.

        }
    }

}



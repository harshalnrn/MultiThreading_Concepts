package thread_methods_lifecycle;
//Divide and conquer using threads.
import java.util.Scanner;

public class Thread_Join_Demo extends Thread {

    static int n, sum = 0;


    public static void main(String[] args) throws InterruptedException {
long start=System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an integer");
        Thread_Join_Demo.n = scanner.nextInt();

        Thread_Join_Demo thread = new Thread_Join_Demo();
        thread.start();

        thread.join();
        for(int i=0;i<200;i++){
            System.out.println(Thread.currentThread().getName());
        }



    }

    @Override
    public void run() {
        for(int i=0;i>100;i++){
            System.out.println(Thread.currentThread().getName());
        }

        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println("Thread name: " + Thread.currentThread().getName() + " i: "+i);
        }
        System.out.println("Thread name: " + Thread.currentThread().getName() + " Sum " + sum);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){

        }

    }
}



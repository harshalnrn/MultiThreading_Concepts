package single_multithread_comparison;

public class Multhreading_Runnable implements Runnable {
    @Override
    public void run() {
//actions that thread supposed to do
    }

    public static void main(String[] args) {
        Runnable runnable = new Multhreading_Runnable();

        Thread thread1 = new Thread(runnable); //calling parameterised constructer of Thread to create Thread object

        thread1.start();
    }
}

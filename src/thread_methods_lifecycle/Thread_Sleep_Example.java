package thread_methods_lifecycle;

public class Thread_Sleep_Example extends Thread {
    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread_sleep_example=new Thread_Sleep_Example();
        thread_sleep_example.start(); //makes it runnable

        for (int i = 0; i < 100; i++) {
            System.out.println(" i: " + i);
            Thread.sleep(2000); //sleep() being static method// throws checked exception : Interuppted exception.// in case of shared resource, current thread accessing this goes to sleep
        }

    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            for (int j = 100; j > 0; j--) {
                System.out.println("j: " + j);
                Thread.sleep(2000); // sleep() being static method //throws checked exception : Interuppted exception.//in case of shared resource, current thread accessing this goes to sleep
            }
        } catch (InterruptedException e) {

        }
    }
}

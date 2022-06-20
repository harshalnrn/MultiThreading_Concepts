package thread_methods_lifecycle;

public class InterruptMain {
    public static void main(String[] args) {
        Thread th = new InterruptingThreadExample();
        th.start();

        th.interrupt(); // note: this command wont come into effect, until thread goes into sleep mode/wait mode, where Interrupted exception gets thrown
        // Thus here only 1 itiration in child thread run(), since it goes to sleep after each itiration, and gets interrupted in very first itiration
        System.out.println("end of main method");
    }
}

class InterruptingThreadExample extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("I am a lazy thread");
                if (i == 5) {
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread got interrupted");

        }
    }
}


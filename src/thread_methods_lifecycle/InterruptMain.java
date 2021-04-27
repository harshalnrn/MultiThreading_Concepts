package thread_methods_lifecycle;

public class InterruptMain {
    public static void main(String[] args) {
        Thread th = new InterruptingThreadExample();
        th.start();

th.interrupt(); // note: we can only interrupt a thread thats in sleep mode/wait mode .
             // Thus here only 1 itiration in child thread run(), since it goes to sleep after each itiration, and gets interrupted in very first itiration
        System.out.println("end of main method");
    }
}

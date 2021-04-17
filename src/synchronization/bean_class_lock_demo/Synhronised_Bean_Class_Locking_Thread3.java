package synchronization.bean_class_lock_demo;

public class Synhronised_Bean_Class_Locking_Thread3 extends Thread {
   private SharedDisplayClassMessage sharedDisplayClassMessage;

    public Synhronised_Bean_Class_Locking_Thread3(SharedDisplayClassMessage sharedDisplayClassMessage) {
        this.sharedDisplayClassMessage = sharedDisplayClassMessage;
    }

    @Override
    public void run() {
        System.out.println("current running thread"+Thread.currentThread().getName());
        //access m5
        SharedDisplayClassMessage.sayHello("preeti");

        System.out.println("current terminating thread"+Thread.currentThread().getName());
    }
}

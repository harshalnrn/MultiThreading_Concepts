package synchronization.bean_class_block_lock_demo;

public class Synhronised_Bean_Class_Locking_Thread1 extends Thread {
    SharedDisplayClassMessage sharedDisplayClassMessage;

    public Synhronised_Bean_Class_Locking_Thread1(SharedDisplayClassMessage sharedDisplayClassMessage) {
        this.sharedDisplayClassMessage = sharedDisplayClassMessage;
    }

    @Override
    public void run() {

        System.out.println("current runnin thread"+Thread.currentThread().getName());
        //access m3
        sharedDisplayClassMessage.sayHello3("vijay");
        System.out.println("current terminating thread"+Thread.currentThread().getName());
    }
}

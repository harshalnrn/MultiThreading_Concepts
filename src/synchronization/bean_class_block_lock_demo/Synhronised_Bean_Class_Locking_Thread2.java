package synchronization.bean_class_block_lock_demo;

public class Synhronised_Bean_Class_Locking_Thread2 extends Thread {
    SharedDisplayClassMessage sharedDisplayClassMessage;

    public Synhronised_Bean_Class_Locking_Thread2(SharedDisplayClassMessage sharedDisplayClassMessage) {
        this.sharedDisplayClassMessage = sharedDisplayClassMessage;
    }

    @Override
    public void run() {
        System.out.println("current running thread"+Thread.currentThread().getName());

        //access m4
       SharedDisplayClassMessage.sayHello4("vimal");
        System.out.println("current terminating thread"+Thread.currentThread().getName());
    }
}

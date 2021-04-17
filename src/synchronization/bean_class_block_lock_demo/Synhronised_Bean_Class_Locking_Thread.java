package synchronization.bean_class_block_lock_demo;

public class Synhronised_Bean_Class_Locking_Thread extends Thread {

    private SharedDisplayClassMessage obj;

    public Synhronised_Bean_Class_Locking_Thread(SharedDisplayClassMessage obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println("current running thread"+Thread.currentThread().getName());
        obj.sayHello2("harshal"); //accessing m1
        System.out.println("current terminating thread"+Thread.currentThread().getName());
    }
}

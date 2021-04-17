package synchronization.bean_class_block_lock_demo;

public class Synchoronised_Bean_Class_Locking_Thread4 extends Thread {

    private SharedDisplayClassMessage obj;

    public Synchoronised_Bean_Class_Locking_Thread4(SharedDisplayClassMessage obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println("current running thread" + Thread.currentThread().getName());
        //accessing m2
        obj.sayHello1("raj");
        System.out.println("current terminating thread" + Thread.currentThread().getName());
    }
}

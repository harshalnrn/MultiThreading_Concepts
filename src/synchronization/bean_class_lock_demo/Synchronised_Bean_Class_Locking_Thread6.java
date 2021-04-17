package synchronization.bean_class_lock_demo;

public class Synchronised_Bean_Class_Locking_Thread6 extends Thread {

    @Override
    public void run() {
        SharedDisplayClassMessage.syncBlock2("static synch block");
    }
}

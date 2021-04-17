package synchronization.bean_class_lock_demo;

public class Synchornised_Bean_Class_Locking_Thread5 extends  Thread {

SharedDisplayClassMessage sharedDisplayClassMessage;

    public Synchornised_Bean_Class_Locking_Thread5(SharedDisplayClassMessage sharedDisplayClassMessage) {
        this.sharedDisplayClassMessage = sharedDisplayClassMessage;
    }

    @Override
    public void run() {
       sharedDisplayClassMessage.syncBlock1("instance synch block");
    }
}

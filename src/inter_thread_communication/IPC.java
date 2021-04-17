package inter_thread_communication;

//sender
//wait - notify cycle

public class IPC extends Thread {
    int sum = 0;
   public Data data;

    public IPC(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("child thread: " + Thread.currentThread().getName() + "is calculating the sum");
        //parameter is the monitor object
        synchronized (data) {
            for (int i = 0; i < 100; i++) {
                sum = sum + i;
                System.out.println("inside for loop");
            }
            data.setSum(sum);
            data.notify(); // notify/wake up the parent thread that run() is completed and lock is also release for this object // note only threads in wait status for this monitor object, is eligible to run after notify()
        }
    }
}
package synchronization.bean_class_block_lock_demo;
//this class has synch instance, synch static, synch block members
public class SharedDisplayClassMessage {


    //instance synchronised methods
    //m1
    public synchronized void sayHello2(String name) {

        for (int i = 0; i < 100; i++) {
            System.out.println("m1" + name);
        }
    }

    //m2
    public synchronized void sayHello1(String name) {
        for (int i = 0; i < 100; i++) {
            System.out.println("m2" + name);
        }
    }

    //non synchronous method.

    //m3
    public void sayHello3(String name) {
        for (int i = 0; i < 50; i++) {
            System.out.println("m3" + name);
        }
    }


    //static synchronised methods

    //m4
    public static synchronized void sayHello4(String name) {
        for (int i = 0; i < 50; i++) {
            System.out.println("m4" + name);
        }
    }


    //m5
    //synchronised caused lock in FCFS basis on same priority threads .
    public static synchronized void sayHello(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.println("m5" + name);
        }
    }

    //m6
    //synchronous block inside instance method

    public  void syncBlock1(String name){

//this: object reference expression
        synchronized(this) {
            for(int i=0;i<50;i++) {
                System.out.println("inside sync block of instance method" + Thread.currentThread().getName());
            }
        }
    }


    //m7
    //synchronous block inside static method

    public  static void syncBlock2(String name){

//this: object/class reference expression
        synchronized(SharedDisplayClassMessage.class) {
            for(int i=0;i<50;i++) {
                System.out.println("inside sync block of static method" + Thread.currentThread().getName());
            }
        }
    }


}
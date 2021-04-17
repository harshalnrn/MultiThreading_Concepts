package inter_thread_communication;

//These methods works on the locks and locks are associated with Object and not Threads. Hence, it is in Object class.
//Receiver
public class ipcMain {
//main thread
    public static void main(String[] args)  throws  InterruptedException{
        Data data=new Data(); //shared object
        IPC thread1 = new IPC(data); //child thread
Thread mainThread=Thread.currentThread();
        //here we cannt be sure whether thread1 would have found final Sum, unless you control their flow and execution completion.Hence inter_thread_communication.IPC

        //IllegalMonitorStateException  : Note this. comes if wait() or notify() called outside synch block (i.e monitor state belongs to object and not thread)
        //this synch block is only to deal with data object

       /* The object taken in the parentheses by the synchronized construct is called a monitor object. T
       The block portion code is said to be synchronized only on the monitor object.
        Wheras A synchronized instance method uses the object it belongs to as monitor object.*/


        synchronized (data){
            //data bean would be locked for main thread
            //here thread1 would get locked
            System.out.println("main thread:"+Thread.currentThread().getName()+" shall wait for child thread to notify");
            thread1.start(); // IPC is runnable  now
          data.wait(); // wait for object access until notified by it //explicit lock



          //is main thread going to wait status or just data object getting locked for main thread//
//note: until data is unlocked, entire synch block goes to wait status, with thread not moving further until synch block executed.

            System.out.println("child thread has notified and child lock on dependent object is unlocked. Next is retreive sum from child thread and print sum");
            System.out.println(data.getSum());
        }

        System.out.println("hello");

    }


    //wait is in context to waiting for the same object, where you can access, one's notify() called on same object
    //wait(), notify() belong to Object class.

}


//receiver waits --> sender processes and notifies  -> receiver resumes
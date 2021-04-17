package thread_methods_lifecycle;

public class MultiThreadingApiMethodsExample extends Thread {


    public static void main(String[] args) throws InterruptedException {


        Thread multiThreading = new MultiThreadingApiMethodsExample();
        Thread multiThreading1 = new MultiThreadingApiMethodsExample();
        multiThreading.setPriority(MIN_PRIORITY);
        multiThreading1.setPriority(MAX_PRIORITY);
        multiThreading.start();// note: start() calls run() internally
        //multiThreading1.start();
        //so here both the above threads shall access common resource run() concurrently and not sequentially
        System.out.println("main method started. main method thread is " + Thread.currentThread().getName()); //give reference of currently executing thread object among multiple threads
        //NOTE :Thread name can be changed too
        Thread.currentThread().setName("mainThread");
        System.out.println("renamed main method thread to "+Thread.currentThread().getName());
        //  compute();
 /*       for (int i = 0; i < 100; i++) {
           // System.out.println("i: " + i);
            Thread.sleep(1000); // main thread would go to sleep for 1 sec after each itiration action.

        }*/

    }


    //both the created threads above would access the below run method as shared resource, concurrently/independently
    public void run() {
        try {
            System.out.println("run method thread is:" + Thread.currentThread().getName()); //returns the thread accessing this resource(method)

            for (int j = 0; j < 100; j++) {
              //  System.out.println("j: " + j);
                Thread.sleep(1000); // current thread to sleep for 1 sec after each itiration action
            }
        } catch (InterruptedException e) {

        }
    }
}


//sleep used to when we are waiting for a particular resource. sleep enables Thread to go to sleep mode and rest before next action, where its is active again after sleep time.

//ex: waiting connect to db/mq/webservice/ polling activity / specific count of messages.

   /* It is highly recommended to override run() method because it improves the performance of the system. If we don't override Thread class run() method in our defined thread
        then Thread class run() method will be executed and we will not get any output because Thread class run() is with an empty implementation.*/
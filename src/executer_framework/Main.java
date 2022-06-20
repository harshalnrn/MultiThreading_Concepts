package executer_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    //Executer(I), ExecuterService (I), Executers(C)
    // 2 most used implementations are as below

    public static void main(String[] args) {


      /*  1. Create a task(Runnable type  Object/ assign lambda expression to runnable type ) to execute
        2. Create appropriate Executor Pool using one of the Executors factory methods
        3. Pass tasks to Executor Pool
        4. Shutdown the Executor Pool*/


        // first create an Thread pool using implemented methods of Executers class, which in-turn return populated factory bean
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor(); // creating a pool of  single thread with ThreadPoolExecuter bean
        ExecutorService multipleThreadPool = Executors.newFixedThreadPool(8); // creating a pool of fixed n threads with ThreadPoolExecuter bean


        // second create a task as below, for run() of thread, and pass this task to the executer pool, where the pool takes care of appropriatly assigning a thread to this task
// Queuing system followed for tasks when no thread is available, where the available threads then
        // note only 1 thread bean per lambda expression created

        //think of parallel threads as parallel tasks in context of pool, which is executed by fixed n parallel threads.

        Runnable task1 = () -> System.out.println("task1 to be run");
        // Lets test parallel tasks of threads of multiple pool now


        Runnable task2 = () -> System.out.println("task2 to be run");
        Runnable task3 = () -> System.out.println("task3 to be run");
        Runnable task4 = () -> System.out.println("task4 to be run");
        Runnable task5 = () -> System.out.println("task5 to be run");
        Runnable task6 = () -> System.out.println("task6 to be run");

        // conventional
        //  new Thread(task1).start();
        //executers

        singleThreadPool.execute(task1);  // you can also directly put lambda expression as parameter instead of variable. but i prefer variables.

        //Q: can we know if a particular task is compelted or not ? NO
        //Q: can we cancel the execution of task. YES , if task not yet started
        // getting multiple tasks run through same thread sequentialy
        //Question: how come its taken care that current thread is not terminated after task1 completed, and same thread re-used for task2. DONT KNOW
        //https://stackoverflow.com/questions/24361779/new-threads-vs-reusing-threads
        singleThreadPool.execute(task2);  // (works via waiting Blocking-queue)


//And you have to shutdown the executor after this runnable has been executed. Otherwise the single thread in this pool will never exit.

        singleThreadPool.shutdown();

//https://stackoverflow.com/questions/42296992/why-threadpool-creates-only-one-thread
//----------------------------------------------------------------------------------


/*

        // running tasks in parallel using multiple thread pool
        multipleThreadPool.execute(task2);
        multipleThreadPool.execute(task3);
        multipleThreadPool.execute(task4);
        multipleThreadPool.execute(task5);
        multipleThreadPool.execute(task6);

*/

    }
}


//Producer -consumer blocking queue based asynchronous multhreaded pattern
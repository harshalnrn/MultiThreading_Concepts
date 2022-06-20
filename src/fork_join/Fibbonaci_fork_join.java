package fork_join;


import java.util.Scanner;
import java.util.concurrent.RecursiveTask;


/**
 * Divide and conquer with parallel recursion using Fork-join/
 */
public class Fibbonaci_fork_join extends RecursiveTask<Integer> {
    int index;
    int fibboSeqNumber;

    public Fibbonaci_fork_join(int index) {
        this.index = index;

    }

    public int getIndex() {
        return index;
    }


    public int getFibboSeqNumber() {
        return fibboSeqNumber;
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter nth value");

        //create parent task object.
        Fibbonaci_fork_join fibonacci_fork_join = new Fibbonaci_fork_join(scan.nextInt() - 1); //parent task object
        System.out.println(fibonacci_fork_join.compute()); //create parent task

    }

    //Subtask operation method.


    @Override
    protected Integer compute() {
        //base condition
        System.out.println(Thread.currentThread().getName());
        if (index <= 1) {
            fibboSeqNumber = index;
            return fibboSeqNumber;
        } else {
            //split the parent tasks into subtasks, based upon fibonacci rule:
            Fibbonaci_fork_join task1 = new Fibbonaci_fork_join(getIndex() - 1);
            Fibbonaci_fork_join task2 = new Fibbonaci_fork_join(getIndex() - 2);
// so subtasks operation gets divided among multiple threads via fork-join framework, as they are independent of each other.S
            //thread management is abstracted!

            task1.fork(); //recursive solving of subtask
            task2.fork(); //resursive solving of subtask

//note: no of recursion calls to compute(), by verifying with binary tree.;
            // fork join pool has threads created based upon available resources.
            // task objects handling is divided among these threads, till fibSeqNumber of each task gets computed.

            // add the total to both tasks
            fibboSeqNumber = task1.join() + task2.join(); //fibonacci rule // join is final return value of compute method of corresponding task
        }
        return fibboSeqNumber;
    }


}


package fork_join;

import java.util.Scanner;

/**
 * Divide and conquer with recursion.
 */
public class Fibonacci_Task_Recursion {
    int index;
    int fibboSeqNumber;

    public Fibonacci_Task_Recursion(int index) {
        this.index = index;

    }

    public int getIndex() {
        return index;
    }


    public int getFibboSeqNumber() {
        return fibboSeqNumber;
    }


    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("enter nth value");

        //create parent task object.
        Fibonacci_Task_Recursion fibonacci_fork_join = new Fibonacci_Task_Recursion(scan.nextInt()-1); //parent task object
        System.out.println(fibonacci_fork_join.getFiboonaciSequenceNumber()); //create parent task

    }

    //Subtask operation method.

    public int getFiboonaciSequenceNumber() {

        //base condition
        if (index<=1 ) {
            fibboSeqNumber=index;
            return fibboSeqNumber;
        } else {
            //split into subtasks, based upon fibonacci rule
            Fibonacci_Task_Recursion task1 = new Fibonacci_Task_Recursion(getIndex()-1);
            Fibonacci_Task_Recursion task2 = new Fibonacci_Task_Recursion(getIndex()-2);


            task1.getFiboonaciSequenceNumber(); //recursive solving of subtask

            task2.getFiboonaciSequenceNumber(); //resurssive solvint of subtask

            // add the total to both tasks
fibboSeqNumber= task1.fibboSeqNumber+task2.fibboSeqNumber;
        }
        return fibboSeqNumber;
    }
}

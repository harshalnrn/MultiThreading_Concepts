package fork_join;

/**
 * Search and find occurance of an element in array, using fork-joins introduced in java8
 * Sum of array elements using divide and conquer with recursion but not parallel. (i.e array of size n divided till n tasks and a[start/end] picked of each.)
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Application of fork-join framework where we split tasks into subtasks and run multithreads concurrently (i.e parallel /non-parallel)
 */
public class SearchTask extends RecursiveTask<Integer> {
    //Divinding array into 2 arrays
    int arr[];
    int start, end;
    int searchEle;
    int sum;

    public SearchTask(int[] arr, int start, int end, int searchEle) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.searchEle = searchEle;
    }

    //overridden compute() is recursive function.
    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread()); //to verify is operation is happening on concurrent multithreads. //return reference of currently executing thread object
        int midIndex = (start + end) / 2; // mid index keeps changing since start/end changes in recursive call.


        //split condition aplying to both tasks.

       /* if ( start!=end) {
            fork_join.SearchTask task1 = new fork_join.SearchTask(arr, start, midIndex, searchEle); //task1 obj
            fork_join.SearchTask task2 = new fork_join.SearchTask(arr, midIndex + 1, end, searchEle); //task2 obj
            task1.fork(); //basically recursively calls compute() for task1 recursive stack; // controls remains here until recursive stack of this call completed.
            task2.fork();// recursively calls compute() for task2 resursive stack. //control remains here until recursive stack of this call completed.
            //fork abstracts the explicit recursion method call
            //join abstracts the collating of result of each task.
            int result = task1.join() + task2.join();
            return result;
        } else {
            //recursion termination and final return

            return calculateOcuurance();

        }*/

        // finding total sum  by dividing array in pieces=n
        //base termination condition
        if (start == end) {
            sum = arr[start]; // recursion end
        } else {

            SearchTask task1 = new SearchTask(arr, start, midIndex, searchEle); //further divide left side
            SearchTask task2 = new SearchTask(arr, midIndex + 1, end, searchEle); //further divide right side
            task1.compute(); // compute() being recursive function // control remains here until task1.sum acheived after start==end.
            task2.compute();
            //task 1, task 2 recursion stack independent.
            sum = task1.sum + task2.sum; // collating both objects results, to get total
        }
        return sum;

    }


    private Integer calculateOcuurance() {

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == searchEle) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //search and calculate number of occurance in array.

        int[] a = {2, 3, 4, 6, 7, 7, 7};
        int start = 0;
        int end = a.length - 1;
        int searchEle = 7;
        // ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SearchTask searchTask = new SearchTask(a, start, end, searchEle);

        //   int result = forkJoinPool.invoke(searchTask);
        //  System.out.print(result);
        System.out.println(searchTask.compute());
    }
}

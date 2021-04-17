package fork_join;

/**
 * Search anf find occurance of an element in array, using fork-joins
 */

/**
 * Application of fork-join framework where we run multithreads concurrently
 */
public class SearchTask /*extends RecursiveTask<Integer>*/ {
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

    //@Override
    protected Integer compute() {
        System.out.println(Thread.currentThread()); //to verify is operation is happening on concurrent multithreads. //return reference of currently executing thread object
        // int midIndex = (start + end) / 2;

        int size = end - start + 1;
      /*  if (size > 1) {
            fork_join.SearchTask task1 = new fork_join.SearchTask(arr, start, midIndex, searchEle);
            fork_join.SearchTask task2 = new fork_join.SearchTask(arr, midIndex + 1, end, searchEle);
            task1.fork();
            task2.fork();
            //fork abstracts the recursion splitting process on each task that gets created.
            //join abstracts the collating of result of each task.
            int result = task1.join() + task2.join();
            return result;
        } else {
            return calculateOcuurance();
        }*/
        //basecondition
        if (start==end) {
            sum = arr[start];
        } else {
            int midIndex = (start + end) / 2;
            SearchTask task1 = new SearchTask(arr, start, midIndex, searchEle);
            SearchTask task2 = new SearchTask(arr, midIndex + 1, end, searchEle);
            task1.compute();
            task2.compute();
            sum = task1.sum + task2.sum;
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

        int[] a = {2, 3, 4,6,7};
        int start = 0;
        int end = a.length - 1;
        int searchEle = 7;
      //  ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SearchTask searchTask = new SearchTask(a, start, end, searchEle);

       // int result = forkJoinPool.invoke(searchTask);
        System.out.println(searchTask.compute());
    }
}

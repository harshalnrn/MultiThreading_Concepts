package fork_join;


/**
 * Decrease and Conquer recursive aproach
 *
 */
public class  Array_Sum_Recursion {


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        System.out.println(sum(a, 0)); //from start index
        System.out.println(sum1(a, a.length)); //from last index.
    }


    // recursive function: left to right of array elements.

    public static int sum(int[] a, int startIndex) {

        //termination condition
        if (startIndex >= a.length) {
            return 0;
        }
        return a[startIndex] + sum(a, startIndex + 1); // array keeps getting small from left to right
    }

    //recursive function: right to left of array elements.

    public static int sum1(int[] a, int length) {
        //termination condition
        if (length < 1) {
            return 0;
        }

        return a[length - 1] + sum1(a, length - 1);
    }

}

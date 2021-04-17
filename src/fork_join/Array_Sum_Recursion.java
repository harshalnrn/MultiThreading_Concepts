package fork_join;

public class Array_Sum_Recursion {


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        System.out.println(sum(a, 0));
        System.out.println(sum1(a, a.length));
    }


    // recursive function: left to right

    public static int sum(int[] a, int startIndex) {

        //termination condition
        if (startIndex >= a.length) {
            return 0;
        }
        return a[startIndex] + sum(a, startIndex + 1);
    }

    public static int sum1(int[] a, int length) {
        //termination condition
        if (length < 1) {
            return 0;
        }

        return a[length - 1] + sum1(a, length - 1);
    }

}

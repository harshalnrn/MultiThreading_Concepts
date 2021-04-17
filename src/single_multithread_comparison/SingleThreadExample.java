package single_multithread_comparison;

public class SingleThreadExample {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        run();

        for(int i=1;i<=100;i++){
            System.out.println(i);
        }
        System.out.println("main method computation is over");
    }


    /**
     *
     */
    public static void run(){
        for(int j=101;j<=200;j++){
            System.out.println(j);
        }
        System.out.println("run method computation over");
    }
}

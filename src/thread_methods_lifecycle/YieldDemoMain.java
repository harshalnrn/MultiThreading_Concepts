package thread_methods_lifecycle;

public class YieldDemoMain {
    public static void main(String[] args){
        Thread childThreadClass=new ChildThreadClass();
        childThreadClass.start();

        for(int i=0;i<10;i++){
            System.out.println("main thread"+i);
        }
    }
}

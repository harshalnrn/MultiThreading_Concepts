package thread_methods_lifecycle;

public class InterruptingThreadExample extends  Thread {
    @Override
    public void run() {
        try{
           for (int i=0;i<10;i++){
               System.out.println("I am a lazy thread");
               Thread.sleep(2000);
           }
        }
        catch(InterruptedException e){
            System.out.println("Child thread got interrupted");

        }
    }
}

package thread_methods_lifecycle;

public class ChildThreadClass extends  Thread {

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println("child thread class"+i);
            Thread.yield(); //yielding current thread and taking it back to runnable state, to allow JVM to run-complete other threads (here main thread) and post which the current resumes.

        }
        }

}

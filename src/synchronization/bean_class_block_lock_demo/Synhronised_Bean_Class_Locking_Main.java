package synchronization.bean_class_block_lock_demo;

public class Synhronised_Bean_Class_Locking_Main {

    public static void main(String[] args) {

        SharedDisplayClassMessage sharedDisplayClassMessage=new SharedDisplayClassMessage();
        SharedDisplayClassMessage sharedDisplayClassMessage1=new SharedDisplayClassMessage();
        //6 threads

        //2 threads trying to access m1()
        Synhronised_Bean_Class_Locking_Thread obj1 = new Synhronised_Bean_Class_Locking_Thread(sharedDisplayClassMessage);
       // Synhronised_Bean_Class_Locking_Thread obj2 = new Synhronised_Bean_Class_Locking_Thread();

     /*   //acceses m2
        Synchoronised_Bean_Class_Locking_Thread4 obj6=new Synchoronised_Bean_Class_Locking_Thread4(sharedDisplayClassMessage);


        //access m3
        Synhronised_Bean_Class_Locking_Thread1 obj3 = new Synhronised_Bean_Class_Locking_Thread1(sharedDisplayClassMessage1);

        //accesses m4
        Synhronised_Bean_Class_Locking_Thread2 obj4 = new Synhronised_Bean_Class_Locking_Thread2(sharedDisplayClassMessage1);
        //accesses m5
        Synhronised_Bean_Class_Locking_Thread3 obj5 = new Synhronised_Bean_Class_Locking_Thread3(sharedDisplayClassMessage1);
*/

        Synchornised_Bean_Class_Locking_Thread5 obj10=new Synchornised_Bean_Class_Locking_Thread5(sharedDisplayClassMessage);
        /*Synchornised_Bean_Class_Locking_Thread5 obj7 = new Synchornised_Bean_Class_Locking_Thread5(sharedDisplayClassMessage1);
        Synchornised_Bean_Class_Locking_Thread5 obj8 = new Synchornised_Bean_Class_Locking_Thread5(sharedDisplayClassMessage1);*/
        //above 2 would access same synch block of instance method
   /*     Synchronised_Bean_Class_Locking_Thread6 obj9 = new Synchronised_Bean_Class_Locking_Thread6();*/
        //above shall access synch block of static method
        obj1.start();
      //  obj2.start();
       // obj6.start();

      //  obj3.start();
        //all above four threads are accessing instance methods

        //all below are accessing static methods
        //obj4.start();
        //obj5.start();

        /*obj7.start();
        obj8.start();
        obj9.start();*/
        obj10.start();
        //thread trying to access m3

        //thread accessing m4


        //thread accessing m5

        //  Expected order of control and completion of threads.

     //   Thread0-m1     Thread1-m1        Thread2 -m2  |        Thread3-m3  |    Thread4-m4      Thread5-m5 |
   //locking post access is guaranteed, but order of same priority threads never guaranteed. (i.e infact order of different priority threads is also not guaranteed)

        System.out.println("main method completed");

    }
}

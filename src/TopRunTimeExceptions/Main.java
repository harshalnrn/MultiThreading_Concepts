package TopRunTimeExceptions;

import java.util.HashMap;
import java.util.Map;


// Type casting : compile type classCast error ( checks declarative type of variable) vs ClasCast run time exception.
public class Main {

    public static void main(String[] args) {
        // type casting (i.e implicit ,explicit) // note primitive, object type casting are different
        Object a = new Object(); //implicit
        System.out.println("before casting of variable a " + a.getClass().getName());

        //  String b=a;  //gives compile time class cast error
        //   String b=(String)a; //explicit   // gives run time classCastException // type doesnt belong to object that being assigned.
        a = "harshal"; // no issue // assigning value of 'subclass type',  to superclass reference. hence compatible! //(implicit casting happens)


        Object c = new HashMap<>();
        Map d = (Map) c;
        //Above is perfect, since casted type can belong to hashmap object


/*
Downgrading: casting of parent to subclass type is explicit.
Upgrading: casting of subclass to parent type is implicit
         */


    }

    // runtime exception dont give compile error. and get auto propagated.
    public void get() {
        try {

        }
        catch(Exception e) {
          throw new RuntimeException(); //automatically propagated and no compile time exception.
        }
    }
}

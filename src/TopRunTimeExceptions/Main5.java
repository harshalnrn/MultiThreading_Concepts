package TopRunTimeExceptions;

public class Main5 {
    //Aruthmatic exception
    // result of expression is exceptional condition (i.e like infinity)
//only applies on int and log data types;
    public static void main(String[]args) {
       // int i = 100 / 0; // arithmatice exception
        float a=100;
        float b=0;
        System.out.println(a/b);  //shall print infinity.
    }
}

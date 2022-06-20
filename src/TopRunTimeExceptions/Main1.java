package TopRunTimeExceptions;
/*
A
|
B
|
C
*/


    class A
    {
        int i = 10;
    }

    class B extends A
    {
        // has access to i , j
        int j = 20;
    }

    class C extends B
    {
        // has access to i,j,k
        int k = 30;
    }

    public class Main1
    {
        public static void main(String[] args)
        {
            A a = new B();   //B type is auto up casted to A type
            B b = (B) a;     //A type is explicitly down casted to B type.
           // C c = (C) b;    //Here, you will get class cast exception
          //  System.out.println(c.k);
        }
    }


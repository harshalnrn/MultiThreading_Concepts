package TopRunTimeExceptions;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args){
        int[]a=new int[2]; // default values of datatype get stored, till its size.
        for (int i=0;i<5;i++){
            System.out.print(a[i]);
        }
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i=0;i<3;i++){
            System.out.print(list.get(i));
        }
    }
}

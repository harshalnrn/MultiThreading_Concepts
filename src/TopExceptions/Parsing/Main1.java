package TopExceptions.Parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main1 {
    public static void main(String[] args){

        try {
            //string to date : value parsing
            new SimpleDateFormat("MM, dd, yyyy").parse("invalid-date");
        } catch (ParseException e) {

        }
    }
}

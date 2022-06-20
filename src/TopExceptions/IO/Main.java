package TopExceptions.IO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            //java.io
            File file=new File("/invalid/file/location");
            InputStream inputFileStream=new FileInputStream(file); // reading file as bytes
        } catch (FileNotFoundException e) {

        }

        try {
            //java.net
            new URL("malformedurl");
        } catch (MalformedURLException e) {

        }
    }

}

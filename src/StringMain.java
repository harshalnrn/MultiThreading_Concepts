public class StringMain {

    public static void main(String[] args){
        String pass=""; // empty without whitespace
        if(!pass.isEmpty()){
            System.out.println("pass is not empty");
        }
    }
}


//isEmpty considers char-sequence as well as white-space as finite characters
//isBlank only considers char-sequence as finite characters
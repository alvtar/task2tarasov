package runner;

import domain.Text;
import reader.TextReader;

public class TestStart {
    public static int wordMinLenght=3; // Word min lenght to be delete, if they starts from consonant letter.
    public static int wordMaxLenght=11; // Word max lenght to be delete, if they starts from consonant letter.
    
    public static void main(String[] args) {
        
        
        TextReader tr=new TextReader();
        new Text(tr.read());

    }

}

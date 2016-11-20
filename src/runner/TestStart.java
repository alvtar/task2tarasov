package runner;

import domain.Text;
import reader.TextReader;

public class TestStart {
    
    public static String fileName="d:\\workspace\\task2tarasov\\src\\book.txt"; // File name for parsing.
    
    public static int wordMinLenght=0; // Minimum length of words to remove if they begin with a consonant.
    public static int wordMaxLenght=0; // Maximum length of words to remove if they begin with a consonant.
    
    public static void main(String[] args) { 
        //System.out.println(args[1]);
        TextReader tr=new TextReader();
        new Text(tr.read());
    }
}

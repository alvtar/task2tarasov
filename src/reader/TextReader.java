package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TextReader {

    public String read(){
 
    File f=new File("D:\\workspace\\task2tarasov\\bin\\reader\\book.txt");
    String str=null;
    
    try(FileReader reader = new FileReader(f))
    {
        char[] buffer=new char[(int) f.length()];
        
        reader.read(buffer);
             
            str=new String(buffer);
            
            

        } 
        
    
    catch(IOException ex){
         
        System.out.println(ex.getMessage());
    }   
    return(str);
    }
}


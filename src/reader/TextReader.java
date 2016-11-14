package reader;

import java.io.FileReader;
import java.io.IOException;


public class TextReader {

    public void read(){
        /*LinkedList<ArrayList<String>> list = new LinkedList<ArrayList<String>>();
        BufferedReader in = new BufferedReader(new InputStreamReader(NewClass.class.getResourceAsStream("in.txt")));
                String str = null;
                ArrayList<String> rlst = null;
                while ((str = in.readLine()) != null) {
                    String arr[] = str.split("\t");
                    rlst = new ArrayList<String>(Arrays.asList(arr));
                    list.addLast(rlst);
              */  
    try(FileReader reader = new FileReader("D:\\workspace\\task2tarasov\\bin\\reader\\book.txt"))
    {
       // читаем посимвольно
        int c;
        while((c=reader.read())!=-1){
             
            System.out.print((char)c);
            
            
        } 
    }
    catch(IOException ex){
         
        System.out.println(ex.getMessage());
    }   
} 

    }


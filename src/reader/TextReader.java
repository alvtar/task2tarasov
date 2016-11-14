package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import domain.*;


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
    File f=new File("D:\\workspace\\task2tarasov\\bin\\reader\\book.txt");
    
    try(FileReader reader = new FileReader(f))
    {
       // читаем посимвольно
        //int c;
        //while((c=reader.read())!=-1){
        char[] buffer=new char[(int) f.length()];
        
        reader.read(buffer);
             
            String sss=new String(buffer);
            String[] words=sss.split("\\s*(\\s|,|!|\\.)\\s*");
        
            //System.out.print(sss);
            
            for (String word:words){
                Word w=new Word(word);
                for (Symbol www:w.symbols){
                    System.out.print(www.letter);
                }
                System.out.println();
            }

            
        } 
    
    catch(IOException ex){
         
        System.out.println(ex.getMessage());
    }   
 
    }
}


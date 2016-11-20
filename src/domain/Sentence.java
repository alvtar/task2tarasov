package domain;

import java.util.LinkedList;


public class Sentence extends SymbolParser {
    public LinkedList<SymbolParser> elements;
    protected static String delimPunctuation="[^. ,?!:;'-=+]";//"[0-9a-zA-Zà-ÿÀ-ß]";//|\\r+|\\n+";//\\f\\n\\r\\t\\v]+";//"\\b\\W+\\b/g";//"[. ,?!:;'-=+]";//"\\b\\W+\\b/g";
    //protected static String delimWords="[^a-zA-Zà-ÿÀ-ß0-9]";//;"[. ,?!:;'-=+]";//"\\b\\W+\\b/g";
    
    public Sentence(String inStr) {
        super(inStr);
    }

    @Override
    protected void parse() {
        elements=new LinkedList<>();
        
        //String temp=inStr;//.replaceAll(String.format("%s|\n|\r", System.getProperty("line.separator"))," ");
        String[] punkt=inStr.replaceAll(delimPunctuation,"").split(delimPunctuation);
        //String[] punkt2=punkt.toString().split("\r|\n");
        
        //inStr
        
       /* System.out.println(punkt.hashCode());
        System.out.println(punkt.toString());
        System.out.println(punkt.getClass());*/
        
        for (String p:punkt){
            elements.add(new Punctuation(p));
            //System.out.println(p);
            /*System.out.println(p.hashCode());
            System.out.println(p.toString());
            System.out.println(p.getClass());
            System.out.println(p.intern());
            //s.*/
        }
        
        StringBuilder outStr=new StringBuilder((inStr));
        
        String[] sents=outStr.toString().split("[^a-zA-Zà-ÿÀ-ß0-9]");//|\\r|\\n+");
        
        for (String s:sents){
            if (s.isEmpty()==false) {
                elements.add(new Word(s));
                //System.out.println(s);
            }
        }
    }
    
    @Override
    public String toString() {
         String s=new String();
         for (SymbolParser pars:elements) {
            // System.out.println(pars.toString()); 
             s=s+pars.toString()+">>>";
         }
        System.out.println("==Sentence==");
        return s;
    }
    
 // @Override
    public void modyfyWord (int wordMinLenght, int wordMaxLenght){
        for (SymbolParser pars:elements) {             
             pars.modyfyWord(wordMinLenght,wordMaxLenght);
   
         }
    }
    
}

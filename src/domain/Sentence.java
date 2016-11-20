package domain;

import java.util.LinkedList;


public class Sentence extends SymbolParser {
    protected LinkedList<SymbolParser> elements;
    protected static String delimPunctuations="[^. ,?!:;'-=+]";
    protected static String delimWords="[^a-zA-Zà-ÿÀ-ß0-9]";
    
    public Sentence(String inStr) {
        super(inStr);
    }

    @Override
    protected void parse() {
        elements=new LinkedList<>();

        String[] punkt=inStr.replaceAll(delimPunctuations,"").split(delimPunctuations);
        
        for (String p:punkt){
            elements.add(new Punctuation(p));
        }
        
        StringBuilder outStr=new StringBuilder((inStr));  
        String[] sents=outStr.toString().split(delimWords);
        
        for (String s:sents){
            if (s.isEmpty()==false) {
                elements.add(new Word(s));
            }
        }
    }
    
    @Override
    public String toString() {
         String s=new String();
         for (SymbolParser pars:elements) { 
             s+=pars.toString();
         }
        return s;
    }
    
 // @Override
    public void modyfyWord (int wordMinLenght, int wordMaxLenght){
        for (SymbolParser pars:elements) {             
             pars.modyfyWord(wordMinLenght,wordMaxLenght);
   
         }
    }
}

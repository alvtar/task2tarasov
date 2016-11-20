package domain;

import java.util.LinkedList;


public class Sentence extends SymbolParser {
    public LinkedList<SymbolParser> elements;
    protected static String delimiters="\\s+";
    
    public Sentence(String inStr) {
        super(inStr);
    }

    @Override
    protected void parse() {
        elements=new LinkedList<>();
        String[] sents=inStr.split(delimiters);
        
        for (String s:sents){
            elements.add(new Word(s));
            //System.out.println(s);
        }
        
    }
    
   ////@Override
   // public LinkedList<SymbolParser> getElements() {
   //     return elements;
//
   // }
    
}

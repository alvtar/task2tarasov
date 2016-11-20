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
        
        String[] punkt=inStr.replaceAll(delimPunctuation,"").split(delimPunctuation);
        //String[] punkt2=punkt.toString().split("\r|\n");
        
        for (String p:punkt){
            elements.add(new Punctuation(p));
            System.out.println(p);
            //s.
        }
        
        StringBuilder outStr=new StringBuilder(inStr);//.replaceAll("[^a-zA-Zà-ÿÀ-ß0-9]", " ");//(matcher.replaceAll(""))
        
        String[] sents=outStr.toString().split("[^a-zA-Zà-ÿÀ-ß0-9]");//|\\r|\\n+");
        
        for (String s:sents){
            elements.add(new Word(s));
            System.out.println(s);
            //s.
        }
        
        
        
        
        
    }
    
   ////@Override
   // public LinkedList<SymbolParser> getElements() {
   //     return elements;
//
   // }
    
}

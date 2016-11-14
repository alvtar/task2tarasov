package domain;

import java.util.LinkedList;
import java.util.List;


public class Sentence {
    protected LinkedList<List> elements;
    protected String sentStr;
    
    public Sentence(String sentStr) {
        this.sentStr=sentStr;
        parse();
    }
    
    protected void parse() {
        elements=new LinkedList<>();
        //for (int i=0; i<wordStr.length();i++) {
        //    symbols.add(new Symbol(wordStr.charAt(i)));
        //}
        String[] sents=sentStr.split("\\s*(\\s|?|!|\\.)\\s*");
        
        //for (int i=0; i<sents.length();i++) {
        for (String s:sents){
            elements.add(new Word(s));
        }
        
    }


    //разборка на элементы по позиции
}

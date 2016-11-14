package domain;

import java.util.LinkedList;

public class Word {
    public LinkedList<Symbol> symbols;
    protected String wordStr;
    
    //public void add(Symbol s){
     //   symbols.add(s);
    //}
    // разборка на символы
    public Word(String wordStr) {
        this.wordStr=wordStr;
        parse();
    }
    
    protected void parse() {
        symbols=new LinkedList<>();
        for (int i=0; i<wordStr.length();i++) {
            //char c=wordStr.charAt(i);
            //Symbol s=new Symbol(c);
            //symbols.add(s);
            symbols.add(new Symbol(wordStr.charAt(i)));
        }
        
    }
    
    
}

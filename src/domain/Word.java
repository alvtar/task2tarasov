package domain;

import java.util.LinkedList;

public class Word {
    public LinkedList<Symbol> symbols;
    protected String wordStr;

    public Word(String wordStr) {
        this.wordStr=wordStr;
        parse();
    }
    
    protected void parse() {
        symbols=new LinkedList<>();
        for (int i=0; i<wordStr.length();i++) {
            symbols.add(new Symbol(wordStr.charAt(i)));
        }
        
    }
    
    
}

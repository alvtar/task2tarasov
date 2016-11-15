package domain;

import java.util.LinkedList;

public abstract class SymbolParser {
    public LinkedList<Symbol> elements;
    protected String inStr;
    
    public SymbolParser() {
    }
    
    public SymbolParser(String inStr) {
        this.inStr=inStr;
        parse();
    }
    
    protected void parse() {
        elements=new LinkedList<>();
        for (int i=0; i<inStr.length();i++) {
            elements.add(new Symbol(inStr.charAt(i)));
        }
        
    }
}

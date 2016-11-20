package domain;

import java.util.LinkedList;

public abstract class SymbolParser {
    protected LinkedList<Symbol> elements;
    protected String inStr;
    
    //public SymbolParser() {
    //}
    
    public SymbolParser(String inStr) {
        this.inStr=inStr;
        parse();
    }
    
    protected void parse() {
        elements=new LinkedList<>();
        for (int i=0; i<inStr.length();i++) {
            //char c=inStr.charAt(i);
            //String s=new String(c);
            elements.add(new Symbol(inStr.charAt(i)));
        }
    }
    
    public LinkedList<Symbol> getElements() {
        return elements;

    }
    
    public void show() {
         for (Symbol pars:elements) {
             //System.out.print(pars.toString()); 
        }
        //System.out.println();
    }
    
}


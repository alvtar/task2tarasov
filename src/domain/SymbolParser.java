package domain;

import java.util.LinkedList;

public abstract class SymbolParser {
    protected LinkedList<Symbol> elements;
    protected String inStr;
    
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

    public void modyfyWord (int wordMinLenght,int wordMaxLenght) {  };

    
    @Override
    public String toString() {
         String s=new String();
         for (Symbol pars:elements) {
             //System.out.print(pars.toString()); 
             s=s+pars.toString();
         }
        //System.out.println("=SP=");
         s=s+"\n";
        return s;
    }
    
}


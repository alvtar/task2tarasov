package domain;

import java.util.LinkedList;

public abstract class Parser {
    public LinkedList<Object> elements;
    protected String inStr;
    
    public Parser(String inStr) {
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

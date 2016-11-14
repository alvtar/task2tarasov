package domain;

import java.util.LinkedList;

public class Text {
    protected LinkedList<Sentence> sentencies;
    protected String textStr;
    
    public Text(String textStr) {
        this.textStr=textStr;
        parse();
    }
    
    protected void parse() {
        sentencies=new LinkedList<>();
        
        ///String sss=new String();
        String[] sents=textStr.split("\\s*(\\s|?|!|\\.)\\s*");
        
        //for (int i=0; i<sents.length();i++) {
        for (String s:sents){
            sentencies.add(new Sentence(s));
        }
        
    }
}

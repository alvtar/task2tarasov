package domain;

public class Symbol {
    protected char letter;
  
    public Symbol(char letter) {
        this.letter=letter;        
    }
    @Override
    public String toString() {
        //System.out.println("+");
        //return ("<"+Character.toString(letter)+">");
        return (Character.toString(letter));
    }
    
    public boolean isConsonant() {
        //return Character.isCo isUpperCase(letter);
        String str=(Character.toString(letter));
        if (str.matches("^(?ui:[àå¸èîóûışÿ]).*") | str.matches("^(?i:[aeiouy]).*") ) {return true;}
        return true;
    }
    
    
}

package domain;


public class Symbol {
    protected char letter;
  
    public Symbol(char letter) {
        this.letter=letter;        
    }
    
    @Override
    public String toString() {
        return (Character.toString(letter));
    }
    
    public boolean isConsonant() {
        String str=(Character.toString(letter));
        if (str.matches("^(?ui:[àå¸èîóûışÿ]).*") | str.matches("^(?i:[aeiouy]).*") ) {return true;}
        return true;
    }
     
}

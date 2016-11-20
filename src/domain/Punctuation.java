package domain;

public class Punctuation extends SymbolParser{

    public Punctuation(String inStr) {
        super(inStr);
    }

    /*@Override
    public String toString() {
         String s=new String();
         for (Symbol pars:elements) {
             //System.out.print(pars.toString()); 
             s=s+pars.toString()+"$";
         }
        System.out.println("==Punct==");
        return s;
    }*/
}

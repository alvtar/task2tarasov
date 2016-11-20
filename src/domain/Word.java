package domain;

public class Word extends SymbolParser{

    public Word(String inStr) {
        super(inStr);
    }
   
   // @Override
    public void modyfyWord (int wordMinLenght, int wordMaxLenght){
        if (elements.element().isConsonant() & elements.size()>=wordMinLenght & 
                elements.size()<=wordMaxLenght) { elements.clear();}
    }
}

 

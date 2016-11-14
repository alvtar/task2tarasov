package domain;

import java.util.LinkedList;


public class Sentence {
    protected LinkedList<LinkedList> elements;
    //protected List<Punctuation> punktuations;
    //protected List<Phone> phones;
    //protected List<Email> emails;
    
    public void addElement(LinkedList<LinkedList> element){
        elements.add(element);
        
    }
    //разборка на элементы по позиции
}

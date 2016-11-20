package domain;

/// метод больша€/мала€ буква - в классе —имвол
/// метод длины - в слове 



import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.*;

public class Text extends SymbolParser{
    public LinkedList<SymbolParser> elements;
    
    protected static String delimEmails="\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    protected static String delimPhones="(8\\(\\d\\d\\d\\)\\d\\d\\d\\-\\d\\d\\-\\d\\d)";
    //protected static String delimSentencies="([^.!?]+[.!?])"; // предложени€ со знаками препинани€
    protected static String delimSentencies="[^.]+";  // предложени€ без знаков препинани€
    
    protected StringBuilder outStr;//=new StringBuilder(inStr);
    
    //protected static String delimiters="[^0-9a-zA-Zа-€ј-я]+"; // слова 
    //protected static String delimPunctuation="[0-9a-zA-Zа-€ј-я]+"; // разделители
    protected static String delimPunctuation="."; 
    
    public Text(String inStr) {
        super(inStr);
    }

    @Override
    protected void parse() {
        
        elements=new LinkedList<>();
        
        outStr=new StringBuilder(inStr);
        
        //System.out.println(outStr);
        //System.out.println("=======");
        outStr=filter("domain.Email",outStr,delimEmails);
        //System.out.println(outStr);
        System.out.println("=======");
        System.out.println(outStr);
        outStr=filter("domain.Phone",outStr,delimPhones);
        //System.out.println(outStr);Phone",outStr,delimPhones));
        System.out.println("=======");
        System.out.println(outStr);
        outStr=filter("domain.Sentence",outStr,delimSentencies);
        
        System.out.println("=======");
        System.out.println(outStr);
        
        outStr=filter("domain.Punctuation",outStr,delimPunctuation);
        
        System.out.println("=======");
        System.out.println(outStr);
        
        for (SymbolParser pars:elements) {
            //System.out.println(pars.show()); 
            LinkedList<Symbol> subPars = pars.getElements();
            
            if (subPars.getClass().equals(Sentence.class)) {
                
                for (Symbol sp:subPars) {
                    System.out.print(sp.letter);
                    // определ€ть тип класса
                   // if sp.getClass().equals(Word.class) //  .getSimpleName().toString().e
                }
            }
            else {
                
                for (Symbol sp:subPars) {
                    System.out.print(sp.letter);
                    // определ€ть тип класса
                    //if sp.getClass().equals(Word.class) //  .getSimpleName().toString().e
                }
            
            }
            }
       //System.out.println();

        
        
        
        /*Matcher matcher = Pattern.compile(delimSentencies).matcher(inStr);
        while (matcher.find())
        {
            System.out.println(matcher.group());
            elements.add(new Sentence(matcher.group()));
        }
        matcher.replaceAll("");*/
        
    }
    
 
   
    @SuppressWarnings("unchecked")
    protected StringBuilder filter(String className,StringBuilder outStr,String delimiters) {

        Class<SymbolParser> c;
        c=null;
        try {
            c = (Class<SymbolParser>) Class.forName(className);
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        @SuppressWarnings("rawtypes")
        Constructor[] construct =  c.getDeclaredConstructors();

        Matcher matcher = Pattern.compile(delimiters).matcher(outStr);
        while (matcher.find())
        {
            try {
                elements.add((SymbolParser) construct[0].newInstance((matcher.group())));
                //System.out.println(matcher.group().toString());
               //matcher.replaceAll("");
                
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        outStr=new StringBuilder(matcher.replaceAll(""));
        //System.out.println(outStr);
        return outStr;
    }
    
         
}

package domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/// ����� �������/����� ����� - � ������ ������
/// ����� ����� - � ����� 



import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import runner.TestStart;

public class Text extends SymbolParser{
    protected LinkedList<SymbolParser> elements;
    
    protected static String delimEmails="\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    protected static String delimPhones="(8\\(\\d\\d\\d\\)\\d\\d\\d\\-\\d\\d\\-\\d\\d)";
    //protected static String delimSentencies="([^.!?]+[.!?])"; // ����������� �� ������� ����������
    protected static String delimSentencies="([�-�A-Z]((�.�.|�.�.|��.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]+)";//"[^.]+";  // ����������� ��� ������ ����������
    
    protected StringBuilder outStr;//=new StringBuilder(inStr);
    
    //protected static String delimiters="[^0-9a-zA-Z�-��-�]+"; // ����� 
    //protected static String delimPunctuation="[0-9a-zA-Z�-��-�]+"; // �����������
    //protected static String delimPunctuation="."; 
    
    public Text(String inStr) {
        super(inStr);
    }

   // @Override
    protected void parse() {
        
        elements=new LinkedList<>();
        
        outStr=new StringBuilder(inStr);
        
        outStr=filter("domain.Sentence",outStr,delimSentencies);
        outStr=filter("domain.Phone",outStr,delimPhones);
        outStr=filter("domain.Email",outStr,delimEmails);

            for (SymbolParser pars:elements) {

                //System.out.print(wordMinLenght);
                pars.modyfyWord(TestStart.wordMinLenght,TestStart.wordMaxLenght);
                //pars.toString();

            }
            
            elements.toString();
            
    }
        
       /* for (SymbolParser pars:elements) {
            //System.out.println(pars.show()); 
            LinkedList<Symbol> subPars = pars.getElements();
            . 
            if (subPars.getClass().equals(Sentence.class)) {
                
                for (Symbol sp:subPars) {
                    //System.out.print(sp.letter);
                    // ���������� ��� ������
                   // if sp.getClass().equals(Word.class) //  .getSimpleName().toString().e
                }
            }
            else {
                
                for (Symbol sp:subPars) {
                    //System.out.print(sp.letter);
                    // ���������� ��� ������
                    //if sp.getClass().equals(Word.class) //  .getSimpleName().toString().e
                }
            
            }
            } */
  
    
 
   
    @SuppressWarnings("unchecked")
    protected StringBuilder filter(String className,StringBuilder outStr,String delimiters) {

        Class<SymbolParser> c;
        c=null;
        try {
            c = (Class<SymbolParser>) Class.forName(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        @SuppressWarnings("rawtypes")
        Constructor[] construct =  c.getDeclaredConstructors();

        Matcher matcher = Pattern.compile(delimiters).matcher(outStr);
        while (matcher.find())
        {
            try {
                elements.add((SymbolParser) construct[0].newInstance((matcher.group())));
                
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {

                e.printStackTrace();
            }

        }

        return outStr;
    }
    
         
}

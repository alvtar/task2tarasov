package domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import runner.TestStart;


public class Text extends SymbolParser{
    protected LinkedList<SymbolParser> elements;   
    protected static String delimEmails="\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    protected static String delimPhones="(8\\(\\d\\d\\d\\)\\d\\d\\d\\-\\d\\d\\-\\d\\d)";
    protected static String delimSentencies="([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]+)";
    protected StringBuilder outStr;
    
    
    public Text(String inStr) {
        super(inStr);
    }

    
   // @Override
    protected void parse() {  
        elements=new LinkedList<>();
        
        outStr=new StringBuilder(inStr);    
        filter("domain.Sentence",outStr,delimSentencies);
        filter("domain.Phone",outStr,delimPhones);
        filter("domain.Email",outStr,delimEmails);

        System.out.println("====== ORIGINAL ALL TEXT ELEMENTS (without sequencing words & punctuations) ========:");
        System.out.println(elements.toString());
        System.out.println();
        System.out.println("====== MODIFIED ELEMENTS OF TEXT (WITH DELETED WORDS MATCH THE CRITERIA) ========:");
        
        for (SymbolParser pars:elements) {
            pars.modyfyWord(TestStart.wordMinLenght,TestStart.wordMaxLenght);
            System.out.println(pars.toString());
        }
    }
    
    
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


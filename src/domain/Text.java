package domain;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends SymbolParser{
    public LinkedList<SymbolParser> elements;
    
    protected static String delimEmails="\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    protected static String delimPhones="(8\\(\\d\\d\\d\\)\\d\\d\\d\\-\\d\\d\\-\\d\\d)";
    //protected static String delimSentencies="([^.!?]+[.!?])"; // предложения со знаками препинания
    protected static String delimSentencies="[^.]+";  // предложения без знаков препинания
    
    protected StringBuilder outStr;//=new StringBuilder(inStr);
    
    //protected static String delimiters="[^0-9a-zA-Zа-яА-Я]+"; // слова 
    //protected static String delimiters="[0-9a-zA-Zа-яА-Я]+"; // разделители
   
    public Text(String inStr) {
        super(inStr);
    }

    @Override
    protected void parse() {
        
        elements=new LinkedList<>();
        
        outStr=new StringBuilder(inStr);
        
        //System.out.println(outStr);
        //System.out.println("=======");
        System.out.println(filterEmails (outStr,delimEmails));
        //System.out.println(outStr);
        filterPhones (outStr,delimPhones);
        filterSentencies (outStr,delimSentencies);
        
        System.out.println("=======");

        /*Matcher matcher = Pattern.compile(delimSentencies).matcher(inStr);
        while (matcher.find())
        {
            System.out.println(matcher.group());
            elements.add(new Sentence(matcher.group()));
        }
        matcher.replaceAll("");*/
        
    }
    
 
    protected StringBuilder filterEmails(StringBuilder inStr,String delimiters) {
 
        Matcher matcher = Pattern.compile(delimiters).matcher(outStr);
        while (matcher.find())
        {
            //System.out.println(matcher.group());
            elements.add(new Email(matcher.group()));      
            matcher.replaceAll("");
        }
        //matcher.replaceAll("");
        return outStr;
    }
    
    protected StringBuilder filterPhones(StringBuilder inStr,String delimiters) {

        Matcher matcher = Pattern.compile(delimiters).matcher(outStr);
        while (matcher.find())
        {
            //System.out.println(matcher.group());
            elements.add(new Phone(matcher.group()));
        }
        matcher.replaceAll("");
        return outStr;
    }
    
    protected StringBuilder filterSentencies(StringBuilder outStr,String delimiters) {
 
        Matcher matcher = Pattern.compile(delimiters).matcher(outStr);
        while (matcher.find())
        {
            //System.out.println(matcher.group());
            elements.add(new Sentence(matcher.group()));
        }
        matcher.replaceAll("");
        return outStr;
    }
     
}

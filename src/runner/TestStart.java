package runner;

/** Task 2, variant 12
 * @author Tarasov Alexandr
 * 
 * Class TestStart with main() method
 * 
 * ��� ��� �������� ������ ������ � ������� �� �������������, 
 * �� �� ������������ ������� �� ����������� ���� � ������ ���������� 
 * � ������� �� ���������, ������ ������ ������� ����������� ���������� 
 * ��������������� � ��������������� ��� ������.
 * 
 * */

import domain.Text;
import reader.TextReader;

public class TestStart {
    public static int wordMinLenght=3; // Minimum length of words to remove if they begin with a consonant.
    public static int wordMaxLenght=5; // Maximum length of words to remove if they begin with a consonant.
 
    
    public static void main(String[] args) { 
        String fileName=System.getProperty("user.dir")+"\\src\\book.txt";  // File name for parsing.
        
        TextReader tr=new TextReader(fileName);
        new Text(tr.read());
    }
}

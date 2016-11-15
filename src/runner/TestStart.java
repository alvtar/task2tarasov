package runner;

import domain.Text;
import reader.TextReader;

public class TestStart {

    public static void main(String[] args) {
        TextReader tr=new TextReader();
        new Text(tr.read());

    }

}

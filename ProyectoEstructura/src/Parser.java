import java.util.List;
import java.util.Stack;

public class Parser {
    public String[] parse (String operacion){
        String cadena = "";
        for (int x=operacion.length()-1;x>=0;x--)
            cadena = cadena + operacion.charAt(x);
        String[] words = cadena.split(" ");
        int index = 0;
        for (String i: words) {
            System.out.println(words[index]);
            index++;
        }
        return  words;
        }
}

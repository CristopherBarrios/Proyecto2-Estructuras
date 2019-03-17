public class Parser {
    public String[] parse (String operacion){
        String[] words = operacion.split(" ");
        int index = 0;
        for (String i: words) {
            System.out.println(words[index]);
            index++;
        }
        return  words;
        }
}

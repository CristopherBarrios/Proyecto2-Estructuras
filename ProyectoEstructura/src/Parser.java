public class Parser {
    public String[] parse (String operacion){
        String[] words = operacion.split(" ");
        String[] invertida = new String[words.length];
        int x = 0;
        for (int i = words.length-1; i>=0;i--){
            invertida[x] = words[i];
            x++;
        }
        words = invertida;
        int index = 0;
        for (String i: words) {
            System.out.println(words[index]);
            index++;
        }
        return  words;
        }
}

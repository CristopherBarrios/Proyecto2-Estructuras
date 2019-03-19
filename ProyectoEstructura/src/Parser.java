/**
 * Clase parser que divide un string por espacios
 */
public class Parser {
    /**
     * @param operacion, la cual es ingresada por el usuario
     * @return una lista de strings con palabras claves
     */
    public String[] parse (String operacion){
        String[] words = operacion.split(" ");
        int index = 0;
        for (String i: words) {
            index++;
        }
        return  words;
        }
}

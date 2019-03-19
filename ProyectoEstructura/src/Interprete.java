import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Clase que traduce los comandos ingresados por el usuario, evalua palabras claves y operandos
 */
public class Interprete {
    public Stack<String> myStack = new Stack<>();
    public Map<String,String> funciones = new HashMap<String,String>();
    Parser par = new Parser();

    /**
     * Metodo principal del programa que recorre una lista y realiza las operaciones especificadas
     * @param terminos, recibe una lista de strings que debe iterar
     * @return, un string con el resultado de los comandos
     */
    public String interpret (String[] terminos){
        Boolean inicio = false;
        Boolean seguir = true;
        Boolean isfun = false;
        String resultado = "0";
        int cont1 = 0;
        int cont2 = 0;
        while(seguir){
            //Recorrer la lista
            for(int i = 0; i < terminos.length; i++){
                Double numero;
                //Si es un numero agregarlo al stack
                try{
                    numero=Double.parseDouble(terminos[i]);
                    myStack.push(terminos[i]);
                }catch(NumberFormatException ex){
                    //Si no es un numero realizar operaciones
                    if (terminos[i].equals("(")&&cont1!=0&& inicio){
                        cont1++;
                    }
                    if (terminos[i].equals("(")&&cont1==0){
                        inicio = true;
                        cont1++;
                    }else{
                        seguir = false;
                    }
                    //Definicion de funcion
                    if (terminos[i].equals("DEFUN")){
                        isfun = true;
                        cont2++;
                        resultado = "Funcion creada";
                        inicio = false;
                        String parcu= "";
                        for(int y = i+2;y<terminos.length-1;y++){
                            parcu = parcu+terminos[y]+" ";
                        }
                        funciones.put(terminos[i+1],parcu);
                    }
                    //Condicianales
                    if (terminos[i].equals("COND")&&inicio){
                        isfun = true;
                        cont2++;
                        inicio = false;
                        String condiciones = "";
                        for(int y = i+2;y<terminos.length-2;y++){
                            condiciones = condiciones+terminos[y]+" ";
                        }
                        System.out.println(condiciones);
                        String[] parts = condiciones.split(" \\) \\( ");
                        for( int x = 0;x<parts.length;x++){
                            System.out.println(parts[x]);
                            String[] yu = parts[x].split("\\)");
                        }
                    }
                    //Mandar a llamar una funcion
                    if(funciones.containsKey(terminos[i])&&inicio){
                        Map<String,String> var = new HashMap<String,String>();
                        isfun = true;
                        cont2++;
                        inicio = false;
                        String todo = funciones.get(terminos[i]);
                        String[] parts = todo.split(" \\) \\( ");
                        String parametros = parts[0];
                        String cuerpo = parts[1];
                        parametros = parametros.replace("( ", "");
                        cuerpo = "( "+cuerpo;
                        parts = par.parse(parametros);
                        String asignacion= "";
                        for(int j = i+1;j<terminos.length-1;j++){
                            asignacion =asignacion+terminos[j]+" ";
                        }
                        asignacion = asignacion.replace(" ) ", "");
                        asignacion = asignacion.replace("( ", "");
                        String[] numeros = asignacion.split(" ");
                        for( int k = 0; k<parts.length; k++){
                            var.put(parts[k],numeros[k]);
                        }
                        String[] cambio = par.parse(cuerpo);
                        for(int n=0;n<cambio.length;n++){
                            if(var.containsKey(cambio[n])){
                                cambio[n]=var.get(cambio[n]);
                            }
                        }
                        resultado= interpret(cambio);
                    }
                    //Añadir al stack principal si es un operador
                    if (terminos[i].equals("+") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("-") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("*") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("/") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals(">") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("<") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("EQUAL") && inicio && !isfun){
                        myStack.push(terminos[i]);
                    }
                    //Al encontrar un parentesis cerrado realizar operaciones dentro del stack principal
                    if (terminos[i].equals(")") && inicio && !isfun){
                        Stack<Double> num = new Stack<>();
                        Boolean isOpe = false;
                        while(!isOpe){
                            if (myStack.peek().equals("+") || myStack.peek().equals("-") || myStack.peek().equals("*") || myStack.peek().equals("/") || myStack.peek().equals(">") || myStack.peek().equals("<")|| myStack.peek().equals("EQUAL")) {
                                isOpe=true;
                            }else{
                                num.push(Double.parseDouble(myStack.pop()));
                            }
                        }
                        //Suma
                        if(myStack.peek().equals("+")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res+x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        //Resta
                        if(myStack.peek().equals("-")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res-x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        //Division
                        if(myStack.peek().equals("/")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res/x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        //Multiplicacion
                        if(myStack.peek().equals("*")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res*x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        //Mayor
                        if(myStack.peek().equals(">")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a>b){
                                resultado = "Verdadero";
                            }else{
                                resultado = "Falso";
                            }
                        }
                        //Menor
                        if(myStack.peek().equals("<")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a>b){
                                resultado = "Falso";
                            }else{
                                resultado = "Verdadero";
                            }
                        }
                        //Igual
                        if(myStack.peek().equals("EQUAL")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a==b){
                                resultado = "Verdadero";
                            }else{
                                resultado = "Falso";
                            }
                        }
                        cont2++;
                    }
                }
            }
        }
        //Si no cumple requisitos de los parentesis mostrar error de sintaxis
        if(cont1!=cont2||(!inicio&&!isfun)){
            resultado = "Error de sintaxis";
        }
        return resultado;
    }
}

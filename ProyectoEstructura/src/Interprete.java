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

    public String interpret (String[] terminos){
        Boolean inicio = false;
        Boolean seguir = true;
        Boolean bool = false;
        Boolean isfun = false;
        String resultado = "0";
        int cont1 = 0;
        int cont2 = 0;
        while(seguir){
            for(int i = 0; i < terminos.length; i++){
                Double numero;
                try{
                    numero=Double.parseDouble(terminos[i]);
                    myStack.push(terminos[i]);
                }catch(NumberFormatException ex){
                    if (terminos[i].equals("(")&&cont1!=0&& inicio){
                        cont1++;
                    }
                    if (terminos[i].equals("(")&&cont1==0){
                        inicio = true;
                        cont1++;
                    }else{
                        seguir = false;
                    }
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
                        System.out.println(cuerpo);
                        cuerpo = "( "+cuerpo;
                        System.out.println(cuerpo);
                        parts = par.parse(parametros);
                        String asignacion= "";
                        for(int j = i+1;j<terminos.length-1;j++){
                            asignacion =asignacion+terminos[j]+" ";
                        }
                        System.out.println(asignacion);
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
                        if(myStack.peek().equals("+")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res+x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        if(myStack.peek().equals("-")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res-x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        if(myStack.peek().equals("/")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res/x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        if(myStack.peek().equals("*")){
                            double res = num.pop();
                            for (double x: num) {
                                res = res*x;
                            }
                            myStack.pop();
                            myStack.push(Double.toString(res));
                            resultado = Double.toString(res);
                        }
                        if(myStack.peek().equals(">")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a>b){
                                resultado = "Verdadero";
                            }else{
                                resultado = "Falso";
                            }
                        }
                        if(myStack.peek().equals("<")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a>b){
                                resultado = "Falso";
                            }else{
                                resultado = "Verdadero";
                            }
                        }
                        if(myStack.peek().equals("EQUAL")){
                            double a = num.pop();
                            double b = num.pop();
                            if(a==b){
                                resultado = "Verdadero";
                                bool = true;
                            }else{
                                resultado = "Falso";
                                bool = false;
                            }
                        }
                        cont2++;
                    }
                }
            }
        }
        if(cont1!=cont2||(!inicio&&!isfun)){
            resultado = "Error de sintaxis";
        }
        return resultado;
    }
}

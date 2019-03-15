import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Clase que traduce los comandos ingresados por el usuario, evalua palabras claves y operandos
 */
public class Interprete {
    public String interpret (String[] terminos){
        Boolean inicio = false;
        Boolean seguir = true;
        String resultado = "0";
        int cont1 = 0;
        int cont2 = 0;
        Stack<String> myStack = new Stack<>();
        Map funciones = new HashMap();
        while(seguir){
            for(int i = 0; i < terminos.length; i++){
                Double numero;
                try{
                    numero=Double.parseDouble(terminos[i]);
                    myStack.push(terminos[i]);
                }catch(NumberFormatException ex){
                    if (terminos[i].equals("(")){
                        inicio = true;
                        cont1++;
                    }else{
                        seguir = false;
                    }
                    if (terminos[i].equals("+") && inicio){
                        System.out.println("Sumar");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("-") && inicio){
                        System.out.println("Restar");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("*") && inicio){
                        System.out.println("Multiplicar");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("/") && inicio){
                        System.out.println("Dividir");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals(">") && inicio){
                        System.out.println("Mayor");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("<") && inicio){
                        System.out.println("Menor");
                        myStack.push(terminos[i]);
                    }
                    if (terminos[i].equals("EQUAL") && inicio){
                        System.out.println("Igual");
                        myStack.push(terminos[i]);
                    }
                    System.out.println(myStack);
                    if (terminos[i].equals(")") && inicio){
                        Stack<Double> num = new Stack<>();
                        Boolean isOpe = false;
                        while(!isOpe){
                            if (myStack.peek().equals("+") || myStack.peek().equals("-") || myStack.peek().equals("*") || myStack.peek().equals("/") || myStack.peek().equals(">") || myStack.peek().equals("<")|| myStack.peek().equals("EQUAL")) {
                                isOpe=true;
                            }else{
                                num.push(Double.parseDouble(myStack.pop()));
                            }
                        }
                        System.out.println("Stack: "+myStack);
                        System.out.println("Stack num:"+num);
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
                            }else{
                                resultado = "Falso";
                            }
                        }
                        cont2++;
                    }
                }
            }
        }
        return resultado;
    }
}

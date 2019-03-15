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
        String resultado="";
        int cont1 = 0;
        int cont2 = 0;
        Stack<Double> myStack = new Stack<>();
        Map funciones = new HashMap();
        while(seguir){
            for(int i = 0; i < terminos.length; i++){
                Double numero;
                try{
                    numero=Double.parseDouble(terminos[i]);
                    myStack.push(numero);
                }catch(NumberFormatException ex){
                    if (terminos[i].equals(")")){
                        inicio = true;
                        cont1++;
                    }else{
                        seguir = false;
                    }
                    if (terminos[i].equals("+") && inicio){
                        System.out.println("Sumar");
                        for(int x=0; x<myStack.size(); x++ ){
                            if (myStack.size()!= 1 ){
                                double a = myStack.pop();
                                double b = myStack.pop();
                                resultado = Double.toString(a+b);
                                myStack.push(Double.parseDouble(resultado));
                            }
                        }
                    }
                    if (terminos[i].equals("-") && inicio){
                        System.out.println("Restar");
                        for(int x=0; x<myStack.size(); x++ ){
                            if (myStack.size()!= 1 ){
                                double a = myStack.pop();
                                double b = myStack.pop();
                                resultado = Double.toString(a-b);
                                myStack.push(Double.parseDouble(resultado));
                            }
                        }
                    }
                    if (terminos[i].equals("*") && inicio){
                        System.out.println("Multiplicar");
                        for(int x=0; x<myStack.size(); x++ ){
                            if (myStack.size()!= 1 ){
                                double a = myStack.pop();
                                double b = myStack.pop();
                                resultado = Double.toString(a*b);
                                myStack.push(Double.parseDouble(resultado));
                            }
                        }
                    }
                    if (terminos[i].equals("/") && inicio){
                        System.out.println("Dividir");
                        for(int x=0; x<myStack.size(); x++ ){
                            if (myStack.size()!= 1 ){
                                double a = myStack.pop();
                                double b = myStack.pop();
                                if (b != 0){
                                    resultado = Double.toString(a/b);
                                    myStack.push(Double.parseDouble(resultado));
                                }else{
                                    System.out.println("No se puede dividir por 0");
                                }
                            }
                        }
                    }
                    if (terminos[i].equals(">") && inicio){
                        System.out.println("Mayor");
                        double a = myStack.pop();
                        double b = myStack.pop();
                        if(a>b){
                            resultado = "Verdadero";
                        }else{
                            resultado = "Falso";
                        }
                    }
                    if (terminos[i].equals("<") && inicio){
                        System.out.println("Menor");
                        double a = myStack.pop();
                        double b = myStack.pop();
                        if(a>b){
                            resultado = "Falso";
                        }else{
                            resultado = "Verdadero";
                        }
                    }
                    if (terminos[i].equals("(") && inicio && cont1==cont2+1){
                        System.out.println("Finalizado");
                        cont2++;
                    }
                    if (terminos[i].equals("Defun")){
                        funciones.put(terminos[i], "");
                        funciones.get(terminos[i]);
                    }
                }
            }
        }
        return resultado;
    }
}

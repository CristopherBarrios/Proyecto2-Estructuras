import java.util.List;
import java.util.Stack;

public class Interprete {
    public String interpret (String[] terminos){
        Boolean inicio = false;
        Boolean seguir = true;
        String resultado="";
        int cont1 = 0;
        int cont2 = 0;
        Stack<Double> myStack = new Stack<>();
        while(seguir){
            for(int i =0; i < terminos.length; i++){
                if (terminos[i].equals(")")){
                    inicio = true;
                    cont1++;
                }else{
                    seguir = false;
                }
                if (terminos[i].equals("+") && inicio){
                    System.out.println("Sumar");
                    double a = myStack.pop();
                    double b = myStack.pop();
                    resultado = Double.toString(a+b);
                    myStack.push(Double.parseDouble(resultado));
                }
                if (terminos[i].equals("-") && inicio){
                    System.out.println("Restar");
                    double a = myStack.pop();
                    double b = myStack.pop();
                    resultado = Double.toString(a-b);
                    myStack.push(Double.parseDouble(resultado));
                }
                if (terminos[i].equals("*") && inicio){
                    System.out.println("Multiplicar");
                    double a = myStack.pop();
                    double b = myStack.pop();
                    resultado = Double.toString(a*b);
                    myStack.push(Double.parseDouble(resultado));
                }
                if (terminos[i].equals("/") && inicio){
                    System.out.println("Dividir");
                    double a = myStack.pop();
                    double b = myStack.pop();
                    if (b != 0){
                        resultado = Double.toString(a/b);
                        myStack.push(Double.parseDouble(resultado));
                    }else{
                        System.out.println("No se puede dividir por 0");
                    }

                }
                if (terminos[i].equals("(") && inicio && cont1-1==cont2){
                    System.out.println("Finalizado");
                    cont2++;
                }
                if (terminos[i].equals("0")||terminos[i].equals("1")||terminos[i].equals("2")||terminos[i].equals("3")||terminos[i].equals("4")||terminos[i].equals("5")||terminos[i].equals("6")||terminos[i].equals("7")||terminos[i].equals("8")||terminos[i].equals("9")){
                    myStack.push(Double.parseDouble(terminos[i]));
                }
            }
        }
        return resultado;
    }
}

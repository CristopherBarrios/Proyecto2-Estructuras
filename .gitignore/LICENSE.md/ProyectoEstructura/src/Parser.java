import java.util.Stack;

public class Parser {
    public int operations (String operacion){
        Boolean inicio = false;
        Boolean seguir = true;
        int resultado=0;
        int cont1 = 0;
        int cont2 = 0;
        Stack<Integer> myStack = new Stack<>();
        while(seguir){
            for(int i =0; i < operacion.length(); i++){
                if (operacion.charAt(i) == '('){
                    inicio = true;
                    cont1++;
                }else{
                    seguir = false;
                }
                if (operacion.charAt(i) == '+' && inicio){
                    System.out.println("Sumar");
                    resultado = 1+1;
                    myStack.push(resultado);
                }
                if (operacion.charAt(i) == '-' && inicio){
                    System.out.println("Restar");
                }
                if (operacion.charAt(i) == '/' && inicio){
                    System.out.println("Multiplicar");
                }
                if (operacion.charAt(i) == '*' && inicio){
                    System.out.println("Dividir");
                }
                if (operacion.charAt(i) == ')' && inicio&& cont1-1==cont2){
                    System.out.println("Finalizado");
                    cont2++;
                }
            }
        }return resultado;
    }
}

// Evaluador de expresion prefix

import java.io.*;
import java.util.*;

class Defun {

    static Boolean esOperando(char c)
    {
        // si el caracter es un digito entonces
        //debe ser un operando
         
        if(c >= 48 && c <= 57)
            return true;
        else
            return false;
    }

    static double evaluarPrefijo(String exprsn)
    {
        Stack<Double> Stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            // Push del operando al Stack
            // para convertir exprsn[j] a un digito restar
            // '0' de exprsn[j].
            if (esOperando(exprsn.charAt(j)))
                Stack.push((double)(exprsn.charAt(j) - 48));

            else {

                // operador encontrado
                // Pop dos elementrosd Stack
                double a1 = Stack.peek();
                Stack.pop();
                double a2 = Stack.peek();
                Stack.pop();

                // uso de switch para operar en a1 y a2 y hacer a1 o a2

                switch (exprsn.charAt(j)) {
                    case '+':
                        Stack.push(a1 + a2);
                        break;
                    case '-':
                        Stack.push(a1 - a2);
                        break;
                    case '*':
                        Stack.push(a1 * a2);
                        break;
                    case '/':
                        Stack.push(a1 / a2);
                        break;
                }
            }
        }

        return Stack.peek();
    }

    /* programa para probar funcionamiento */
    public static void main(String[] args)
    {
        String exprsn = "+9/26";
        System.out.println(evaluarPrefijo(exprsn));
    }
}


import java.io.IOException;
import java.util.Scanner;

/**
 * Ricardo Valenzuela Avila 18762
 * Cristopher Rodolfo Barrios Solis 18207
 * Estuardo Ureta Granados 17010
 * Nombre del programa: ProyectoEstructura
 * Programa que funciona como interprete de lisp
 */
public class Main {
    private static Scanner input;
    public static void main(String[] args){
        boolean bucle = true;
        boolean infinity = true;
        input = new Scanner(System.in);
        System.out.println(""
                +"Especificaciones del interprete: \n"
                + "- Para este interprete debe poner un espacio despues de cada palabra/caracter\n"
                + "     Ejemplo 1: ( + 9 9 ) Ejemplo 2: ( / ( + 8 8 ) 2 )\n"
                + "-Utilize EQUAL en lugar de =\n"
                + "-Debe utilizar DEFUN para definir una funcion\n"
                + "-Debe utilizar COND para la condicional =\n"
                + "");
        Parser myParser = new Parser();
        Interprete myInter = new Interprete();
        /**
         * Bucle infinito, que imita el comportamiento de un interprete
         */
        while(infinity){
            try{
                System.out.println("Intruccion: ");
                String instruccion = (input.nextLine());
                System.out.println(myInter.interpret(myParser.parse(instruccion)));
            }catch (Exception e){
                System.out.println("ERROR dato ingresado no reconocido");
            }
        }
    }
}

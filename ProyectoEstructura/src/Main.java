import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    public static void main(String[] args){
        boolean bucle = true;
        input = new Scanner(System.in);
        System.out.println("Para este interprete recuerde siempre agregar un espacio despues de cada termino que introdusca" );
        while (bucle){
            System.out.println("Intruccion: ");
            String instruccion = (input.nextLine());
            Parser myParser = new Parser();
            Interprete myInter = new Interprete();
            System.out.println(myInter.interpret(myParser.parse(instruccion)));
        }
    }
}

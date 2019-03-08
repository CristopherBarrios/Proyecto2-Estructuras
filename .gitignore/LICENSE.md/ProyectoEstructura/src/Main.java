import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    public static void main(String[] args) throws IOException {
        input = new Scanner(System.in);
        System.out.println("Intruccion: ");
        Parser izi = new Parser();
        System.out.println(izi.operations("+ 1 1)"));
        String instruction = (input.nextLine());
    }
}

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        int numero = 7;
        Scanner escaner = new Scanner(System.in);
        System.out.print("Ingrese un texto: ");
        String texto = escaner.nextLine();
        numero = 3;
        System.out.println("El texto ingresado es: " + texto);
    }
}

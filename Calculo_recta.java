
import java.util.Scanner;

public class Calculo_recta {

    public static void main(String[] args) throws Exception {
        System.out.println("Cálculo ecuación lineal");

        Scanner lector = new Scanner(System.in);

        // Mensaje para el usuario
        System.out.println("Coordenadas del primer punto");

        System.out.print("x1? ");
        double x1 = lector.nextDouble();

        System.out.print("y1? ");
        double y1 = lector.nextDouble();

        System.out.print("x2? ");
        double x2 = lector.nextDouble();

        System.out.print("y2? ");
        double y2 = lector.nextDouble();

        // Calculo
        double distancia = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double m = (y2 - y1) / (x2 - x1);
        double b = y2 - m * x2;
        String ecuacion = "y = (" + m + ") * x + (" + b + ")";

        // Salida
        System.out.println("La distancia entre los puntos es: " + distancia);
        System.out.println("La ecuación es: " + ecuacion);
    }
}

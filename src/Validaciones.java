import java.util.Scanner;

public class Validaciones {

    private Scanner sc = new Scanner(System.in);


    public Validaciones() {
    }


    public int numeroEntre(int min, int max) {

        int numero;

        numero = sc.nextInt();

        while(numero< min || numero > max ){
            Mensajes.numeroEntre(min, max);
            numero = sc.nextInt();
        }

        return numero;

    }


    public char elegirCaracter(char caracter1, char caracter2){

        char eleccion;

        eleccion = sc.next().charAt(0);

        while(eleccion != caracter1 || eleccion != caracter2){

            Mensajes.caracterIncorrecto(caracter1, caracter2);
            eleccion = sc.next().charAt(0);
        }

        return eleccion;

    }




}

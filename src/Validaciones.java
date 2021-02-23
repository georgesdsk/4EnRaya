import java.util.Scanner;

public class Validaciones {

    private Scanner sc = new Scanner(System.in);


    public Validaciones() {
    }


/*
    Entradas: (int) min , max = rangos minimos y maximos permitidos
    Salidas: int, numero validado entre esos rangos
    Precondiciones: -
    Postcondiciones: -
*/



    public int numeroEntre(int min, int max) {

        int numero;

        numero = sc.nextInt();

        while(numero< min || numero > max ){
            Mensajes.numeroEntre(min, max);
            numero = sc.nextInt();
        }

        return numero;

    }

    /*
    Entradas: (char) 1 y 2
    Salidas: char elegido entre uno de ellos
    Precondiciones: que haya un Scanner validado tipo sc
    Postcondiciones:
*/



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

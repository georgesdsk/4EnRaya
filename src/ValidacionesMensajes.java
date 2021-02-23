import java.util.Scanner;

public class ValidacionesMensajes {

    private Scanner sc = new Scanner(System.in);


    public ValidacionesMensajes() {
    }



    public int elegirCaracter(int min,int max){
        System.out.println("Con que caracter desea jugar el jugador 1?");
        return numeroEntre(min, max);
    }

    public int elegirTipoPartida(int min,int max){
        System.out.println("Que tipo de partida desea jugar?\n 1) Contra ordenador \n2) Contra humano ");
        return numeroEntre(min, max);
    }

    public int  elegirLinea( int max){

        System.out.println("En que linea desea poner la figura?");
        return numeroEntre(0, max);
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
            System.out.println("Respuesta incorrecta elige " + min + " y " + max);
            numeroEntre(min, max);
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


            /*
                public char elegirCaracter(char caracter1, char caracter2){

                    char eleccion;

                    eleccion = sc.next().charAt(0);

                    while(eleccion != caracter1 || eleccion != caracter2){


                        eleccion = sc.next().charAt(0);
                    }

                    return eleccion;

                }
            */



    /*
    Entradas: (char):
                    turno-> a quien le toca
                    eleccion-> la figura que a elegido

    Salidas: mensaje del jugador en la pantalla
    Precondiciones: -
    Postcondiciones: mensaje del jugador en la pantalla
*/


    public void escribirJugador(char turno, char eleccion) {

        switch (turno) {

            case '1' -> {
                System.out.println("El jugador 1 con la figura " + eleccion);
            }
            case '2' -> {
                System.out.println("El jugador2 con la figura " + eleccion);
            }
            case 'O' -> {
                System.out.println("El ordenador con la figura " + eleccion);
            }
            case 'e' -> {
                System.out.println("El empate");
            }

        }
    }

    public void jugada(int y){

        System.out.println("La ha puesto en la linea "+y);

    }


    /*
    Entradas: -
    Salidas: pintar en pantalla el tablero
    Precondiciones:
    Postcondiciones: tablero 3X3 en pantalla
*/

    public void pintarTablero(Tablero tablero) {


        for (int i = 0; i < tablero.getTablero().length; i++) {

            System.out.print("\t");
            for (int j = 0; j < tablero.getTablero()[0].length; j++) {
                System.out.print(tablero.getCasilla(i,j));
                if (j <tablero.getTablero()[0].length -1){// si no es la ultima linea, que pinte una raya divisoria
                    System.out.print("\t█\t");
                }
            }

            System.out.println();//salto de linea

            if (i <tablero.getTablero().length -1){

                for (int j = 0; j < tablero.getTablero()[0].length; j++) {
                    System.out.print("▀▀▀▀▀▀▀▀");//Linea horizontal
                }

                System.out.println();

            }


        }
    }



    public void escribirGanador(char turno, char eleccion){

        System.out.println("Ha ganado  ");
        escribirJugador(turno, eleccion);

    }


}

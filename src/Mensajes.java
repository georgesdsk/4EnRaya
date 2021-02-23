public class Mensajes {


    public Mensajes() {
    }

    public void tipoPartida() {

        System.out.println("Que tipo de partida desea, elige el numero? \n\t 1-Contra la maquina \n\t 2- Contra otro jugador");

    }

    public void elegirCaracter() {

        System.out.println("Con que pieza desea jugar, elige el numero? \n\t 1- cara \n\t 2- cruz X");

    }

    public static void numeroEntre(int min, int max) {

        System.out.println("Respuesta incorrecta elige " + min + " y " + max);

    }

    public static void caracterIncorrecto(char caracter1, char caracter2) {

        System.out.println("Respuesta incorrecta, elige " + caracter1 + " y " + caracter2);

    }

    /*
    Entradas: (char):
                    turno-> a quien le toca
                    eleccion-> la figura que a elegido

    Salidas: mensaje del jugador en la pantalla
    Precondiciones: -
    Postcondiciones: mensaje del jugador en la pantalla
*/


    public static void escribirJugador(char turno, char eleccion) {

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

    public static void escribirJugada(int x, int y) {

        System.out.println("La ha puesto en "+x+ ", " +y);
    }


    /*
    Entradas: -
    Salidas: tablero 3X3 en pantalla
    Precondiciones: que el tablero sea 3X3
    Postcondiciones: tablero 3X3 en pantalla
*/

    public void pintarTablero(Tablero tablero){

        System.out.println("\t|\t\t|");

        for (int i = 0; i < tablero.getTablero().length; i++) {
            System.out.println(tablero.getTablero()[i][0]+ "\t|\t" +tablero.getTablero()[i][1]+ "\t|\t" +tablero.getTablero()[i][2]);
            if (i<2){
                System.out.println("------------------");
            }
        }

        System.out.println("\t|\t\t|");

    }


    public static void ponerCaracterTablero() {

        System.out.println("Donde desea poner el caracter en tablero? ");

    }

    public void escribirGanador(char turno, char eleccion){

        System.out.println("Ha ganado  ");
        escribirJugador(turno, eleccion);

    }



}

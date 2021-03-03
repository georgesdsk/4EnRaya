import java.util.Random;
/*
Esta clase trata de gestionar el juego de 3 en raya.
 */

public class Partida {

    private Tablero tablero;
    private ValidacionesMensajes validaciones;
    private int contador = 1;
    private char eleccionj1 = 'X';
    private char eleccionj2 = 'O';
    private char eleccionOrdenador = 'O';
    private char turno;
    private boolean tipoPartida = false; // si es true es contra otro jugador
    private boolean ganada = false;


    public Partida() {

        this.tablero = new Tablero();
        this.validaciones = new ValidacionesMensajes();
    }

    public Partida(int x, int y){

        this.tablero = new Tablero(x,y);
        this.validaciones = new ValidacionesMensajes();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public char getEleccionj1() {
        return eleccionj1;
    }

    public char getEleccionj2() {
        return eleccionj2;
    }

    public char getEleccionOrdenador() {
        return eleccionOrdenador;
    }

    public char getTurno() {
        return turno;
    }

    /*
    Entradas: -
    Salidas: -
    Precondiciones: -
    Postcondiciones:    se inicia la variable tipoPartida que indicará si la partida es vsJ o vsO
     */

    public void setTipoPartida() {

        if (validaciones.elegirTipoPartida(1, 2) == 2) {
            tipoPartida = true;
        }

    }

/*
    Entradas: -
    Salidas: -
    Precondiciones: -
    Postcondiciones: se valida la eleccion de la figura, solo se hace para el jugador 1
*/


    public void elegirCaracter() {

        if (validaciones.elegirCaracter(1, 2) == 1) {
            eleccionj1 = 'O';

            if (tipoPartida) {
                eleccionj2 = 'X';
            } else {
                eleccionOrdenador = 'X';
            }
        }

    }


    /*
    Entradas: -
    Salidas: -
    Precondiciones: -
    Postcondiciones: se calcula el turno segun el contador, si es impar le toca al jugador1 y si no es u ordenador o jugador2
*/


    public void calcularTurno() {//quiero generalizar este metodo y que me ponga el caracter segun las jugadas llevadas, es decir el primero siempre será el jugador, el segundo o el ordenador o el j2 y asi sucesivamente


        if (this.contador % 2 != 0) { // Siempre va a empezar el jugador 1

           validaciones.escribirJugador('1', eleccionj1);
            turno = '1';

        } else {

            if (tipoPartida) {

                validaciones.escribirJugador('2' ,eleccionj2);
                turno = '2';
            } else {
                validaciones.escribirJugador('O', eleccionOrdenador);
                turno = 'O';
            }

        }
    }


    /*
    Entradas: -
    Salidas: -
    Precondiciones: -
    Postcondiciones: pone el caracter en funcion a quien le toque
*/



    public void ponerCaracter() {

        int y = 0;

        Random rd = new Random();

        do {

            if (turno =='1' || turno =='2'){//si le toca a un jugador


                y = validaciones.elegirLinea( tablero.getTablero()[0].length);

            }else {

                y = rd.nextInt(tablero.getTablero()[0].length);
            }

        }while(tablero.getCasilla(0, y) != '*');//mientras la ultima casilla del eje horizontal que se le pase este ocupada


        tablero.setFigura(y,getEleccion(turno));

        validaciones.jugada(y);        //escribe la jugada


        contador++;


    }



    /*
    Entradas:       char el jugador del que se quiera saber su eleccion(el caracter con el que pone)
    Salidas:        char la eleccion
    Precondiciones: jugador puede ser:
                                        0-> ordenador
                                        1-> jugador 1
                                        2-> jugador 2
    Postcondiciones:-
 */

    public char getEleccion(char jugador) {

        char eleccion = ' ';

        switch (jugador) {
            case 'O' -> eleccion = eleccionOrdenador;
            case '1' -> eleccion = eleccionj1;
            case '2' -> eleccion = eleccionj2;
        }

        return eleccion;
    }


    /*
    Entradas: -
    Salidas: char   n-> nada, sigue la partida
                    e-> empate, si se llega a 9 intentos (contador = 10)
                    O-> ordenador
                    1-> jugador1
                    2-> jugador2


    Precondiciones: la partida debe de estar empezada
    Postcondiciones: devolverá un caracter
*/


    public char comprobarGanador() {


        //linea horizontal

        if (!comprobarHorizontal() && !comprobarDiagonal()){

            turno = 'n';

        }




        return turno;
    }



    /*
    Entradas:-
    Salidas: boolean, si se ha ganado
    Precondiciones: partida empezada
    Postcondiciones:
     */


    private boolean comprobarHorizontal(){

        int acumulador = 0;
        char caracterAcumulado= ' ', caracterLeido ;


        for (int i = 0; i < tablero.getTablero().length && !ganada; i++) {

            acumulador = 0;
            caracterAcumulado= ' ';


            for (int j = 0; j < tablero.getTablero()[0].length && !ganada; j++) { //

                caracterLeido = tablero.getTablero()[i][j];


                if (caracterLeido == caracterAcumulado) {

                    ++acumulador;

                    if (acumulador > 2) {

                        ganada = true;

                    }

                } else {

                    acumulador = 0;

                    if (caracterLeido != '*') {

                        caracterAcumulado = caracterLeido;
                    }
                }
            }
        }

        return ganada;





    }


    /*
    Entradas:-
    Salidas: boolean, si se ha rellenado la diagonal inversa de 4 caracteres seguidos e iguales
    Precondiciones: partida empezada
    Postcondiciones: se comprobaran todas las diagonales
     */


    private boolean comprobarVertical(){

        int acumulador = 0;
        char caracterAcumulado= ' ', caracterLeido ;


        for (int i = 0; i < tablero.getTablero()[0].length && !ganada; i++) { // recorren las y

            acumulador = 0;
            caracterAcumulado= ' ';


            for (int j = 0; j < tablero.getTablero().length && !ganada; j++) { // recorre las x

                caracterLeido = tablero.getTablero()[j][i];


                if (caracterLeido == caracterAcumulado) {

                    ++acumulador;

                    if (acumulador > 2) {

                        ganada = true;

                    }

                } else {

                    acumulador = 0;

                    if (caracterLeido != '*') {

                        caracterAcumulado = caracterLeido;
                    }
                }
            }
        }

        return ganada;


    }



    /*Entradas: -
      Salidas: boolean, si la partida se ha ganado por diagonales
      Precondiciones: El tablero debe de estar inicializado y tiene que ser igual o mayor que 4x4
      Postcondiciones: Se comprobaran todas las diagonales si tienen una linea de 4 figuras iguales seguidas


     */



    public boolean comprobarDiagonal(){

        int acumulador = 0;
        char caracterLeido =' ';
        char caracterAcumulado = '-';
        boolean ganada = false;

        for (int i = 3; i <tablero.getTablero().length && !ganada ; i++) { //recorremos las x, empieza desde el 3 ya que no se puede pintar ninguna diagonal a partir de 3

            acumulador = 0;
            caracterAcumulado= ' ';


            for (int j = 0; j <tablero.getTablero()[0].length -3 && !ganada ; j++) {

               caracterLeido =  tablero.getCasilla(i-j,j);

                if ( caracterLeido == caracterAcumulado){

                    acumulador++;

                    if (acumulador > 2){

                        ganada = true;

                    }

                }else if(caracterLeido != '*'){

                    caracterAcumulado = caracterLeido;
                    acumulador = 0;

                }

            }

        }

    }




    /*
    Entradas: -
    Salidas: boolean si la partida se ha ganado o no
    Precondiciones:
    Poscondiciones:
     */

    private boolean comprobarLetra(){}




    }

import java.util.Random;
/*
Esta clase trata de gestionar el juego de 3 en raya.
 */

public class Gestora {

    private Tablero tablero;
    private Mensajes mensajes;
    private Validaciones validaciones;
    private int contador = 1;
    private char eleccionj1 = 'X';
    private char eleccionj2 = 'O';
    private char eleccionOrdenador = 'O';
    private char turno;
    private boolean tipoPartida = false; // si es true es contra otro jugador
    private boolean ganada = false;


    public Gestora() {

        this.tablero = new Tablero();
        this.mensajes = new Mensajes();
        this.validaciones = new Validaciones();
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

        mensajes.tipoPartida();

        if (validaciones.numeroEntre(1, 2) == 2) {
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

        mensajes.elegirCaracter();

        if (validaciones.numeroEntre(1, 2) == 1) {
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

            Mensajes.escribirJugador('1', eleccionj1);
            turno = '1';

        } else {

            if (tipoPartida) {

                Mensajes.escribirJugador('2' ,eleccionj2);
                turno = '2';
            } else {
                Mensajes.escribirJugador('O', eleccionOrdenador);
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

        int x = 0, y = 0;

        Random rd = new Random();


        do {//mientras la casilla elegida no este libre

            if (turno != 'O') {

                mensajes.ponerCaracterTablero();
                x = validaciones.numeroEntre(0, 2);
                y = validaciones.numeroEntre(0, 2);

            } else {

                x = rd.nextInt(2);
                y = rd.nextInt(2);

            }


        } while (tablero.getCasilla(x, y) != '*'); // ya que tengo esta condicion, la aprovecho para implementar la eleccion aleatoria del ordenador

        tablero.setCasilla(x, y, getEleccion(turno));

        Mensajes.escribirJugada(x,y);

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


        for (int i = 0; i < 2 && !ganada; i++) {

            //Verticales

            if (!ganada && (tablero.getCasilla(0, i) != '*') && tablero.getCasilla(0, i) == tablero.getCasilla(1, i) && tablero.getCasilla(0, i) == tablero.getCasilla(2, i)) {

                ganada = true;

            }

            //Horizontales

            if (!ganada && (tablero.getCasilla(i, 0) != '*') && tablero.getCasilla(i, 0) == tablero.getCasilla(i, 1) && tablero.getCasilla(i, 1) == tablero.getCasilla(i, 2)) {

                ganada = true;

            }
            //Diagonal1

            if (!ganada && (tablero.getCasilla(0, 0) != '*') && tablero.getCasilla(1, 1) == tablero.getCasilla(0, 0) && tablero.getCasilla(1, 1) == tablero.getCasilla(2, 2)) {

                ganada = true;

            }

            //Diagonal2

            if (!ganada && (tablero.getCasilla(2, 0) != '*') && tablero.getCasilla(1, 1) == tablero.getCasilla(2, 0) && tablero.getCasilla(1, 1) == tablero.getCasilla(0, 2)) {

                ganada = true;

            }


        }

            //Empate
            if (contador> 10){//ya que el contador empieza por 1, debe acabar en 10, que serán 9 movimientos
                turno ='e';
                ganada = true;
            }

            //Si alguien gana o es empatada, que envie un mensaje

            if (ganada) {
                mensajes.escribirGanador(turno, getEleccion(turno));
            }else{
                turno ='n'; //si no se sigue
            }

            return turno; // el ganador

    }




    }

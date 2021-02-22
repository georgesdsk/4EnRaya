import java.util.Random;

public class Gestora {

    private Tablero tablero = new Tablero();
    private Mensajes mensajes = new Mensajes();
    private Validaciones validaciones = new Validaciones();
    private int contador = 1;
    private char eleccionj1 = 'X';
    private char eleccionj2 = 'O';
    private char eleccionOrdenador = 'O';
    private char turno;
    private boolean tipoPartida = false; // si es true es contra otro jugador
    private boolean ganada = false;


    public Gestora() {
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

    public char getEleccion(char jugador) {

        char eleccion = ' ';

        switch (jugador) {
            case 'O' -> eleccion = eleccionOrdenador;
            case '1' -> eleccion = eleccionj1;
            case '2' -> eleccion = eleccionj2;
        }

        return eleccion;
    }


    public void setTipoPartida() {

        mensajes.tipoPartida();

        if (validaciones.numeroEntre(1, 2) == 2) {
            tipoPartida = true;
        }

    }

    public void elegirCaracter() {

        mensajes.elegirCaracter();

        if (validaciones.numeroEntre(1, 2) == 1) {
            eleccionj1 = 'O';
        }
        if (tipoPartida) {
            eleccionj2 = 'X';
        } else {
            eleccionOrdenador = 'X';
        }
    }

    public char calcularTurno() {//quiero generalizar este metodo y que me ponga el caracter segun las jugadas llevadas, es decir el primero siempre será el jugador, el segundo o el ordenador o el j2 y asi sucesivamente


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

        return turno;

    }


    //Pintar el tablero


    public void ponerCaracter(char jugador) {

        int x = 0, y = 0;

        Random rd = new Random();


        do {//mientras la casilla elegida no este libre

            if (jugador != 'O') {

                mensajes.ponerCaracterTablero();
                x = validaciones.numeroEntre(0, 3);
                y = validaciones.numeroEntre(0, 3);

            } else {

                x = rd.nextInt(3);
                y = rd.nextInt(3);

            }


        } while (tablero.getCasilla(x, y) != '*'); // ya que tengo esta condicion, la aprovecho para implementar la eleccion aleatoria del ordenador

        tablero.setCasilla(x, y, getEleccion(jugador));

        contador++;

    }


    public char comprobarGanador() {


        for (int i = 0; i < 3 && !ganada; i++) {

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

            if (!ganada && (tablero.getCasilla(3, 0) != '*') && tablero.getCasilla(1, 1) == tablero.getCasilla(0, 0) && tablero.getCasilla(1, 1) == tablero.getCasilla(2, 2)) {

                ganada = true;

            }


        }

        if (!ganada && contador == 8 ){

            turno = 'f';

        }

            return turno; // el ganador

    }


    }

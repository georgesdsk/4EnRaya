/*
Esta clase trata de tablero, crea el array que se desee donde guardadará los caracteres puestos por los jugadores
 */


public class Tablero {

    private char[][] tablero;



    public Tablero() {

        this.tablero = new char[6][7];
        rellenarTablero();
    }

    public Tablero(int x, int y){

        this.tablero = new char[x][y];
        rellenarTablero();
    }

    /*
    Entradas: -
    Salidas: -
    Precondiciones: -
    Postcondiciones: rellena el tablero entero de *
    */


    public void rellenarTablero() {

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {

                tablero[i][j] = '*';
            }
        }
    }


        public char[][] getTablero () {

            return this.tablero;
        }


        public char getCasilla ( int x, int y){

            char casilla = '*';

            try {

                casilla = tablero[x][y];

            } catch (ArrayIndexOutOfBoundsException e) {

                e.printStackTrace();

            }
            return casilla;
        }
 /*
    Entradas: int y (columna), char figura(con lo que se va a rellenar)
    Salidas: -
    Precondiciones: -
    Postcondiciones: y no se puede salir del array
*/


    public void setFigura (int y, char figura){

        boolean fin = false;

        for (int i = tablero.length -1 ; i > -1 && !fin; i--) { // Ya que el length devuelve el tamano total sin contar el cero, siempre sera 1+ que las posiciones del array

            if (tablero[i][y]== '*' ){ // si la casilla esta libre

                tablero[i][y] = figura;
                fin = true;

            }
        }
    }




    }


public class Tablero {

    private char[][] tablero = new char[3][3];

    public Tablero() {

        for (int i = 0; i < tablero.length; i++) {

            for (int j = 0; j < tablero[i].length; j++) {

                tablero[i][j] = '*';

            }

        }

    }


    public char[][] getTablero(){

        return tablero;
    }

    public char getCasilla(int x, int y){

        char casilla = '*';

        try{

            casilla = tablero[x][y];

        }catch(ArrayIndexOutOfBoundsException e){

            e.printStackTrace();

        }
        return casilla;
    }


    public void setCasilla(int x, int y, char caracter){

        try {

            tablero[x][y] = caracter;


        }catch(ArrayIndexOutOfBoundsException e){

            e.printStackTrace();
        }

    }



}

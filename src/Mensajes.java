public class Mensajes {


    public Mensajes() {
    }

    public void tipoPartida(){

        System.out.println("Que tipo de partida desea? 1-Contra la maquina 2- Contra otro jugador");

    }

    public void elegirCaracter(){

        System.out.println("Con que pieza desea jugar? 1- cara 0 2- cruz X");

    }

    public static void numeroEntre(int min, int max){

        System.out.println("Respuesta incorrecta elige " +min+ " y " +max );

    }

    public static void caracterIncorrecto(char caracter1, char caracter2){

        System.out.println("Respuesta incorrecta, elige " +caracter1+ " y " +caracter2 );

    }

    public static void escribirJugador(char turno, char eleccion){

        switch(turno){

            case '1'-> {System.out.println("El jugador 1 con la "+eleccion);}
            case '2'-> {System.out.println("El jugador2 con la "+eleccion);}
            case 'O'-> {System.out.println("El ordenador con la " +eleccion);}
            case 'f' -> {
                System.out.println("El empate");
            }

        }
    }

    public static void ponerCaracterTablero(){

        System.out.println("Donde desea poner el caracter en tablero? ");

}

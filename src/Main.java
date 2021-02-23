public class Main {

    public static void main(String[] args) {

        Gestora gestora = new Gestora();
        Mensajes mensajes = new Mensajes();
        Tablero tablero =  new Tablero();
        char turno, ganador;

        gestora.setTipoPartida();
        gestora.elegirCaracter();
        mensajes.pintarTablero(gestora.getTablero());
        do {
            gestora.calcularTurno();
            gestora.ponerCaracter();
            mensajes.pintarTablero(gestora.getTablero());
        }while (gestora.comprobarGanador()== 'n' );



    }


}



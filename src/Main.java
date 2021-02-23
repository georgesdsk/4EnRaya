public class Main {

    public static void main(String[] args) {

        Partida partida = new Partida();
        Mensajes mensajes = new Mensajes();
        Tablero tablero =  new Tablero();
        ValidacionesMensajes validaciones = new ValidacionesMensajes();
        char turno, ganador;

        partida.setTipoPartida();
        partida.elegirCaracter();
        validaciones.pintarTablero(partida.getTablero());
        do {
            partida.calcularTurno();
            partida.ponerCaracter();

        }while (partida.comprobarGanador()== 'n' );



    }


}



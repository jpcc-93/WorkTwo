import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        String menu = "  *** MENU ***\n" +
                "1. Mostrar juegos\n" +
                "2. Agregar juego\n" +
                "3. Eliminar juego\n" +
                "4. Editar juego\n" +
                "5. 10 Juegos mas largos\n" +
                "6. ver informacion de un juego\n" +
                "0. Salir";
        ListaJuegos lista = new ListaJuegos();
        lista.llenarTiendaN();

        do {
            switch (opcion){
                case 1:

                    lista.mostrarJtiendaN();
                    break;
                case 2:
                    lista.agregarJuegoN();
                    lista.llenarTiendaN();
                    break;
                case 3:
                    lista.borrarJuegoN();
                    break;
                case 4:
                    lista.editarJuegoN();
                    break;
                case 5:
                    break;
                case 6:
                    lista.mostrarInfoJuegoN();
                    break;

                case 0:
                    break;
            }


            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        }while (opcion != 0);



//        lista.llenarTienda();
//        lista.agregarJuego();
        //lista.borrarJuego();

    }


}
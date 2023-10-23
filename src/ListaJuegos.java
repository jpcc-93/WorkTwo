import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListaJuegos {

    int sizeL;

    public void agregarJuego() {
        VideoJuego[] videojuegos = new VideoJuego[sizeL + 1];

        FileWriter escritor = null;

        try {
            // Abre el archivo
            escritor = new FileWriter("src/datos.txt", true);

            // Escribe los datos en el archivo
            VideoJuego videojuego = new VideoJuego();
            videojuego.setTitulo(JOptionPane.showInputDialog("Ingrese el nombre del juego"));
            videojuego.setHorasEstimadas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas")));
            videojuego.setGenero(JOptionPane.showInputDialog("Ingrese el genero del juego"));
            videojuego.setCompania(JOptionPane.showInputDialog("Ingrese la compañia del juego"));
            escritor.write("\n" + videojuego.getTitulo() + "," +
                    videojuego.getHorasEstimadas() + "," + videojuego.getGenero() +
                    "," + videojuego.getCompania());


//            // Escribe un nuevo videojuego
//            escritor.append(videojuego.getTitulo()+","+videojuego.getHorasEstimadas()+
//                    ","+videojuego.getGenero()+","+videojuego.getCompania());

            // Cierra el archivo
            escritor.close();
        } catch (IOException e) {
            System.err.println("error al escribir datos");
        }


    }

    public void borrarJuego(){
        VideoJuego[] videoJuego = llenarvec();
        String datos = "";
        int datoEliminar;
        for(int i = 0; i < videoJuego.length-1; i++){
            datos += (i+1) + " " + videoJuego[i].getTitulo() + "\n";
        }
        datoEliminar = Integer.parseInt(JOptionPane.showInputDialog(null,"ELIGE EL DATO A ELIMINAR:\n"+datos));
        for(int i = 0; i < videoJuego.length-1; i++){
            if((datoEliminar -1) == i){
                for (int j = i; j < videoJuego.length-2; j++) {
                    videoJuego[j] = videoJuego [j +1];
                }
                sizeL = sizeL -1;

            }

        }
        datos = "";
        for(int i = 0; i < videoJuego.length-2; i++){
            datos += (i+1) + " " + videoJuego[i].getTitulo() + "\n";
        }
        JOptionPane.showMessageDialog(null,"ELIGE EL DATO A ELIMINAR:\n"+datos);




    }


    public void llenarTienda() {
        validarTmano();
        System.out.println(sizeL);
        VideoJuego[] videojuegos = new VideoJuego[sizeL];

        // Crea un lector de archivos
        BufferedReader lector = null;

        try {
            lector = new BufferedReader(new FileReader("src/datos.txt"));


            // Lee los datos del archivo
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    videojuegos[i] = new VideoJuego(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);

                    i++;
                }
            }

            // Cierra el lector de archivos
            lector.close();
        } catch (IOException e) {
            System.err.println("error al cargar datos");
        }

        for (int i = 0; i < sizeL-1; i++) {
            System.out.println(videojuegos[i].getTitulo());

        }
    }

    public void validarTmano() {
        BufferedReader lector = null;
        sizeL = 0;
            try {
                lector = new BufferedReader(new FileReader("src/datos.txt"));
                int i = 0;

                while ((lector.readLine()) != null){
                    sizeL += 1;
                    i++;

                }


                lector.close();
        } catch (IOException e) {
            System.err.println("error al cargar datos");
        }
    }

    public VideoJuego[] llenarvec(){
        validarTmano();
        System.out.println(sizeL);
        VideoJuego[] videojuegos = new VideoJuego[sizeL];

        // Crea un lector de archivos
        BufferedReader lector = null;

        try {
            lector = new BufferedReader(new FileReader("src/datos.txt"));


            // Lee los datos del archivo
            String linea;
            int i = 0;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    videojuegos[i] = new VideoJuego(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);

                    i++;
                }
            }

            // Cierra el lector de archivos
            lector.close();
        } catch (IOException e) {
            System.err.println("error al cargar datos");
        }
        return videojuegos;
    }

}

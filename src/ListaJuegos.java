import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListaJuegos {

    int sizeL;

    private VideoJuego cabeza;

    ListaJuegos(){
        cabeza = null;
    }

    public VideoJuego getCabeza() {
        return cabeza;
    }

    public void setCabeza(VideoJuego cabeza) {
        this.cabeza = cabeza;
    }

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

    public void agregarJuegoarchivoN(String titulo,int horas,String genero,String compania) {
        FileWriter escritor = null;
        try {
            // Abre el archivo
            escritor = new FileWriter("src/datos.txt", true);

            // Escribe los datos en el archivo
            VideoJuego videojuego = new VideoJuego();
            videojuego.setTitulo(titulo);
            videojuego.setHorasEstimadas(horas);
            videojuego.setGenero(genero);
            videojuego.setCompania(compania);
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
    public void agregarJuegoN() {

        VideoJuego videojuego = new VideoJuego();
        videojuego.setTitulo(JOptionPane.showInputDialog("Ingrese el nombre del juego"));
        videojuego.setHorasEstimadas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas")));
        videojuego.setGenero(JOptionPane.showInputDialog("Ingrese el genero del juego"));
        videojuego.setCompania(JOptionPane.showInputDialog("Ingrese la compañia del juego"));
        agregarJuegoarchivoN(videojuego.getTitulo(),videojuego.getHorasEstimadas(),videojuego.getGenero(),videojuego.getCompania());
        VideoJuego aux = cabeza;
        while (aux != null){
            if(aux.getLiga() == null){
                aux.setLiga(videojuego);
                break;
            }
            aux = aux.getLiga();
        }
    }
    public void borrarJuegoN(){
        int opcion;

        do {
            VideoJuego aux = cabeza,anterior = aux;
            int i = 0;
            opcion = mostrarJtiendainputN() - 1;
            if (cabeza.getLiga() != null) {
                while (aux != null) {
                    if (opcion == i) {
                        if (opcion == 0) {
                            cabeza = cabeza.getLiga();
                        } else {
                            anterior.setLiga(aux.getLiga());
                        }

                    }
                    anterior = aux;
                    aux = aux.getLiga();
                    i++;
                }
            }
        }while (opcion+1 != 0);

    }
    public void mostrarInfoJuegoN(){
        int opcion;
        do {

            String mensaje = "";
            int i = 0;

            VideoJuego aux = cabeza;
            opcion = mostrarJtiendainputN() - 1;
            if (cabeza.getLiga() != null) {
                while (aux != null) {
                    if (opcion == i) {
                        mensaje += "\nNombre: " + aux.getTitulo() + "\nHoras: " + aux.getHorasEstimadas()
                                + "\nGenero: " + aux.getGenero() + "\nCompañia: " + aux.getCompania()+
                        "\nDisponible: "+aux.isDisponible();
                        break;
                    }

                    aux = aux.getLiga();
                    i++;
                }
                if(opcion != -1)JOptionPane.showMessageDialog(null, mensaje);
            }

        }while (opcion+1 != 0);


    }

    public void editarJuegoN(){int opcion;
        do {

            int i = 0;

            VideoJuego aux = cabeza;
            opcion = mostrarJtiendainputN() - 1;
            if (cabeza.getLiga() != null) {
                while (aux != null) {
                    if (opcion == i) {
                        int opcion2 = 0;
                        String mensaje = "Informacion a editar: \n" +
                                "1. Titulo = "+aux.getTitulo()+"\n" +
                                "2. Duracion del juego = "+ aux.getHorasEstimadas() +"\n" +
                                "3. Genero = " + aux.getGenero()+"\n" +
                                "4. Compañia = "+aux.getCompania()+"\n" +
                                "5. Disponible = "+aux.isDisponible()+"\n" +
                                "0. Salir";
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,mensaje));
                        switch (opcion2){
                            case 1:
                                aux.setTitulo(JOptionPane.showInputDialog("Ingrese el nombre del juego"));
                                break;
                            case 2:
                                aux.setHorasEstimadas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas")));
                                break;
                            case 3:
                                aux.setGenero(JOptionPane.showInputDialog("Ingrese el genero del juego"));
                                break;
                            case 4:
                                aux.setCompania(JOptionPane.showInputDialog("Ingrese la compañia del juego"));
                                break;
                            case 5:
                                aux.devolver();
                                break;
                            case 0:
                                break;
                        }

                        break;
                    }

                    aux = aux.getLiga();
                    i++;
                }
                //if(opcion != -1)JOptionPane.showMessageDialog(null, mensaje);
            }

        }while (opcion+1 != 0);

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

    public void llenarTiendaN() {
        VideoJuego anterior = new VideoJuego(),videojuego;
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
                    videojuego = new VideoJuego(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3]);
                    if (i == 0){
                        cabeza = videojuego;
                    }else{
                        anterior.setLiga(videojuego);
                    }
                    anterior = videojuego;
                }
                i++;
            }
            // Cierra el lector de archivos
            lector.close();
        } catch (IOException e) {
            System.err.println("error al cargar datos");
        }

    }

    public void mostrarJtiendaN(){
        VideoJuego aux = cabeza;
        String datos = "";
        int i = 0;
        while (aux != null){
            datos += (i+1) + " " + aux.getTitulo() + "\n";
            i++;
            aux = aux.getLiga();
        }
        JOptionPane.showMessageDialog(null,datos);
    }
    public int mostrarJtiendainputN(){
        int opcion = 0;
        VideoJuego aux = cabeza;
        String datos = "";
        int i = 0;
        while (aux != null){
            datos += (i+1) + " " + aux.getTitulo() + "\n";
            i++;
            aux = aux.getLiga();
        }
        datos += "\n0. SALIR";
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,datos));
        return opcion;
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

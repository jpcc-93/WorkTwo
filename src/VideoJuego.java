public class VideoJuego {
    private String titulo;
    private int horasEstimadas;
    private boolean disponible;
    private String genero, compania;
    private VideoJuego liga;



    public VideoJuego() {
        liga = null;
        this.titulo = "";
        this.horasEstimadas = 10;
        this.disponible = false;
        this.genero = "";
        this.compania = "";
    }



    public VideoJuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.disponible = false;
        this.genero = "";
        this.compania = "";
    }

    public VideoJuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.disponible = false;
        this.genero = genero;
        this.compania = compania;
    }

    public VideoJuego getLiga() {
        return liga;
    }

    public void setLiga(VideoJuego liga) {
        this.liga = liga;
    }

    public void entregar() {
        disponible = false;
    }

    public void devolver(){
        disponible = true;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String isDisponible() {
        String disponible = "";
        if(this.disponible == true){
            disponible = "Disponible";
        }else {
            disponible = "No Disponible";
        }
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;

    }


}

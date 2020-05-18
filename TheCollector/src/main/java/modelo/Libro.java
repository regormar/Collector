package modelo;


public class Libro extends Miscelanea {
    
    private String autor;
    private String numPaginas;
    private int estado;
    private int paginaActual;

    public Libro(String autor, String numPaginas, int estado, String nombre, int genero) {
        super(nombre, genero);
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.estado = estado;
    }   
    
    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    
}

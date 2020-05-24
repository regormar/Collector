package modelo;


public class Libro extends Miscelanea {
    
    private String autor;
    private int numPaginas;
    private int paginaActual;

    public Libro(String autor, int numPaginas, String nombre, int genero) {
        super(nombre, genero);
        this.autor = autor;
        this.numPaginas = numPaginas;
    }   

    public Libro() {
    }
    
    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }
   
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    
}

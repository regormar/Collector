package modelo;


public abstract class Miscelanea {
    
    private int id;
    private String nombre;   
    private int genero;
    private int valoracion;
    
    public Miscelanea(String nombre, int genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public Miscelanea(){       
    }
    
    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

package modelo;


public class Pelicula extends Miscelanea{
    
    private String direccion;
    private int duracion;   
    private int minuto;
    private int valoracion;

    public Pelicula(){    
    }
    
    public Pelicula(String direccion, int duracion, String nombre, int genero) {
        super(nombre, genero);
        this.direccion = direccion;
        this.duracion = duracion;
    }   
    
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

}

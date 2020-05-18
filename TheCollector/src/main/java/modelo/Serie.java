package modelo;


public class Serie extends Miscelanea {
    
    private String direccion;
    private int numTemporadas;
    private String numCapitulos; 

    public Serie(String direccion, int numTemporadas, String numCapitulos, String nombre, int genero) {
        super(nombre, genero);
        this.direccion = direccion;
        this.numTemporadas = numTemporadas;
        this.numCapitulos = numCapitulos;
    }
    
    public String getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(String numCapitulos) {
        this.numCapitulos = numCapitulos;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}

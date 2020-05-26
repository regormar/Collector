package modelo;


public class Serie extends Miscelanea {
    
    private String direccion;
    private int numTemporadas;
    private int numCapitulos; 
    private int duracionCapitulo;  
    private int minuto;
    private int temporada;
    private int capitulo;

    public Serie(){    
    }
    
    public Serie(String direccion, int numTemporadas, int numCapitulos, int duracionCapitulo, String nombre, int genero) {
        super(nombre, genero);
        this.direccion = direccion;
        this.numTemporadas = numTemporadas;
        this.numCapitulos = numCapitulos;
        this.duracionCapitulo = duracionCapitulo;
    }
        
    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    
    public int getDuracionCapitulo() {
        return duracionCapitulo;
    }

    public void setDuracionCapitulo(int duracionCapitulo) {
        this.duracionCapitulo = duracionCapitulo;
    }
    
    public int getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(int numCapitulos) {
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

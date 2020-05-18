package modelo;


public class Juego extends Miscelanea {
    
    private String desarrolladora;

    public Juego(String desarrolladora, String nombre, int genero) {
        super(nombre, genero);
        this.desarrolladora = desarrolladora;
    } 
    
    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

}

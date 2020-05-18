package manager;

import modelo.Usuario;


public class Controlador {
    
    private static Controlador instance;
    public static Usuario currentUser;
    
    public static Controlador getInstace() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }
    
    
}

package vista;

import manager.Controlador;


public class Inicio {
    
    private static Controlador manager;
    
    public static void main(String[] args) {  
        manager = Controlador.getInstace();
        manager.conectarBBDD();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
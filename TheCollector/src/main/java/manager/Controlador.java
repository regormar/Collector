package manager;

import excepciones.Excepcion;
import java.sql.SQLException;
import modelo.Usuario;
import persistencia.CollectorDao;


public class Controlador {
    
    private static Controlador instance;
    public static Usuario currentUser;
    public static CollectorDao collectorDao;
        
    public void conectarBBDD(){
        collectorDao = CollectorDao.getInstace();
        try {
            collectorDao.conectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Controlador getInstace() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }
    
    public void validarUsuario(String u, String p) throws SQLException, Excepcion{
        if(collectorDao.checkLogin(u, p)){
            currentUser = collectorDao.getUser(u);
        }
    }
    
    public void validarRegistro(Usuario usu, String pass2) throws Excepcion, SQLException{
        if(usu.getUsername().equals("") || usu.getNombre().equals("") || usu.getApellidos().equals("") || usu.getPass().equals("") || pass2.equals("") || usu.getEmail().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(!usu.getPass().equals(pass2)){
            throw new Excepcion(Excepcion.ERROR_DIFFERENT_PASSWORDS);
        }
        if(collectorDao.existeUsuario(usu.getUsername())){
            throw new Excepcion(Excepcion.ERROR_USERNAME_NOT_AVAILABLE);
        }
        collectorDao.insertarUsuario(usu);
    }
}

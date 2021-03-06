package manager;

import excepciones.Excepcion;
import excepciones.Succestion;
import java.sql.SQLException;
import modelo.Juego;
import modelo.Libro;
import modelo.Pelicula;
import modelo.Serie;
import modelo.Usuario;
import persistencia.CollectorDao;


public class Controlador {
    
    private static Controlador instance;
    public static Usuario currentUser;
        
    public static void conectarBBDD(){
        try {
            CollectorDao.conectar();
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
    
    public static boolean validarUsuario(String u, String p) throws SQLException, Excepcion{
        boolean validado = false;
        if(!CollectorDao.checkLogin(u, p)){
            throw new Excepcion(Excepcion.ERROR_LOGIN_INCORRECTO); 
        }
        if(CollectorDao.checkLogin(u, p)){
            currentUser = CollectorDao.getUser(u);
            validado = true;
        } else{
            
        }
        return validado;
    }
    
    //Funcion para validar el registro de un usuario.
    public static void validarRegistro(Usuario usu, String pass2) throws Excepcion, SQLException, Succestion{
        if(usu.getUsername().equals("") || usu.getNombre().equals("") || usu.getApellidos().equals("") || usu.getPass().equals("") || pass2.equals("") || usu.getEmail().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(!usu.getPass().equals(pass2)){
            throw new Excepcion(Excepcion.ERROR_DIFFERENT_PASSWORDS);
        }
        if(CollectorDao.checkUsername(usu)){
            throw new Excepcion(Excepcion.ERROR_USERNAME_NOT_AVAILABLE);
        }
        CollectorDao.insertarUsuario(usu);
        throw new Succestion(Succestion.USER_REGISTERED); 
    }
    
    //Funcion para validar si los datos a modificar son correctos.
    public static void validarUsuario(Usuario usu, String pass2, String oldName) throws Excepcion, SQLException, Succestion{
        if(usu.getUsername().equals("") || usu.getNombre().equals("") || usu.getApellidos().equals("") || usu.getPass().equals("") || pass2.equals("") || usu.getEmail().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(!usu.getPass().equals(pass2)){
            throw new Excepcion(Excepcion.ERROR_DIFFERENT_PASSWORDS);
        }
        if(!oldName.equals(usu.getUsername())){
            if(CollectorDao.checkUsername(usu)){
                throw new Excepcion(Excepcion.ERROR_USERNAME_NOT_AVAILABLE);
            }
        }
        CollectorDao.modificarUsuario(usu, oldName);
        if(currentUser.getUsername().equals(oldName)){
            currentUser = usu;
        }
        throw new Succestion(Succestion.USER_EDITED); 
    }
    
    //Funcion para validar el registro de una serie.
    public static void validarSerie(Serie s) throws Excepcion, SQLException, Succestion {
        if(s.getDireccion().equals("") || s.getNombre().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(CollectorDao.checkSerie(s)){
            throw new Excepcion(Excepcion.ERROR_SERIE_EXIST);
        }
        CollectorDao.insertarSerie(s);
        throw new Succestion(Succestion.SERIE_REGISTERED); 
    }
    
    //Funcion para validar el registro de una pelicula.
    public static void validarPelicula(Pelicula p) throws Excepcion, SQLException, Succestion {
        if(p.getDireccion().equals("") || p.getNombre().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(CollectorDao.checkPelicula(p)){
            throw new Excepcion(Excepcion.ERROR_MOVIE_EXIST);
        }
        CollectorDao.insertarPelicula(p);
        throw new Succestion(Succestion.MOVIE_REGISTERED); 
    }
    
    //Funcion para validar el registro de un libro.
    public static void validarLibro(Libro l) throws Excepcion, SQLException, Succestion{
        if(l.getAutor().equals("") || l.getNombre().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(CollectorDao.checkLibro(l)){
            throw new Excepcion(Excepcion.ERROR_BOOK_EXIST);
        }
        CollectorDao.insertarLibro(l);
        throw new Succestion(Succestion.BOOK_REGISTERED);
    }
    
    //Funcion para validar el registro de un juego.
    public static void validarJuego(Juego j) throws Excepcion, SQLException, Succestion{
        if(j.getDesarrolladora().equals("") || j.getNombre().equals("")){
            throw new Excepcion(Excepcion.ERROR_EMPTY_FIELDS);
        }
        if(CollectorDao.checkJuego(j)){
            throw new Excepcion(Excepcion.ERROR_GAME_EXIST);
        }
        CollectorDao.insertarJuego(j);
        throw new Succestion(Succestion.GAME_REGISTERED);
    }
}

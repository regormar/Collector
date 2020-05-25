package excepciones;

import java.util.Arrays;
import java.util.List;


public class Excepcion extends Exception {

    public static final int ERROR_EXIST_USER_NAME = 0;
    public static final int ERROR_USER_NOT_FOUND = 1;
    public static final int ERROR_EMPTY_FIELDS = 2;
    public static final int ERROR_DIFFERENT_PASSWORDS = 3;
    public static final int ERROR_USERNAME_NOT_AVAILABLE = 4;
    public static final int ERROR_LOGIN_INCORRECTO = 5;
    public static final int ERROR_MOVIE_EXIST = 6;
    public static final int GENERO_INVALIDO = 7;
    public static final int PELICULA_INVALIDA = 8;
    public static final int ERROR_BOOK_EXIST = 9;
    public static final int ERROR_UNSELECTED_GENRE = 10;
    public static final int BOOK_INVALIDO = 11;
    public static final int INVALID_PAGE_NUMBER = 12;
    public static final int INVALID_MINUTE_NUMBER = 13;
    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "Ya existe un usuario con ese nombre",
        "Nombre de usuario incorrecto",
        "Campos vacíos",
        "Las contraseñas no coinciden",
        "El nombre de usuario no esta disponible",
        "Login incorrecto",
        "Esta película ya existe",          
        "Seleccion invalida: Seleccione un género válido",          
        "Seleccion invalida: Seleccione una película válida",
        "Este libro ya existe",
        "Selecciona un género",
        "Seleccion invalida: Seleccione un libro válido",
        "El número de página no puede ser superior al total",
        "El minuto de película no puede ser superior al de la duración total"
    );

    public Excepcion(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }

}
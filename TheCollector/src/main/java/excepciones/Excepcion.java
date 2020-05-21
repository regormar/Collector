package excepciones;

import java.util.Arrays;
import java.util.List;


public class Excepcion extends Exception {

    public static final int ERROR_EXIST_USER_NAME = 0;
    public static final int ERROR_USER_NOT_FOUND = 1;
    public static final int ERROR_EMPTY_FIELDS = 2;
    public static final int ERROR_DIFFERENT_PASSWORDS= 3;
    public static final int ERROR_USERNAME_NOT_AVAILABLE= 4;
    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "Ya existe un usuario con ese nombre",
        "Nombre de usuario incorrecto",
        "Campos vacíos",
        "Las contraseñas no coinciden.",
        "El nombre de usuario no esta disponible."
    );

    public Excepcion(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }

}
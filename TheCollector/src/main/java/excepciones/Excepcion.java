package excepciones;

import java.util.Arrays;
import java.util.List;


public class Excepcion extends Exception {

    public static final int EXIST_USER_NAME = 0;

    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "Ya existe un usuario con ese nombre"
    );

    public Excepcion(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }

}
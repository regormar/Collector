package excepciones;

import java.util.Arrays;
import java.util.List;

public class AlertException extends Exception{
        public static final int BOOKS_NOT_FOUND = 0;
        public static final int NO_EXISTEN_GENEROS = 1;

    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "No hay libros registrados",
        "No existen generos"
    );

    public AlertException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}

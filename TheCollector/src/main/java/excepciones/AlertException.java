package excepciones;

import java.util.Arrays;
import java.util.List;

public class AlertException extends Exception{
        public static final int NO_EXISTEN_GENEROS = 0;
        public static final int NO_EXISTEN_PELICULAS = 1;
        public static final int NO_TIENE_PELICULAS = 2;
        public static final int NO_EXISTEN_LIBROS = 3;
        public static final int NO_EXISTEN_MAS_LIBROS = 4;
        public static final int NO_EXISTEN_MAS_PELICULAS = 5;
        public static final int NO_TIENE_LIBROS = 6;

    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "No existen géneros",
        "No existen películas",
        "No tienes películas añadidas",
        "No existen libros",
        "No existen más libros para añadir",
        "No existen más películas para añadir",
        "No tienes libros añadidos"
    );

    public AlertException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}

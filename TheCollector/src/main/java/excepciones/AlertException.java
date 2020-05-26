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
        public static final int NO_EXISTEN_MAS_JUEGOS = 7;
        public static final int NO_EXISTEN_JUEGOS = 8;
        public static final int NO_TIENE_JUEGOS = 9;
        public static final int NO_EXISTEN_SERIES = 10;
        public static final int NO_EXISTEN_MAS_SERIES= 11;
        public static final int NO_TIENE_SERIES = 12;
        public static final int UNICO_USUARIO = 13;

    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "No existen géneros",
        "No existen películas",
        "No tienes películas añadidas",
        "No existen libros",
        "No existen más libros para añadir",
        "No existen más películas para añadir",
        "No tienes libros añadidos",
        "No existen más videojuegos para añadir",
        "No existen Videojuegos",
        "No tienes videojuegos añadidos",
        "No existen series",
        "No existen más series para añadir",
        "No tienes series añadidas",
        "Eres el único usuario"
    );

    public AlertException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}

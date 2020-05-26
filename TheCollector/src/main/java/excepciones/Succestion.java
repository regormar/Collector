package excepciones;

import java.util.Arrays;
import java.util.List;


public class Succestion extends Exception{
    
    public static final int BOOK_REGISTERED = 0;
    public static final int USER_REGISTERED = 1;
    public static final int MOVIE_REGISTERED = 2;
    public static final int MOVIE_ADDED = 3;
    public static final int MOVIE_REMOVED = 4;
    public static final int BOOK_ADDED = 5;
    public static final int MOVIE_EDITED = 6;
    public static final int BOOK_REMOVED = 7;
    public static final int BOOK_EDITED = 8;
    public static final int GAME_REGISTERED = 9;
    public static final int GAME_EDITED = 10;
    public static final int GAME_ADDED = 11;
    public static final int GAME_REMOVED = 12;
    public static final int USER_EDITED = 13;
    public static final int SERIE_REGISTERED = 14;
    public static final int SERIE_ADDED = 15;
    public static final int SERIE_EDITED = 16;
    public static final int SERIE_REMOVED = 17;
    public static final int USER_REMOVED = 18;
    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "¡Libro registrado con éxito!",
        "¡Usuario registrado con éxito!",
        "¡Película registrada con éxito!",
        "¡Película añadida con éxito!",
        "¡Película eliminada con éxito!",
        "¡Libro añadido con éxito!",
        "¡Película editada con éxito!",
        "¡Libro eliminado con éxito!",
        "¡Libro editado con éxito!",
        "¡Videojuego registrado con éxito!",
        "¡Videojuego editado con éxito!",
        "¡Videojuego añadido con éxito!",
        "¡Videojuego eliminado con éxito!",
        "¡Usuario editado con éxito!",
        "¡Serie registrada con éxito!",
        "¡Serie añadida con éxito!",
        "¡Serie editada con éxito!",
        "¡Serie eliminada con éxito!",
        "¡Usuario eliminado con éxito!"
    );

    public Succestion(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}

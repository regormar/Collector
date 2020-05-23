package excepciones;

import java.util.Arrays;
import java.util.List;


public class Succestion extends Exception{
    
    public static final int BOOK_REGISTERED = 0;
    public static final int USER_REGISTERED = 1;
    public static final int MOVIE_REGISTERED = 2;
    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "¡Libro registrado con éxito!",
        "!Usuario registrado con éxito!",
        "!Pelicula registrada con éxito!"
    );

    public Succestion(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}

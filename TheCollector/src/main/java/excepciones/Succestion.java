package excepciones;

import java.util.Arrays;
import java.util.List;


public class Succestion extends Exception{
    
    public static final int BOOK_ADDED = 0;
    
    private int code;

    private final List<String> MESSAGES = Arrays.asList(
        "¡Libro registrado con éxito!"
    );

    public Succestion(int code) {
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return MESSAGES.get(code);
    }
}
package modelo;


public class Usuario {
    
    private String nombre;
    private String apellidos;
    private int tipo;
    private String username;
    private String email;
    private String pass;

    public Usuario(String nombre, String apellidos, int tipo, String username, String email, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }   
    
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario() {
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

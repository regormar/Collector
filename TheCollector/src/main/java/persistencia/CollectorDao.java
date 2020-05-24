package persistencia;

import excepciones.Excepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;
import modelo.Pelicula;
import modelo.Usuario;

/**
 *
 * @author ROGER
 */
public class CollectorDao {
    
    public static Connection conexion;
    private static CollectorDao instance;
    private static String usuActual;
    private static int IdUsuActual;
    
    public static CollectorDao getInstace() {
        if (instance == null) {
            instance = new CollectorDao();
        }
        return instance;
    }
    
    //Funcion para guardar la id del usuario actual.
    public static void usuLogin(String usu) throws SQLException{
        usuActual = usu;
        String select = "select idusuario from usuario where username ='" + usu + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            IdUsuActual = rs.getInt("idusuario");
        }
        rs.close() ;
        st.close();
    }
    
    //Función que devuelve el número de libros que tiene un usuario.
    public static int getNumBooksByUser() throws SQLException {
        String select = "select count(username) as veces from librousuario where username ='" + usuActual + "'";
        int veces = 0;
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            veces = rs.getInt("veces");
        }
        rs.close() ;
        st.close();
        return veces;
    }
    
    //Funcion que selecciona la id de una pelicula segun su nombre.
    public static int getIdPeliculaByName(String nombre, String director) throws SQLException {
        String select = "select idpelicula from pelicula where nombrepelicula ='" + nombre + "' and direccion = '" + director + "'";
        int id = 0;
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            id = rs.getInt("idpelicula");
        }
        rs.close() ;
        st.close();
        return id;
    }

    //Funcion que selecciona la id de un genero segun su nombre.
    public static int getIdGeneroByName(String nombre) throws SQLException {
        String select = "select idgenero from genero where nombregenero ='" + nombre + "'";
        int id = 0;
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            id = rs.getInt("idgenero");
        }
        rs.close() ;
        st.close();
        return id;
    }
    
    /*
        0- Videojuegos
        1- Peliculas, series y libros
    */
    //Funcion que selecciona los nombres de los generos de la bbdd segun su tipo.
    public static List<String> selectNombreGeneros(int tipo) throws SQLException {
        String query = "select nombregenero from genero where tipogenero='" + tipo + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<String> generos = new ArrayList<>();
        String nombre = null;
        while (rs.next()) {
            nombre = rs.getString("nombregenero");
            generos.add(nombre);
        }
        rs.close();
        st.close();
        return generos;
    }
    
    //Funcion que selecciona los datos de la pelicula del usuario.
    public static Pelicula selectPeliculaUsuario(Pelicula peli, int id) throws SQLException {
        String query = "select * from peliculausuario where username='" + usuActual + "' and idpelicula = '" + id + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            peli.setMinuto(rs.getInt("minuto"));
            peli.setValoracion(rs.getInt("valoracion"));
        }
        rs.close();
        st.close();
        return peli;
    }
    
    //Funcion que selecciona todas las peliculas registradas en la bbdd.
    public static ArrayList<Pelicula> selectPeliculas() throws SQLException {
        String query = "select * from pelicula";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Pelicula> activity = new ArrayList<>();
        while (rs.next()) {
            Pelicula p = new Pelicula(null, 0, null, 0);
            p.setDireccion(rs.getString("direccion"));
            p.setDuracion(rs.getInt("duracion"));
            p.setNombre(rs.getString("nombrepelicula"));
            p.setGenero(rs.getInt("idgenero"));
            activity.add(p);
        }
        rs.close();
        st.close();
        return activity;
    }
    
    //Funcion que selecciona todos los libros registrados en la bbdd.
    public static ArrayList<Libro> selectLibros() throws SQLException {
        String query = "select * from libro";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Libro> activity = new ArrayList<>();
        while (rs.next()) {
            Libro l = new Libro();
            l.setId(rs.getInt("idlibro"));
            l.setNombre(rs.getString("nombrelibro"));
            l.setAutor(rs.getString("autor"));
            l.setNumPaginas(rs.getInt("numpaginas"));
            l.setGenero(rs.getInt("idgenero"));
            activity.add(l);
        }
        rs.close();
        st.close();
        return activity;
    }
    
    //Funcion para insertar una pelicula en la bbdd.
    public static void insertarPeliculaUsuario(Pelicula p, int id) throws SQLException {
        String insert = "insert into peliculausuario values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, usuActual);
        ps.setInt(2, id);
        ps.setInt(3, p.getMinuto());
        ps.setInt(4, p.getValoracion());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar una pelicula en la bbdd.
    public static void insertarLibroUsuario(Libro l) throws SQLException {
        String insert = "insert into librousuario values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, usuActual);
        ps.setInt(2, l.getId());
        ps.setInt(3, l.getPaginaActual());
        ps.setInt(4, l.getValoracion());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar una pelicula en la bbdd.
    public static void insertarPelicula(Pelicula p) throws SQLException {
        String insert = "insert into pelicula values (?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, null);
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getDireccion());
        ps.setInt(4, p.getDuracion());
        ps.setInt(5, p.getGenero());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar un libro en la bbdd.
    public static void insertarLibro(Libro l) throws SQLException {
        String insert = "insert into libro values (?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, null);
        ps.setString(2, l.getNombre());
        ps.setString(3, l.getAutor());
        ps.setInt(4, l.getNumPaginas());
        ps.setInt(5, l.getGenero());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar un usuario en la bbdd.
    public static void insertarUsuario(Usuario usu) throws SQLException {
        String insert = "insert into usuario values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, null);
        ps.setString(2, usu.getUsername());
        ps.setString(3, usu.getPass());
        ps.setString(4, usu.getNombre());
        ps.setString(5, usu.getApellidos());
        ps.setInt(6, 1);
        ps.setString(7, usu.getEmail());
        ps.executeUpdate();
        ps.close();
    }
    
    // Función que borra una pelicula.
    public static void eliminarPeliculaUsuario(int id) throws SQLException {
        String delete = "delete from peliculausuario where username='" + usuActual + "' and idpelicula = '" + id + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }

    //Funcion para comprobar si el usuario tiene una pelicula.
    public static boolean checkPeliculaUsuario(int id) throws SQLException {
        String select = "select * from peliculausuario where username ='" + usuActual + "'and idpelicula = '" + id + "'";
        Statement statment = conexion.createStatement();
        ResultSet result = statment.executeQuery(select);
        boolean existe = false;
        if (result.next()) {
            existe = true;
        }
        result.close();
        statment.close();
        return existe;
    }
    
    //Funcion para comprobar si el usuario tiene un libro.
    public static boolean checkLibroUsuario(int id) throws SQLException {
        String select = "select * from librousuario where username ='" + usuActual + "'and idlibro = '" + id + "'";
        Statement statment = conexion.createStatement();
        ResultSet result = statment.executeQuery(select);
        boolean existe = false;
        if (result.next()) {
            existe = true;
        }
        result.close();
        statment.close();
        return existe;
    }
    
    //Funcion para comprobar si existe una pelicula en la bbdd con el mismo nombre y director.
    public static boolean checkLibro(Libro l) throws SQLException {
        String select = "select * from libro where nombrelibro ='" + l.getNombre() + "'and autor = '" + l.getAutor()+ "'";
        Statement statment = conexion.createStatement();
        ResultSet result = statment.executeQuery(select);
        boolean existe = false;
        if (result.next()) {
            existe = true;
        }
        result.close();
        statment.close();
        return existe;
    }
    
    //Funcion para comprobar si existe una pelicula en la bbdd con el mismo nombre y director.
    public static boolean checkPelicula(Pelicula p) throws SQLException {
        String select = "select * from pelicula where nombrepelicula ='" + p.getNombre() + "'and direccion = '" + p.getDireccion() + "'";
        Statement statment = conexion.createStatement();
        ResultSet result = statment.executeQuery(select);
        boolean existe = false;
        if (result.next()) {
            existe = true;
        }
        result.close();
        statment.close();
        return existe;
    }
    
    public static boolean checkLogin(String u, String p) throws SQLException {
        String pass = "";
        boolean resultado = false;
        String select = "select username,pass from usuario o where o.username ='" + u + "' and o.pass = '" + p + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()) {
            if (rs.getString("username").equals(u) && rs.getString("pass").equals(p)) {
                resultado = true;
            } else {
                resultado = false;
            }
        }
        return resultado;
    }
    
    //Funcion para comprobar si existe un usurio en la bbdd con el mismo nombre.
    public static boolean checkUsername(Usuario u) throws SQLException {
        String select = "select username from usuario o where o.username ='" + u.getUsername() + "'";
        Statement statment = conexion.createStatement();
        ResultSet result = statment.executeQuery(select);
        boolean existe = false;
        if (result.next()) {
            existe = true;
        }
        result.close();
        statment.close();
        return existe;
    }
    
    public static Usuario getUser(String nombre) throws SQLException, Excepcion {
        String select = "select * from usuario where username='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        Usuario t = null;
        if (rs.next()) {
            t = new Usuario();
            t.setUsername(nombre);
            t.setApellidos(rs.getString("apellidos"));
            t.setNombre(rs.getString("nombre"));
            t.setTipo(rs.getInt("tipo"));
            t.setPass(rs.getString("pass"));
            t.setEmail(rs.getString("email"));
        }
        rs.close();
        st.close();
        return t;
    }
    
    /**
    * Función para conectar con la bbdd
    *
    * @throws SQLException
    */
    public static void conectar() throws SQLException { 
        String url = "jdbc:mysql://localhost:3306/thecollector?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Función para desconectar con la bbdd
     *
     * @throws SQLException
     */
    public static void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}

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
import modelo.Juego;
import modelo.Libro;
import modelo.Pelicula;
import modelo.Serie;
import modelo.Usuario;

/**
 *
 * @author ROGER
 */
public class CollectorDao {
    
    public static Connection conexion;
    private static CollectorDao instance;
    public static String usuActual;
    
    public static CollectorDao getInstace() {
        if (instance == null) {
            instance = new CollectorDao();
        }
        return instance;
    }
    
    //Funcion para guardar la id del usuario actual.
    public static void usuLogin(String usu) throws SQLException{
        usuActual = usu;
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
    
    //Función que devuelve el número de libros que tiene un usuario.
    public static int getNumGamesByUser() throws SQLException {
        String select = "select count(username) as veces from videojuegousuario where username ='" + usuActual + "'";
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
    
    //Funcion que selecciona el nombre de un genero segun su id.
    public static String getNombreGeneroById(int id) throws SQLException {
        String select = "select nombregenero from genero where idgenero ='" + id + "'";
        String nombre = "";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            nombre = rs.getString("nombregenero");
        }
        rs.close() ;
        st.close();
        return nombre;
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
    
    //Funcion que selecciona los datos de la serie del usuario.
    public static Serie selectSerieUsuario(Serie serie) throws SQLException {
        String query = "select * from serieusuario where username='" + usuActual + "' and idserie = '" + serie.getId() + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            serie.setTemporada(rs.getInt("temporada"));
            serie.setCapitulo(rs.getInt("capitulo"));
            serie.setMinuto(rs.getInt("minuto"));
            serie.setValoracion(rs.getInt("valoracion"));
        }
        rs.close();
        st.close();
        return serie;
    }
    
    //Funcion que selecciona los datos de la pelicula del usuario.
    public static Pelicula selectPeliculaUsuario(Pelicula peli) throws SQLException {
        String query = "select * from peliculausuario where username='" + usuActual + "' and idpelicula = '" + peli.getId() + "'";
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
    
    //Funcion que selecciona los datos del juego del usuario.
    public static Juego selectJuegoUsuario(Juego game) throws SQLException {
        String query = "select * from videojuegousuario where username='" + usuActual + "' and idvideojuego = '" + game.getId() + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            game.setValoracion(rs.getInt("valoracion"));
        }
        rs.close();
        st.close();
        return game;
    }
    
    //Funcion que selecciona los datos del libro del usuario.
    public static Libro selectLibroUsuario(Libro book) throws SQLException {
        String query = "select * from librousuario where username='" + usuActual + "' and idlibro = '" + book.getId() + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            book.setPaginaActual(rs.getInt("paginaactual"));
            book.setValoracion(rs.getInt("valoracion"));
        }
        rs.close();
        st.close();
        return book;
    }
    
    //Funcion que selecciona todas las series registradas en la bbdd.
    public static ArrayList<Serie> selectSerie() throws SQLException {
        String query = "select * from serie";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Serie> activity = new ArrayList<>();
        while (rs.next()) {
            Serie s = new Serie();
            s.setId(rs.getInt("idserie"));
            s.setDireccion(rs.getString("direccion"));
            s.setNumTemporadas(rs.getInt("numtemporadas"));
            s.setNumCapitulos(rs.getInt("numcapitulos"));
            s.setDuracionCapitulo(rs.getInt("duracioncapitulo"));
            s.setNombre(rs.getString("nombreserie"));
            s.setGenero(rs.getInt("idgenero"));
            activity.add(s);
        }
        rs.close();
        st.close();
        return activity;
    }
    
    //Funcion que selecciona todas las peliculas registradas en la bbdd.
    public static ArrayList<Pelicula> selectPeliculas() throws SQLException {
        String query = "select * from pelicula";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Pelicula> activity = new ArrayList<>();
        while (rs.next()) {
            Pelicula p = new Pelicula();
            p.setId(rs.getInt("idpelicula"));
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
    
    //Funcion que selecciona todos los juegos registrados en la bbdd.
    public static ArrayList<Juego> selectJuegos() throws SQLException {
        String query = "select * from videojuego";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Juego> activity = new ArrayList<>();
        while (rs.next()) {
            Juego j = new Juego();
            j.setId(rs.getInt("idvideojuego"));
            j.setNombre(rs.getString("nombrevideojuego"));
            j.setDesarrolladora(rs.getString("desarrolladora"));
            j.setGenero(rs.getInt("idgenero"));
            activity.add(j);
        }
        rs.close();
        st.close();
        return activity;
    }
    
    //Funcion que selecciona todos los juegos registrados en la bbdd.
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
    
    //Funcion que selecciona todos los usuarios registrados en la bbdd.
    public static ArrayList<Usuario> selectUsuarios() throws SQLException {
        String query = "select * from usuario";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Usuario> activity = new ArrayList<>();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setUsername(rs.getString("username"));
            u.setPass(rs.getString("pass"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidos(rs.getString("apellidos"));
            u.setTipo(rs.getInt("tipo"));
            u.setEmail(rs.getString("email"));
            activity.add(u);
        }
        rs.close();
        st.close();
        return activity;
    }
    
    //Funcion para modificar en la bbdd los datos de un usuario.
    public static void modificarUsuario(Usuario u, String oldName) throws SQLException{
        String update = "update usuario set username=?, pass=?, nombre=?, apellidos=?, tipo=?, email=? where username=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPass());
        ps.setString(3, u.getNombre());
        ps.setString(4, u.getApellidos());
        ps.setInt(5, u.getTipo());
        ps.setString(6, u.getEmail());
        ps.setString(7, oldName);
        ps.executeUpdate();
        ps.close();
        if(usuActual.equals(oldName)){
            usuActual = oldName;
        }
    }
    
    //Funcion para modificar en la bbdd la serie de un usuario.
    public static void modificarSerieUsuario(Serie s) throws SQLException{
        String update = "update serieusuario set temporada=?, capitulo=?, minuto=?, valoracion=? where username=? and idserie=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, s.getTemporada());
        ps.setInt(2, s.getCapitulo());
        ps.setInt(3, s.getMinuto());
        ps.setInt(4, s.getValoracion());
        ps.setString(5, usuActual);
        ps.setInt(6, s.getId());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para modificar en la bbdd la pelicula de un usuario.
    public static void modificarPeliculaUsuario(Pelicula p) throws SQLException{
        String update = "update peliculausuario set minuto=?, valoracion=? where username=? and idpelicula=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, p.getMinuto());
        ps.setInt(2, p.getValoracion());
        ps.setString(3, usuActual);
        ps.setInt(4, p.getId());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para modificar en la bbdd el juego de un usuario.
    public static void modificarJuegoUsuario(Juego j) throws SQLException{
        String update = "update videojuegousuario set valoracion=? where username=? and idvideojuego=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, j.getValoracion());
        ps.setString(2, usuActual);
        ps.setInt(3, j.getId());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para modificar en la bbdd el libro de un usuario.
    public static void modificarLibroUsuario(Libro l) throws SQLException{
        String update = "update librousuario set paginaactual=?, valoracion=? where username=? and idlibro=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, l.getPaginaActual());
        ps.setInt(2, l.getValoracion());
        ps.setString(3, usuActual);
        ps.setInt(4, l.getId());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar una serie en la bbdd.
    public static void insertarSerieUsuario(Serie s) throws SQLException {
        String insert = "insert into serieusuario values (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, usuActual);
        ps.setInt(2, s.getId());
        ps.setInt(3, s.getTemporada());
        ps.setInt(4, s.getCapitulo());
        ps.setInt(5, s.getMinuto());
        ps.setInt(6, s.getValoracion());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar una pelicula en la bbdd.
    public static void insertarPeliculaUsuario(Pelicula p) throws SQLException {
        String insert = "insert into peliculausuario values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, usuActual);
        ps.setInt(2, p.getId());
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
    
    //Funcion para insertar un juego en la bbdd.
    public static void insertarJuegoUsuario(Juego j) throws SQLException {
        String insert = "insert into videojuegousuario values (?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, usuActual);
        ps.setInt(2, j.getId());
        ps.setInt(3, j.getValoracion());
        ps.executeUpdate();
        ps.close();
    }
    
    //Funcion para insertar una serie en la bbdd.
    public static void insertarSerie(Serie s) throws SQLException {
        String insert = "insert into serie values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, null);
        ps.setString(2, s.getNombre());
        ps.setString(3, s.getDireccion());
        ps.setInt(4, s.getNumTemporadas());
        ps.setInt(5, s.getNumCapitulos());
        ps.setInt(6, s.getDuracionCapitulo());
        ps.setInt(7, s.getGenero());
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
    
    //Funcion para insertar un juego en la bbdd.
    public static void insertarJuego(Juego j) throws SQLException {
        String insert = "insert into videojuego values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, null);
        ps.setString(2, j.getNombre());
        ps.setString(3, j.getDesarrolladora());
        ps.setInt(4, j.getGenero());
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
        ps.setInt(6, usu.getTipo());
        ps.setString(7, usu.getEmail());
        ps.executeUpdate();
        ps.close();
    }
    
    //Función que borra un usuario.
    public static void eliminarUsuario(String usu) throws SQLException {
        String delete = "delete from usuario where username='" + usu + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    
    //Función que borra una serie.
    public static void eliminarSerieUsuario(int id) throws SQLException {
        String delete = "delete from serieusuario where username='" + usuActual + "' and idserie = '" + id + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    
    //Función que borra una pelicula.
    public static void eliminarPeliculaUsuario(int id) throws SQLException {
        String delete = "delete from peliculausuario where username='" + usuActual + "' and idpelicula = '" + id + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    
    //Función que borra un libro.
    public static void eliminarLibroUsuario(int id) throws SQLException {
        String delete = "delete from librousuario where username='" + usuActual + "' and idlibro = '" + id + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    
    //Función que borra un juego.
    public static void eliminarJuegoUsuario(int id) throws SQLException {
        String delete = "delete from videojuegousuario where username='" + usuActual + "' and idvideojuego = '" + id + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }

    //Funcion para comprobar si el usuario tiene una serie.
    public static boolean checkSerieUsuario(int id) throws SQLException {
        String select = "select * from serieusuario where username ='" + usuActual + "'and idserie = '" + id + "'";
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
    
    //Funcion para comprobar si el usuario tiene un juego.
    public static boolean checkJuegoUsuario(int id) throws SQLException {
        String select = "select * from videojuegousuario where username ='" + usuActual + "'and idvideojuego = '" + id + "'";
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
    
    //Funcion para comprobar si existe un juego en la bbdd con el mismo nombre y desarolladora.
    public static boolean checkJuego(Juego j) throws SQLException {
        String select = "select * from videojuego where nombrevideojuego ='" + j.getNombre() + "'and desarrolladora = '" + j.getDesarrolladora()+ "'";
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
    
    //Funcion para comprobar si existe una serie en la bbdd con el mismo nombre y director.
    public static boolean checkSerie(Serie s) throws SQLException {
        String select = "select * from serie where nombreserie ='" + s.getNombre() + "'and direccion = '" + s.getDireccion() + "'";
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
    
    //Función para conectar con la bbdd
    public static void conectar() throws SQLException { 
        String url = "jdbc:mysql://localhost:3306/thecollector?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    //Función para desconectar con la bbdd
    public static void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}

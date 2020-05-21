/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.Excepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Usuario;

/**
 *
 * @author ROGER
 */
public class CollectorDao {
    
    Connection conexion;
    private static CollectorDao instance;
    
    public static CollectorDao getInstace() {
        if (instance == null) {
            instance = new CollectorDao();
        }
        return instance;
    }
    
    //Funcion para comprobar si existe un usurio en la bbdd con el mismo nobre.
    public boolean existeUsuario(String usu) throws SQLException {
        String select = "select * from usuario where username='" + usu + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close() ;
        st.close();
        return existe;
    }
    
    //Funcion para insertar un usuario en la bbdd.
    public void insertarUsuario(Usuario usu) throws SQLException {
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
    
    
    public boolean checkLogin(String u, String p) throws SQLException {
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
    
    public boolean checkUsername(Usuario u) throws SQLException {
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
    
    public Usuario getUser(String nombre) throws SQLException, Excepcion {
        Usuario taux = new Usuario(nombre);
        if (!checkUsername(taux)) {
            throw new Excepcion(Excepcion.ERROR_USER_NOT_FOUND);
        }
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
    public void conectar() throws SQLException { 
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
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}

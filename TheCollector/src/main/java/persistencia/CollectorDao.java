/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import excepciones.Excepcion;
import java.sql.Connection;
import java.sql.DriverManager;
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

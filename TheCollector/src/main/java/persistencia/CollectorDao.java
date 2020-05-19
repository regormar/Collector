/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ROGER
 */
public class CollectorDao {
    
    Connection conexion;
    
    /**
    * Función para conectar con la bbdd
    *
    * @throws SQLException
    */
    public void conectar() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/thecollector";
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

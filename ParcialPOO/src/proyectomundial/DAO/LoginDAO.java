/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.Registro;
import proyectomundial.util.BasedeDatos;
import static proyectomundial.util.BasedeDatos.ejecutarSQL;

/**
 *
 * @author miguelropero
 */


   public class LoginDAO {
       
       public LoginDAO() {
        BasedeDatos.conectar();
    }
       
    private static final String URL = "dpg-cfpuu1qrrk0fd9ounopg-a.oregon-postgres.render.com";
    private static final String username = "pepito";
    private static final String password = "buenaSuerte";

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean autenticado = false;

        try {
            conn = DriverManager.getConnection(URL, username, password);
            String consulta = "SELECT poo.users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(consulta);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            autenticado = rs.next(); // Si hay un resultado, el usuario y la contraseña son válidos
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return autenticado;
    }
    }

   
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.DAO;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.Registro;
import proyectomundial.util.BasedeDatos;
import static proyectomundial.util.BasedeDatos.ejecutarSQL;

/**
 *
 * @author miguelropero
 */
public class RegistroDAO {

    public RegistroDAO() {
        BasedeDatos.conectar();
    }
    
    public boolean RegistrarLogin(Registro registrar) {
        
        String sql = "INSERT INTO poo.users values(usuario, contraseña,) "
                + "'" + registrar.getUsuario() + "', " 
                + "'" + registrar.getContraseña() + "')";
        
        //BasedeDatos.conectar();
        boolean registro = BasedeDatos.ejecutarActualizacionSQL(sql);
        //BasedeDatos.desconectar();
        return registro;
    }
    public List<Registro> getRegistro() {
        
        String sql = "SELECT usuario, contraseña FROM poo.users";
        List<Registro> registro = new ArrayList<Registro>();
        
        try {
            ResultSet result = BasedeDatos.ejecutarSQL(sql);
            
            if(result != null) {
            
                while (result.next()) { 
                    Registro registro = new Registro(result.getString("usuario"),result.getString("contraseña"));
                    registro.add(registro);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error consultando selecciones");
        }
        
        return registro;
    }
    
}


package formulario;

import database.Conexion;
import database.ObtenerInformacion;
import modelo.Usuario;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

public class Login {

    ObtenerInformacion obtenerInformacion = new ObtenerInformacion();

    //Creamos una instancia de la clase panel
    Panel panel = new Panel();

    public void iniciarSesion() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contrasenia = JOptionPane.showInputDialog("Ingrese su contraseña:");

        Usuario usuario = obtenerInformacion.loguearse(nombreUsuario, contrasenia);

        if (usuario != null){
            panel.Panel(usuario);
        }

    }
}

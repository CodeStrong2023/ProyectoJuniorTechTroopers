package formulario;

import modelo.CorreccionDeErrores;
import database.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro {

    Conexion cn = new Conexion();
    CorreccionDeErrores correccion = new CorreccionDeErrores();
    boolean registroExitoso = true;
    
    public void registrarUsuario() {
         
        String nombreUsuario = correccion.correccionUsuario("Ingrese su Usuario: ");
        if (nombreUsuario == null){
            registroExitoso = false;
            return;
        }
        
        String contrasenia = correccion.correccionString( "Ingrese una contraseña:");
        if (contrasenia == null){
            registroExitoso = false;
            return;
        }
        
        String correo = correccion.correccionCorreo("Ingrese su correo:");
        if (correo == null){
            registroExitoso = false;
            return;
        }

        int edad = correccion.correccionInt("Ingrese su edad:");
        if (edad == 0){
            registroExitoso = false;
            return;
        }
        
        String nombre = correccion.correccionNombreApellido("Ingrese su nombre:");
        if (nombre == null){
            registroExitoso = false;
            return;
        }
        
        String apellido = correccion.correccionNombreApellido("Ingrese su apellido:");
        if (apellido == null){
            registroExitoso = false;
            return;
        }
        
        //Determinamos por defecto un salgo para todo el que se registra $1.000.000
        float saldo = 1000000;
        
        if (registroExitoso) {
            insertarUsuario(nombreUsuario, contrasenia, correo, edad, nombre, apellido, saldo);
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        } else {
            JOptionPane.showMessageDialog(null, "Error en el registro. Inténtelo nuevamente.");

        }
    }

    private boolean insertarUsuario(String nombreUsuario, String contrasenia, String correo, int edad, String nombre, String apellido, float saldo) {
        String sql = "INSERT INTO usuarios (nombre_de_usuario, contrasenia, correo, edad, nombre, apellido, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conexion = cn.conexion;

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasenia);
            statement.setString(3, correo);
            statement.setInt(4, edad);
            statement.setString(5, nombre);
            statement.setString(6, apellido);
            statement.setFloat(7, saldo);

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
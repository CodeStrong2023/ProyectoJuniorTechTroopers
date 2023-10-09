package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    public Connection conexion;
    //Creamos el metodo conexion para conectarnos con la base de datos TrooperStay
    public Conexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/trooper_stay", "root", "02091898");
        } catch (Exception e) {
            //En caso de que ocura una excepción durante la conexión, se muestra un mensaje de erorr
            System.err.print("Error" + e);
        }
    }
    //Getter
    public Connection getConexion() {
        return conexion;
    }
}

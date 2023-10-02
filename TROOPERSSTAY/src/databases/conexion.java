
package databases;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
     public Connection conexion;
    //Creamos el metodo conexion para conectarnos con la base de datos "TrooperStay"
    public conexion(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/trooper_stay","root","32893064");
        }catch (Exception e){
            //En caso de que ocurra una excepción durante la conexión, se muestra un mensaje de error
            System.err.print("Error" + e);
        }
        
    }
}

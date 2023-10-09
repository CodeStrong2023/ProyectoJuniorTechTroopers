
import database.Conexion;

public class main {
    public static void main(String[] args) {
        //Creamos una instancia de la clase conexion para establecer la conexión a la base de datos
        Conexion cn = new Conexion();
        //Intanciamos la clase Menu
       
        //Verificamos si la conexión a la base de datos es exitosa
        if(cn.conexion != null){
            System.out.println("La conexión fue exitosa");
            
        }else{
            System.out.println("La conexión falló");
        }


    }
}

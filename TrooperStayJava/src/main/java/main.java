import database.Conexion;
import formulario.Menu;

public class main {

    public static void main(String[] args) {
        //Creamos una instancia de la clase conexion para establecer la conexión a la base de datos
        Conexion cn = new Conexion(); // Esto no se debe usar
        //Intanciamos la clase Menu
        Menu menu = new Menu();
        if (cn.conexion != null) {
            System.out.println("La conexión fue exitosa");
            menu.Menu();
        } else {
            System.out.println("La conexión falló");
        }
    }
}

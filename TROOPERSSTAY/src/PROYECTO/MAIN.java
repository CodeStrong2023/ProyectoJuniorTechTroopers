
package PROYECTO;

import databases.conexion;

public class MAIN {
    public static void main(String[] args) {
        
        conexion cn = new conexion();
       
       
        if(cn.conexion != null){
            System.out.println("La conexión fue exitosa");
            
        }else{
            System.out.println("La conexión falló");
        }
    }
}

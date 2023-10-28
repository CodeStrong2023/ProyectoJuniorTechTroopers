package formulario;

import database.IngresarInformacion;
import modelo.AlojamientoHospedaje;
import modelo.CorreccionDeErrores;
import modelo.Provincias;

import javax.swing.*;

public class CrearHospedaje {

    //Creamos una instancia de la clase conexion
    private static final IngresarInformacion INGRESAR_DB = new IngresarInformacion(); // Son atributos
    // Instanciamos la clase ArrayList con las provincias para el selector

    CorreccionDeErrores correccion = new CorreccionDeErrores();
    Provincias provincias = new Provincias();

    public void cargarHospedaje(int idUsuario) {

        boolean salir = false;
        String[] arreglo = {"Departamento", "Cabaña", "Hotel 1/4"};
        // usamos el comando de JOptionPane.showOptionDiaglog te permite seleeccional opciones
        while (!salir) {

            String nombreLugar = correccion.correccionNombreApellido("Ingrese un nombre del Lugar:");
            if (nombreLugar == null) {
                salir = true;
                return;
            }
            int opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "OPCIONES", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "");
            int tipo = 0;
            //Por medio de un SWITCH derivamos la opcion seleccionada en base a la posicion del arreglo
            switch (opcion) {
                case 0:
                    // Lógica para iniciar sesión
                    tipo = 1;
                    break;
                case 1:
                    // Lógica para registrarse
                    tipo = 2;
                    break;
                case 2:
                    tipo = 3;
                    break;
                default:
                    // Cualquier otra opcion sale
                    salir = true;
                    break;
            }

            int capacidad = correccion.correccionInt2("Ingrese capacidad MAXIMA:");
            if (capacidad == 0) {
                salir = true;
                return;
            }
            String localizacion = provincias.getProvincias();
            if (localizacion == null) {
                salir = true;
                return;
            }
            
            double precio = correccion.correccionPrecio("Ingrese el monto por día:");
            if (precio == 0.0) {
                salir = true;
                return;
            }

            // Creamos un constructor, creo un objeto con estados cargados y otros por defecto (ya que esto no se pasa a la base de datos)
            AlojamientoHospedaje newhospedaje = new AlojamientoHospedaje(nombreLugar, tipo, capacidad, localizacion, precio, idUsuario);

            INGRESAR_DB.cargarHospedaje(newhospedaje);
            salir = true;
        }
        return;
    }
}

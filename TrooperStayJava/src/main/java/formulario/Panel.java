
package formulario;


import database.Conexion;
import modelo.Usuario;

import javax.swing.JOptionPane;

public class Panel {

    //Creamos un objeto de la clase cargar hospedaje
    CrearHospedaje crearhospedaje = new CrearHospedaje();

    //Creamos un objeto de la clase verHospedaje
    VerHospedajes vista = new VerHospedajes();


    //Constructor
    public Panel() {


    }

    public void Panel(Usuario usuario) {
        boolean salir = false; 
        while (!salir) { // Cambiamos la condición a true
            String[] arreglo = {"Ver/Alquilar hospedajes", "Cargar Hospedaje", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "MENÚ PRINCIPAL", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "");

            switch (opcion) {
                case 0:
                    // Lógica para "Ver hospedajes"
                    vista.ingresarFiltrosDeUsuario(usuario);
                    break;
                case 1:
                    //Lógica para "Insetar hospedajes"
                    crearhospedaje.cargarHospedaje(usuario.id);
                    break;
                default:
                    salir = true; 
                    return;
            }
        }
    }
}


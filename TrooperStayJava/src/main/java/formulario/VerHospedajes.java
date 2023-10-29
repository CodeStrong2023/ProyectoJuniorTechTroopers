package formulario;

import database.ActualizarInformacion;
import database.ObtenerInformacion;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.AlojamientoHospedaje;
import modelo.CorreccionDeErrores;
import modelo.Provincias;
import modelo.Usuario;

/**
 * @author lopoj
 */
public class VerHospedajes extends JPanel {

    private final ObtenerInformacion obtenerInformacion;

    Provincias provincias = new Provincias(); // Instanciamos el modelo
    CorreccionDeErrores correccion = new CorreccionDeErrores();

    public VerHospedajes() {
        setLayout(new BorderLayout());

        obtenerInformacion = new ObtenerInformacion();

    }

    public void ingresarFiltrosDeUsuario(Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            // Llamamos al metodo get provincia para realizar la muestra por filtrado
            String localizacion = provincias.getProvincias();
            if (localizacion == null) {
                salir = true;
                return;
            }
            // Esto para seguir un patron de ingreso a la base de datos.

            int capacidad = correccion.correccionInt2("Ingrese la capacidad:");
            if (capacidad == 0) {
                salir = true;
                return;
            }

            // Realiza la búsqueda con los filtros ingresados por el usuario
            List<AlojamientoHospedaje> hospedajes = obtenerInformacion.filtrarHospedajes(localizacion, capacidad);

            // Muestra los resultados y permite al usuario seleccionar alquileres
            AlojamientoHospedaje alquilerSeleccionado = seleccionarAlquileres(hospedajes);
            if (alquilerSeleccionado == null) {
                salir = true;
                return;
            } else {
                // Ingresamos el id del que acaba de Alquilar
                alquilerSeleccionado.setId_usuario_inquilino(usuario.id);

                // Fecha de hospedaje
                alquilerSeleccionado.setInicio_estadia(JOptionPane.showInputDialog("Ingrese AAAA-MM-DD:"));

            }

            // Definimos cantidad de dias de hospedajes para poder calcular luego.
            int diasHospedaje = correccion.correccionInt2("Ingrese los numeros de días a Hospedarse:");
            if (diasHospedaje == 0) {
                salir = true;
                return;
            }

            // Dias a hospedarse
            alquilerSeleccionado.setEstadia(diasHospedaje);

            // Calculamos el monto que le descontamos al saldo
            double montoFinal = diasHospedaje * alquilerSeleccionado.getPrecio_por_noche();
            String[] arreglo = {"Aceptar", "Calcelar"};
            int opcion = JOptionPane.showOptionDialog(null, "Presiona ACEPTAR para continuar o CANCELAR para volver al menu", "Su alquiler por " + diasHospedaje +" tiene un monto final de $" +montoFinal, 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "");

            switch (opcion) {
                case 0:
                    break;
                default:
                    // Cualquier otra opcion sale
                    salir = true;
                    return;
            }

            if (montoFinal <= usuario.saldo) {
                ActualizarInformacion actualizarInformacion = new ActualizarInformacion();
                // TODO: PRIMERO ACTUALIZAMOS EL HOSPEDAJE
                actualizarInformacion.actualizarHospedajes(alquilerSeleccionado);

                // TODO: SEGUNDO ACTUALIZAMOS EL USUARIO INQUILINO
                double montoFinalInquilino = usuario.saldo - montoFinal;
                actualizarInformacion.actualizarUsuarioInquilino(alquilerSeleccionado, montoFinalInquilino);

                // TODO: TERCER ACTUALIZAMOS EL USUARIO PROPIETARIO
                actualizarInformacion.actualizarUsuarioPropietario(alquilerSeleccionado, montoFinal);

            } else {
                JOptionPane.showMessageDialog(null, "POBRE DE MIERDA");
                salir = true; 
                return; 
            }
            if (salir == false){
            JOptionPane.showMessageDialog(null, "Que disfrute de su estadia!! :)");
            }
            // Lo instanciamos para que no de problemas de recursividad
            Panel panel = new Panel();
            obtenerInformacion.obtenerObjetoPanel(usuario.id);
            salir = true; 
        }

    }

// Listado alquileres
    public AlojamientoHospedaje seleccionarAlquileres(List<AlojamientoHospedaje> hospedajes) {
        String[] objetoDetallado = new String[hospedajes.size()];

        for (int i = 0; i < hospedajes.size(); i++) {
            AlojamientoHospedaje hospedaje = hospedajes.get(i);

            String tipo = "";
            switch (hospedaje.getTipo()) {
                case 1:
                    tipo = "Departamento";
                    break;
                case 2:
                    tipo = "Cabaña";
                    break;
                case 3:
                    tipo = "Hotel 1/4";
                    break;
            }

            objetoDetallado[i] = "Nombre: " + hospedaje.getNombre()
                    + " - Precio: " + hospedaje.getPrecio_por_noche()
                    + " - Capacidad: " + hospedaje.getCapacidad()
                    + " - Tipo: " + tipo;
        }
        boolean salida = false;
        int conteo = 0;
        while (!salida) {
            Object seleccion = JOptionPane.showInputDialog(
                    this,
                    "Seleccione alquileres para agregar al carrito:",
                    "Selección de Alquileres",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    objetoDetallado,
                    null
            );
            conteo++;
            // Obtén el índice seleccionado y úsalo para obtener el objeto correspondiente de la lista original.
            if (seleccion == null) {
                if (conteo == 3) {
                    JOptionPane.showMessageDialog(null, "Volvemos al Menu");
                    salida = true;
                    return null; // Devuelve null si el usuario cancela la selección.    
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un Alquiler. Intentos restantes: " + (3 - conteo));
                }

            } else {
                int indiceSeleccionado = Arrays.asList(objetoDetallado).indexOf(seleccion);
                return hospedajes.get(indiceSeleccionado);
            }
        }
        return null;
    }
}

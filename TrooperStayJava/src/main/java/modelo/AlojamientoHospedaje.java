package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class AlojamientoHospedaje {

    // Se usa private final porque es un atributo inmutable y despues usamos un get
    private final int id;
    private final String nombre;
    //Cambiasmos el tipo de dato int
    private final int tipo;
    private final int capacidad;
    private final String localizacion;
    private final double precio_por_noche;
    //Cambiamos el tipo de dato a estado
    private byte estado;
    private final int id_usuario;
    private int id_usuario_inquilino;
    private String inicio_estadia; // 2023-10-13 +7
    private String estadia; // 2023-10-20

    public AlojamientoHospedaje(int id, String nombre, int tipo, int capacidad, String localizacion, double precio_por_noche, byte estado, int id_usuario, int idUsuarioInquilino, String estadia) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
        this.precio_por_noche = precio_por_noche;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_usuario_inquilino = idUsuarioInquilino;
        this.estadia = estadia;
    }

    // Se creo para crear un nuevo hospedaje
    public AlojamientoHospedaje(String nombre, int tipo, int capacidad, String localizacion, double precio_por_noche, int id_usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
        this.precio_por_noche = precio_por_noche;
        this.id_usuario = id_usuario;
        // Son creados por default
        this.id = 0;
        this.estado = 0; // Falso porque no esta alquilado :)
        this.id_usuario_inquilino = 0;
        this.inicio_estadia = "";
        this.estadia = "";

    }

    //Getter y Setter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public double getPrecio_por_noche() {
        return precio_por_noche;
    }

    public byte getEstado() {
        return estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_usuario_inquilino() {
        return id_usuario_inquilino;
    }

    public String getInicio_estadia() {
        return inicio_estadia;
    }

    public String getEstadia() {
        return estadia;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public void setId_usuario_inquilino(int id_usuario_inquilino) {
        this.id_usuario_inquilino = id_usuario_inquilino;
    }

    public void setInicio_estadia(String inicio_estadia) {
        boolean fechaValida = false;

        while (!fechaValida) {
            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            try {
                // Convierte la fecha de inicio a LocalDate
                LocalDate fechaInicio = LocalDate.parse(inicio_estadia, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Verifica si la fecha de inicio es mayor o igual a la fecha actual
                if (fechaInicio.isAfter(fechaActual) || fechaInicio.isEqual(fechaActual)) {
                    fechaValida = true;
                    this.inicio_estadia = inicio_estadia;
                } else {
                    // La fecha de inicio es menor que la fecha actual, muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser mayor o igual que la fecha actual.");
                    // Pide al usuario que ingrese una fecha válida
                    inicio_estadia = JOptionPane.showInputDialog("Ingrese AAAA-MM-DD:");
                }
            } catch (Exception e) {
                // Si ocurre un error al analizar la fecha, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Formato de fecha no válido. Ingrese AAAA-MM-DD.");
                // Pide al usuario que ingrese una fecha válida
                inicio_estadia = JOptionPane.showInputDialog("Ingrese AAAA-MM-DD:");
            }
        }
    }
    public void setEstadia(int estadia) {
        // Convierte inicio_estadia a LocalDate
        LocalDate fechaInicio = LocalDate.parse(inicio_estadia, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Agrega la cantidad de días
        LocalDate fechaEstadia = fechaInicio.plusDays(estadia);

        // Convierte la fecha resultante de vuelta a String en el formato deseado
        this.estadia = fechaEstadia.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

package database;

import modelo.AlojamientoHospedaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class IngresarInformacion {
    private static final Connection CONEXION = new Conexion().getConexion();

    public Boolean cargarHospedaje(AlojamientoHospedaje nuevoHospedaje) {
        String sql = "INSERT INTO hospedajes (nombre, tipo, capacidad, localizacion, precio_por_noche, estado,id_usuario) VALUES (? , ? , ? , ? , ? , ? , ?)";

        try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {
            statement.setString(1, nuevoHospedaje.getNombre());
            statement.setInt(2, nuevoHospedaje.getTipo()); // En el codigo es un String pero en la base de datos es un int
            statement.setInt(3, nuevoHospedaje.getCapacidad());
            statement.setString(4, nuevoHospedaje.getLocalizacion());
            statement.setDouble(5, nuevoHospedaje.getPrecio_por_noche());
            statement.setByte(6, nuevoHospedaje.getEstado());
            statement.setInt(7, nuevoHospedaje.getId_usuario());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}


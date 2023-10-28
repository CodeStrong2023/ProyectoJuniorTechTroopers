package database;

import modelo.AlojamientoHospedaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarInformacion {

    private static final Connection CONEXION = new Conexion().getConexion();

    public void actualizarHospedajes(AlojamientoHospedaje alquilerSeleccionado) {
        String sql = "UPDATE hospedajes SET estado = 1, id_usuario_inquilino = ?, inicio_estadia = ?, estadia = ? WHERE id = ?";

        try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {

            statement.setInt(1, alquilerSeleccionado.getId_usuario_inquilino());
            statement.setString(2, alquilerSeleccionado.getInicio_estadia());
            statement.setString(3, alquilerSeleccionado.getEstadia());
            statement.setInt(4, alquilerSeleccionado.getId());

            int filasAfectadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void actualizarUsuarioInquilino(AlojamientoHospedaje alquilerSeleccionado, double montoFinal) {
        String sql = "UPDATE usuarios SET saldo = ? WHERE id = ?";

        try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {

            statement.setDouble(1, montoFinal);
            statement.setInt(2, alquilerSeleccionado.getId_usuario_inquilino());


            int filasAfectadas = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void actualizarUsuarioPropietario(AlojamientoHospedaje alquilerSeleccionado, double montoFinal) {
        ObtenerInformacion obtenerInformacion = new ObtenerInformacion();
        float saldoDelUsuarioPropietario = obtenerInformacion.obtenerSaldoDeUsuarioPorId(
                alquilerSeleccionado.getId_usuario()
        );

        float montoFinalPropietario = (float) (saldoDelUsuarioPropietario + montoFinal);

        String sql = "UPDATE usuarios SET saldo = ? WHERE id = ?";

        try (PreparedStatement statement = CONEXION.prepareStatement(sql)) {

            statement.setFloat(1, montoFinalPropietario);
            statement.setInt(2, alquilerSeleccionado.getId_usuario());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}

package ar.com.ere.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.ere.entity.Reserva;

public class ReservaExtractor implements RowMapper<Reserva> {

	public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(rs.getString("id_reserva"));
		reserva.setNombre(rs.getString("nombre"));
		reserva.setEmail(rs.getString("email"));
		reserva.setOrigen(rs.getString("origen"));
		reserva.setDestino(rs.getString("destino"));
		reserva.setFechaHoraSalida(rs.getString("fecha_hora_salida"));
		reserva.setDuracion(rs.getString("duracion"));
		return reserva;
	}

}

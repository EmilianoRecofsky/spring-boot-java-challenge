package ar.com.ere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ere.entity.Reserva;
import ar.com.ere.extractor.ReservaExtractor;

@Transactional
@Repository
public class ReservaDao {

	private static Logger logger = Logger.getLogger(ReservaDao.class.getName());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Reserva> obtenerReservas() throws Exception {
		logger.info("ReservaDao obtenerReservas");
		List<Reserva> lista = jdbcTemplate.query("SELECT * FROM reserva;", new ReservaExtractor());
		return lista;
	}

	public Integer agregarReserva(Reserva reserva) throws Exception {
		logger.info("ReservaDao agregarReserva");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pst = con.prepareStatement("INSERT INTO reserva (nombre, email, origen, destino, fecha_hora_salida, duracion) values (?,?,?,?,?,?)",
						new String[] { "ir_reserva" });
				pst.setString(1, reserva.getNombre());
				pst.setString(2, reserva.getEmail());
				pst.setString(3, reserva.getOrigen());
				pst.setString(4, reserva.getDestino());
				pst.setString(5, reserva.getFechaHoraSalida());
				pst.setString(6, reserva.getDuracion());
				return pst;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	public void modificarReserva(Reserva reserva) throws Exception {
		logger.info("ReservaDao modificarReserva");
		jdbcTemplate.update("UPDATE reserva SET nombre=?, email=?, origen=?, destino=?, fecha_hora_salida=?, duracion=? WHERE id_reserva=?",
				new Object[] { 
					reserva.getNombre(),
					reserva.getEmail(),
					reserva.getOrigen(),
					reserva.getDestino(),
					reserva.getFechaHoraSalida(),
					reserva.getDuracion(),
					reserva.getIdReserva()
				});
	}

	public Reserva obtenerReservaById(String idReserva) {
		logger.info("ReservaDao obtenerReservaById idReserva:" + idReserva);
		List<Reserva> lista = jdbcTemplate.query("SELECT * FROM reserva WHERE id_reserva=?", new ReservaExtractor(), idReserva);
		if (lista != null) {
			if (lista.size() > 0) {
				return lista.get(0);
			} else
				return null;
		} else{
			return null;
		}
	}

	public void eliminarReserva(String idReserva) throws Exception {
		logger.info("ReservaDao eliminarReserva idReserva:" + idReserva);
		jdbcTemplate.update("DELETE FROM reserva WHERE id_reserva=?", idReserva);
	}

}

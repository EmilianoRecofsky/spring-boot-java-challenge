package ar.com.ere.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ere.dao.ReservaDao;
import ar.com.ere.entity.Reserva;

@Service
public class ReservaService {

	private static Logger logger = Logger.getLogger(ReservaService.class.getName());

	@Autowired
	ReservaDao reservaDao;

	/**
	 * Obtener todas las reservas
	 * 
	 * @return lista de reservas totales
	 * @throws Exception : Tratamiento de excepcion al obtener reservas
	 */
	public List<Reserva> obtenerReservas() throws Exception {
		logger.info("ReservaService obtenerReservas");
		List<Reserva> reservaes = reservaDao.obtenerReservas();
		return reservaes;
	}

	/**
	 * Agregar una reserva
	 * 
	 * @param reserva: Objeto reserva a persitir
	 * @return Objeto reserva agregado con id auto-generado
	 * @throws Exception: Tratamiento de excepcion al agregar reserva
	 */
	public Reserva agregarReserva(Reserva reserva) throws Exception {
		logger.info("ReservaService agregarReserva");
		int idReservaGenerado = reservaDao.agregarReserva(reserva);
		reserva.setIdReserva(String.valueOf(idReservaGenerado));
		return reserva;
	}

	/**
	 * Actualziar una reserva
	 * 
	 * @param reserva: Reserva a modiifcar (actualziar)
	 * @return: Reserva modificada
	 * @throws Exception: Tratamiento de excepcion al actualziar reserva
	 */
	public Reserva modificarReserva(Reserva reserva) throws Exception {
		logger.info("ReservaService modificarReserva");
		reservaDao.modificarReserva(reserva);
		return reserva;
	}

	/**
	 * Eliminar una reserva dado su id
	 * 
	 * @param idReserva: Identificador de reserva a eliminar
	 * @throws Exception: Tratamiento de excepcion al eliminar reserva 
	 */
	public void eliminarReserva(String idReserva) throws Exception {
		logger.info("ReservaService eliminarReserva idReserva:" + idReserva);
		reservaDao.eliminarReserva(idReserva);
	}

	/**
	 * Obtener una reserva dado su id
	 * 
	 * @param idReserva: Identificador de reserva a retornar
	 * @return: Reserva que se encontró dado el id de búsqueda
	 * @throws Exception: Tratamiento de excepcion al buscar reserva dado identificador
	 */
	public Reserva obtenerReservaById(String idReserva) throws Exception {
		logger.info("ReservaService obtenerReservaById idReserva:" + idReserva);
		return reservaDao.obtenerReservaById(idReserva);
	}

}

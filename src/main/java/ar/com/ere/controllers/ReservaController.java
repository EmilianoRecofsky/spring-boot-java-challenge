package ar.com.ere.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ere.entity.Reserva;
import ar.com.ere.service.ReservaService;

@RestController
@RequestMapping("/reserva")
@CrossOrigin("*")
public class ReservaController {

	private static Logger logger = Logger.getLogger(ReservaController.class.getName());

	@Autowired
	private ReservaService reservaService;

	@GetMapping("/obtenerReservas")
	public List<Reserva> obtenerReservas() throws Exception {
		logger.info("ReservaController obtenerReservas");
		return reservaService.obtenerReservas();
	}

	@PostMapping("/agregarReserva")
	public Reserva agregarReserva(@Valid @RequestBody Reserva reserva) throws Exception {
		logger.info("ReservaController agregarReserva");
		return reservaService.agregarReserva(reserva);
	}

	@PutMapping("/modificarReserva")
	public Reserva modificarReserva(@RequestBody Reserva reserva) throws Exception {
		logger.info("ReservaController modificarReserva");
		return reservaService.modificarReserva(reserva);
	}

	@DeleteMapping("/eliminarReserva/{idReserva}")
	public void eliminarReserva(@PathVariable("idReserva") String idReserva) throws Exception {
		logger.info("ReservaController eliminarReserva idReserva:" + idReserva);
		reservaService.eliminarReserva(idReserva);
	}

	@GetMapping("/obtenerReservaById/{idReserva}")
	private Reserva obtenerReservaById(@PathVariable("idReserva") String idReserva) throws Exception {
		logger.info("ReservaController obtenerReservaById idReserva:" + idReserva);
		return reservaService.obtenerReservaById(idReserva);
	}

}

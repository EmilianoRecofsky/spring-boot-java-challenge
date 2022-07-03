package ar.com.ere.entity;

public class Reserva {

	private String idReserva;
	private String nombre;
	private String email;
	private String origen;
	private String destino;
	private String fechaHoraSalida;
	private String duracion;

	public Reserva() {

	}

	public Reserva(String idReserva, String nombre, String email,
			String origen, String destino, String fechaHoraSalida,
			String duracion) {
		this.idReserva = idReserva;
		this.nombre = nombre;
		this.email = email;
		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.duracion = duracion;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}

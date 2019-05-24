package ejercicioentrega;

public class CircuitoPiloto {
	
	private String nombrePiloto;
	private String fecha;
	private String hora;
	
	public CircuitoPiloto(String nombrePiloto, String fecha, String hora) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.fecha = fecha;
		this.hora = hora;
	}

	
	public String getNombrePiloto() {
		return nombrePiloto;
	}


	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return fecha+" "+nombrePiloto+" "+hora; 
	}
	
	
	

}

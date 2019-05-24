package ejercicioentrega;

public class Circuito {
	
	private String id;
	private String nombre;
	private String lugar;
	
	
	public Circuito(String id, String nombre, String lugar) 
	{
		this.id = id;
		this.nombre = nombre;
		this.lugar = lugar;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	

}

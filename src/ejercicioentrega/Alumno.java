package ejercicioentrega;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno {
	
	private String dni;
	private String nombre;
	private int edad;
	private Date fechaNac;
	
	public Alumno()
	{
		
	}
	
	public Alumno(String dni, String nombre, int edad, Date fechaNac) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public String toString()
	{
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-YY");
		String strFecha=f.format(this.fechaNac);
		
		return dni+" "+nombre+" "+edad+" "+strFecha;
	}
	
	
	public static void main(String[] args) {
		
		Alumno al=new Alumno("111A", "Aaron", 20, new Date());
		System.out.println(al.toString());
	}

}

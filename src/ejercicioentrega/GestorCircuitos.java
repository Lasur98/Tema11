package ejercicioentrega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class GestorCircuitos {
	
	private final static String 
			CAD_CONEX="jdbc:mysql://172.20.101.130/bd_aitor";
	private final static String USER="aitor";
	private final static String PASS="robles";
	private Connection cn;
	
	public  GestorCircuitos(){
		
		// Conectarnos a BD bd_aitor
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");			
			cn=DriverManager.getConnection(CAD_CONEX, USER, PASS);
			//System.out.println("Conexion:" + cn);
		} 
		catch (ClassNotFoundException e) 
		{
			
			System.err.println("No puede registrar jdbc");
		} 
		catch (SQLException e) 
		{
			System.err.println("Error al conectarse con usuario " + USER);
		}
	}
	
	public ArrayList<String> nombresCircuitos()
	{
		ArrayList<String> circuitos=new ArrayList<String>();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select nombre from circuitos";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				circuitos.add(rs.getString("nombre"));
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		return circuitos;
		
		
	}
	
	public ArrayList reservaCircuito(String circuito)
	{
		ArrayList pilotos=new ArrayList();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select fecha,hora,nombre from circuito_piloto;";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				String fecha=rs.getString("fecha");
				String nombre=rs.getString("nombre");
				String hora=rs.getString("hora");
				
				pilotos.add(new CircuitoPiloto(nombre, fecha, hora));
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		return pilotos;
	}
	
	
	public static void main(String[] args) {
		
	
		
	}

}

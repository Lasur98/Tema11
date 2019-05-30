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
	
	public String idCircuito(String nombreCircuito)
	{
		String id_circuito="";
		try 
		{
			Statement st=cn.createStatement();
			String sql="select id_circuito from circuitos where nombre='"+nombreCircuito+"';";
			ResultSet rs=st.executeQuery(sql);
			
			if (rs.next())
				id_circuito=rs.getString("id_circuito");
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		return id_circuito;
	}
	
	public ArrayList reservaCircuito(String id_circuito)
	{
		ArrayList pilotos=new ArrayList();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select fecha,hora,nombre from circuito_piloto where id_circuito='"+id_circuito+"';";
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
	
	public void anyadirPiloto(String id_circuito,String nombre,String dni,String hora,String fecha)
	{
		try 
		{
			Statement st=cn.createStatement();
			String sql="insert into circuito_piloto (id_circuito,dni,fecha,hora,nombre) values"
					+ " ('"+id_circuito+"','"+dni+"','"+fecha+"','"+hora+"','"+nombre+"');";
			st.executeUpdate(sql);
			
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		/*GestorCircuitos gc=new GestorCircuitos();
		//System.out.println(gc.idCircuito("Catalunya"));
		System.out.println(gc.reservaCircuito(gc.idCircuito("Catalunya")));*/
		
	}

}

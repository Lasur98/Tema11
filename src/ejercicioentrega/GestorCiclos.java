package ejercicioentrega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GestorCiclos {
	
	private final static String 
			CAD_CONEX="jdbc:mysql://172.20.101.130/bd_aitor";
	private final static String USER="aitor";
	private final static String PASS="robles";
	private Connection cn;
	
	public  GestorCiclos(){
		
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
	
	public ArrayList<String> nombresCiclos()
	{
		ArrayList<String> ciclos=new ArrayList<String>();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select ID_ciclo from ciclos";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				ciclos.add(rs.getString("ID_ciclo"));
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		return ciclos;
		
		
	}
	
	public ArrayList alumnosCiclo(String ciclo)
	{
		ArrayList alumnos=new ArrayList();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select * from alumnos where ciclo='"+ciclo+"'";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				alumnos.add(rs.getString("dni"+"nombre"+"fechanac"));
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		return alumnos;
	}
	
	
	public static void main(String[] args) {
		
		//GestorCiclos gc=new GestorCiclos();
		
	}

}

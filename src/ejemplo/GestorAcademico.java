package ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GestorAcademico {
	
	private final static String CAD_CONEXION="jdbc:mysql://172.20.101.130/bd_aitor";
	private final static String USER="aitor";
	private final static String PASS="robles";
	
	private Connection cn;
	
	public GestorAcademico()
	{
		//Conectarnos a base de datos
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(CAD_CONEXION,USER,PASS);
			//System.out.println("Conexion:"+cn);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println("No puede registrar JDBC");
		} 
		catch (SQLException e) 
		{

			System.err.println("Error al conectarse a la base de datos");
		}
	}
	
	public float notaMediaEn(String codAsig)
	{
		float media=-1;
		try 
		{
			Statement st=cn.createStatement();
			String sql="select avg(nota) as notamedia from cursa where idasignatura='"+codAsig+"'";
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{
				media=rs.getFloat("notamedia");
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL"+e.getMessage());
		}
		
		return media;
		
	}
	
	public HashMap<String,Integer> mapaTotalesFaltas()
	{
		//Mapa:   111A-----> (2+5)
		
		HashMap<String, Integer> mapa=new HashMap<String, Integer>();
		try 
		{
			Statement st=cn.createStatement();
			String sql="select idalumno,sum(faltas) from cursa group by idalumno";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				mapa.put(rs.getString("idlaumno"),rs.getInt("suma"));
				
			}
			
			rs.close();
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL"+e.getMessage());
		}
		finally
		{
			return mapa;
		}
		
		
	}
	
	public ArrayList<String> subirNotaSinFaltas(String idAsig)
	{
		final int PORCENSUBIDA=25;
		int actualizados=0;
		ArrayList<String> nombresSinFaltas=new ArrayList<String>();
		try 
		{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select nombre from alumnos where dni in (select idalumno from cursa where faltas=0 and idasignatura='LEMA')");
			String sql="update cursa set nota=(nota+nota * "+PORCENSUBIDA/100.0+") where faltas=0 and idasignatura='"+idAsig+"'";
			while(rs.next())
			{
				nombresSinFaltas.add(rs.getString("nombre"));
			}
			rs.close();
			System.out.println(sql);
			actualizados=st.executeUpdate(sql);
			
			
			
			st.close();
		} 
		catch (SQLException e) 
		{
			System.err.println("Error SQL "+e.getMessage());
		}
		finally
		{
			return nombresSinFaltas;
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		GestorAcademico ga=new GestorAcademico();
		//System.out.println(ga.notaMediaEn("LEMA"));
		/*HashMap<String, Integer> mapa=ga.mapaTotalesFaltas();
		Iterator it=mapa.keySet().iterator();
		while(it.hasNext())
		{
			String idAlumno=(String) it.next();
			int faltas_alumno=mapa.get(idAlumno);
			System.out.println(idAlumno+" :"+faltas_alumno+" faltas");
		}*/
		
		//int actualizados=ga.subirNotaSinFaltas("LEMA");
		//System.out.println("Se ha subido la nota a "+actualizados+ " alumnos");
		
		ArrayList<String> nombres=ga.subirNotaSinFaltas("LEMA");
		System.out.println(nombres);
	}
}

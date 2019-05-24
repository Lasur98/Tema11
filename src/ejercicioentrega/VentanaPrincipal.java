package ejercicioentrega;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame{
	
	private VentanaDialogo vd;
	private JList pilotos;
	private JLabel lblfecha,lblHora;
	private JComboBox fechaDia,fechaMes;
	private DefaultListModel listaPilotos;
	private GestorCircuitos gc;
	
	public VentanaPrincipal()
	{
		vd=new VentanaDialogo();
		String circuito=vd.getCurso();
		gc=new GestorCircuitos();
		setTitle("Circuito "+circuito);
		
		//PanelSur
		listaPilotos=cargarPilotos();
		pilotos=new JList(listaPilotos);
		JScrollPane scroll=new JScrollPane(pilotos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scroll, "South");
		
		//Panel Oeste
		JPanel panelOeste=new JPanel();
		lblfecha=new JLabel("Elige dia y mes del año");
		panelOeste.add(lblfecha);
		String[] meses=meses();
		String[] dias=dias();
		fechaMes=new JComboBox(meses);
		fechaDia=new JComboBox(dias);
		fechaDia.setVisible(false);
		panelOeste.add(fechaMes);
		panelOeste.add(fechaDia);
		lblHora=new JLabel("Elige hora: ");
		this.getContentPane().add(panelOeste, "West");
		
		
		//PanelCentro
		
		
		eventos();
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	private void eventos() 
	{
		
		fechaMes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fechaDia.setVisible(true);
			}
		});
		
		fechaDia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}



	private DefaultListModel cargarPilotos() {
		
		DefaultListModel listaAlumnos=new DefaultListModel();
		ArrayList pilotos=gc.reservaCircuito(circuito);
		for(int i=0;i<pilotos.size();i++)
		{
			listaAlumnos.addElement(pilotos.get(i).toString());
		}
		return listaAlumnos;
		
	}
	
	private String[] meses()
	{
		String [] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		return meses;
	}

	private String[] dias()
	{
		String[] dias=new String[32];
		for(int i=1;i<=31;i++)
		{
			dias[i]=String.valueOf(i);
		}
		
		return dias;
	}
	
	public static void main(String[] args) {
		
		new VentanaPrincipal();
	}
}

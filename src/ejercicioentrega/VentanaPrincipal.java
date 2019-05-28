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
	private JComboBox fechaDia,fechaMes,horas,minutos;
	private JButton anyadirPiloto;
	private GestorCircuitos gc;
	
	public VentanaPrincipal()
	{
		vd=new VentanaDialogo();
		String circuito=vd.getCircuito();
		gc=new GestorCircuitos();
		setTitle("Circuito "+circuito);
		
		//PanelSur
		pilotos=new JList();
		pilotos.setVisible(false);
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
		lblHora.setVisible(false);
		panelOeste.add(lblHora);
		horas=new JComboBox(horas());
		minutos=new JComboBox(minutos());
		horas.setVisible(false);
		minutos.setVisible(false);
		panelOeste.add(horas);
		panelOeste.add(minutos);
		this.getContentPane().add(panelOeste, "West");
		
		
		//PanelCentro
		JPanel panelNorte=new JPanel();
		anyadirPiloto=new JButton("Añadir reserva");
		anyadirPiloto.setVisible(false);
		panelNorte.add(anyadirPiloto);
		this.getContentPane().add(panelNorte, "North");
		
		eventos();
		
		setSize(500, 400);
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
				
				lblHora.setVisible(true);
				horas.setVisible(true);
				minutos.setVisible(true);
				//Comprobamos el dia y mes de la lista de pilotos que alquilan el circuito
				ArrayList pilotosCircuito=gc.reservaCircuito(vd.getId_circuito());
				String[] pilotosCircui=new String[pilotosCircuito.size()];
				boolean enFecha=true;
				for(int i=0;i<pilotosCircuito.size();i++)
				{
					CircuitoPiloto cp=(CircuitoPiloto) pilotosCircuito.get(i);
					String[] fecha=cp.getFecha().split("-");
					String mes=mesANumero(fechaMes.getSelectedItem().toString());
					if(fecha[1].equals(mes) && fecha[2].equals(fechaDia.getSelectedItem().toString()))
					{
						pilotosCircui[i]=cp.toString();
					}
					else
						enFecha=false;
						
				}
				if(enFecha==true)
				{
					pilotos.setListData(pilotosCircui);
					pilotos.setVisible(true);
				}
				else
					pilotos.setVisible(false);
				anyadirPiloto.setVisible(true);
				revalidate();
				repaint();
				
			}
		});
		
		anyadirPiloto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hora=horas.getSelectedItem().toString()+":"+minutos.getSelectedItem().toString();
				String diaMes="2019-"+fechaMes.getSelectedItem().toString()+"-"+fechaDia.getSelectedItem().toString();
				new VentanaDialogo2(vd.getId_circuito(),hora,diaMes);
				
			}
		});
		
	}


	private String mesANumero(String mes)
	{
		String[] meses=meses();
		String numeroMes="";
		for(int i=0;i<meses.length;i++)
		{
			String mes1=meses[i].toUpperCase();
			if(mes1.equals(mes.toUpperCase()))
				if(i<10)
				{
					numeroMes="0"+String.valueOf(i+1);
				}
		}
		return numeroMes;
	}

	
	private String[] horas()
	{
		String[] horas=new String[23];
		for(int i=1;i<24;i++)
		{
			if(i<10)
				horas[i-1]="0"+String.valueOf(i);
		}
		return horas;
	}
	
	private String[] minutos()
	{
		String[] minutos=new String[60];
		for(int i=0;i<60;i++)
		{
			if(i<10)
				minutos[i]="0"+String.valueOf(i);
			else
				minutos[i]=String.valueOf(i);
		}
		return minutos;
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
			dias[i-1]=String.valueOf(i);
		}
		
		return dias;
	}
	
	
	
	public static void main(String[] args) {
		
		new VentanaPrincipal();
	}
}

package ejercicioentrega;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaDialogo extends JDialog{
	
	private JLabel lblelegir;
	private JComboBox circuitos;
	private JButton elegir;
	private DefaultComboBoxModel comboCircuitos;
	private GestorCircuitos gc;
	private String circuito;
	
	public VentanaDialogo()
	{
		setTitle("Circuitos");
		setModal(true);
		gc=new GestorCircuitos();
		
		//panelNorte
		JPanel panelNorte=new JPanel();
		lblelegir=new JLabel("Elige circuito a alquilar: ");
		panelNorte.add(lblelegir);
		this.getContentPane().add(panelNorte, "North");
		
		//panel Centro
		JPanel panelCentro=new JPanel();
		comboCircuitos=cargarCombo();
		circuitos=new JComboBox(comboCircuitos);
		
		panelCentro.add(circuitos);
		this.getContentPane().add(panelCentro, "Center");
		
		//Panel Sur
		JPanel panelSur=new JPanel();
		elegir=new JButton("Elegir");
		panelSur.add(elegir);
		this.getContentPane().add(panelSur, "South");
		
		eventos();
		
		pack();
		setVisible(true);
	}

	private void eventos() 
	{
		elegir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				circuito=(String) comboCircuitos.getSelectedItem();
				setVisible(false);
				
			}
		});
		
	}

	public String getCurso() {
		return circuito;
	}

	private DefaultComboBoxModel cargarCombo() {
		
		DefaultComboBoxModel ciclos=new DefaultComboBoxModel();
		ArrayList nomCiclos=gc.nombresCircuitos();
		for(int i=0;i<nomCiclos.size();i++)
		{
			ciclos.addElement(nomCiclos.get(i));
		}
		
		return ciclos;
		
	}

}

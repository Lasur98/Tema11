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
	private JComboBox ciclos;
	private JButton elegir;
	private DefaultComboBoxModel comboCiclos;
	private GestorCiclos gc;
	private String curso;
	
	public VentanaDialogo()
	{
		setTitle("Ciclos");
		setModal(true);
		gc=new GestorCiclos();
		
		//panelNorte
		JPanel panelNorte=new JPanel();
		lblelegir=new JLabel("Elige ciclo");
		panelNorte.add(lblelegir);
		this.getContentPane().add(panelNorte, "North");
		
		//panel Centro
		JPanel panelCentro=new JPanel();
		comboCiclos=cargarCombo();
		ciclos=new JComboBox(comboCiclos);
		
		panelCentro.add(ciclos);
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
				
				curso=(String) comboCiclos.getSelectedItem();
				setVisible(false);
				
			}
		});
		
	}

	public String getCurso() {
		return curso;
	}

	private DefaultComboBoxModel cargarCombo() {
		
		DefaultComboBoxModel ciclos=new DefaultComboBoxModel();
		ArrayList nomCiclos=gc.nombresCiclos();
		for(int i=0;i<nomCiclos.size();i++)
		{
			ciclos.addElement(nomCiclos.get(i));
		}
		
		return ciclos;
		
	}

}

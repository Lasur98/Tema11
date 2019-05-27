package ejercicioentrega;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaDialogo2 extends JDialog{
	
	private JLabel lblNombre,lblDni,lblHora,lblDiaMes;
	private JTextField txtNombre,txtDni,txtHora,txtDiaMes;
	private VentanaDialogo vd;
	private JButton anyadir;

	public VentanaDialogo2(String hora,String fecha)
	{
		setTitle("Añadir reserva");
		setModal(true);
		setLayout(null);
		
		lblNombre=new JLabel("Nombre:");
		lblNombre.setBounds(20, 20, 50, 20);
		this.getContentPane().add(lblNombre);
		txtNombre=new JTextField(10);
		txtNombre.setBounds(80, 20, 100, 20);
		this.getContentPane().add(txtNombre);
		
		lblDni=new JLabel("Dni:");
		lblDni.setBounds(20, 50, 50, 20);
		this.getContentPane().add(lblDni);
		txtDni=new JTextField(10);
		txtDni.setBounds(80, 50, 100, 20);
		this.getContentPane().add(txtDni);
		
		lblHora=new JLabel("Hora:");
		lblHora.setBounds(20, 80, 50, 20);
		this.getContentPane().add(lblHora);
		txtHora=new JTextField(hora);
		txtHora.setEnabled(false);
		txtHora.setBounds(80, 80, 100, 20);
		this.getContentPane().add(txtHora);
		
		lblDiaMes=new JLabel("Mes y dia:");
		lblDiaMes.setBounds(20, 110, 100, 20);
		this.getContentPane().add(lblDiaMes);
		txtDiaMes=new JTextField(fecha);
		txtDiaMes.setEnabled(false);
		txtDiaMes.setBounds(80, 110, 100, 20);
		this.getContentPane().add(txtDiaMes);
		
		anyadir=new JButton("Añadir reserva");
		anyadir.setBounds(70, 150, 150, 30);
		this.getContentPane().add(anyadir);
		
		eventos();
		
		
		
		setSize(300, 250);
		setVisible(true);
	}

	private void eventos() {
		anyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
}

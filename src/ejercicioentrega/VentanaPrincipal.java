package ejercicioentrega;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame{
	
	private VentanaDialogo vd;
	private JList alumnos;
	private JButton faltas;
	
	public VentanaPrincipal()
	{
		vd=new VentanaDialogo();
		String curso=vd.getCurso();
		setTitle("Ciclo "+curso);
		
		//PanelSur
		JPanel panelSur=new JPanel();
		alumnos=new JList();
		JScrollPane scroll=new JScrollPane(alumnos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelSur.add(scroll);
		this.getContentPane().add(panelSur, "South");
		
		
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new VentanaPrincipal();
	}
}

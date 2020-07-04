package zoo_java_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

import zoo_poo.*;
import java.util.ArrayList;

public class Second_View {
	
	//Attributes
	private JPanel panel;
	private JLabel title;
	private JTextField texto;
	private JTextArea arreglo;
	private JButton volver;
	private Border border;
	private JFrame view;
	
	
	//Constructor
	public Second_View(ArrayList<Animal> texto, String titulo) {
		panel = new JPanel(new BorderLayout());
		title = new JLabel("Lista de " + titulo);
		arreglo = new JTextArea();
		getArray(texto);
		
		//Type of Border
		border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
				
		JPanel pNorth = crearPNorth();
		panel.add(pNorth, BorderLayout.NORTH);
		
		JPanel pCenter = crearPCenter();
		panel.add(pCenter, BorderLayout.CENTER);
		
		/*JPanel pSouth = new JPanel();
		pSouth.setLayout(null);
		panel.add(pSouth, BorderLayout.SOUTH);*/
	}
	
	//Method - getJPanel()
	public JPanel getJPanel() {
		return this.panel;
	}
	
	public JFrame getJFrame(JFrame view) {
		return view;
	}
	
	//Method - crearPNorth()
	public JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
		
		p.setBorder(border);
		p.add(title);
		
		return p;
	}
	
	//Method - crearPCenter()
	public JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		//JPanel pArray = crearArreglo();
		p.setBorder(border);
		p.add(arreglo, BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(arreglo);
		p.add(scroll, BorderLayout.CENTER);
		
		return p;
	}
	
	//Method - crearPSouth()
	public JPanel crearPSouth(JButton volver) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		//volver = new JButton("Volver");
		//p.add(volver);
		return p;
	}
	
	//Method - getArray
	public void getArray (ArrayList<Animal> array) {
		String s = "";
		for(int i = 0; i < array.size(); i++) {
			s += array.get(i) + "\n\n";
			System.out.print(array.get(i));
		}
		arreglo.setText(s);;
	}
	
	//Method - retonarPanel()
	public JFrame retornarPanel(JFrame view) {
		view.setContentPane(this.getJFrame(view));
		view.invalidate();
    	view.validate();
    	view.setBounds(390, 150, 600, 330);
		view.setVisible(true);
		
		return view;
	}
}
	

package socket_servidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

//import zoo_poo.*;
import java.util.ArrayList;

public class Second_View {
	
	//Attributes
	private JPanel panel;
	private JLabel titulo;
	private JTextArea lista;
	private Border border;
	private DB db = DB.getInstances();
	
	
	
	public Second_View(String titulo) {
		panel = new JPanel(new BorderLayout());
		this.titulo = new JLabel("Lista de " + titulo);
		this.lista  = new JTextArea();
		
		//Type of Border
		border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
						
		JPanel pNorth = crearPNorth();
		panel.add(pNorth, BorderLayout.NORTH);
				
		JPanel pCenter = crearPCenter();
		panel.add(pCenter, BorderLayout.CENTER);
		
		lista.setText(db.dbStatement("select *from Animal_3 where especie = '" + titulo + "'"));
	}
	
	//Method - getJPanel()
	public JPanel getJPanel() {
		return this.panel;
	}
	
	
	//Method - crearPNorth()
	public JPanel crearPNorth() {
		JPanel p = new JPanel(new FlowLayout());
			
		p.setBorder(border);
		p.add(this.titulo);
			
		return p;
	}
	
	
	//Method - crearPCenter()
	public JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
			
		//JPanel pArray = crearArreglo();
		p.setBorder(border);
		p.add(this.lista, BorderLayout.CENTER);
			
		JScrollPane scroll = new JScrollPane(this.lista);
		p.add(scroll, BorderLayout.CENTER);
			
		return p;
	}

}

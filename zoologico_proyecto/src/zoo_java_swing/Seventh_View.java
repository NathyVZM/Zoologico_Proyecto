package zoo_java_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import zoo_poo.*;

public class Seventh_View {
	
	//Attributes
	private JPanel panel;
	private JTextField nombre, color, habitat, accion, cantidad;
	private JLabel lbnombre, lbcolor, lbhabitat, lbaccion, lbcantidad, title;
	private JButton pez;
	private JLabel confirmar;
		
	String name = "";
	String colors = "";
	String hogar = "";
	String acto = "";
	int entero = 0;
	
	public Seventh_View(ArrayList<Animal> array) {
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Ingresar Pez");
		title.setBounds(235, -140, 200, 300);
		panel.add(title);
		
		//NOMBRE
		lbnombre = new JLabel("Nombre");
		nombre = new JTextField();
		
		lbnombre.setBounds(80, -100, 200, 300);
		nombre.setBounds(140, 40, 300, 25);
		
		panel.add(lbnombre);
		panel.add(nombre);
		
		//COLOR
		lbcolor = new JLabel("Color");
		color = new JTextField();
		
		lbcolor.setBounds(80, -50, 200, 300);
		color.setBounds(140, 90, 300, 25);
		
		panel.add(lbcolor);
		panel.add(color);
		
		//HABITTA
		lbhabitat = new JLabel("Habitat");
		habitat = new JTextField();
		
		lbhabitat.setBounds(80, 0, 200, 300);
		habitat.setBounds(140, 140, 300, 25);
		
		panel.add(lbhabitat);
		panel.add(habitat);
		
		//ACCION
		lbaccion = new JLabel("Accion");
		accion = new JTextField();
		
		lbaccion.setBounds(80, 50, 200, 300);
		accion.setBounds(140, 190, 300, 25);
		
		panel.add(lbaccion);
		panel.add(accion);
		
		//CANTIDAD
		lbcantidad = new JLabel("Cantidad");
		cantidad = new JTextField();
		
		lbcantidad.setBounds(80, 100, 200, 300);
		cantidad.setBounds(140, 240, 300, 25);
		
		panel.add(lbcantidad);
		panel.add(cantidad);
		
		//BOTON - MAMIFERO
		pez = new JButton("Ingresa Pez");
		pez.setBounds(220, 300, 140, 25);
		
		panel.add(pez);
		
		confirmar = new JLabel("Se ha ingresado correctamente :)");
		confirmar.setBounds(192, 210, 200, 300);
		panel.add(confirmar);
		confirmar.setVisible(false);
		
		pez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = nombre.getText();
				colors = color.getText();
				hogar = habitat.getText();
				acto = accion.getText();
				String numero = cantidad.getText();
				entero = Integer.parseInt(numero);
				
				Animal new_pez = new Pez(name, colors);
				new_pez.setHabitat(hogar);
				new_pez.setAccion(acto);
				new_pez.setCantidad(entero);
				
				array.add(new_pez);
				confirmar.setVisible(true);
			}
		});
	}
	
	//Method - getJPanel()
		public JPanel getJPanel() {
			return this.panel;
		}

}

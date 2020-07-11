package zoo_bd;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

//import zoo_poo.*;

public class Third_View {
	
	//Attributes
	private JPanel panel;
	private JLabel title, lbnombreC, lbnombre, lbcolor, lbhabitat, lbaccion, lbcantidad, lbbuscar, error, errorC;
	private JTextField nombreC, nombre, color, habitat, accion, cantidad, buscarN, buscarNC;
	private JButton ingresar, modificar, eliminar, buscar;
	private JLabel iconfirmar, mconfirmar, econfirmar;
	
	private JLabel indicarB1, indicarB2;
	
	private Border border1;
	
	
	/*private String driverDB = "org.postgresql.Driver";
    private String dbName = "Animal";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "NathalieZambrano";*/
    
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;
    
    DB db = DB.getInstances();
	
	
	public Third_View(String especie) {
		panel  = new JPanel ();
		panel.setLayout(null);
		
		
		//TITLE
		title = new JLabel("Editar " + especie);
		title.setBounds(250, -135, 200, 300);
		
		panel.add(title);
		
		//Type of Border
		border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		panel.setBorder(border1);
		
		
		//NOMBRE
		lbnombre = new JLabel("Nombre: ");
		nombre = new JTextField();
		nombre.setBorder(border1);
				
		lbnombre.setBounds(90, -100, 200, 300);
		nombre.setBounds(150, 40, 300, 25);
				
		panel.add(lbnombre);
		panel.add(nombre);
		
		
		//NOMBRE_CIENTIFICO
		lbnombreC = new JLabel ("Nombre Cientifico: ");
		nombreC = new JTextField();
		nombreC.setBorder(border1);
		
		lbnombreC.setBounds(35, -50, 200, 300);
		nombreC.setBounds(150, 90, 300, 25);
		
		panel.add(lbnombreC);
		panel.add(nombreC);
		
		
		//COLOR
		lbcolor = new JLabel("Color: ");
		color = new JTextField();
		color.setBorder(border1);
		
		lbcolor.setBounds(105, 0, 200, 300);
		color.setBounds(150, 140, 300, 25);
		
		panel.add(lbcolor);
		panel.add(color);
		
		
		//HABITAT
		lbhabitat = new JLabel("Habitat: ");
		habitat = new JTextField();
		habitat.setBorder(border1);
				
		lbhabitat.setBounds(95, 50, 200, 300);
		habitat.setBounds(150, 190, 300, 25);
				
		panel.add(lbhabitat);
		panel.add(habitat);
		
		
		//ACCION
		lbaccion = new JLabel("Accion: ");
		accion = new JTextField();
		accion.setBorder(border1);
				
		lbaccion.setBounds(95, 100, 200, 300);
		accion.setBounds(150, 240, 300, 25);
				
		panel.add(lbaccion);
		panel.add(accion);
		
		
		//CANTIDAD
		lbcantidad = new JLabel("Cantidad: ");
		cantidad = new JTextField();
		cantidad.setBorder(border1);
				
		lbcantidad.setBounds(85, 150, 200, 300);
		cantidad.setBounds(150, 290, 300, 25);
				
		panel.add(lbcantidad);
		panel.add(cantidad);
		
		
		//BOTON - INGRESAR
		ingresar = new JButton("Ingresar");
		ingresar.setBounds(80, 365, 100, 25);
				
		panel.add(ingresar);
		
		
		//BOTON - MODIFICAR
		modificar = new JButton("Modificar");
		modificar.setBounds(250, 365, 100, 25);
		
		panel.add(modificar);
		
		
		//BOTON - ELIMINAR
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(420, 365, 100, 25);
				
		panel.add(eliminar);
		
		
		//BUSCAR
		lbbuscar = new JLabel("Ingrese " + especie + " a Buscar: ");
		
		buscarN = new JTextField();
		buscarNC = new JTextField();
		buscarN.setBorder(border1);
		buscarNC.setBorder(border1);
		
		buscar = new JButton("Buscar");
		
		indicarB1 = new JLabel("· Campo #1: Nombre");
		indicarB2 = new JLabel("· Campo #2: Nombre Cientifico");
		
		lbbuscar.setBounds(40, 275, 200, 300);
		buscarN.setBounds(210, 415, 150, 25);
		buscarNC.setBounds(390, 415, 150, 25);
		buscar.setBounds(320, 470, 100, 25);
		indicarB1.setBounds(42, 305, 200, 300);
		indicarB2.setBounds(42, 325, 200, 300);
		
		panel.add(lbbuscar);
		panel.add(buscarN);
		panel.add(buscarNC);
		panel.add(buscar);
		panel.add(indicarB1);
		panel.add(indicarB2);
		
		//LABEL - ICONFIRMAR
		iconfirmar = new JLabel("Animal Ingresado");
		iconfirmar.setBounds(240, 187, 200, 300);
		panel.add(iconfirmar);
		iconfirmar.setVisible(false);
		
		
		//LABEL - MCONFIRMAR
		mconfirmar = new JLabel("Modificacion Exitosa");
		mconfirmar.setBounds(240, 190, 200, 300);
		panel.add(mconfirmar);
		mconfirmar.setVisible(false);
		
		//LABEL - ECONFIRMAR
		econfirmar = new JLabel ("Animal Eliminado");
		econfirmar.setBounds(250, 190, 200, 300);
		panel.add(econfirmar);
		econfirmar.setVisible(false);
		
		
		//LABEL - ERROR
		error = new JLabel ("Animal No Disponible");
		error.setBounds(240, 190, 200, 300);
		panel.add(error);
		error.setVisible(false);
		
		//LABEL - ERRORC
		errorC = new JLabel("Animal Ya Registrado");
		errorC.setBounds(240, 190, 200, 300);
		panel.add(errorC);
		errorC.setVisible(false);
		
		
		
		//LISTENER - ingresar
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 db.dbPrepareStatement(nombreC, nombre, especie, color, habitat, accion, cantidad, iconfirmar, errorC);
					 mconfirmar.setVisible(false);
					 error.setVisible(false);
					 econfirmar.setVisible(false);
					 
				 }catch(Exception sqle) {
					 sqle.printStackTrace();
				 }
			}
		});
		
		
		//LISTENER - buscar
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.dbBuscar(nombreC, nombre, especie, color, habitat, accion, cantidad, buscarN, buscarNC, error);
					 iconfirmar.setVisible(false);
					 mconfirmar.setVisible(false);
					 econfirmar.setVisible(false);
					 errorC.setVisible(false);
					
				}catch(Exception sqle) {
					error.setVisible(true);
					sqle.printStackTrace();
				}
			}
		});
		
		
		//LISTENER - modificar
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.dbModificar(buscarN, buscarNC, nombreC, nombre, especie, color, habitat, accion, cantidad);
					mconfirmar.setVisible(true);
					iconfirmar.setVisible(false);
					econfirmar.setVisible(false);
					error.setVisible(false);
					error.setVisible(false);
					
				}catch(Exception sqle) {
					sqle.printStackTrace();
				}
			}
		});
		
		
		//LISTENER - eliminar
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.dbEliminar(buscarN, nombreC, nombre, color, habitat, accion, cantidad);
					econfirmar.setVisible(true);
					iconfirmar.setVisible(false);
					mconfirmar.setVisible(false);
					error.setVisible(false);
					
				}catch(Exception sqle) {
					sqle.printStackTrace();
				}
			}
		});
		
	}
	
	
	//Method - getJPanel()
	public JPanel getJPanel() {
				return this.panel;
	}
}

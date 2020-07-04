package zoo_java_swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import zoo_poo.*;

public class Zoo_Menu {
	
	//Attributes
	private JFrame view;
	private JButton op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
	private JButton bIngresar, bZoo, volver;
	private JLabel nombre, gerente, title;
	private JTextField tfGerente;
	private JTextField tfZoo;
	private JPanel panel;
	private JTextField tfname;
	
	private Border border;
	
	public Zoo_Menu() {
		
		//Mamifero
		Animal leon = new Mamifero("Leon", "Amarillo");
		leon.setHabitat("Tierra (Selva)");
		leon.setCantidad(10);
		leon.setAccion("Caminar");
		
		Animal tigre = new Mamifero("Tigre", "Blanco");
		tigre.setHabitat("Tierra (Selva)");
		tigre.setCantidad(12);
		tigre.setAccion("Caminar");
		
		Animal delfin = new Mamifero("Delfin", "Rosa");
		delfin.setHabitat("Agua (Mar/Oceano)");
		delfin.setCantidad(8);
		delfin.setAccion("Nadar");
		
		//ArrayList - Mamifero
		ArrayList <Animal> mamiferos = new ArrayList<Animal>();
		mamiferos.add(leon);
		mamiferos.add(tigre);
		mamiferos.add(delfin);
		
		
		//Aves
		Animal perico = new Ave("Perico", "Verde");
		perico.setHabitat("Tierra (Selva)");
		perico.setCantidad(15);
		perico.setAccion("Volar");
				
		Animal loro = new Ave("Loro", "Rojo\n       Amarillo\n       Azul");
		loro.setHabitat("Tierra (Selva)");
		loro.setCantidad(11);
		loro.setAccion("Volar");
				
		Animal pato = new Ave("Pato", "Blanco");
		pato.setHabitat("Agua (Estanques, Lagos)");
		pato.setCantidad(18);
		pato.setAccion("Nadar\n             Caminar");
				
		//ArrayList - Ave
		ArrayList <Animal> aves = new ArrayList<Animal>();
		aves.add(perico);
		aves.add(loro);
		aves.add(pato);
		
		
		//Reptiles
		Animal caiman = new Reptil("Caiman", "Verde");
		caiman.setHabitat("Pantano");
		caiman.setCantidad(7);
		caiman.setAccion("Nadar");
				
		Animal vibora = new Reptil("Vibora", "Marron");
		vibora.setHabitat("Tierra (Selva, Desierto)");
		vibora.setCantidad(6);
		vibora.setAccion("Reptar");
				
		Animal tortuga = new Reptil ("Tortuga", "Verde");
		tortuga.setHabitat("Agua (Estanques, Lagos)");
		tortuga.setCantidad(10);
		tortuga.setAccion("Caminar");
				
		//ArrayList - Reptil
		ArrayList <Animal> reptiles = new ArrayList<Animal>();
		reptiles.add(caiman);
		reptiles.add(vibora);
		reptiles.add(tortuga);
		
		
		//Anfibios
		Animal rana = new Anfibio("Rana", "Verde");
		rana.setHabitat("Agua (Lago, Rios)");
		rana.setCantidad(12);
		rana.setAccion("Nadar\n             Saltar");
				
		Animal sapo = new Anfibio("Sapo", "Marron");
		sapo.setHabitat("Agua (Aguas Estancadas)");
		sapo.setCantidad(10);
		sapo.setAccion("Nadar\n             Saltar");
				
		Animal triton = new Anfibio ("Triton", "Amarillo");
		triton.setHabitat("Agua (Lagunas, Arroyos)");
		triton.setCantidad(13);
		triton.setAccion("Caminar\n             Nadar");
				
		//ArrayList - Anfibio
		ArrayList <Animal> anfibios = new ArrayList<Animal>();
		anfibios.add(rana);
		anfibios.add(sapo);
		anfibios.add(triton);
		
		//Peces
		Animal salmon = new Pez("Salmon", "Rosa");
		salmon.setHabitat("Mar, Oceano");
		salmon.setCantidad(20);
		salmon.setAccion("Nadar");
				
		Animal tiburon = new Pez("Tiburon", "Gris");
		tiburon.setHabitat("Agua (Mar, Oceano)");
		tiburon.setCantidad(9);
		tiburon.setAccion("Nadar");
				
		Animal pez_espada = new Pez("Pez\n             Espada", "Gris");
		pez_espada.setHabitat("Agua (Mar, Oceano)");
		pez_espada.setCantidad(9);
		pez_espada.setAccion("Nadar");
				
		//ArrayList - Pez
		ArrayList <Animal> peces = new ArrayList<Animal>();
		peces.add(salmon);
		peces.add(tiburon);
		peces.add(pez_espada);
		
		//FRAME
		view = new JFrame("Menu de Zoologico");
		panel = new JPanel(new BorderLayout());
		view.add(panel);
		
		op1 = new JButton("1. Mostrar Lista de Mamiferos");
		op1.setBounds(80, 150, 210, 30);
		panel.add(op1); 
		
		op2 = new JButton("2. Mostrar Lista de Aves");
		op2.setBounds(290, 150, 210, 30);
		panel.add(op2);
		
		op3 = new JButton("3. Mostrar Lista de Reptiles");
		op3.setBounds(80, 180, 210, 30);
		panel.add(op3);
		
		op4 = new JButton("4. Mostrar Lista de Anfibios");
		op4.setBounds(290, 180, 210, 30);
		panel.add(op4);
		
		op5 = new JButton("5. Mostrar Lista de Peces");
		op5.setBounds(80, 210, 210, 30);
		panel.add(op5);
		
		op6 = new JButton("6. Ingresar un Mamifero");
		op6.setBounds(290, 210, 210, 30);
		panel.add(op6);
		
		op7 = new JButton("7. Ingresar un Ave");
		op7.setBounds(80, 240, 210, 30);
		panel.add(op7);
		
		op8 = new JButton("8. Ingresar un Reptil");
		op8.setBounds(290, 240, 210, 30);
		panel.add(op8);
		
		op9 = new JButton("9. Ingresar un Anfibio");
		op9.setBounds(80, 270, 210, 30);
		panel.add(op9);
		
		op10 = new JButton("10. Ingresar un Pez");
		op10.setBounds(290, 270, 210, 30);
		panel.add(op10);
		
		/*title = new JLabel(".:MENU DEL ZOO:.");
		title.setBounds(240, 110, 210, 30);
		view.add(title);*/
		
		//Type of Border
		border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
		//NORTH
		JPanel pNorth = crearPNorth();
		panel.add(pNorth, BorderLayout.NORTH);
		
		//CENTER
		JPanel pCenter = crearPCenter();
		panel.add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = crearPSouth();
		panel.add(pSouth, BorderLayout.SOUTH);
		
		//Listeners
		op1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_View mamifero = new Second_View(mamiferos, "Mamiferos");
				view.setContentPane(mamifero.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 200, 80, 20);
				mamifero.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_View ave = new Second_View(aves, "Aves");
				view.setContentPane(ave.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 250, 80, 20);
				ave.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_View reptil = new Second_View(reptiles, "Reptiles");
				view.setContentPane(reptil.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 250, 80, 20);
				reptil.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});

		op4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_View anfibio = new Second_View(anfibios, "Anfibios");
				view.setContentPane(anfibio.getJPanel());
				
				volver = new JButton("Volver");
				volver.setBounds(480, 250, 80, 20);
				anfibio.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_View pez = new Second_View(peces, "Peces");
				view.setContentPane(pez.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 250, 80, 20);
				pez.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Third_View ingresar = new Third_View(mamiferos);
				
				view.setContentPane(ingresar.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(490, 300, 80, 25);
				ingresar.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fourth_View ingresar = new Fourth_View(aves);
				
				view.setContentPane(ingresar.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(490, 300, 80, 25);
				ingresar.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fifth_View ingresar = new Fifth_View(reptiles);
				
				view.setContentPane(ingresar.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(490, 300, 80, 25);
				ingresar.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sixth_View ingresar = new Sixth_View(anfibios);
				
				view.setContentPane(ingresar.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(490, 300, 80, 25);
				ingresar.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		op10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seventh_View ingresar = new Seventh_View(peces);
				
				view.setContentPane(ingresar.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(490, 300, 80, 25);
				ingresar.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		
		view.setBounds(390, 150, 600, 460);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//Method - crearPNorth
	private JPanel crearPNorth() {
		JPanel p = new JPanel(new BorderLayout());
		
		//Border - Gerente
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Gerente:.");
		p.setBorder(titleborder);
		
		tfGerente = new JTextField();
		p.add(tfGerente, BorderLayout.CENTER);
		
		bIngresar = new JButton("Ingresar");
		p.add(bIngresar, BorderLayout.EAST);
		
		gerente = new JLabel(" Nombre :   ");
		p.add(gerente, BorderLayout.WEST);
		
		JPanel pZoo = panelZoo();
		p.add(pZoo, BorderLayout.SOUTH);
		
		return p;
	}
	
	//Method - panelZoo()
	private JPanel panelZoo() {
		JPanel pZoo = new JPanel(new BorderLayout());
		
		//Border - Gerente
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Nombre del Zoo:.");
		pZoo.setBorder(titleborder);
		
		tfZoo = new JTextField();
		pZoo.add(tfZoo, BorderLayout.CENTER);
		
		nombre = new JLabel(" Nombre :   ");
		pZoo.add(nombre, BorderLayout.WEST);
		
		bZoo = new JButton("Ingresar");
		pZoo.add(bZoo, BorderLayout.EAST);
		
		return pZoo;
	}
	
	
	//Method - crearPCenter
	private JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		//Border
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "MENU:.");
		p.setBorder(titleborder);
		
		JPanel ptitulo = panelTitulo();
		p.add(ptitulo, BorderLayout.NORTH);
		
		return p;
	}
	
	//Method - panelTitulo()
	private JPanel panelTitulo() {
		JPanel ptitulo = new JPanel(new FlowLayout());
		
		title = new JLabel(".:MENU DEL ZOO:.");
		ptitulo.add(title);
		
		return ptitulo;
	}
	
	//Method - crearPSouth()
	private JPanel crearPSouth() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBounds(390, 150, 600, 400);
		
		JLabel datos = new JLabel("  Datos:       ");
		List nombreG = new List();
		//List nombreZ = new List();
		
		p.add(nombreG, BorderLayout.CENTER);
		p.add(datos, BorderLayout.WEST);
		//p.add(nombreZ, BorderLayout.SOUTH);
		
		
		bIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tfGerente.getText();
				
				nombreG.add(s);
				
				tfGerente.requestFocus();
			}
		});
		
		
		bZoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tfZoo.getText();
				
				nombreG.add(s);
			}
		});
		
		
		//Border
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "ZOO:.");
		p.setBorder(titleborder);
		
		return p;
	}
}

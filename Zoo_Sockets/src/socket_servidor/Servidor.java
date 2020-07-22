package socket_servidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.*;

//import zoo_bd.DB;

import java.io.*;
import java.net.*;

public class Servidor implements Runnable {
	
	private JFrame view;
	private JButton op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
	private JButton bIngresar, bZoo, volver;
	private JLabel nombre, gerente, title, indicarM, indicarM1, indicarM2, indicarM3;
	private JTextField tfGerente;
	private JTextField tfZoo;
	private JPanel panel;
	private Border border;
	private DB db = DB.getInstances();
	
	public Servidor() {
		//FRAME
		view = new JFrame("Servidor_Zoologico");
		panel = new JPanel(new BorderLayout());
		view.add(panel);
		
		op1 = new JButton("1. Mostrar Lista de Mamiferos");
		op1.setBounds(85, 150, 210, 30);
		panel.add(op1); 
		
		op2 = new JButton("2. Mostrar Lista de Aves");
		op2.setBounds(295, 150, 210, 30);
		panel.add(op2);
		
		op3 = new JButton("3. Mostrar Lista de Reptiles");
		op3.setBounds(85, 180, 210, 30);
		panel.add(op3);
		
		op4 = new JButton("4. Mostrar Lista de Anfibios");
		op4.setBounds(295, 180, 210, 30);
		panel.add(op4);
		
		op5 = new JButton("5. Mostrar Lista de Peces");
		op5.setBounds(85, 210, 210, 30);
		panel.add(op5);
		
		op6 = new JButton("6. Editar Mamiferos");
		op6.setBounds(295, 210, 210, 30);
		panel.add(op6);
		
		op7 = new JButton("7. Editar Aves");
		op7.setBounds(85, 240, 210, 30);
		panel.add(op7);
		
		op8 = new JButton("8. Editar Reptiles");
		op8.setBounds(295, 240, 210, 30);
		panel.add(op8);
		
		op9 = new JButton("9. Editar Anfibios");
		op9.setBounds(85, 270, 210, 30);
		panel.add(op9);
		
		op10 = new JButton("10. Editar Peces");
		op10.setBounds(295, 270, 210, 30);
		panel.add(op10);
		
		indicarM = new JLabel(".:NOTA:.");
		indicarM.setBounds(270, 175, 200, 300);
		panel.add(indicarM);
		
		indicarM1 = new JLabel("Para Modificar o Eliminar un Animal, primero ingrese el animal a buscar");
		indicarM1.setBounds(90, 205, 1000, 300);
		panel.add(indicarM1);
		
		indicarM2 = new JLabel("en la seccion de 'EDITAR X', para luego ejecutar las acciones deseadas.");
		indicarM2.setBounds(90, 225, 1000, 300);
		panel.add(indicarM2);
		
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
				Second_View mamifero = new Second_View("Mamifero");
				view.setContentPane(mamifero.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
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
				Second_View ave = new Second_View("Ave");
				view.setContentPane(ave.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
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
				Second_View reptil = new Second_View("Reptil");
				view.setContentPane(reptil.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
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
				Second_View anfibio = new Second_View("Anfibio");
				view.setContentPane(anfibio.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
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
				Second_View pez = new Second_View("Pez");
				view.setContentPane(pez.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
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
				Third_View im = new Third_View("Mamifero");
				view.setContentPane(im.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
				im.getJPanel().add(volver, BorderLayout.SOUTH);
				
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
				Third_View ia = new Third_View("Ave");
				view.setContentPane(ia.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
				ia.getJPanel().add(volver, BorderLayout.SOUTH);
				
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
				Third_View ir = new Third_View("Reptil");
				view.setContentPane(ir.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
				ir.getJPanel().add(volver, BorderLayout.SOUTH);
				
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
				Third_View ian = new Third_View("Anfibio");
				view.setContentPane(ian.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
				ian.getJPanel().add(volver, BorderLayout.SOUTH);
				
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
				Third_View ip = new Third_View("Pez");
				view.setContentPane(ip.getJPanel());
				volver = new JButton("Volver");
				volver.setBounds(480, 470, 80, 25);
				ip.getJPanel().add(volver, BorderLayout.SOUTH);
				
				volver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setContentPane(panel);
					}
				});
				
	        	view.invalidate();
	        	view.validate();
			}
		});
		
		view.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//view.setVisible(false);
				view.dispose();
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
		view.setBounds(660, 170, 600, 550);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//END_CLASS
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor = new ServerSocket(2000);
			
			while(true) {
				Socket socket = servidor.accept();
				
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
				
				String mensaje_recibido = entrada.readUTF();
				
				/*if (mensaje_recibido.equalsIgnoreCase("Hola")) {
					String mensaje_envio = "Como Estas";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					salida.writeUTF(mensaje_envio);
					salida.close();
				}*/
				String [] animal = mensaje_recibido.split(" ", 2);
				String [] animal2 = mensaje_recibido.split(" ", 3);
				
				if(mensaje_recibido.equalsIgnoreCase("/Mostrar")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Limpiar")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Mostrar Mamiferos")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where especie = 'Mamifero'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Mostrar Aves")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where especie = 'Ave'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Mostrar Reptiles")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where especie = 'Reptil'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Mostrar Anfibios")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where especie = 'Anfibio'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(mensaje_recibido.equalsIgnoreCase("/Mostrar Peces")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where especie = 'Pez'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if (animal[0].equalsIgnoreCase("/Buscar")) {
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where nombre = '" + animal[1] + "'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(animal2[0].equalsIgnoreCase("/BuscarNC")){
					String mensaje_envio = "";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					mensaje_envio = db.dbStatement("select *from Animal_3 where nombre = '" + animal2[1] + "' and nombreC = '" + animal2[2] + "'");
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				else if(animal2[0].equalsIgnoreCase("/Eliminar")){
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					db.dbEliminarSocket("delete from Animal_3 where nombre = '" + animal2[1] + "' and nombreC = '" + animal2[2] + "'");
					String eliminado = "Animal Eliminado\n";
					salida.writeUTF(eliminado);
					salida.close();
				}
				
				else {
					String mensaje_envio = "Comando no Admitido\n";
					DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
					salida.writeUTF(mensaje_envio);
					salida.close();
				}
				
				entrada.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//END_THREAD
	
	
	// Method - crearPNorth
	private JPanel crearPNorth() {
		JPanel p = new JPanel(new BorderLayout());

		// Border - Gerente
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Gerente:.");
		p.setBorder(titleborder);

		tfGerente = new JTextField();
		p.add(tfGerente, BorderLayout.CENTER);

		bIngresar = new JButton("Ingresar");
		p.add(bIngresar, BorderLayout.EAST);

		gerente = new JLabel("  Nombre :   ");
		p.add(gerente, BorderLayout.WEST);

		JPanel pZoo = panelZoo();
		p.add(pZoo, BorderLayout.SOUTH);

		return p;
	}

	// Method - panelZoo()
	private JPanel panelZoo() {
		JPanel pZoo = new JPanel(new BorderLayout());

		// Border - Gerente
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Nombre del Zoologico:.");
		pZoo.setBorder(titleborder);

		tfZoo = new JTextField();
		pZoo.add(tfZoo, BorderLayout.CENTER);

		nombre = new JLabel("  Titulo :   ");
		pZoo.add(nombre, BorderLayout.WEST);

		bZoo = new JButton("Ingresar");
		pZoo.add(bZoo, BorderLayout.EAST);

		return pZoo;
	}

	// Method - crearPCenter
	private JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());

		// Border
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "MENU:.");
		p.setBorder(titleborder);

		JPanel ptitulo = panelTitulo();
		p.add(ptitulo, BorderLayout.NORTH);

		return p;
	}

	// Method - panelTitulo()
	private JPanel panelTitulo() {
		JPanel ptitulo = new JPanel(new FlowLayout());

		title = new JLabel(".:MENU DEL ZOOLOGICO:.");
		ptitulo.add(title);

		return ptitulo;
	}

	// Method - crearPSouth()
	private JPanel crearPSouth() {
		JPanel p = new JPanel(new BorderLayout());
		p.setBounds(390, 150, 600, 400);

		JLabel datos = new JLabel("  Nombre :    ");
		JTextField nombreG = new JTextField();
		JButton eliminarG = new JButton("Eliminar");

		// List nombreZ = new List();

		JPanel pList = panel_List();

		p.add(nombreG, BorderLayout.CENTER);
		p.add(pList, BorderLayout.SOUTH);
		p.add(datos, BorderLayout.WEST);
		p.add(eliminarG, BorderLayout.EAST);
		// p.add(nombreZ, BorderLayout.SOUTH);

		bIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tfGerente.getText();

				nombreG.setText(s);

				tfGerente.setText("");
				nombreG.requestFocus();
			}
		});

		eliminarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfGerente.setText(nombreG.getText());

				nombreG.setText("");
				tfGerente.requestFocus();
			}
		});

		// Border
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Gerente:.");
		p.setBorder(titleborder);

		return p;
	}
	
	// Method - panel_List()
	private JPanel panel_List() {
		JPanel p = new JPanel(new BorderLayout());

		JLabel titulo = new JLabel("  Titulo :    ");
		JTextField nombreZ = new JTextField();
		JButton eliminarZ = new JButton("Eliminar");

		// Border
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "ZOO:.");
		p.setBorder(titleborder);

		p.add(titulo, BorderLayout.WEST);
		p.add(nombreZ, BorderLayout.CENTER);
		p.add(eliminarZ, BorderLayout.EAST);

		bZoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tfZoo.getText();

				nombreZ.setText(s);

				tfZoo.setText("");
				nombreZ.requestFocus();
			}
		});

		eliminarZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfZoo.setText(nombreZ.getText());

				nombreZ.setText("");

				tfZoo.requestFocus();
			}
		});

		return p;
	}
}

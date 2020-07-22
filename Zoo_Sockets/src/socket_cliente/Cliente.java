package socket_cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import org.omg.CORBA.Request;

import java.io.*;
import java.net.*;

public class Cliente {
	
	//Attributes
	private JFrame view;
	private JPanel panel;
	private JTextArea texto;
	private JTextField comando, ip;
	private JButton bEnviar, bHelp;
	private JLabel l_ip;
	private Border border;
	
	public Cliente() {
		//VIEW AND MAIN PANEL
		view = new JFrame("Cliente_Zoologico");
		panel = new JPanel(new BorderLayout());
		view.add(panel);
		
		//BORDER
		border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
		//PANELS
		JPanel pNorth = crearPNorth();
		JPanel pCenter = crearPCenter();
		JPanel pSouth = crearPSouth();
		
		//ADD PANELS
		panel.add(pNorth, BorderLayout.NORTH);
		panel.add(pCenter, BorderLayout.CENTER);
		panel.add(pSouth, BorderLayout.SOUTH);
		
		bEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					//while(true) {
						Socket cliente = new Socket("10.15.37.135", 2000);
						DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
						salida.writeUTF(comando.getText());
						System.out.println("Enviando Mensaje...");
						//salida.close();
						
						//while(true) {
							DataInputStream entrada  = new DataInputStream(cliente.getInputStream());
							String mensaje_server = entrada.readUTF();
							texto.setText(mensaje_server + "\n");
							//entrada.close();
						//}
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		bHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ayuda = "\t\t                    .:AYUDA:.\n\n  /Mostrar  =  Mostrar Lista completa de Animales\n"
						+ "  /Mostrar  *<Especie>  =  Mostrar Lista de Animales de la especie introducida\n"
						+ "  /Buscar *<Nombre>  =  Mostrar Datos de Animal indicado por su <Nombre>\n"
						+ "  /BuscarNC *<Nombre> *<NombreC>  =  Mostrar datos de Animal indicado por su <Nombre> y <NombreC>\n"
						+ "  /Limpiar  =  Limpiar Chat\n"
						+ "  /Eliminar *<Nombre> *<NombreC>  =  Eliminar Animal indicado por su <Nombre> y <NombreC>\n\n"
						+ "  *<Especie>  =  Mamiferos, Aves, Reptiles, Anfibios, Peces\n"
						+ "  *<Nombre>  =  Nombre del Animal. Ej: Leon, Tigre, Canario\n"
						+ "  *<NombreC>  =  Nombre Cientifico del Animal\n";
				
				texto.setText(ayuda);
			}
		});
		
		view.setBounds(25, 170, 550, 550);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//END OF CLASS
	
	
	//METHOD - crearPNorth()
	private JPanel crearPNorth() {
		JPanel p = new JPanel(new BorderLayout());
		
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "IP del Usuario :.");
		p.setBorder(titleborder);
		
		l_ip =  new JLabel ("  IP :   ");
		p.add(l_ip, BorderLayout.WEST);
		
		ip = new JTextField();
		ip.setBorder(border);
		
		String ip_local = "";
		
		try {
			ip_local = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ip.setText(ip_local);
		p.add(ip, BorderLayout.CENTER);
		
		return p;
	}
	
	//METHOD - crearPCenter()
	private JPanel crearPCenter() {
		JPanel p = new JPanel(new BorderLayout());
		
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "CHAT:.");
		p.setBorder(titleborder);
		
		texto = new JTextArea();
		texto.setBorder(border);;
		p.add(texto, BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(this.texto);
		p.add(scroll, BorderLayout.CENTER);
		
		return p;
	}
	
	//METHOD - crearPSouth()
	private JPanel crearPSouth() {
		JPanel p = new JPanel(new BorderLayout());
		
		TitledBorder titleborder = BorderFactory.createTitledBorder(border, "Comandos:.");
		p.setBorder(titleborder);
		
		bHelp = new JButton("Ayuda");
		p.add(bHelp, BorderLayout.WEST);
		
		comando = new JTextField();
		comando.setBorder(border);
		p.add(comando, BorderLayout.CENTER);
		
		bEnviar = new JButton("Enviar");
		p.add(bEnviar, BorderLayout.EAST);
		
		return p;
	}
}

package zoo_bd;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import zoo_poo.*;

public class DB {
    //Attributes
    public static DB DB = new DB();
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;
    private String driverDB = "org.postgresql.Driver";
    private String dbName = "Zoologico";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "NathalieZambrano";
    public String s = "";
    
    public DB(){
    	try {
    	Class.forName(driverDB);
    	conn = DriverManager.getConnection(urlDB, userDB, passDB);
    	System.out.println("Conexion establecida");
    	} catch (ClassNotFoundException | SQLException e) {
    	    e.printStackTrace();
    	}
    }

    public static DB getInstances() {
        return DB;
    }

    
    public String dbStatement(String query) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            s = "";
            while(rs.next()) {
            	
            	/*String nombre = rs.getString("nombre");
            	lista.add(nombre);*/
                System.out.println(rs.getString("nombre") + "	" + rs.getString("especie") + "\n" + rs.getString("color") + "	" + rs.getString("habitat") + "\n" + rs.getString("accion") + "	" + rs.getInt("cantidad") + "\n\n");
               
               s += "Nombre: " + rs.getString("nombre") +  "                    Nombre Cientifico: " + rs.getString("nombreC") + "\nEspecie: " + rs.getString("especie") + "                    Color: " + rs.getString("color")
               + "\nHabitat: " + rs.getString("habitat") + "                    Accion: " + rs.getString("accion") + "\nCantidad: " + rs.getInt("cantidad") + "\n\n";
                
            }
           
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try{
                stmt.close();
                rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return s;
    }

    
    public void dbPrepareStatement(JTextField nombreC, JTextField nombre, String especie, JTextField color, JTextField habitat, JTextField accion, JTextField cantidad, JLabel iconfirmar, JLabel errorI) {
        try {
            pstmt = conn.prepareStatement("insert into Animal_3 values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, nombre.getText());
            pstmt.setString(2, nombreC.getText());
            pstmt.setString(3, especie);
            pstmt.setString(4, color.getText());
            pstmt.setString(5, habitat.getText());
            pstmt.setString(6, accion.getText());
            
            String numero = cantidad.getText();
			int entero = Integer.parseInt(numero);
            pstmt.setInt(7, entero);
            
            iconfirmar.setVisible(true);
            //iconfirmar.setVisible(true);
           errorI.setVisible(false);
            
            nombre.setText("");
            nombreC.setText("");
            color.setText("");
            habitat.setText("");
            accion.setText("");
            cantidad.setText("");
            
            pstmt.executeUpdate();
        } 
        catch (SQLException e) {
           // e.printStackTrace();
        	iconfirmar.setVisible(false);
            errorI.setVisible(true);
        } 
        finally {
            try {
                this.pstmt.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void dbBuscar(JTextField nombreC, JTextField nombre, String especie, JTextField color, JTextField habitat, JTextField accion, JTextField cantidad, JTextField buscarN, JTextField buscarNC, JLabel error) {
        try {
            pstmt = conn.prepareStatement("select *from Animal_3 where nombre = ? and nombreC = ? and especie = '" + especie + "'");
            pstmt.setString(1, buscarN.getText());
            pstmt.setString(2, buscarNC.getText());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			nombre.setText(rs.getString("nombre"));
			nombreC.setText(rs.getString("nombreC"));
			color.setText(rs.getString("color"));
			habitat.setText(rs.getString("habitat"));
			accion.setText(rs.getString("accion"));
			int entero = rs.getInt("cantidad");
			cantidad.setText(String.valueOf(entero));
			error.setVisible(false);
			
		}else {
			error.setVisible(true);
			System.out.println("Animal no Registrado");
		}
            
            //pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                this.pstmt.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void dbModificar(JTextField buscarN, JTextField buscarNC, JTextField nombreC, JTextField nombre, String especie, JTextField color, JTextField habitat, JTextField accion, JTextField cantidad) {
    	try {
    		String nombreB = buscarN.getText();
    		String nombreBC = buscarNC.getText();
    		pstmt = conn.prepareStatement("update Animal_3 set nombre = ?, nombreC = ?, especie = ?, color = ?, habitat = ?, accion = ?, cantidad = ? where nombre = '" + nombreB + "' and nombreC = '" + nombreBC + "'");
    		
    		pstmt.setString(1, nombre.getText());
    		pstmt.setString(2, nombreC.getText());
    		pstmt.setString(3, especie);
    		pstmt.setString(4, color.getText());
    		pstmt.setString(5, habitat.getText());
    		pstmt.setString(6, accion.getText());
    		
    		String numero = cantidad.getText();
    		int entero = Integer.parseInt(numero);
    		pstmt.setInt(7, entero);
    		
    		pstmt.executeUpdate();
    		
    		/*nombre.setText("");
            color.setText("");
            habitat.setText("");
            accion.setText("");
            cantidad.setText("");*/
            
            
    		
    	}catch (SQLException e) {
                e.printStackTrace();
         } 
         finally {
        	 try {
        		 this.pstmt.close();
        		 } catch (SQLException e) {
        			 e.printStackTrace();
                }
            }
    }
    
    
    public void dbEliminar(JTextField buscarN, JTextField nombreC, JTextField nombre, JTextField color, JTextField habitat, JTextField accion, JTextField cantidad) {
    	try {
    		pstmt = conn.prepareStatement("delete from Animal_3 where nombre = ? and nombreC = ?");
    		pstmt.setString(1, buscarN.getText());
    		pstmt.setString(2, nombreC.getText());
    		
    		nombre.setText("");
    		nombreC.setText("");
    		color.setText("");
    		habitat.setText("");
    		accion.setText("");
    		cantidad.setText("");
    		
    		pstmt.executeUpdate();
    		
    	}catch (SQLException e) {
            e.printStackTrace();
     } 
     finally {
    	 try {
    		 this.pstmt.close();
    		 } catch (SQLException e) {
    			 e.printStackTrace();
            }
        }
    }
    
    
    
    public void dbClose() {
        try {
            this.conn.close();
            System.out.println("Conexion cerrada");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    public void getArray (ArrayList<String> array, JTextArea lista) {
    	lista = new JTextArea();
		String s = "";
		for(int i = 0; i < array.size(); i++) {
			s += array.get(i) + "\n\n";
			System.out.print(array.get(i));
		}
		lista.setText(s);;
	}
}

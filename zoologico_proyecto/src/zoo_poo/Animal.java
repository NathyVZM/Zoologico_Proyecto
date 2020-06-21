package zoo_poo;

import java.util.Scanner;

public abstract class Animal implements Accion_Animal{
	
	Scanner scanner = new Scanner(System.in);
	
	//Attributes
	private String nombre;	//Constructor
	private String color;	//Constructor
	private String habitat;
	private int cantidad_zoo;
	private String accion; //Interface
	
	//Constructors
	public Animal(String nombre, String color) {
		this.nombre = nombre;
		this.color = color;
	}
	
	//Constructor - For the User
	public Animal() { 
		System.out.print("\nNombre: ");
		nombre = scanner.nextLine();
		System.out.print("Color: ");
		color = scanner.nextLine();
	}
	
	//Methods - Constructor
	public String getNombre() {
		return nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	//Methods - Habitat
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public String getHabitat() {
		return habitat;
	}
	
	//Methods - Cantidad
	public void setCantidad(int cantidad_zoo) {
		this.cantidad_zoo = cantidad_zoo;
	}
	public int getCantidad() {
		return cantidad_zoo;
	}
	
	//Methods - Accion - Interface
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getAccion() {
		return accion;
	}
	
	//Methods - Tipo - Abstract
	public abstract String getTipo();
	
	//Method - toStrings
	public String toString() {
		return "Nombre: " + this.getNombre() + "\t\t\tEspecie: " + this.getTipo()
		+ "\nColor: " + this.getColor() + "\t\t\tHabitat: " + this.getHabitat()
		+ "\nAccion: " + this.getAccion() + "\t\t\tCantidad en el Zoo: "
		+ this.getCantidad();
	}
	
	
	//Methods for the User - Scanner
	public abstract void setHabitatU();	//Habitat - Abstract
	
	public void setCantidadU() {			//Cantidad - User
		System.out.print("Cantidad en el Zoo: ");
		cantidad_zoo = scanner.nextInt();
	}
	public void setAccionU() {				//Accion - Interface
		System.out.print("Accion: ");
		accion = scanner.nextLine();
	}
}
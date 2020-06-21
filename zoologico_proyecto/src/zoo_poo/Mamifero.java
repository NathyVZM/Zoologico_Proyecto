package zoo_poo;

import java.util.Scanner;

public class Mamifero extends Animal{
	
	Scanner scanner = new Scanner(System.in);
	
	//Attributes
	private String habitat;
	
	//Constructor
	public Mamifero(String nombre, String color) {
		super(nombre, color);
	}
	
	//Constructor - For the User
	public Mamifero() { 
		super();
	}
	
	//Methods - Habitat - User
	@Override
	public void setHabitatU(){
		System.out.print("Habitat del Mamifero: ");
		habitat = scanner.nextLine();
		super.setHabitat(habitat);
	}
	
	//Methods - Tipo - Overriding
	public String getTipo() {
		return "Mamifero";
	}
}

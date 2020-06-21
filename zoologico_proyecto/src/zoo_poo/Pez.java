package zoo_poo;

public class Pez extends Animal {
	
	//Attributes
	private String habitat;
	
	//Constructor
	public Pez(String nombre, String color) {
		super(nombre, color);
	}
	
	//Constructor - For the User
	public Pez() {
		super();
	}
	
	//Method - Habitat - User
	@Override
	public void setHabitatU() {
		System.out.print("Habitat del Pez: ");
		habitat = scanner.nextLine();
		super.setHabitat(habitat);
	}
	
	//Method - Tipo - Overriding
	public String getTipo() {
		return "Pez";
	}

}

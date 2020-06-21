package zoo_poo;

public class Anfibio extends Animal{
	
	//Attributes
	private String habitat;
	
	//Constructor
	public Anfibio(String nombre, String color) {
		super(nombre, color);
	}
	
	//Constructor - For the User
	public Anfibio() {
		super();
	}
	
	//Method - Habitat - User
	@Override
	public void setHabitatU() {
		System.out.print("Habitat del Anfibio: ");
		habitat = scanner.nextLine();
		super.setHabitat(habitat);
	}
	
	//Method - Tipo - Overridings
	public String getTipo() {
		return "Anfibio";
	}

}

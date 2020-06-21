package zoo_poo;

public class Ave extends Animal{
	
	//Attributes
	private String habitat;
	
	//Constructor
	public Ave(String nombre, String color) {
		super(nombre, color);
	}
	
	//Constructor - For the User
	public Ave() {
		super();
	}
	
	//Methods - Habitat - User
	@Override
	public void setHabitatU() {
		System.out.print("Habitat del Ave: ");
		habitat = scanner.nextLine();
		super.setHabitat(habitat);
	}
	
	//Methods - Tipo - Overriding
	public String getTipo() {
		return "Ave";
	}

}

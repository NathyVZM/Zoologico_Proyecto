package zoo_poo;

public class Reptil extends Animal{
	
	//Attributes
	private String habitat;
	
	//Constructor
	public Reptil(String nombre, String color) {
		super(nombre, color);
	}
	
	//Constructor - For the User
	public Reptil() {
		super();
	}
	
	//Methods - Habitat - User
	@Override
	public void setHabitatU() {
		System.out.print("Habitat del Reptil: ");
		habitat = scanner.nextLine();
		super.setHabitat(habitat);
	}
	
	//Method - Tipo - Overriding
	public String getTipo() {
		return "Reptil";
	}

}

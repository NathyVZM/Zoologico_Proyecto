package zoo_poo;

/*Nombre: Nathalie Zambrano		C.I: 28.400.266
  Programacion Orientada a Objeto
  Proyecto #1: Zoologico
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		//Mamiferos
		Mamifero leon = new Mamifero("Leon", "Amarillo");
		leon.setHabitat("Tierra (Selva)");
		leon.setCantidad(10);
		leon.setAccion("Caminar");
		
		Mamifero tigre = new Mamifero("Tigre", "Blanco");
		tigre.setHabitat("Tierra (Selva)");
		tigre.setCantidad(12);
		tigre.setAccion("Caminar");
		
		Mamifero delfin = new Mamifero("Delfin", "Rosa");
		delfin.setHabitat("Agua (Mar/Oceano)");
		delfin.setCantidad(8);
		delfin.setAccion("Nadar");
		
		//ArrayList - Mamifero
		ArrayList <Mamifero> mamiferos = new ArrayList<Mamifero>();
		mamiferos.add(leon);
		mamiferos.add(tigre);
		mamiferos.add(delfin);
		
		
		//Aves
		Ave perico = new Ave("Perico", "Verde");
		perico.setHabitat("Tierra (Selva)");
		perico.setCantidad(15);
		perico.setAccion("Volar");
		
		Ave loro = new Ave("Loro", "Rojo\n       Amarillo\n       Azul");
		loro.setHabitat("Tierra (Selva)");
		loro.setCantidad(11);
		loro.setAccion("Volar");
		
		Ave pato = new Ave("Pato", "Blanco");
		pato.setHabitat("Agua (Estanques, Lagos)");
		pato.setCantidad(18);
		pato.setAccion("Nadar\n\tCaminar");
		
		//ArrayList - Ave
		ArrayList <Ave> aves = new ArrayList<Ave>();
		aves.add(perico);
		aves.add(loro);
		aves.add(pato);
		
		
		//Reptiles
		Reptil caiman = new Reptil("Caiman", "Verde");
		caiman.setHabitat("Pantano");
		caiman.setCantidad(7);
		caiman.setAccion("Nadar");
		
		Reptil vibora = new Reptil("Vibora", "Marron");
		vibora.setHabitat("Tierra (Selva, Desierto)");
		vibora.setCantidad(6);
		vibora.setAccion("Reptar");
		
		Reptil tortuga = new Reptil ("Tortuga", "Verde");
		tortuga.setHabitat("Agua (Estanques, Lagos)");
		tortuga.setCantidad(10);
		tortuga.setAccion("Caminar");
		
		//ArrayList - Reptil
		ArrayList <Reptil> reptiles = new ArrayList<Reptil>();
		reptiles.add(caiman);
		reptiles.add(vibora);
		reptiles.add(tortuga);
		
		
		//Anfibios
		Anfibio rana = new Anfibio("Rana", "Verde");
		rana.setHabitat("Agua (Lago, Rios)");
		rana.setCantidad(12);
		rana.setAccion("Nadar\n\tSaltar");
		
		Anfibio sapo = new Anfibio("Sapo", "Marron");
		sapo.setHabitat("Agua (Aguas Estancadas)");
		sapo.setCantidad(10);
		sapo.setAccion("Nadar\n\tSaltar");
		
		Anfibio triton = new Anfibio ("Triton", "Amarillo");
		triton.setHabitat("Agua (Lagunas, Arroyos)");
		triton.setCantidad(13);
		triton.setAccion("Caminar\n\tNadar");
		
		//ArrayList - Anfibio
		ArrayList <Anfibio> anfibios = new ArrayList<Anfibio>();
		anfibios.add(rana);
		anfibios.add(sapo);
		anfibios.add(triton);
		
		
		//Peces
		Pez salmon = new Pez("Salmon", "Rosa");
		salmon.setHabitat("Mar, Oceano");
		salmon.setCantidad(20);
		salmon.setAccion("Nadar");
		
		Pez tiburon = new Pez("Tiburon", "Gris");
		tiburon.setHabitat("Agua (Mar, Oceano)");
		tiburon.setCantidad(9);
		tiburon.setAccion("Nadar");
		
		Pez pez_espada = new Pez("Pez\n\tEspada", "Gris");
		pez_espada.setHabitat("Agua (Mar, Oceano)");
		pez_espada.setCantidad(9);
		pez_espada.setAccion("Nadar");
		
		//ArrayList - Pez
		ArrayList <Pez> peces = new ArrayList<Pez>();
		peces.add(salmon);
		peces.add(tiburon);
		peces.add(pez_espada);
		
		//MENU - VARIABLES
		int opc = 1;
		int lista = 1;
		
		//MENU
		do {
			System.out.println("\n\t.:MENU ZOOLOGICO:.\n");
			System.out.println("\t1. Mostrar Lista de Mamiferos");
			System.out.println("\t2. Mostrar Lista de Aves");
			System.out.println("\t3. Mostrar Lista de Reptiles");
			System.out.println("\t4. Mostrar Lista de Anfibios");
			System.out.println("\t5. Mostrar Lista de Peces");
			System.out.println("\t6. Ingresar un Animal");
			System.out.println("\t0. Salir");
			System.out.print("\n\tEleccion: ");
			int menu = scanner.nextInt();
			
			if (menu == 1) {
				System.out.println("\n .:Mamiferos:. \n");
				for (int i = 0; i < mamiferos.size(); i++) {
					System.out.println(mamiferos.get(i) + "\n");
				}
			}
			
			if (menu == 2) {
				System.out.println("\n .:Aves:. \n");
				for (int i = 0; i < aves.size(); i++) {
					System.out.println(aves.get(i) + "\n");
				}
			}
			
			if (menu == 3) {
				System.out.println("\n .:Reptiles:. \n");
				for (int i = 0; i < reptiles.size(); i++) {
					System.out.println(reptiles.get(i) + "\n");
				}
			}
			
			if (menu == 4) {
				System.out.println("\n .:Anfibios:. \n");
				for (int i = 0; i < anfibios.size(); i++) {
					System.out.println(anfibios.get(i) + "\n");
				}
			}
			
			if (menu == 5) {
				System.out.println("\n .:Peces:. \n");
				for (int i = 0; i < peces.size(); i++) {
					System.out.println(peces.get(i) + "\n");
				}
			}
			
			//Option - USER
			if(menu == 6) {
				do {
					System.out.println("\n\t.:ESPECIE:. \n");
					System.out.println("\t1. Mamifero\n\t2. Ave\n\t3. Reptil");
					System.out.println("\t4. Anfibio\n\t5. Pez\n\t0. Salir\n");
					System.out.print("\tEleccion: ");
					int i = scanner.nextInt();
					
					if (i == 1) {
						Mamifero mamifero_nuevo = new Mamifero();
						mamifero_nuevo.setHabitatU();
						mamifero_nuevo.setAccionU();
						mamifero_nuevo.setCantidadU();
						
						mamiferos.add(mamifero_nuevo);
						lista = 1;
					}
					
					if (i == 2) {
						Ave ave_nueva = new Ave();
						ave_nueva.setHabitatU();
						ave_nueva.setAccionU();
						ave_nueva.setCantidadU();
						
						aves.add(ave_nueva);
						lista = 1;
					}
					
					if(i == 3) {
						Reptil reptil_nuevo = new Reptil();
						reptil_nuevo.setHabitatU();
						reptil_nuevo.setAccionU();
						reptil_nuevo.setCantidadU();
						
						reptiles.add(reptil_nuevo);
						lista = 1;
					}
					
					if(i == 4) {
						Anfibio anfibio_nuevo = new Anfibio();
						anfibio_nuevo.setHabitatU();
						anfibio_nuevo.setAccionU();
						anfibio_nuevo.setCantidadU();
						
						anfibios.add(anfibio_nuevo);
						lista = 1;
					}
					
					if(i == 5) {
						Pez pez_nuevo = new Pez();
						pez_nuevo.setHabitatU();
						pez_nuevo.setAccionU();
						pez_nuevo.setCantidadU();
						
						peces.add(pez_nuevo);
						lista = 1;
					}
					
					if (i == 0) {
						lista = 0;
					}
					
				}while(lista != 0);
			}
			
			
			if (menu == 0) {
				opc = 0;
				System.out.println("\n\tHasta Luego~!");
			}
		} while(opc != 0);
	}
}
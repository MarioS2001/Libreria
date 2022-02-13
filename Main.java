
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leer= new Scanner(System.in);;
		int cantidad;
		String isbn = "", titulo = "";
		double precio;
		boolean control = true;
		Inventario inventario = new Inventario();
		int opc=0;
		
		do {
			System.out.println("\t\t-- MENÚ --");
			System.out.println("1. Ingresar libro");
			System.out.println("2. Buscar libro por ISBN");
			System.out.println("3. Vender libro");
			System.out.println("4. Mostrar los tres libros más caros");
			System.out.println("5. Mostrar todos los libros");
			System.out.println("6. Fin del programa");
			System.out.print("\nEscoja una opción: ");
			opc= leer.nextInt();
			
		}while(control==true);
		
	}

}

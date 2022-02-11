
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
			switch(opc) {
			case 1:
				leer= new Scanner(System.in);
				System.out.println();
				System.out.println("\t\t-- INGRESE LOS SIGUIENTES DATOS --");
				System.out.print("\nISNB: ");
				isbn = leer.nextLine();
				System.out.print("\nTítulo del libro: ");
				titulo = leer.nextLine();
				System.out.print("\nPrecio del libro: ");
				precio = leer.nextDouble();
				System.out.print("\nCantidad: ");
				cantidad = leer.nextInt();
				Libro libros = new Libro(isbn, titulo, precio, cantidad);
				if(inventario.getLibrobyIsbn(isbn) == null) {
					inventario.almacenar(libros);
					System.out.println("\nLibro ingresado correctamente\n");
				} else {
					System.out.println("\nISBN REPETIDO\n");
				}
				break;
			case 2: 
				leer= new Scanner(System.in);
				System.out.print("\nIngresar el ISBN del libro a buscar: ");
				isbn= leer.nextLine();
				if(inventario.getLibrobyIsbn(isbn) == null) {
					System.out.println("\nNo existe libro con ese ISBN\n");
				} else {
					System.out.println("\n\t\t-- INFORMACIÓN DEL LIBRO -- \n");
					System.out.println(inventario.getLibrobyIsbn(isbn)+"\n");
				}
				break;
			case 3: 
				leer= new Scanner(System.in);
				System.out.print("\nIngresar el ISBN del libro a vender: ");
				isbn= leer.nextLine();
				System.out.print("\nIngresar la cantidad de libro(s) a vender: ");
				cantidad= leer.nextInt();
				inventario.ventaLibros(isbn, cantidad);
				System.out.println();
				break;
			case 4: 
				System.out.println("\n\t\t-- LIBROS MÁS CAROS -- \n");
				inventario.ordenarPrecios();
				inventario.getOrdenPrecio();
				System.out.println();
				break;
			case 5: 
				System.out.println("\n\t   -- INFORMACIÓN DE TODOS LOS LIBROS --\n");
				inventario.getlibrosCompletos();	
				System.out.println();
				break;
			case 6: 
				System.out.println("\nFIN DEL PROGRAMA");
				control=false;
				break;
			default:
				System.out.println("OPCIÓN INCORRECTA");
			}
		}while(control==true);
		
	}

}

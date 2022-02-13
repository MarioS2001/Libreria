
import java.util.ArrayList;
import java.util.Collections;

public class Inventario {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Libro> ordenPrecio = new ArrayList<Libro>();
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}	
	
	public void ventaLibros(String isbn, int cantidad) {
		if(getLibrobyIsbn(isbn) == null) {
			System.out.println("\nISBN incorrecto\n");}
		else
			if(getLibrobyIsbn(isbn).getCantidad() >= cantidad) {
				System.out.println("\n\t\t-- VENTA--");
				System.out.print("\nISBN: "+ isbn);
				System.out.print("\nTítulo: "+ getLibrobyIsbn(isbn).getTitulo());
				System.out.print("\nPrecio: "+ getLibrobyIsbn(isbn).getPrecio());
				System.out.print("\nCantidad: "+ cantidad);
				System.out.print("\nTotal a pagar: $"+
				getLibrobyIsbn(isbn).getPrecio()*cantidad+"\n");
				getLibrobyIsbn(isbn).setCantidad((getLibrobyIsbn(isbn).getCantidad() - cantidad));
				if(getLibrobyIsbn(isbn).getCantidad() == 0) {
					System.out.println("\nLibro agotado\n");
					libros.remove(libros.indexOf(getLibrobyIsbn(isbn)));
					}
			} else {
				System.out.println("\nLa cantidad requerida sobrepasa la cantidad de este libro");
				System.out.println("\nSolo hay "+getLibrobyIsbn(isbn).getCantidad()+" unidades\n");
			}
	}
	
	public void ordenarPrecios() {
		ordenPrecio = new ArrayList<Libro>();
		for(int i=0; i<libros.size(); i++) {
			ordenPrecio.add(libros.get(i));
		}
		Collections.sort(ordenPrecio, new OrdenarPrecio());
		
	}
	
	public ArrayList<Libro> getOrdenPrecio() {
		for(int i=0; i<3; i++) {
			System.out.print(ordenPrecio.get(i) + "\n");
		}
		return null;
	}
	
	public String getlibrosCompletos() {
		for(int i=0; i<libros.size(); i++){
			System.out.println(libros.get(i));
		}
		return null;	
	}
}

	

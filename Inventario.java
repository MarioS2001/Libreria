
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
	
}

	

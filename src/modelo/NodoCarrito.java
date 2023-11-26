package modelo;

public class NodoCarrito extends NodoProducto {

    public NodoCarrito(int id, String titulo, String autor, String descripcion, double precio, String fechaPublicacion, NodoProducto sig, NodoProducto ant) {
        super(id, titulo, autor, descripcion, precio, fechaPublicacion, sig, ant);
    }

}

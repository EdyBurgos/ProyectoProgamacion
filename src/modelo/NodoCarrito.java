package modelo;

// @author Juan Noriega
import java.util.Date;
// @author Juan Noriega

public class NodoCarrito extends NodoProducto {

    public NodoCarrito(int id, String titulo, String autor, String descripcion, double precio, Date fechaPublicacion, NodoProducto sig, NodoProducto ant) {
        super(id, titulo, autor, descripcion, precio, fechaPublicacion, sig, ant);
    }

}

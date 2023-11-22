package modelo;

// @author Juan Noriega
import java.util.Date;

public class NodoProducto {

    private int id;
    private String titulo;
    private String autor;
    private String descripcion;
    private double precio;
    private Date fechaPublicacion;
    private NodoProducto sig, ant;

    public NodoProducto(int id, String titulo, String autor, String descripcion, double precio, Date fechaPublicacion, NodoProducto sig, NodoProducto ant) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.sig = sig;
        this.ant = ant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}

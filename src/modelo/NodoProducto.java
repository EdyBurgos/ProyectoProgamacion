package modelo;

import java.util.Date;

public class NodoProducto {

    private int id;
    private String titulo;
    private String autor;
    private String descripcion;
    private double precio;
    private String fechaPublicacion;
    private NodoProducto sig, ant;

    public NodoProducto(int id, String titulo, String autor, String descripcion, double precio, String fechaPublicacion, NodoProducto sig, NodoProducto ant) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.sig = sig;
        this.ant = ant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}

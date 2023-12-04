package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ListaCarrito {

    NodoCarrito cab;

    public ListaCarrito() {
        this.cab = null;
    }

    public void realizarCompra() {

    }

    public void delLibCarrito(int id) {

    }

    public void aggLibCarrito(int id, String titulo, String autor, double precio, String desc, String fechaPublicacion) {
        // Crea un nuevo nodo con el usuario
        NodoCarrito nuevoNodo = new NodoCarrito(id, titulo, autor, desc, precio, fechaPublicacion);

        // Agrega el nuevo nodo a la lista
        if (cab == null) {
            cab = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabecera
        } else {
            nuevoNodo.setSig(cab); // El siguiente del nuevo nodo es la cabecera actual
            cab.setAnt(nuevoNodo); // El anterior de la cabecera actual es el nuevo nodo
            cab = nuevoNodo; // El nuevo nodo ahora es la cabecera
        }
    }
    
    public void guardarInfoCarrShoping() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivoCarrito.txt"))) {
            NodoCarrito actual = cab;

            while (actual != null) {
                String usuarioStr = String.format("%s,%s,%s,%s,%s",
                        actual.getId(),
                        actual.getTitulo(),
                        actual.getAutor(),
                        actual.getDescripcion(),
                        actual.getFechaPublicacion());

                writer.write(usuarioStr);
                writer.newLine();

                actual = (NodoCarrito) actual.getSig();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

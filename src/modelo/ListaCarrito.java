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
        NodoCarrito actual = cab;

        // Buscar el nodo con el ID proporcionado
        while (actual != null && actual.getId() != id) {
            actual = (NodoCarrito) actual.getSig();
        }

        // Si se encuentra el nodo con el ID, eliminarlo
        if (actual != null) {
            // Actualizar los enlaces de los nodos adyacentes
            if (actual.getAnt() != null) {
                actual.getAnt().setSig(actual.getSig());
            } else {
                cab = (NodoCarrito) actual.getSig();  // El nodo a eliminar es el primero
            }

            if (actual.getSig() != null) {
                actual.getSig().setAnt(actual.getAnt());
            }
        }

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

    public void verElementosCarrito() {
        NodoCarrito actual = cab;

        System.out.println("Elementos en el carrito:");

        while (actual != null) {
            System.out.println("ID: " + actual.getId());
            System.out.println("Título: " + actual.getTitulo());
            System.out.println("Autor: " + actual.getAutor());
            System.out.println("Descripción: " + actual.getDescripcion());
            System.out.println("Precio: " + actual.getPrecio());
            System.out.println("Fecha de Publicación: " + actual.getFechaPublicacion());
            System.out.println("----------------------");

            actual = (NodoCarrito) actual.getSig();
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

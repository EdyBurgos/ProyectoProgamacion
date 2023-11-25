package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class ListaUser {

    NodoUser cab;

    public ListaUser() {
        this.cab = null;
    }

    public boolean getUser(String correo) {
        // Verifica si ya existe un usuario con el mismo correo
        NodoUser actual = cab;
        while (actual != null) {
            if (actual.getCorreo().equals(correo)) {
                return true; // El correo ya está registrado
            }
            actual = actual.getSig();
        }
        return false; // El correo no está registrado
    }

    public boolean verificarContraseña(String passwd) {
        NodoUser actual = cab;
        while (actual != null) {
            if (actual.getContrasenia().equals(passwd)) {
                return true;
            }
            actual = actual.getSig();
        }
        return false;
    }

    public void addUser(
            TextField txtNomUser,
            TextField txtCorreo,
            TextField txtPasswrd,
            TextField txtNumCel,
            DatePicker txtFechaNac) {

        // Verifica si el correo ya está registrado
        if (getUser(txtCorreo.getText())) {
            mostrarAlerta("Error", "Ya existe un usuario con este correo.");
            return;
        }

        // Formatea la fecha al formato "dd/MM/yyyy"
        String fechaNacStr = txtFechaNac.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Crea un nuevo nodo con el usuario
        NodoUser nuevoNodo = new NodoUser(
                txtNomUser.getText(),
                txtCorreo.getText(),
                txtPasswrd.getText(),
                txtNumCel.getText(),
                LocalDate.parse(fechaNacStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Agrega el nuevo nodo a la lista
        if (cab == null) {
            cab = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabecera
        } else {
            nuevoNodo.setSig(cab); // El siguiente del nuevo nodo es la cabecera actual
            cab.setAnt(nuevoNodo); // El anterior de la cabecera actual es el nuevo nodo
            cab = nuevoNodo; // El nuevo nodo ahora es la cabecera
        }
        mostrarAlerta("Registro Exitoso", "¡¡Se ha registrado de manera exitosa!!");
    }

    public void guardarInfoUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivoUser.txt"))) {
            NodoUser actual = cab;

            while (actual != null) {
                if (!correoRegEnArchivo(actual.getCorreo())) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String usuarioStr = String.format("%s,%s,%s,%s,%s",
                            actual.getNombre(),
                            actual.getCorreo(),
                            actual.getContrasenia(),
                            actual.getNumTelefono(),
                            actual.getFechaNac().format(formatter));

                    writer.write(usuarioStr);
                    writer.newLine();
                } else {
                    System.out.println("Correo duplicado: " + actual.getCorreo());
                }

                actual = actual.getSig();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarInfoUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivoUser.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Divide la línea en partes usando la coma como separador
                String[] partes = line.split(",");

                // Asegúrate de tener suficientes partes para construir un usuario
                if (partes.length == 5) {
                    String nombre = partes[0].trim();
                    String correo = partes[1].trim();
                    String contrasenia = partes[2].trim();
                    String numTelefono = partes[3].trim();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaNac = LocalDate.parse(partes[4].trim(), formatter);

                    // Crea un nuevo nodo con la información del archivo
                    NodoUser nuevoNodo = new NodoUser(nombre, correo, contrasenia, numTelefono, fechaNac);

                    // Agrega el nuevo nodo a la lista
                    if (cab == null) {
                        cab = nuevoNodo;
                    } else {
                        nuevoNodo.setSig(cab);
                        cab.setAnt(nuevoNodo);
                        cab = nuevoNodo;
                    }
                }
            }
            System.out.println("La información se cargó correctamente desde el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    private boolean correoRegEnArchivo(String correo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivoUser.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Divide la línea en partes usando la coma como separador
                String[] partes = line.split(",");

                // La posición 1 (índice 0) debería contener el correo en este ejemplo
                String correoEnArchivo = partes[1].trim();

                // Compara el correo actual con el correo en el archivo
                if (correoEnArchivo.equals(correo)) {
                    return true; // El correo ya está registrado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }

        return false; // El correo no está registrado
    }

    private void mostrarAlerta(String tipo, String contenido) {
        // Muestra una alerta al usuario
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(tipo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarMensajeConfirmacion(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void aggFavoritos() {

    }

    public void delFavoritos() {

    }

    public void makeBuy() {

    }

    public void configurarTextFieldNumerico(TextField textField) {
        // Configurar un TextFormatter para aceptar solo dígitos
        StringConverter<Double> converter = new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                // Convierte el valor a cadena
                return object == null ? "" : object.toString();
            }

            @Override
            public Double fromString(String string) {
                // Intenta convertir la cadena a un valor numérico
                try {
                    return string.isEmpty() ? 0.0 : Double.parseDouble(string);
                } catch (NumberFormatException e) {
                    return 0.0;
                }
            }
        };

        TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0,
                change -> {
                    // Verificar si el nuevo valor es numérico
                    if (esNumero(change.getControlNewText())) {
                        return change;
                    } else {
                        return null; // No permitir la entrada si no es numérico
                    }
                });

        textField.setTextFormatter(textFormatter);
    }

    private static boolean esNumero(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

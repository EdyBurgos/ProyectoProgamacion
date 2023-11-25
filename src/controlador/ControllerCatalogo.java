/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;
//a

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControllerCatalogo implements Initializable {

    @FXML
    private Button btnVerCarrio;
    @FXML
    private Button btnVerFavoritos;
    @FXML
    private Button btnDetalles1;
    @FXML
    private Button btnDetalles2;
    @FXML
    private Button btnDetalles3;
    @FXML
    private Button btnDetalles4;
    @FXML
    private ImageView imgVLib1;
    @FXML
    private ImageView imgVLib2;
    @FXML
    private ImageView imgVLib3;
    @FXML
    private ImageView imgVLib4;
    @FXML
    private BorderPane contendDetalles;
    @FXML
    private ImageView unaFoto;
    @FXML
    private Button btnVolver;
    @FXML
    private ImageView btnIconUser;
    @FXML
    private VBox vtnOptionUser;
    @FXML
    private Button btnComprar;
    @FXML
    private Label lblTituloLib;
    @FXML
    private Label lblDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void VerCarrito(ActionEvent event) {
    }

    @FXML
    private void VerFavoritos(ActionEvent event) {
    }

    @FXML
    private void MostrarLibro(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        String idBoton = botonPresionado.getId();
        System.out.println("ID del botón presionado: " + idBoton);
        if (idBoton.equals("btnDetalles1")) {
            Image image = imgVLib1.getImage();
            unaFoto.setImage(image);
        } else if (idBoton.equals("btnDetalles2")) {
            Image image = imgVLib2.getImage();
            unaFoto.setImage(image);
        } else if (idBoton.equals("btnDetalles3")) {
            Image image = imgVLib3.getImage();
            unaFoto.setImage(image);

        } else if (idBoton.equals("btnDetalles4")) {
            Image image = imgVLib4.getImage();
            unaFoto.setImage(image);
        }
        contendDetalles.setVisible(true);

    }

    @FXML
    private void MostrarDetalles(MouseEvent event) {
        ImageView clickedImageView = (ImageView) event.getSource();
        Image clickedImage = clickedImageView.getImage();

        unaFoto.setImage(clickedImage);
        contendDetalles.setVisible(true);
    }

    @FXML
    private void VolverCatalogo(ActionEvent event) {
        contendDetalles.setVisible(false);

    }

    @FXML
    private void OptionUser(MouseEvent event) {
        vtnOptionUser.setVisible(!vtnOptionUser.isVisible());

    }

    @FXML
    private void RealizarCompra(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaMetodosPagos.fxml"));
            Parent root = loader.load();

            Stage vtnPagos = new Stage();
            vtnPagos.setTitle("REALIZAR PAGO");
            vtnPagos.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            ControllerMetodosPagos controlCatalog = loader.getController();

            vtnPagos.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void mostrarAlerta(String info, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(info);
        alert.setContentText(msj);

        DialogPane dialogPane = alert.getDialogPane();

        alert.showAndWait();

    }
}

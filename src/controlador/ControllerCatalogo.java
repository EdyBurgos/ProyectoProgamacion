/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Juan Noriega
 */
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
        contendDetalles.setVisible(true);
    }

    @FXML
    private void MostrarDetalles(MouseEvent event) {
        ImageView clickedImageView = (ImageView) event.getSource();
        Image clickedImage = clickedImageView.getImage();

        // Coloca la imagen del ImageView clicado en el outputImageView
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
}

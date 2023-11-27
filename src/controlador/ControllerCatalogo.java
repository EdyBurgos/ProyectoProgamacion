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
import javafx.event.EventHandler;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerCatalogo implements Initializable {

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
    private VBox contentCarrito;
    @FXML
    private VBox contentFavoritos;
    @FXML
    private Button btnVerCarrito;
    @FXML
    private Label lblPrecio1;
    @FXML
    private Label lblDatePublic1;
    @FXML
    private Label lblAutor1;
    @FXML
    private Label lblTitle2;
    @FXML
    private Label lblPrecio2;
    @FXML
    private Label lblDatePublic2;
    @FXML
    private Label lblAutor2;
    @FXML
    private Label lblPrecio3;
    @FXML
    private Label lblDatePublic3;
    @FXML
    private Label lblAutor3;
    @FXML
    private Label lblTitle4;
    @FXML
    private Label lblPrecio4;
    @FXML
    private Label lblDatePublic4;
    @FXML
    private Label lblAutor4;
    @FXML
    private Label lblPrecioMuestra;
    @FXML
    private Label lblDescLib;
    @FXML
    private Label lblAutorSelec;
    @FXML
    private Label lblFechaLibSelec;
    @FXML
    private Label lblTitle1;
    @FXML
    private Label lblTitle3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void VerCarrito(ActionEvent event) {
        contentCarrito.setVisible(!contentCarrito.isVisible());
        contentFavoritos.setVisible(false);
    }

    @FXML
    private void VerFavoritos(ActionEvent event) {
        contentFavoritos.setVisible(!contentFavoritos.isVisible());
        contentCarrito.setVisible(false);
    }

    @FXML
    private void MostrarLibro(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        String idBoton = botonPresionado.getId();
        Image image = null;

        switch (idBoton) {
            case "btnDetalles1":
                image = imgVLib1.getImage();
                unaFoto.setImage(image);
                lblTituloLib.setText(lblTitle1.getText());
                lblAutorSelec.setText(lblAutor1.getText());
                lblFechaLibSelec.setText(lblDatePublic1.getText());
                lblPrecioMuestra.setText(lblPrecio1.getText());
                break;
            case "btnDetalles2":
                image = imgVLib2.getImage();
                unaFoto.setImage(image);
                lblTituloLib.setText(lblTitle2.getText());
                lblAutorSelec.setText(lblAutor2.getText());
                lblFechaLibSelec.setText(lblDatePublic2.getText());
                lblPrecioMuestra.setText(lblPrecio2.getText());
                break;
            case "btnDetalles3":
                image = imgVLib3.getImage();
                unaFoto.setImage(image);
                lblTituloLib.setText(lblTitle3.getText());
                lblAutorSelec.setText(lblAutor3.getText());
                lblFechaLibSelec.setText(lblDatePublic3.getText());
                lblPrecioMuestra.setText(lblPrecio3.getText());
                break;
            case "btnDetalles4":
                image = imgVLib4.getImage();
                unaFoto.setImage(image);
                lblTituloLib.setText(lblTitle4.getText());
                lblAutorSelec.setText(lblAutor4.getText());
                lblFechaLibSelec.setText(lblDatePublic4.getText());
                lblPrecioMuestra.setText(lblPrecio4.getText());
                break;
            default:
                throw new AssertionError();
        }
        contendDetalles.setVisible(true);

    }

    @FXML
    private void MostrarDetalles(MouseEvent event) {
        ImageView clickedImageView = (ImageView) event.getSource();
        Image clickedImage = clickedImageView.getImage();
        String idImageV = clickedImageView.getId();

        unaFoto.setImage(clickedImage);
        contendDetalles.setVisible(true);

        switch (idImageV) {
            case "imgVLib1":
                lblTituloLib.setText(lblTitle1.getText());
                lblAutorSelec.setText(lblAutor1.getText());
                lblFechaLibSelec.setText(lblDatePublic1.getText());
                lblPrecioMuestra.setText(lblPrecio1.getText());
                break;
            case "imgVLib2":
                lblTituloLib.setText(lblTitle2.getText());
                lblAutorSelec.setText(lblAutor2.getText());
                lblFechaLibSelec.setText(lblDatePublic2.getText());
                lblPrecioMuestra.setText(lblPrecio2.getText());
                break;
            case "imgVLib3":
                lblTituloLib.setText(lblTitle3.getText());
                lblAutorSelec.setText(lblAutor3.getText());
                lblFechaLibSelec.setText(lblDatePublic3.getText());
                lblPrecioMuestra.setText(lblPrecio3.getText());
                break;
            case "imgVLib4":
                lblTituloLib.setText(lblTitle4.getText());
                lblAutorSelec.setText(lblAutor4.getText());
                lblFechaLibSelec.setText(lblDatePublic4.getText());
                lblPrecioMuestra.setText(lblPrecio4.getText());
                break;
            default:
                throw new AssertionError();
        }
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

    @FXML
    private void AggCarrito(ActionEvent event) {
        Label lblTitulo = new Label();
        Label lblAutor = new Label();
        Label lblFechaPublic = new Label();
        Label lblPrecio = new Label();
        Button btnDel = new Button("ELIMINAR ELEMENTO");
        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                contentCarrito.getChildren().remove(contLibSelected);
            }
        });

        column.setPrefWidth(contentCarrito.getWidth() / 2);

        contLibSelected.getColumnConstraints().addAll(column);
        contLibSelected.prefWidth(contentCarrito.getMaxWidth());
        contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        lblTitulo.setText(lblTituloLib.getText());
        lblAutor.setText(lblAutorSelec.getText());
        lblFechaPublic.setText(lblFechaLibSelec.getText());
        lblPrecio.setText(lblPrecioMuestra.getText());

        contLibSelected.add(lblTitulo, 0, 0);
        contLibSelected.add(lblAutor, 1, 0);
        contLibSelected.add(lblFechaPublic, 0, 1);
        contLibSelected.add(lblPrecio, 1, 1);
        contLibSelected.add(btnDel, 0, 2);

        contentCarrito.getChildren().add(contLibSelected);

    }

    @FXML
    private void AggFavoritos(ActionEvent event) {
        Label lblTitulo = new Label();
        Label lblAutor = new Label();
        Label lblFechaPublic = new Label();
        Label lblPrecio = new Label();
        Button btnDel = new Button("ELIMINAR ELEMENTO");
        GridPane contLibSelected = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Botón clickeado");
                contentFavoritos.getChildren().remove(contLibSelected);
            }
        });

        column.setPrefWidth(contentFavoritos.getWidth() / 2);

        contLibSelected.getColumnConstraints().addAll(column);
        contLibSelected.prefWidth(contentFavoritos.getMaxWidth());
        contLibSelected.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        lblTitulo.setText(lblTituloLib.getText());
        lblAutor.setText(lblAutorSelec.getText());
        lblFechaPublic.setText(lblFechaLibSelec.getText());
        lblPrecio.setText(lblPrecioMuestra.getText());

        contLibSelected.add(lblTitulo, 0, 0);
        contLibSelected.add(lblAutor, 1, 0);
        contLibSelected.add(lblFechaPublic, 0, 1);
        contLibSelected.add(lblPrecio, 1, 1);
        contLibSelected.add(btnDel, 0, 2);

        contentFavoritos.getChildren().add(contLibSelected);
    }
}

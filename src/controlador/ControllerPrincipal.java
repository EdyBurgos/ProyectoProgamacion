/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.ListaUser;

public class ControllerPrincipal implements Initializable {

    ListaUser userMetod = new ListaUser();
    @FXML
    private ImageView imgVPortada;
    @FXML
    private Button btnIngesar;
    @FXML
    private Button btnReg;
    @FXML
    private TextField txtNomUser;
    @FXML
    private TextField txtPasswd;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userMetod.cargarInfoUser();

    }

    @FXML
    private void IniciarSesion(ActionEvent event) {
        if (userMetod.getUser(txtNomUser.getText())) {
            if (userMetod.verificarContraseña(txtPasswd.getText())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaCatalogo.fxml"));
                    Parent root = loader.load();

                    Stage vtnCatalogo = new Stage();
                    vtnCatalogo.setTitle("CATALOGO");
                    vtnCatalogo.setScene(new Scene(root));

                    // Obtén el controlador de la segunda ventana si es necesario
                    ControllerCatalogo controlCatalog = loader.getController();

                    mostrarAlerta("INFO LOGIN", "HA INICIADO SESION");
                    vtnCatalogo.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            } else {
                mostrarAlerta("INFO LOGIN", "Contraseña incorrecta");
            }
        } else {
            mostrarAlerta("INFO LOGIN", "El usuario no existe por favor registrese");
            btnReg.fire();
        }
    }

    @FXML
    private void Registrarse(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaRegister.fxml"));
            Parent root = loader.load();

            Stage vtnRegister = new Stage();
            vtnRegister.setTitle("CATALOGO");
            vtnRegister.setScene(new Scene(root));

            // Obtén el controlador de la segunda ventana si es necesario
            ControllerRegister controlRegister = loader.getController();
            controlRegister.setMetodUser(userMetod);

            vtnRegister.showAndWait();
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

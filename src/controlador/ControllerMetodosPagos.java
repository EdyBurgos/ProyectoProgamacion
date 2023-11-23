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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControllerMetodosPagos implements Initializable {

    @FXML
    private ComboBox<?> cmbMetodos;
    @FXML
    private TextField txtNumCuenta;
    @FXML
    private TextField txtValPagar;
    @FXML
    private TextField txtFegaExp;
    @FXML
    private TextField txtCVV;
    @FXML
    private Button btnPagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void RealizarPago(ActionEvent event) {
    }

}

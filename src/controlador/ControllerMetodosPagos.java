/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.ListaCarrito;

public class ControllerMetodosPagos implements Initializable {

    ListaCarrito metodsCarrito = new ListaCarrito();
    ControllerCatalogo controller;
    int cont = 0;

    @FXML
    private ComboBox<String> cmbMetodos;
    @FXML
    private TextField txtNumCuenta;
    @FXML
    private TextField txtCVV;
    @FXML
    private Button btnPagar;
    @FXML
    private TextField txtNomPrope;
    @FXML
    private TextField txtFechaExp;
    @FXML
    private TextField txtCorreo;
    @FXML
    private ImageView imgVPicLib;

    public void setImagenSS(Image imagen) {
        imgVPicLib.setImage(imagen);
    }

    public void setControllerAnt(ControllerCatalogo controlCat) {
        this.controller = controlCat;
    }

    public ControllerCatalogo controlCat() {
        return controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> elementos = FXCollections.observableArrayList("Selecciones una opcion",
                "Tarjeta Crédito",
                "Tarjeta Débito",
                "Bancolombia",
                "Cuenta Nequi",
                "Cuenta Daviplata");
        cmbMetodos.setItems(elementos);
        cmbMetodos.setValue(elementos.get(0));
    }

    @FXML
    private void RealizarPago(ActionEvent event) {
        if (cmbMetodos.getSelectionModel().getSelectedIndex() > 0) {
            if (!txtNumCuenta.getText().isEmpty()) {
                String title = controlCat().getLblTituloLib().getText();
                String autor = obtenerTextoDespuesDosPuntos(controlCat().getLblAutorSelec());
                String precio = obtenerTextoDespuesDosPuntos(controlCat().getLblPrecioMuestra());
                String desc = controlCat().getLblDescLib().getText();
                String fechaPubl = obtenerTextoDespuesDosPuntos(controlCat().getLblFechaLibSelec());
                cont++;
                metodsCarrito.aggLibCarrito(cont, title, autor, Double.parseDouble(precio), desc, fechaPubl);
                metodsCarrito.guardarInfoCarrShoping();
            }
        }
    }

    @FXML
    private void OpcionSeleccionada(ActionEvent event) {
        int metodo = cmbMetodos.getSelectionModel().getSelectedIndex();
        switch (metodo) {
            case 0:
                break;
            case 1:
                txtNumCuenta.setPromptText("NUMERO DE TARJETA");
                txtNumCuenta.setVisible(true);
                txtNomPrope.setVisible(true);
                txtCorreo.setVisible(true);
                txtFechaExp.setVisible(true);
                txtCVV.setVisible(true);
                break;
            case 2:
                txtNumCuenta.setPromptText("NUMERO DE TARJETA");
                txtNumCuenta.setVisible(true);
                txtNomPrope.setVisible(true);
                txtCorreo.setVisible(true);
                txtFechaExp.setVisible(true);
                txtCVV.setVisible(true);
                break;
            case 3:
                txtNumCuenta.setPromptText("NUMERO DE CUENTA");
                txtNumCuenta.setVisible(true);
                txtNomPrope.setVisible(true);
                txtCorreo.setVisible(true);
                txtFechaExp.setVisible(false);
                txtCVV.setVisible(false);
                break;
            case 4:
                txtNumCuenta.setPromptText("NUMERO DE CUENTA");
                txtNumCuenta.setVisible(true);
                txtNomPrope.setVisible(true);
                txtCorreo.setVisible(true);
                txtFechaExp.setVisible(false);
                txtCVV.setVisible(false);
                break;
            case 5:
                txtNumCuenta.setPromptText("NUMERO DE CUENTA");
                txtNumCuenta.setVisible(true);
                txtNomPrope.setVisible(true);
                txtCorreo.setVisible(true);
                txtFechaExp.setVisible(false);
                txtCVV.setVisible(false);
                break;
            default:
                System.out.println("None");
        }

    }

    private String obtenerTextoDespuesDosPuntos(Label label) {
        String textoCompleto = label.getText();
        int indiceDosPuntos = textoCompleto.indexOf(":");
        return indiceDosPuntos != -1 ? textoCompleto.substring(indiceDosPuntos + 1).trim() : "";
    }

}

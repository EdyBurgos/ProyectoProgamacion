package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.ListaUser;

public class ControllerRegister implements Initializable {

    ListaUser metodUser;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtPasswd;
    @FXML
    private TextField txtConfPass;
    @FXML
    private TextField txtNumCell;
    @FXML
    private DatePicker txtFechaNac;
    @FXML
    private Button btnRegister;
    @FXML
    private Label lblArcoiris;

    public ControllerRegister() {
        this.metodUser = getMetodUser();
    }

    public ListaUser getMetodUser() {
        return metodUser;
    }

    public void setMetodUser(ListaUser metodUser) {
        this.metodUser = metodUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animacion(lblArcoiris);

    }

    @FXML
    private void RegistarUser(ActionEvent event) {
        if (txtPasswd.getText().equals(txtConfPass.getText())) {
            metodUser.addUser(txtNombre, txtCorreo, txtPasswd, txtNumCell, txtFechaNac);
            metodUser.guardarInfoUser();
            Stage stage = (Stage) btnRegister.getScene().getWindow();
            stage.close();
        } else {
            mostrarAlerta("INFO REGISTER", "La contraseña no coincide");
            txtPasswd.setText("");
            txtConfPass.setText("");
            txtPasswd.requestFocus();
        }

    }

    @FXML
    private void eventKey(KeyEvent key) {
        if (key.getSource() == txtNumCell) {

            String currentText = txtNumCell.getText();
            String input = key.getCharacter();

            if ((currentText + input).length() > 10) {
                key.consume();
            }
            if (!input.matches("[0-9]")) {
                key.consume();
            }
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

    private void animacion(Label lblAnimation) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(lblAnimation.textFillProperty(), Color.WHITE)),
                new KeyFrame(Duration.seconds(3), new KeyValue(lblAnimation.textFillProperty(), Color.BLUE))
        );

        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.setAutoReverse(true); // Para que revierta la animación al final

        timeline.play();

    }

}

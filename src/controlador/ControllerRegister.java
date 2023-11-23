package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.ListaUser;

public class ControllerRegister implements Initializable {

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

    ListaUser metodUser;

    public ListaUser getMetodUser() {
        return metodUser;
    }

    public void setMetodUser(ListaUser metodUser) {
        this.metodUser = metodUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void RegistarUser(ActionEvent event) {
        metodUser.addUser(txtNombre, txtCorreo, txtPasswd, txtNumCell, txtFechaNac);
        metodUser.guardarInfoUser();
    }

}

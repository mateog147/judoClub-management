package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class macController {

    @FXML
    private Button registroBtn;

    @FXML
    private Button pagoBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button astBtn;

    @FXML
    private Button asenBtn;

    @FXML
    private Button newAdminBtn;

    @FXML
    void asenso(MouseEvent event) throws Exception{
        Stage teatro = new Stage();
        Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/ascensosView.fxml"))).load();
        Scene obra =new Scene(raiz);
        teatro.setTitle("Registrar nuevo grado"); 
        teatro.setScene(obra);
        teatro.show();
        Stage teatrico = (Stage) this.registroBtn.getScene().getWindow();
        teatrico.close();
    }

    @FXML
    void asistencia(MouseEvent event) {

    }

    @FXML
    void cargarUser(MouseEvent event) throws Exception{
        Stage teatro = new Stage();
        Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/actualizarView.fxml"))).load();
        Scene obra =new Scene(raiz);
        teatro.setTitle("Ingreso Usuario"); 
        teatro.setScene(obra);
        teatro.show();
        Stage teatrico = (Stage) this.registroBtn.getScene().getWindow();
        teatrico.close();

    }

    @FXML
    void newAdmin(ContextMenuEvent event) {

    }

    @FXML
    void pagos(MouseEvent event) throws Exception{
        Stage teatro = new Stage();
        Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/pagosView.fxml"))).load();
        Scene obra =new Scene(raiz);
        teatro.setTitle("Registra pago"); 
        teatro.setScene(obra);
        teatro.show();
        Stage teatrico = (Stage) this.registroBtn.getScene().getWindow();
        teatrico.close();
    }

    @FXML
    void registrarUser(MouseEvent event) throws Exception{
        Stage teatro = new Stage();
        Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/registroView.fxml"))).load();
        Scene obra =new Scene(raiz);
        teatro.setTitle("Ingreso Usuario");
        teatro.setScene(obra);
        teatro.show();
        Stage teatrico = (Stage) this.registroBtn.getScene().getWindow();
        teatrico.close();
    }
}

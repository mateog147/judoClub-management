package controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class pagosController{

    @FXML
    private ComboBox<?> usrCbx;

    @FXML
    private ChoiceBox<String> mesesCB;

    @FXML
    private Button pagarBtn;

    @FXML
    private Button regresarBtn;

    @FXML
    private DatePicker fechaPiecker;

    @FXML
    private TextField montoTxt;

    @FXML
    void pago(MouseEvent event) {

    }

    @FXML
    void regresar  (MouseEvent event) throws Exception{
        Stage teatro = new Stage();
        Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/MACView.fxml"))).load();
        Scene obra =new Scene(raiz);
        teatro.setTitle("Ingreso Usuario");
        teatro.setScene(obra);
        teatro.show();
        Stage teatrico = (Stage) this.regresarBtn.getScene().getWindow();
        teatrico.close();
    }

    @FXML
    void initialize(){
        ObservableList<String> periodos = FXCollections.observableArrayList("DIC-ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV");
        mesesCB.setItems(periodos);

    }
    
}

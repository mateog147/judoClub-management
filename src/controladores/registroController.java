package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelos.Constantes;

public class registroController implements Constantes{

    @FXML
    private DatePicker nacimientoRegistro;

    @FXML
    private TextField nombreRegistroTxt;

    @FXML
    private TextField docRegistroTxt;

    @FXML
    private ComboBox<String> cosTipoRegistroCB;

    @FXML
    private ComboBox<String> gradoRegistroCB;

    @FXML
    private DatePicker fechaIngreso;

    @FXML
    private Label errorLbl;

    @FXML
    private Button guardarBtn;

    @FXML
    private Button regresarBtn;

    @FXML
    private ComboBox<String> sexoCB;

    @FXML
    void guardarUsr(MouseEvent event) throws Exception{
        //creo la Constantes.RUTA 
        //guardo las entradas en variables.
        String nom = nombreRegistroTxt.getText();
        String doc = cosTipoRegistroCB.getValue();
        String cc = docRegistroTxt.getText().trim();
        String kyu = gradoRegistroCB.getValue();
        String sex = sexoCB.getValue();
        LocalDate nacimiento = nacimientoRegistro.getValue();
        LocalDate ingreso = fechaIngreso.getValue();

        //valido las entradas
        if(nom == " "|| nom.isEmpty() || cc == " " || cc.isEmpty()){
            errorLbl.setText("Los valores de Nombre y Cedula son requeridos");
        }
        else if(doc == null || kyu == null || sex == null){
            errorLbl.setText("Seleccione un valor de tipo de Documento, el sexo y el grado actual");
        }
        else if(nacimiento == null || ingreso == null){
            errorLbl.setText("Seleccione las fechas de ingreso y nacimiento");
        }
        //si todo esta correcto registro el valor
        else{
             //me conecto a la base de datos
            Class.forName("org.sqlite.JDBC");
            Connection conec = DriverManager.getConnection("jdbc:sqlite:"+Constantes.RUTA);
            
            try(Statement sta = conec.createStatement()){
                int res = sta.executeUpdate("INSERT INTO judokas(nombre,tipoDocumento,numeroDocumento,fechaIngreso,fechaNacimiento,sexo) VALUES('"+nom+"','"+doc+"','"+cc+"','"+ingreso+"','"+nacimiento+"','"+sex+"')");
                if(res>0){
                    int res2 = sta.executeUpdate("INSERT INTO ascensos(documento,fecha,grado) VALUES('"+cc+"','"+ingreso+"','"+kyu+"')");
                    if(res+res2>1){
                        errorLbl.setText("Almacenado con exito");
                        nombreRegistroTxt.setText("");
                        cosTipoRegistroCB.setValue("");
                        docRegistroTxt.setText("");
                        sexoCB.setValue("");
                        gradoRegistroCB.setValue("");
                    }
                    else{
                        errorLbl.setText("ERROR AL GUARDAR LOS DATOS");
                    }
                }
            }
            conec.close();
        }
    }

    @FXML
    void regresar(MouseEvent event) throws Exception{
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
        ObservableList<String> sexos = FXCollections.observableArrayList("M","F");
        ObservableList<String> tiposDoc = FXCollections.observableArrayList("CC","TI","CE","PASAPORTE","RC");
        ObservableList<String> grados = FXCollections.observableArrayList("Blanco- 6 Kyu","Amarillo - 5 Kyu","Naranja- 4 Kyu","Verde - 3 Kyu","Azul- 2 Kyu","Marron - 1 Kyu","Shodan- 1 Dan", "Nidan- 2 Dan", "Sandan- 3 Dan","Yondan- 4 Dan","Godan- 5 Dan", "Rokudan- 6 Dan");
        cosTipoRegistroCB.setItems(tiposDoc);
        gradoRegistroCB.setItems(grados) ;
        gradoRegistroCB.setValue("Blanco- 6 Kyu");
        sexoCB.setItems(sexos);
    }
}

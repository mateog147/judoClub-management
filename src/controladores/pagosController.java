package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelos.Constantes;

public class pagosController{
    private List<String[]> users = new ArrayList<String[]>(); 
    @FXML
    private ComboBox<String> usrCbx;

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
    private Label errorLbl;

    @FXML
    void pago(MouseEvent event) {
        LocalDate fechaPago = fechaPiecker.getValue();
        String nombre = usrCbx.getValue();
        String periodo = mesesCB.getValue();
        if(montoTxt.getText() ==" " || montoTxt.getText().isEmpty()){
            errorLbl.setText("ERROR::Se debe ingresar el monto pagado");
        }
        else{
            int monto = Integer.parseInt(montoTxt.getText());
            errorLbl.setText(" ");
        }
        

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
    void initialize() throws Exception{
        String vec[] = new String[2];
        String nombre, cedula;

        ObservableList<String> periodos = FXCollections.observableArrayList("DIC-ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV");
        ObservableList<String> judokas = FXCollections.observableArrayList();
        mesesCB.setItems(periodos);
        //cargo los datos de la base de datos
        Class.forName("org.sqlite.JDBC");
        Connection conec = DriverManager.getConnection("jdbc:sqlite:" + Constantes.RUTA);
        
        try(Statement sta = conec.createStatement()){
            ResultSet res = sta.executeQuery("SELECT nombre, numeroDocumento FROM judokas");
            while(res.next()){
                //System.out.println(res.getString("nombre"));
                nombre = res.getString("nombre");
                cedula = res.getString("numeroDocumento");
                vec[0]=nombre;
                vec[1]=cedula;
                users.add(vec);
                judokas.add(res.getString("nombre"));
            }
        }
        conec.close();
        usrCbx.setItems(judokas);
    }
    
}

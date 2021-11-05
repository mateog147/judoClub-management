package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelos.Constantes;
import modelos.Judoka;

public class ascensosController {
    public ArrayList<Judoka> users = new ArrayList<Judoka>(); 

    @FXML
    private ComboBox<String> usrCbx;

    @FXML
    private ChoiceBox<String> gradosCB;

    @FXML
    private Button registrarBtn;

    @FXML
    private Button regresarBtn;

    @FXML
    private DatePicker fechaPiecker;

    @FXML
    private Label errorLbl;

    @FXML
    void pago(MouseEvent event) {

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
    void initialize() throws Exception{
        Judoka temp;
        String nombre, cedula;
        ObservableList<String> grados = FXCollections.observableArrayList("Blanco- 6 Kyu","Amarillo - 5 Kyu","Naranja- 4 Kyu","Verde - 3 Kyu","Azul- 2 Kyu","Marron - 1 Kyu","Shodan- 1 Dan", "Nidan- 2 Dan", "Sandan- 3 Dan","Yondan- 4 Dan","Godan- 5 Dan", "Rokudan- 6 Dan");
        gradosCB.setItems(grados) ;
        gradosCB.setValue("Blanco- 6 Kyu");

        ObservableList<String> judokas = FXCollections.observableArrayList();
        //cargo los datos de la base de datos
        Class.forName("org.sqlite.JDBC");
        Connection conec = DriverManager.getConnection("jdbc:sqlite:" + Constantes.RUTA);
        
        try(Statement sta = conec.createStatement()){
            ResultSet res = sta.executeQuery("SELECT nombre, numeroDocumento FROM judokas");
            while(res.next()){
                //System.out.println(res.getString("nombre"));
                nombre = res.getString("nombre");
                cedula = res.getString("numeroDocumento");
                temp = new Judoka(nombre,cedula);
                
                users.add(temp);
                judokas.add(res.getString("nombre"));
                }
        }
        conec.close();
        usrCbx.setItems(judokas);
    }

}


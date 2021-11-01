/*
CONTROLADOR PARA INGRESO A LA APLICACIÓN

ESTA CLASE CONTROLA EL FORMULARIO DE INGRESO AL APLICATIVO.
SE CONECTA A LA BASE DE DATOS: dbclub.db 
LA CUAL ESTA EN LA MISMA RUTA DE ESTA CLASE,
VALIDA QUE EL USUARIO SE ENCUENTRE REGISTRADO LA BASE DE DATOS Y QUE LA CLAVE COINCIDA CON EL DE LA BASE DE DATOS

entradaTexto ==> String user <>? columna Id

*/
package controladores;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelos.Constantes;

public class loginController implements Constantes{

    @FXML
    private Button ingresarBtn;

    @FXML
    private TextField userTxt;

    @FXML
    private Label errorTxt;

    @FXML
    private PasswordField claveTxt;

    @FXML
    void validarUsuarioBtn(MouseEvent event) throws Exception{
        //declaro las variables a usar 
        String user = userTxt.getText();
        String pwd = claveTxt.getText();
        //valido las entradas antes de proceder
        if(pwd.isEmpty() || pwd == null || user.isEmpty() || user == null ){
            errorTxt.setText("Por favor ingrese Usuario y clave");
        }
        
        else{
            //estables la RUTA del archivo de la base de datos
            //String RUTA = this.getClass().getResource("").getPath();
            //RUTA = RUTA.substring(0, RUTA.length()-18);
            //RUTA = RUTA + "src/appdata/dbclub.db";
            //creo la conexión a la base de datos 
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + Constantes.RUTA);
            //Intento hacer una consulta
            try(Statement st = con.createStatement()){
                //System.out.print("conectado a la base de datos");
                ResultSet res = st.executeQuery("SELECT * FROM usuarios WHERE Id = '"+user+"' AND clave = '"+pwd+"'");
                //si exite el registro con ese usuario y clave procedo a abrir la otra parte del archivo 
                if(res.next()){
                    //limpio el label 
                    errorTxt.setText("");
                    //desplieago el siguiente formulario
                    Stage teatro = new Stage();
                    Parent raiz = (new FXMLLoader(getClass().getResource("../vistas/MACView.fxml"))).load();
                    Scene obra =new Scene(raiz);
                    teatro.setTitle("Ingreso Usuario");
                    teatro.setScene(obra);
                    teatro.show();
                    Stage teatrico = (Stage) this.ingresarBtn.getScene().getWindow();
                    teatrico.close();
                }
                //si no hay registro
                else{
                    errorTxt.setText("Usuario o Clave Invalida, intente nuevamente");
                }
            }
            con.close();
        }
    }

}
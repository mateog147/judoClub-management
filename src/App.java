import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage teatro) throws Exception {
        Parent root = (new FXMLLoader(getClass().getResource("vistas/loginView.fxml"))).load();
        Scene obraLogin =new Scene(root);
        teatro.setTitle("Ingreso Usuario");
        teatro.setScene(obraLogin);
        teatro.show();
    }
    
}

package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OnlineStore extends Application {
    public void start(Stage primaryStage) throws Exception {

        VentanaPrincipal v = new VentanaPrincipal();
        Parent root = FXMLLoader.load(v.getClass().getResource("VentanaPrincipal.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("ObjetivoDB");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

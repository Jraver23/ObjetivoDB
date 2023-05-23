package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static javafx.application.Application.launch;
import static view.mostrarArticulos.*;

public class VentanaMenuArticulo {
        private agregarArticulo agregarArts = new agregarArticulo();
        private mostrarArticulos mostrarArts = new mostrarArticulos();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menuArticulos.fxml"));
            primaryStage.setTitle("Menú Artículos");
            primaryStage.setScene(new Scene(root, 570, 400));
            primaryStage.show();

        }

        public void addArt(ActionEvent actionEvent) throws IOException {
            System.out.println("Añadir Articulo clicked");
            agregarArts.start(new Stage());

        }

        public void mostrarArts(ActionEvent actionEvent) throws IOException {
            System.out.println("Mostrar Artículos clicked");
            mostrarArts.start(new Stage());
        }
    }


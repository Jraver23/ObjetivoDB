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
import static view.VentanaMenuArticulo.*;

public class VentanaMenuArticulo {
        private agregarArticulo agregarArt = new agregarArticulo();
        private mostrarArticulos mostrarArt = new mostrarArticulos();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/VentanaMenuArticulos.fxml"));
            primaryStage.setTitle("Menú Artículos");
            primaryStage.setScene(new Scene(root, 570, 400));
            primaryStage.show();

        }

        public void addArt(ActionEvent actionEvent) throws IOException {
            System.out.println("Añadir Articulo clicked");
            agregarArt.start(new Stage());

        }

        public void mostrarArts(ActionEvent actionEvent) throws IOException {
            System.out.println("Mostrar Artículos clicked");
            mostrarArt.start(new Stage());
        }
    }


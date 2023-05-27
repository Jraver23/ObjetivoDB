package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;
import static view.VentanaMenuArticulo.*;

public class VentanaMenuArticulo implements Initializable {
        private Button agregarArt, mostrarArt;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

         }
        @FXML
        private void addArt (ActionEvent event){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            try {
                VentanaAñadirArticulo v = new VentanaAñadirArticulo();
                Parent root = FXMLLoader.load(v.getClass().getResource("VentanaAñadirArticulos.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Añadir articulo");
                stage.setScene(scene);
                stage.show();
            } catch ( IOException e) {
                System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
            }
        }

        @FXML
        private void mostrarArt (ActionEvent event){
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            try {
                VentanaMostrarArticulos v = new VentanaMostrarArticulos();
                Parent root = FXMLLoader.load(v.getClass().getResource("VentanaMostrarArticulos.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Mostrar articulos");
                stage.setScene(scene);
                stage.show();
            } catch ( IOException e) {
                System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
            }
        }
}


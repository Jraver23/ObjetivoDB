package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class VentanaCrearCliente implements Initializable {

    @FXML
    private Button CrearP, CrearE, Salir;
    @FXML
    private TextField nifP, nombreP, domicilioP, emailP, nifE, nombreE, domicilioE, emailE;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CrearClientePremium(ActionEvent event) {
        String nif = nifP.getText();
        String nombre = nombreP.getText();
        String domicilio = domicilioP.getText();
        String email = emailP.getText();

        Controlador controlador = new Controlador();
        controlador.addClienteToAList(nombre, domicilio, nif, email, "Premium");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("Se ha almacenado el Cliente Premium.");
        alert.showAndWait();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("VentanaPrincipal.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Ventana Principal");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }

    @FXML
    private void CrearClienteEstandar(ActionEvent event) {
        String nif = nifE.getText();
        String nombre = nombreE.getText();
        String domicilio = domicilioE.getText();
        String email = emailE.getText();

        Controlador controlador = new Controlador();
        controlador.addClienteToAList(nombre, domicilio,nif, email,"Estandar");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("Se ha almacenado el Cliente Estandar.");
        alert.showAndWait();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("VentanaPrincipal.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Ventana Principal");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }

    @FXML
    private void Salir(ActionEvent event) {
        Stage stage = (Stage) this.Salir.getScene().getWindow();
        stage.close();
        try {
            VentanaPrincipal v = new VentanaPrincipal();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaPrincipal.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }
}

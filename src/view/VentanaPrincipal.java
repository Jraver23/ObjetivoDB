package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VentanaPrincipal implements Initializable {
    /*String usuario;
    String password;*/
    @FXML
    private Button CrearArticulo,MostrarArticulos,CrearCliente, MostrarClientes, CrearPedido, EliminarPedido, MostrarPedidos, Salir;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CrearCliente (ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            VentanaCrearCliente v = new VentanaCrearCliente();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaCrearCliente.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Crear cliente");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }
    @FXML
    private void MostrarClientes (ActionEvent event){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            VentanaMostrarCliente v = new VentanaMostrarCliente();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaMostrarCliente.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Mostrar clientes");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }
    @FXML
    private void CrearPedido (ActionEvent event){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            VentanaCrearPedido v= new VentanaCrearPedido();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaCrearPedido.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Crear pedido");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }
    @FXML
    private void EliminarPedido (ActionEvent event){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            VentanaEliminarPedido v = new VentanaEliminarPedido();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaEliminarPedido.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Borrar pedido");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }

    @FXML
    private void MostrarPedido (ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            VentanaMostrarPedidos v = new VentanaMostrarPedidos();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaMostrarPedidos.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Mostrar pedido");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }


    @FXML
    private void Salir (ActionEvent event){
        Stage stage = (Stage) this.Salir.getScene().getWindow();
        stage.close();
    }
}

package view;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Articulo;
import model.Cliente;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;


public class VentanaCrearPedido implements  Initializable{

    @FXML
    private TextField cantidadPrem, cantidadEst, clientePrem, clienteEst, articuloPrem, articuloEst, numPedido;
    @FXML
    private Button crearPedPrem, crearPedEst, salir;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void crearPedEst (javafx.event.ActionEvent event){
        Controlador cont = new Controlador();
        int num_pedido = Integer.parseInt(numPedido.getText());
        String email = clienteEst.getText();
        String articulo = articuloEst.getText();
        int numero_de_articulos= Integer.parseInt(cantidadEst.getText());
        LocalDateTime fecha = LocalDateTime.now();
        cont.addPedido(num_pedido, email, articulo, numero_de_articulos, fecha);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Se ha almacenado el pedido.");
        alert.showAndWait();
    }
    @FXML
    private void crearPedPrem (javafx.event.ActionEvent event){
        Controlador cont = new Controlador();
        int num_pedido = Integer.parseInt(numPedido.getText());
        String email = clientePrem.getText();
        String articulo = articuloPrem.getText();
        int numero_de_articulos= Integer.parseInt(cantidadPrem.getText());
        LocalDateTime fecha = LocalDateTime.now();
        cont.addPedido(num_pedido, email, articulo, numero_de_articulos, fecha);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Se ha almacenado el pedido.");
        alert.showAndWait();
    }
    @FXML
    private void clicSalir (javafx.event.ActionEvent event){
        Stage stage = (Stage) this.salir.getScene().getWindow();
        stage.close();
        try {
            VentanaPrincipal v = new VentanaPrincipal();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaPrincipal.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }
}

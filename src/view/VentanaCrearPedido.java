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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class VentanaCrearPedido implements  Initializable{

    @FXML
    private TextField cantidadPrem, cantidadEst;
    @FXML
    private Button crearPedPrem, crearPedEst, salir;
    @FXML
    private ComboBox boxClientePrem,boxArticuloPrem, boxClienteEst, boxArticuloEst;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Controlador cont = new Controlador();
        cont.AgregarClientesPremiumComboBox(boxClientePrem);
        cont.AgregarClientesEstandarComboBox(boxClienteEst);
        cont.AgregarArticulosComboBox(boxArticuloPrem);
        cont.AgregarArticulosComboBox(boxArticuloEst);
    }
    @FXML
    private void crearPedEst (javafx.event.ActionEvent event){
        Controlador cont = new Controlador();
        cont.CrearPedidosE(boxClienteEst, boxArticuloEst, cantidadEst);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Se ha almacenado el pedido.");
        alert.showAndWait();
    }
    @FXML
    private void crearPedPrem (javafx.event.ActionEvent event){
        Controlador cont = new Controlador();
        cont.CrearPedidosP(boxClientePrem,boxArticuloPrem,cantidadPrem);
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

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
import java.util.Optional;
import java.util.ResourceBundle;

public class VentanaEliminarPedido implements Initializable {

    @FXML
    private TextField textPedidos;
    @FXML
    private Button eliminar, salir;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private void clicEliminar(ActionEvent event){
        Controlador cont = new Controlador();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("ELIMINANDO pedido sin enviar...");
        alert.setContentText("¿Esta seguro/a que desea eliminar este pedido?");
        Optional<ButtonType> action = alert.showAndWait();
        if(action.get()==ButtonType.OK){
            int num_pedido = Integer.parseInt(textPedidos.getText());
            cont.deletePedidoFromLista(num_pedido);
        }
    }
    @FXML
    private void clicSalir (ActionEvent event){
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

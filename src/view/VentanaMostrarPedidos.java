package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.Pedido_DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VentanaMostrarPedidos implements  Initializable{

    @FXML
    private TextArea pedPendientes, pedEnviados;
    @FXML
    private Button salir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        Pedido_DAO pedido= new Pedido_DAO();
        pedido.ormImprimirPedidosEnviados(pedEnviados);
        pedido.ormImprimirPedidosNoEnviados(pedPendientes);
    }
    @FXML
    private void Salir (javafx.event.ActionEvent event) throws IOException {
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

package view;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VentanaMostrarCliente implements Initializable {
    @FXML
    private TextArea ClientesP, ClientesE;
    @FXML
    private Button Salir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Controlador controlador = new Controlador();
        String ClientesPremium = controlador.getListaClientesPremium();
        String ClientesEstandar = controlador.getListaClientesStandard();

        ClientesP.setText(ClientesPremium);

        ClientesE.setText(ClientesEstandar);
    }
    @FXML
    private void Salir (ActionEvent event){
        Stage stage = (Stage) this.Salir.getScene().getWindow();
        stage.close();
        try {
            VentanaPrincipal v = new VentanaPrincipal();
            Parent root = FXMLLoader.load(v.getClass().getResource("VentanaPrincipal.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("ObjetivoDB - Menu Principal");
            stage.setScene(scene);
            stage.show();
        } catch ( IOException e) {
            System.err.println(String.format("Error al crear la ventana: %s", e.getMessage()));
        }
    }
}

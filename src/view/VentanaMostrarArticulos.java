package view;

import controlador.Controlador;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Articulo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

    //public class VentanaMostrarArticulos {

    public class VentanaMostrarArticulos implements Initializable  {
        @FXML
        private TextArea listaArticulos;
        @FXML
        private Button salir;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            Controlador controlador = new Controlador();
            String articulos = controlador.getListaArticulos();
            listaArticulos.setText(articulos);
        }
        @FXML
        private void Salir (ActionEvent event){
            Stage stage = (Stage) this.salir.getScene().getWindow();
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



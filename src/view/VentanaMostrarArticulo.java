package view;

import controlador.Controlador;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//public class VentanaMostrarArticulos { este es el comienzo

public class mostrarArticulos extends Application implements Initializable {
    private Controlador controlador = new Controlador();

    @FXML
    private TableView<Articulo> tablaArticulos;

    @FXML
    private TableColumn<Articulo, String> codigo;

    @FXML
    private TableColumn<Articulo, String> descripcion;

    @FXML
    private TableColumn<Articulo, Float> precio_venta;

    @FXML
    private TableColumn<Articulo, Float> gastos_envio;

    @FXML
    private TableColumn<Articulo, Long> tiempo_preparacion;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mostrarArticulos.fxml"));
        primaryStage.setTitle("Mostrar Artículos");
        primaryStage.setScene(new Scene(root, 570, 400));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        codigo.setCellValueFactory(new PropertyValueFactory<Articulo, String>("codigo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));
        precio_venta.setCellValueFactory(new PropertyValueFactory<Articulo, Float>("precio_venta"));
        gastos_envio.setCellValueFactory(new PropertyValueFactory<Articulo, Float>("gastos_envio"));
        tiempo_preparacion.setCellValueFactory(new PropertyValueFactory<Articulo, Long>("tiempo_preparacion"));
        ArrayList<Articulo> listArts = controlador.listadoArts();
        ObservableList<Articulo> listaArticulos = FXCollections.observableArrayList();
        for (Articulo art:listArts){
            listaArticulos.add(new Articulo(art.getCodigo(), art.getDescripcion(), art.getPrecio_venta(), art.getGastos_envio(), art.getTiempo_preparacion()));
        }
        tablaArticulos.setItems(listaArticulos);

    }
}

}

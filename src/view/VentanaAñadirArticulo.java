package view;

import controlador.Controlador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


//public class VentanaAñadirArticulo extends initializable{
  public class VentanaAñadirArticulo implements initializable{

        private Controlador controlador = new Controlador();
        @FXML
        private TextField codigo;

        @FXML
        private TextField descripcion;

        @FXML
        private TextField precio_venta;

        @FXML
        private TextField gastos_envio;

        @FXML
        private TextField tiempo_preparacion;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/añadirArticulo.fxml"));
            primaryStage.setTitle("Añadir Artículo");
            primaryStage.setScene(new Scene(root, 570, 400));
            primaryStage.show();
        }

        public void agregarArtBtn(ActionEvent actionEvent) {
            String cod = codigo.getText();
            String desc = descripcion.getText();
            Float prec_vent = Float.parseFloat(precio_venta.getText());
            Float gast_env = Float.parseFloat(gastos_envio.getText());
            Long t_prep = Long.parseLong(tiempo_preparacion.getText());
            System.out.println("{" +
                    "codigo: " + cod + ","+
                    "descripcion: " + desc + ","+
                    "precio_venta: " + prec_vent +","+
                    "gastos_envio: " + gast_env +","+
                    "tiempo_preparacion: " + t_prep +
                    "}");

            boolean posibleAr = controlador.addArticulo(cod, desc, prec_vent, gast_env, t_prep);
            if(posibleAr==true){
                System.out.println("El articulo se ha añadido correctamente");
            }else{
                System.out.println("El articulo ya existe");
            }
        }
    }

}

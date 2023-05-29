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
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;



public class VentanaAñadirArticulo implements Initializable {

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

        @FXML
        private Button crearArt, salir;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
        }

        public void crearArt(ActionEvent actionEvent) {
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

            boolean posibleAr = controlador.addArticuloToList(cod, desc, prec_vent, gast_env, t_prep);
            if(posibleAr==true){
                System.out.println("El articulo se ha añadido correctamente");
            }else{
                System.out.println("El articulo ya existe");
            }
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



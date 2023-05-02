/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxmlapplication.JavaFXMLApplication;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class VistaTablaController implements Initializable {

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    @FXML
    private Button addButton;
    @FXML
    private Button modificarButton;
    @FXML
    private Button borrarButton;
    @FXML
    private TableColumn<Persona, String> nombreColumn;
    @FXML
    private TableColumn<Persona, String> apellidosColumn;
    @FXML
    private TableColumn<Persona, String> imagenColumn;
    @FXML
    private TableView<Persona> personasTableV;
    

    private void inicializaModelo() {
        ArrayList<Persona> misdatos = new ArrayList<Persona>();
        misdatos.add(new Persona("Pepe", "García", "/resources/images/Lloroso.png"));
        misdatos.add(new Persona("María", "Pérez", "/resources/images/Sonriente.png"));
        datos = FXCollections.observableList(misdatos);
        
        personasTableV.setItems(datos);
        
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        imagenColumn.setCellValueFactory(personaFila -> new SimpleStringProperty(personaFila.getValue().getImagen()));
        imagenColumn.setCellFactory(c -> new ImagenTabCell());
        borrarButton.disableProperty().bind(Bindings.equal(personasTableV.getSelectionModel().selectedIndexProperty(), -1));
        modificarButton.disableProperty().bind(Bindings.equal(personasTableV.getSelectionModel().selectedIndexProperty(), -1));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializaModelo();
       
    }

    @FXML
    private void addAction(ActionEvent event) throws IOException{
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/vista/VistaPersona_1.fxml"));
        Parent root = miCargador.load();
        
        VistaPersonaController_1 controladorPersona = miCargador.getController();
        
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vista añadir persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
        if(controladorPersona.isOKPressed()){
            datos.add(controladorPersona.getPersona());
        }
    }

    @FXML
    private void modificarAction(ActionEvent event) throws Exception{
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/vista/VistaPersona_1.fxml"));
        Parent root = miCargador.load();
        
        VistaPersonaController_1 controladorPersona = miCargador.getController();
        Persona persona = personasTableV.getSelectionModel().getSelectedItem();
        controladorPersona.initPersona(persona);
        
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vista modificar persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
        if(controladorPersona.isOKPressed()){
            datos.set(datos.indexOf(persona), controladorPersona.getPersona());
        }
    }

    @FXML
    private void borrarAction(ActionEvent event) {
        datos.remove(personasTableV.getSelectionModel().getSelectedIndex());
    }


    class ImagenTabCell extends TableCell<Persona, String> {
        private ImageView view = new ImageView();
        private Image imagen;
    
        @Override
        protected void updateItem(String t, boolean bln){
          super.updateItem(t, bln);
           if(t == null || bln){
               setText(null);
               setGraphic(null);
           }
          else{
              imagen = new Image(t, 25, 25, true, true);
               view.setImage(imagen);
               setGraphic(view);
            }
        }
    }
}

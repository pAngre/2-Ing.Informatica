/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class VistaListaControlador_1 implements Initializable {

    @FXML
    private ListView<Persona> personasListView;
    @FXML
    private Button addButton;
    @FXML
    private Button modificarButton;
    @FXML
    private Button borrarButton;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // en el código de inicialización del controlador
        // TODO Auto-generated method stub
//        ArrayList<Persona> misdatos = new ArrayList<Persona>();
//        misdatos.add(new Persona("Pepe", "García"));
//        misdatos.add(new Persona("María", "Pérez"));
        //=======================================================
        // creamos la lista observable mediante un metodo de FXCollections
//        datos = FXCollections.observableArrayList(misdatos);

        //=======================================================
        //=======================================================
        // vinculamos la lista observable de personas con el ListView
//        personasListView.setItems(datos); // vinculacion entre la vista y el modelo
        datos = personasListView.getItems(); // no creo la lista observable, utilizo la que tiene vacia el listview
        datos.add(new Persona("Pepe", "García"));
        datos.add(new Persona("María", "Pérez"));

        //=======================================================
        //=======================================================
        // Hay que modificar CellFactory para mostrar el objeto Persona
        personasListView.setCellFactory(c -> new PersonListCell());

        //=======================================================
        // disble de los botones modificar y borrar.
        borrarButton.disableProperty().bind(Bindings.equal(personasListView.getSelectionModel().selectedIndexProperty(), -1));
        modificarButton.disableProperty().bind(Bindings.equal(personasListView.getSelectionModel().selectedIndexProperty(), -1));
        
        
    }

    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/tarea2/vista/VistaPersona.fxml"));
        Parent root = miCargador.load();
        
        VistaPersonaController controladorPersona = miCargador.getController();
        
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vista Añadir Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
        datos.add(controladorPersona.getPersona());
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        //============================================
        // borramos de la lista
        datos.remove(personasListView.getSelectionModel().getSelectedIndex());

        //================================================
    }

    @FXML
    private void modifyButton(ActionEvent event) throws Exception {
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/tarea2/vista/VistaPersona.fxml"));
        Parent root = miCargador.load();
        
        VistaPersonaController controladorPersona = miCargador.getController();
        Persona persona = personasListView.getSelectionModel().getSelectedItem();
        controladorPersona.initPersona(persona);
        
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vista Modificar Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        
        if(controladorPersona.isOKPressed()){
            int indice = datos.indexOf(persona);
            Persona p = controladorPersona.getPersona();
            datos.set(indice, p);
        }
    }



class PersonListCell extends ListCell<Persona> {

    @Override
    protected void updateItem(Persona t, boolean bln) {
        super.updateItem(t, bln); //To change body of generated methods, choose Tools | Templates.
        if (bln) // esta vacia
        {
            setText("");
        } else {
            setText(t.getApellidos() + ", " + t.getNombre());
        }

    }
}
}
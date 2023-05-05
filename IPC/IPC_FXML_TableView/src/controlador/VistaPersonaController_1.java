/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsole
 */
public class VistaPersonaController_1 implements Initializable {

    
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidosTextField;
    @FXML
    private ComboBox<String> imagenCombo;
    
    private boolean OKPressed = false;
    
    private Persona persona;
    
    
    public boolean isOKPressed(){
        return OKPressed;
    }
    
    public Persona getPersona(){
        return persona;
    }
    
    public void initPersona(Persona p){
        persona = p;
        nombreTextField.setText(p.getNombre());
        apellidosTextField.setText(p.getApellidos());
        imagenCombo.setValue(p.getImagen());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imagenCombo.getItems().addAll("/resources/images/Lloroso.png", "/resources/images/Pregunta.png", "/resources/images/Sonriente.png");
        imagenCombo.setCellFactory(c -> new ImagenTabCell());
    }      

    @FXML
    private void aceptar(ActionEvent event) {
        OKPressed = true;
        
        if((!nombreTextField.getText().isEmpty())
                && (nombreTextField.getText().trim().length() != 0)
                && (!apellidosTextField.getText().isEmpty())
                && (apellidosTextField.getText().trim().length() != 0)
                && (!imagenCombo.getValue().isEmpty())){
            persona = new Persona(nombreTextField.getText(), apellidosTextField.getText(),imagenCombo.getValue());
        }
        
        nombreTextField.getScene().getWindow().hide();
    }

    @FXML
    private void cancelar(ActionEvent event) {
        nombreTextField.getScene().getWindow().hide();
    }
    
    
    class ImagenTabCell extends ComboBoxListCell<String> {
        private ImageView view = new ImageView();
        private Image imagen;

        @Override
        public void updateItem(String t, boolean bln) {
            super.updateItem(t, bln); 
            if (t == null || bln) {
                setText(null);
                setGraphic(null);
            } else {
                imagen = new Image(t,25,25,true,true);
                view.setImage(imagen);
                setGraphic(view);
                setText(null);
            }
        }
    }
}

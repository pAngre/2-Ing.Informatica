/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class VistaPersonaController implements Initializable {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidosTextField;
    
    private Persona persona;
    private boolean pulsadoOK = false;
    
    public void initPersona(Persona p){
        persona = p;
        nombreTextField.setText(p.getNombre());
        apellidosTextField.setText(p.getApellidos());
    }
    
    public boolean isOKPressed(){
        return pulsadoOK;
    }
    
    public Persona getPersona(){
        return persona;
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aceptar(ActionEvent event) {
        pulsadoOK = true;
        
        if((!nombreTextField.getText().isEmpty())
                && (nombreTextField.getText().trim().length() != 0)
                && (!apellidosTextField.getText().isEmpty())
                && (apellidosTextField.getText().trim().length() != 0)){
            //persona = new Persona(nombreTextField.getText(), apellidosTextField.getText());
        }
        
        nombreTextField.getScene().getWindow().hide();
    }

    @FXML
    private void cancelar(ActionEvent event) {
        nombreTextField.getScene().getWindow().hide();
    }


    
}

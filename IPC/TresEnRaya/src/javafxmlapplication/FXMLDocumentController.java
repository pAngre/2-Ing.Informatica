/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private Button boton_01;
    @FXML
    private Button boton_21;
    @FXML
    private Button boton_20;
    @FXML
    private Button boton_02;
    @FXML
    private Button boton_22;
    @FXML
    private Button boton_00;
    @FXML
    private Button boton_10;
    @FXML
    private Button boton_12;
    @FXML
    private Button boton_11;
    
    private int turno = 1;
    private int start = 0;
    @FXML
    private Text empieza;
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pulsadoBoton01(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_01.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_01.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
        
    }

    @FXML
    private void pulsadoBoton21(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_21.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_21.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton20(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_20.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_20.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton02(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_02.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_02.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton22(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_22.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_22.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton00(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_00.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_00.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton10(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_10.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_10.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton12(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_12.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_12.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoBoton11(ActionEvent event) {
        if(start == 1){
            if(turno%2 == 0){
                boton_11.setText("O");
                turno++;
                empieza.setText("Turno: Player 1");
            }
            else{
                boton_11.setText("X");
                turno++;
                empieza.setText("Turno: Player 2");
            }
        }
        else{
            empieza.setText("PULSAR INICIAR PARA EMPEZAR EL JUEGO");
        }
    }

    @FXML
    private void pulsadoReset(ActionEvent event) {
        boton_00.setText("");
        boton_01.setText("");
        boton_02.setText("");
        boton_10.setText("");
        boton_11.setText("");
        boton_12.setText("");
        boton_20.setText("");
        boton_21.setText("");
        boton_22.setText("");
        turno = 1;
    }

    @FXML
    private void pulsadoStart(ActionEvent event) {
        start = 1;
        empieza.setText("Turno: Player 1");
    }
    
}

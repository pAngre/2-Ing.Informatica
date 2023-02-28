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
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafxmlapplication.Utils.*;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Circle myBall;
    @FXML
    private GridPane grid;
    
    //=========================================================
    // event handler, fired when button is clicked or 
    //                      when the button has the focus and enter is pressed
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleKeyPressed(KeyEvent event) {    
        if(event.getCode() == KeyCode.RIGHT){
            int column = GridPane.getColumnIndex(myBall);
            if(column < 4){
                GridPane.setColumnIndex(myBall, column + 1);
            }
        }
        else if(event.getCode() == KeyCode.LEFT){
            int column = GridPane.getColumnIndex(myBall);
            if(0 < column){
                GridPane.setColumnIndex(myBall, column - 1);
            }
        }
        else if(event.getCode() == KeyCode.DOWN){
            int row = GridPane.getRowIndex(myBall);
            if(row < 4){
                GridPane.setRowIndex(myBall, row + 1);
            }
        }
        else if(event.getCode() == KeyCode.UP){
            int row = GridPane.getRowIndex(myBall);
            if(0 < row){
                GridPane.setRowIndex(myBall, row - 1);
            }
        }
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        double x =event.getSceneX();
        double y = event.getSceneY();
        GridPane.setColumnIndex(myBall, columnCalc(grid, (int)x));
        GridPane.setRowIndex(myBall, rowCalc(grid, (int)y));
    }
    
    public int columnCalc(GridPane grid, int x){
        int celdaWidth = (int) grid.getWidth() / grid.getColumnCount();
        return (int) (x / celdaWidth);
    }
    public int rowCalc(GridPane grid, int y){
        int celdaHeight = (int) grid.getHeight() / grid.getRowCount();
        return (int) (y / celdaHeight);
    }

    
}

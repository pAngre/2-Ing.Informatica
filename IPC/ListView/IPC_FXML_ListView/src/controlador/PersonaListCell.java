/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javafx.scene.control.ListCell;
import modelo.Persona;

/**
 *
 * @author angre
 */
public class PersonaListCell extends ListCell<Persona>{

    @Override
    protected void updateItem(Persona t, boolean bln) {
        super.updateItem(t, bln); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (t==null || bln) setText(null);
        else setText(t.getApellidos() + ", " + t.getNombre());
    }
    
    
}

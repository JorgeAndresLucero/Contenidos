/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import access.DirectorDAO;
import javax.swing.JTable;

/**
 *
 * @author Georgie
 */
public class DeleteDirector {
    public JTable                     tabla;
   public  DeleteDirector(JTable tablita){
        this.tabla = tablita;
        borrar();
    }
       
    private void borrar(){
        DirectorDAO dir = new DirectorDAO();
        int fila_actual = tabla.getSelectedRow();       
        dir.deleteDirector((int) tabla.getValueAt(fila_actual, 0));
    }
    
}

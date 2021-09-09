/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DirectorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DirectorModel;
import view.AddDirector;
import view.ControlsPanel;
import view.EditDirector;

/**
 *
 * @author Georgie
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;
    private JTable tablita;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
        this.tablita = controlsPanel.getTblResults();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnGetOneDirector()) {
            String directorName = (String)this.controlsPanel.getTxtName().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directors = (directorDAO.getFilteredDirectors(directorName));            
            this.controlsPanel.setTblResults(directors);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()){
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directors = directorDAO.getAllDirectors();         
            this.controlsPanel.setTblResults(directors);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddDirector()) {
            AddDirector addDirectorView = new AddDirector();
            addDirectorView.setVisible(true);
        }else if(actionEvent.getSource() == this.controlsPanel.getBtnEditDirector()){
            if(tablita.getSelectedRow() > -1){
                EditDirector editDirectorView = new EditDirector(tablita);            
                editDirectorView.setVisible(true);
            }else{JOptionPane.showMessageDialog(null, "¡Seleccione un director!");}
             
        }else if(actionEvent.getSource() == this.controlsPanel.getBtnDeleteDiector()){
            if(tablita.getSelectedRow() > -1){
              int i = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el director No. "+tablita.getValueAt(tablita.getSelectedRow(), 0)+"?");
                switch (i) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Eliminando...");
                        DirectorDAO directorDAO = new DirectorDAO();
                        directorDAO.deleteDirector( (int) tablita.getValueAt(tablita.getSelectedRow(), 0));
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Operación abortada!");
                        break;  
                    default:
                        break;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "¡Seleccione un director!");
            }
                       
             
        }
    
    }
    
}
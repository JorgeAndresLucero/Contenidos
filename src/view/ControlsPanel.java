/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.DirectorModel;



/**
 *
 * @author Georgie
 */
public class ControlsPanel extends JPanel {
    
    private JLabel                       lblDirectors;
    private JComboBox<DirectorModel>       cbxDirectorsList;
    private JLabel                       lblName;
    private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddDirector;
    private JButton                      btnEditDirector;
    private JButton                      btnDeleteDirector;
    private JButton                      btnGetOneDirector;
    private final JTable                       tblResults;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        // Complete Directors info
        this.setTblResults(initialData.getDirectors());
 
        // Name patttern 
        this.lblName = new JLabel(" Nombre del Director");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Get All button
        this.btnSearch = new JButton("Actualizar Tabla");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddDirector = new JButton("Agregar Nuevo Director");
        add(this.getBtnAddDirector());
        this.getBtnAddDirector().addActionListener(clickEvent);
        
        // Edit button
        this.btnEditDirector = new JButton("Editar un Director");
        add(this.getBtnEditDirector());
        this.getBtnEditDirector().addActionListener(clickEvent);
        
        //Delete button
        this.btnDeleteDirector = new JButton("Eliminar un Director");
        add(this.getBtnDeleteDiector());
        this.getBtnDeleteDiector().addActionListener(clickEvent);
        
        //Get one Director
        this.btnGetOneDirector = new JButton("Buscar un Director");
        add(this.btnGetOneDirector);
        this.getBtnGetOneDirector().addActionListener(clickEvent);
    }

    /**
     * @return the lblDirectors
     */
    public JLabel getLblDirectors() {
        return lblDirectors;
    }

    /**
     * @return the cbxDirectorsList
     */
    public JComboBox getCbxDirectorsList() {
        return cbxDirectorsList;
    }


    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
     /**
     * @return the btnGetOneDirector
     */
    public JButton getBtnGetOneDirector() {
        return btnGetOneDirector;
    }

       /**
     * @param directors
     */
    public void setCbxDirectorsList(ArrayList<DirectorModel> directors) {
        this.cbxDirectorsList.setModel(new DefaultComboBoxModel<>(directors.toArray(new DirectorModel[directors.size()])));
        this.getCbxDirectorsList().setSelectedIndex(0);
    }
    /**
     * @param Directors
     */
    public void setTblResults(ArrayList<DirectorModel> directors) {
        String[] headers = {"ID", "Nombre", "Apellido", "Nacionalidad"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<directors.size(); i++){
            tableModel.addRow(directors.get(i).toArray());
        }
    }
    

    /**
     * @return the btnAddDirector
     */
    public JButton getBtnAddDirector() {
        return btnAddDirector;
    }
    
     /**
     * @return the btnEditDirector
     */
    public JButton getBtnEditDirector() {
        return btnEditDirector;
    }
 /**
     * @return the btnEditDirector
     */
    public JButton getBtnDeleteDiector() {
        return btnDeleteDirector;
    }

     /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }
    
   
}
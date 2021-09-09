/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import access.DirectorDAO;
import controller.ClickEvent;
import controller.InitialData;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.DirectorModel;
import java.awt.Font;
/**
 *
 * @author Georgie
 */
public class AddDirector extends JFrame implements ActionListener {
    private JLabel                     lblId;
    private JTextField                 txtId;
    private JLabel                     lblName;
    private JTextField                 txtName;
    private JLabel                     lblLastName;
    private JTextField                 txtLastName;
    private JLabel                     lblNacionality;
    private JTextField                 txtNacionality;
    private JLabel                     lblExhibition;
    private JComboBox<DirectorModel> cbxDirector;
    private JLabel                     lblOnPresentation;
    private JCheckBox                  chbOnPresentation;
    private JLabel                     lblMuseums;
    private JLabel                     lblPresentation;
    private JTextField                 txtPresentation;
    private JButton                    btnInsertArtPiece;
    
    public AddDirector(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Directores - Agregar Director");
        setLayout(new GridLayout(8,2));
        InitialData initialData = new InitialData();
        
        this.lblId = new JLabel("ID del director");
     lblId.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);
        
        
        this.lblName = new JLabel("Nombres");
        lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);
        
        
        this.lblLastName = new JLabel("Apellidos");
        lblLastName.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblLastName);
        this.txtLastName = new JTextField();
        add(this.txtLastName);
        
        
        this.lblNacionality = new JLabel("Nacionalidad");
        lblNacionality.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblNacionality);
        this.txtNacionality = new JTextField();
        add(this.txtNacionality);
        
        this.btnInsertArtPiece = new JButton("Agregar a BD");
        btnInsertArtPiece .setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.btnInsertArtPiece);
        
        this.btnInsertArtPiece.addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertArtPiece) {
            int    id = Integer.parseInt( (String)this.txtId.getText()); 
            String nombres = (String)this.txtName.getText(); 
            String apellidos = (String)this.txtLastName.getText(); 
            String nacionalidad = (String)this.txtNacionality.getText();
    
            DirectorModel director = new DirectorModel(id, nombres, apellidos, nacionalidad);
            
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            DirectorDAO directorDAO = new DirectorDAO();
            directorDAO.insertDirector(director);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import access.DirectorDAO;
import controller.InitialData;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.DirectorModel;
import java.awt.Font;
/**
 *
 * @author Georgie
 */
public class EditDirector extends JFrame implements ActionListener {
    private JLabel                     lblId;
    private JTextField                 txtId;
    private JLabel                     lblName;
    private JTextField                 txtName;
    private JLabel                     lblLastName;
    private JTextField                 txtLastName;
    private JLabel                     lblNacionality;
    private JTextField                 txtNacionality;
    private JButton                    btnEditArtPiece;
    private JTable                     tablilla;
    
    public EditDirector(JTable tabla){
        this.tablilla = tabla;
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Directores - Editar Director");
        
        setLayout(new GridLayout(8,2));
        tablilla.getSelectedRow();
  
        int indice_row = tablilla.getSelectedRow();
        String id =   tablilla.getValueAt(indice_row, 0).toString();
        this.lblId = new JLabel("ID del director");
        lblId.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);
        this.txtId.setText(id);
        this.txtId.setEditable(false);
        
        String nombres =   tablilla.getValueAt(indice_row,1).toString();
        this.lblName = new JLabel("Nombres");
        lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);
        this.txtName.setText(nombres);
        
        String apellidos =   tablilla.getValueAt(indice_row, 2).toString();
        this.lblLastName = new JLabel("Apellidos");
        lblLastName .setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblLastName);
        this.txtLastName = new JTextField();
        add(this.txtLastName);
        this.txtLastName.setText(apellidos);
        
        String nacionalidad =   tablilla.getValueAt(indice_row, 3).toString();
        this.lblNacionality = new JLabel("Nacionalidad");
        lblNacionality .setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.lblNacionality);
        this.txtNacionality = new JTextField();
        add(this.txtNacionality);
        this.txtNacionality.setText(nacionalidad);
        
        this.btnEditArtPiece = new JButton("Agregar a BD");
        btnEditArtPiece.setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.btnEditArtPiece);
        
        this.btnEditArtPiece.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnEditArtPiece) {
            int    id = Integer.parseInt( (String)this.txtId.getText()); 
            String nombres = (String)this.txtName.getText(); 
            String apellidos = (String)this.txtLastName.getText(); 
            String nacionalidad = (String)this.txtNacionality.getText();
    
            DirectorModel director = new DirectorModel(id, nombres, apellidos, nacionalidad);    
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            DirectorDAO directorDAO = new DirectorDAO();
            directorDAO.updateDirector(director);
        }
    }
}

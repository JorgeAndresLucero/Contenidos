/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import access.DirectorDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.DirectorModel;
import java.awt.Font;
import javax.swing.JOptionPane;
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
    private JButton                    btnInsertDirector;
    
    public AddDirector(){
        initComponents();
    }
    
    public void initComponents(){
        setTitle("Directores - Agregar Director");
        setLayout(new GridLayout(8,2));
        
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
        
        this.btnInsertDirector = new JButton("Agregar a BD");
        btnInsertDirector .setFont(new Font("Berlin Sans FB", Font.PLAIN,18));
        add(this.btnInsertDirector);
        
        this.btnInsertDirector.addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertDirector && this.txtId.getText().matches("[0-9]*") &&  !this.txtId.getText().equals("")) {
            System.out.println("ENTREE:"+this.txtId.getText()+"FUCK" );
            int    id = Integer.parseInt( (String)this.txtId.getText()); 
            String nombres = (String)this.txtName.getText(); 
            String apellidos = (String)this.txtLastName.getText(); 
            String nacionalidad = (String)this.txtNacionality.getText();
            DirectorModel director = new DirectorModel(id, nombres, apellidos, nacionalidad);
            DirectorDAO directorDAO = new DirectorDAO();
            directorDAO.insertDirector(director);
        } else if (!this.txtId.getText().matches("[0-9]*")){
            JOptionPane.showMessageDialog(null, "¡Sólo se permiten números en el ID");
        }else if(this.txtId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "¡No puede quedar en blanco el ID");
        }
    }
}

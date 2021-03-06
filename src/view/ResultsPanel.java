/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
/**
 *
 * @author Georgie
 */
public class ResultsPanel extends JPanel {
   
    private JTable      tblResults;
    private JScrollPane jspPane;
    
    public ResultsPanel(){
        initComponents();
    }
    
    private void initComponents(){
        this.tblResults = new JTable();
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tblResults.setFont(new Font("Berlin Sans FB", Font.PLAIN,16));
        this.jspPane = new JScrollPane(this.tblResults);
        jspPane.setBackground(Color.yellow);
        //setBounds(58, 11, 540, 517);
        add(jspPane, BorderLayout.CENTER);
        jspPane.setBackground(Color.yellow);
        tblResults.setBackground(Color.ORANGE);
        tblResults.setOpaque(true);
        jspPane.getViewport().setBackground(Color.CYAN);
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    
    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}

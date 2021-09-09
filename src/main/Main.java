/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import access.DirectorDAO;
import view.MainWindow;
/**
 *
 * @author Georgie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DirectorDAO dir = new DirectorDAO();
         new MainWindow();
    
    }
    
}
